package com.metamagic.desire.exceptions;


public class DataNotFoundException extends BaseException
{
	private String message;
	
	public DataNotFoundException(String message){
		super(message);
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
}
