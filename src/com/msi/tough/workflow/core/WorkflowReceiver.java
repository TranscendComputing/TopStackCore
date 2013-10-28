/*
 * TopStack (c) Copyright 2012-2013 Transcend Computing, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the License);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Transcend Computing, Inc.
 * Confidential and Proprietary
 * Copyright (c) Transcend Computing, Inc. 2012
 * All Rights Reserved.
 */
package com.msi.tough.workflow.core;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.zeromq.ZMQ;
import org.zeromq.ZMQException;

import com.google.common.base.Charsets;
import com.msi.tough.core.Appctx;
import com.msi.tough.core.ExecutorHelper;

public class WorkflowReceiver implements Runnable {

    private ZMQ.Context zmqContext = null;
    private ZMQ.Socket zmqRecvSocket = null;
    private ZMQ.Poller items = null;

    private final static Logger logger = Appctx
            .getLogger(WorkflowReceiver.class.getName());

    private AtomicBoolean done = new AtomicBoolean(false);

    @Resource
    /**
     * Should be ZMQ socket on which to listen.
     */
    private String recvEndpoint = "tcp://*:5555";

    @Resource
    /**
     * Workflow to process received jobs.
     */
    private Workflow workflow = null;

    private Future<?> executeResult = null;

    /**
     * Initialize receiver and begin listening for messages.
     *
     * @throws Exception
     */
    public void init() throws Exception {
        zmqContext = ZMQ.context(1);
        logger.debug("ZMQ initialized:" + ZMQ.getVersionString() +":"+ zmqContext.toString());

        logger.debug("Binding to ZMQ socket for receive:" +
                recvEndpoint);
        zmqRecvSocket = zmqContext.socket(ZMQ.PULL);
        boolean success = false;
        for (int i = 0; i < 5 && !success; i++) {
            try {
                zmqRecvSocket.bind(recvEndpoint);
                success = true;
            } catch (ZMQException zmqex) {
                Thread.sleep(1000);
                // Retry for a few seconds; on webapp restart, ZMQ may not have
                // released the port.
                logger.info("Failed to listen on socket...retrying:" + zmqex);
            }
        }
        items = new ZMQ.Poller(1);
        items.register(zmqRecvSocket, ZMQ.Poller.POLLIN);
        executeResult = ExecutorHelper.execute(this);
    }

    /**
     * Shutdown receiver and clean up.
     *
     * @throws Exception
     */
    public void destroy() throws Exception {
        logger.debug("Destroying receiver.");
        done.set(true);
        logger.debug("Destroyed receiver, result:" + executeResult.get());
        if (zmqContext != null) {
            logger.debug("Terminating ZMQ.");
            zmqContext.term();
            zmqContext = null;
            logger.debug("Terminated ZMQ.");
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while (!done.get() && !Thread.currentThread().isInterrupted()) {
            byte[] messageBytes, messageBytesPt2 = null;
            items.poll(500);
            if (items.pollin(0)) {
                messageBytes = zmqRecvSocket.recv(0);
                logger.info("Got an item, len:"+messageBytes.length);
                try {
                    String returnAddress = null;
                    if (items.pollin(0)) {
                        messageBytesPt2 = zmqRecvSocket.recv(0);
                        returnAddress = new String(messageBytesPt2,
                                Charsets.UTF_8);
                        logger.info("Got request from:"+returnAddress);
                    }
                    Object payload = new Object[] { messageBytes, messageBytesPt2 };
                    workflow.doWorkRaw(payload);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        logger.debug("WorkflowReceiver: Exiting receive thread.");
        zmqRecvSocket.close();
    }
}
