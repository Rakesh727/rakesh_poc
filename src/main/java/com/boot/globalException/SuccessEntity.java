package com.boot.globalException;

import java.time.LocalDateTime;

public class SuccessEntity {
	
	private String message;
	private LocalDateTime timeStamp;	
	private Integer statusCode;

	public SuccessEntity(String message, LocalDateTime timeStamp, Integer statusCode) {
		this.message = message;
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
	}

	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public Integer getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}


	@Override
	public String toString() {
		return "SuccessEntity [message=" + message + ", timeStamp=" + timeStamp + ", statusCode=" + statusCode + "]";
	}


	
	

}
