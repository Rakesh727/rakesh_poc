package com.boot.globalException;

import java.time.LocalDateTime;

public class ErrorEntity {
	
	private String message;
	private LocalDateTime timeStamp;
	private String error;
	private Integer httpStatusCode;
	
	
	public ErrorEntity() {
	}
	
	public ErrorEntity(String message, LocalDateTime timeStamp, String error, Integer httpStatusCode) {
		this.message = message;
		this.timeStamp = timeStamp;
		this.error = error;
		this.httpStatusCode = httpStatusCode;
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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	@Override
	public String toString() {
		return "ErrorEntity [message=" + message + ", timeStamp=" + timeStamp + ", error=" + error + ", httpStatusCode="
				+ httpStatusCode + "]";
	}
	

}
