package com.msi.tough.model.rds;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.msi.tough.model.AccountBean;

/**
 * RdsDbparameterGroup generated by hbm2java
 */

@Entity
@Table(name = "rds_dbparameter_group")
public class RdsDbparameterGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rds_parameter_group_id")
	private long id;
	
	@ManyToOne
	private AccountBean account;
	
	@OneToMany(mappedBy="rdsParamGroup", fetch=FetchType.LAZY)
	private List<RdsParameter> parameters;
	
	private String dbparameterGroupName;
	private String dbparameterGroupFamily;
	private String description;
	
	public RdsDbparameterGroup(){
		parameters = new ArrayList<RdsParameter>();
	}
	
	public RdsDbparameterGroup(AccountBean account, String dbparameterGroupName, String dbparamterGroupFamily, String description){
		this();
		this.account=account;
		this.dbparameterGroupName=dbparameterGroupName;
		this.dbparameterGroupFamily=dbparamterGroupFamily;
		this.description=description;
	}
	
	public AccountBean getAccount() {
		return account;
	}

	public String getDbparameterGroupFamily() {
		return dbparameterGroupFamily;
	}

	public String getDbparameterGroupName() {
		return dbparameterGroupName;
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}
	
	public List<RdsParameter> getParameters(){
		return parameters;
	}

	public void setAccount(AccountBean ac){
		this.account = ac;
	}
	
	public void setParameters(List<RdsParameter> newParam){
		this.parameters = newParam;
	}
	
	public void setDbparameterGroupFamily(String dbparameterGroupFamily) {
		this.dbparameterGroupFamily = dbparameterGroupFamily;
	}

	public void setDbparameterGroupName(String dbparameterGroupName) {
		this.dbparameterGroupName = dbparameterGroupName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}
}
