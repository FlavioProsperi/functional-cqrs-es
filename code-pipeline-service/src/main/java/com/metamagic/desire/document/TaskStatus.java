package com.metamagic.desire.document;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class TaskStatus extends TenantDocument {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.UUIDSTRING)
	private String id;
	
	@Persistent(name="task_name")
	private String taskName;
	
	private Integer uiCreated;
	
	private Integer entityCreated;
	
	private Integer repoCreated;
	
	private Integer bizServiceCreated;
	
	private Integer serviceCreated;
	
	private Integer designType;
	
	private String reffId;
	
	public TaskStatus() {
	}

	public TaskStatus(String id, String taskName, Integer uiCreated, Integer entityCreated, Integer repoCreated,
			Integer bizServiceCreated, Integer serviceCreated, Integer designType, String reffId) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.uiCreated = uiCreated;
		this.entityCreated = entityCreated;
		this.repoCreated = repoCreated;
		this.bizServiceCreated = bizServiceCreated;
		this.serviceCreated = serviceCreated;
		this.designType = designType;
		this.reffId = reffId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getUiCreated() {
		return uiCreated;
	}

	public void setUiCreated(Integer uiCreated) {
		this.uiCreated = uiCreated;
	}

	public Integer getEntityCreated() {
		return entityCreated;
	}

	public void setEntityCreated(Integer entityCreated) {
		this.entityCreated = entityCreated;
	}

	public Integer getRepoCreated() {
		return repoCreated;
	}

	public void setRepoCreated(Integer repoCreated) {
		this.repoCreated = repoCreated;
	}

	public Integer getBizServiceCreated() {
		return bizServiceCreated;
	}

	public void setBizServiceCreated(Integer bizServiceCreated) {
		this.bizServiceCreated = bizServiceCreated;
	}

	public Integer getServiceCreated() {
		return serviceCreated;
	}

	public void setServiceCreated(Integer serviceCreated) {
		this.serviceCreated = serviceCreated;
	}

	public Integer getDesignType() {
		return designType;
	}

	public void setDesignType(Integer designType) {
		this.designType = designType;
	}

	public String getReffId() {
		return reffId;
	}

	public void setReffId(String reffId) {
		this.reffId = reffId;
	}
	
}
