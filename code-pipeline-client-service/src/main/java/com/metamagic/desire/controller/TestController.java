package com.metamagic.desire.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.metamagic.desire.beans.ResponseBean;
import com.metamagic.desire.component.BaseComponent;
import com.metamagic.desire.fallback.FallbackMessage;
import com.metamagic.desire.service.ReactiveService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/taskInfo")
public class TestController extends BaseComponent {
	
	@Autowired
	private ReactiveService reactiveService;

	@HystrixCommand(fallbackMethod = "getAllFallBack")
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public DeferredResult<ResponseEntity<ResponseBean>> getAll(HttpServletRequest request){
		HttpHeaders headers = this.createHeaders(request);
		HttpEntity<?> requestEntity = new HttpEntity<>(headers);
		return reactiveService.callService("test/findAll", HttpMethod.GET, requestEntity);
	}
	
	public DeferredResult<ResponseEntity<ResponseBean>> getAllFallBack(HttpServletRequest request){
		return reactiveService.fallback(FallbackMessage.message, FallbackMessage.messageId);
	}
}
