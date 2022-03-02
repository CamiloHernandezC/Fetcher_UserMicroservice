package com.fetcher.usermicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsernameTakenAdvice {
	
	@ResponseBody
	@ExceptionHandler(UsernameTakenException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String usernameTakenHandler(UsernameTakenException ex) {
		return ex.getMessage();
	}
}
