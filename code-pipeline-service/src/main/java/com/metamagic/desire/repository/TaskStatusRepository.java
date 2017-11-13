package com.metamagic.desire.repository;

import java.util.List;

import com.metamagic.desire.document.TaskStatus;

public interface TaskStatusRepository {

	public TaskStatus save(TaskStatus taskStatus);
	
	public void update(TaskStatus taskStatus);
	
	public List<TaskStatus> findAll();
}
