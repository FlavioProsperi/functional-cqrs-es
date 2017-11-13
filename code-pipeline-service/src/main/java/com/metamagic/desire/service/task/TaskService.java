package com.metamagic.desire.service.task;

import java.util.List;

import com.metamagic.desire.document.TaskStatus;

public interface TaskService {

	public List<TaskStatus> findAll();
}
