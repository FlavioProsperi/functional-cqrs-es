package com.metamagic.desire.repository.impl;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.metamagic.desire.PMFConfig;
import com.metamagic.desire.document.TaskStatus;
import com.metamagic.desire.repository.TaskStatusRepository;

public class TaskStatusRepositoryImpl implements TaskStatusRepository {
	
	private PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();

	@Override
	public TaskStatus save(TaskStatus taskStatus) {
		return pm.makePersistent(taskStatus);
	}

	@Override
	public void update(TaskStatus taskStatus) {
		pm.makePersistent(taskStatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaskStatus> findAll() {
		List<TaskStatus> taskStatus = (List<TaskStatus>) pm.newQuery(TaskStatus.class);
		return taskStatus;
	}

}
