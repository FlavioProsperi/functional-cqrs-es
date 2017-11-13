package com.metamagic.desire.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metamagic.desire.document.TaskStatus;
import com.metamagic.desire.repository.TaskStatusRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Override
	public List<TaskStatus> findAll() {
		return taskStatusRepository.findAll();
	}

}
