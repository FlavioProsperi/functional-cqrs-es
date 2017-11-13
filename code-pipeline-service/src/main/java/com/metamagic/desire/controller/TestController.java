package com.metamagic.desire.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.metamagic.desire.beans.ResponseBean;


@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/findAll")
	public DeferredResult<ResponseEntity<ResponseBean>> getAll() {
		DeferredResult<ResponseEntity<ResponseBean>> deferredResult = new DeferredResult<ResponseEntity<ResponseBean>>();
		ResponseBean responseBean = new ResponseBean(false, "success", "success", null, null, null);
		deferredResult.setErrorResult(new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK));
		System.out.println("*****Reactive call " + Thread.currentThread().getStackTrace()[1].getClassName() + "::"
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " completed*****");
		return deferredResult;
	}
}
