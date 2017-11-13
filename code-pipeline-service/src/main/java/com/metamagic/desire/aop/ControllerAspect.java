package com.metamagic.desire.aop;

import java.io.IOException;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.metamagic.desire.beans.ResponseBean;
import com.metamagic.desire.exceptions.ServiceException;
import com.metamagic.desire.service.message.MessageService;

@Component
@Aspect
@Order(1)
public class ControllerAspect {

	@Autowired
	private MessageService messageService;

	@Around("execution(* com.metamagic.desire.controller..*.*(..))")
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		String msg = joinPoint.getTarget().getClass() + " " + signature.getName();

		System.out.println(new Date() + " Executing [ " + msg + "  ] starts");
		Object response = joinPoint.proceed();
		System.out.println(new Date() + " Execution [ " + msg + "  ] ends");
		return response;
	}

	/*@Around("execution(org.springframework.web.context.request.async.DeferredResult com.metamagic.desire.controller..*.*(..))")
	public Object addMessage(ProceedingJoinPoint joinPoint) {
		
		Object response = null;
		try {
			 IF SERVICE RETURNS DATA SUCCCESSFULLY 
			response = joinPoint.proceed();
			if (response instanceof ResponseEntity<?>) {
				ResponseEntity<?> responseEntity = (ResponseEntity<?>) response;
				ResponseBean responseBean = (ResponseBean) responseEntity.getBody();
				if (responseBean.isSuccess()) {
					try {
						String message = messageService.getMessage(responseBean.getSuccessCode());
						if(message!=null){
							responseBean.setSuccessMessage(message);	
						}
					} catch (IOException e) {
						// ADD LOG
					}
				} else {
					try {
						String message = messageService.getMessage(responseBean.getErrorCode());
						if(message!=null){
							responseBean.setErrorMessage(message);	
						}
					} catch (IOException e) {
						// ADD LOG
					}
				}
			}
		} catch (Throwable error) {
			error.printStackTrace();
			 IF SERVICE THROWS AN EXCEPTION 
			if(error instanceof ServiceException){
				ServiceException serviceException = (ServiceException) error;
				String message = null;
				try {
					message = messageService.getMessage(serviceException.getMessageId());
					if(message==null){
						message = serviceException.getMessage();
					}
				} catch (IOException e) {
					// ADD LOG
					message = serviceException.getMessage();
				}
				ResponseBean responseBean = new ResponseBean(false, null, null, message, serviceException.getMessageId(), null);
				return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
			} else {
				String message = null;
				try {
					message = messageService.getMessage("error.global");
				} catch (IOException e) {
					// ADD LOG
					message = "The service failed to respond";
				}
				ResponseBean responseBean = new ResponseBean(false, null, null, message, "error.global", null);
				return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
			}

		}
		return response;
	}*/

}
