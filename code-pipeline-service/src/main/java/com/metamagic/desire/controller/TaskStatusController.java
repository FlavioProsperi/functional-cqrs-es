package com.metamagic.desire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.metamagic.desire.beans.ResponseBean;
import com.metamagic.desire.document.TaskStatus;
import com.metamagic.desire.service.task.TaskService;

@RestController("/task") 
public class TaskStatusController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/findAll")
	public DeferredResult<ResponseEntity<ResponseBean>> getAll() {
		DeferredResult<ResponseEntity<ResponseBean>> deferredResult = new DeferredResult<ResponseEntity<ResponseBean>>();
		List<TaskStatus> taskStatus = taskService.findAll();
 		ResponseBean responseBean = new ResponseBean(false, "success", "success", null, null, taskStatus);
		deferredResult.setErrorResult(new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK));
		System.out.println("*****Reactive call " + Thread.currentThread().getStackTrace()[1].getClassName() + "::"
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " completed*****");
		return deferredResult;
	}
}
