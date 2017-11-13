package com.metamagic.desire.exceptions;

public class DataAccessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Throwable causedBy;
	
	private String messageId;

	public DataAccessException(String message) {
		super(message);
	}
	
	public DataAccessException(String message, Throwable causedBy){
		super(message);
		this.causedBy = causedBy;
	}
	
	public DataAccessException(String message, String messageId){
		super(message);
		this.messageId = messageId;
	}
	
	public String getMessageId(){
		return this.messageId;
	}

	public Throwable getCausedBy() {
		return causedBy;
	}

}
