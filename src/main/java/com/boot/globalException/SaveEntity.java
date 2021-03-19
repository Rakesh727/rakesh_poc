package com.boot.globalException;

import java.time.LocalDateTime;

import com.boot.model.User;

public class SaveEntity {
	
	private String message;
	private LocalDateTime timeStamp;
	
	private Integer statusCode;
	private User data;
	
	public SaveEntity() {
	}
	
	public SaveEntity(String message, LocalDateTime timeStamp, Integer statusCode,User data) {
		this.message = message;
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.data=data;
	}
	
	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
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
		return "SuccessEntity [message=" + message + ", timeStamp=" + timeStamp + ", statusCode=" + statusCode
				+ "]";
	}
	

}
