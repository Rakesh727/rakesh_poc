package com.boot.globalException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.boot.Constant;
import com.boot.exception.DataNotFoundException;
import com.boot.exception.SomethingWentWrong;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorEntity> handleDataNotFoundException(DataNotFoundException dfnt){
		ErrorEntity err=new ErrorEntity();
		err.setMessage(dfnt.getMessage());
		err.setError(Constant.NOT_FOUND_ERROR);
		err.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		err.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(SomethingWentWrong.class)
	public ResponseEntity<ErrorEntity> handleSomeThingWentWrongException(SomethingWentWrong sw){
		ErrorEntity err=new ErrorEntity();
		err.setMessage(sw.getMessage());
		err.setError(Constant.SOME_THING_WENT_WRONG_ERROR);
		err.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
	}

}
