package com.fetcher.usermicroservice.exceptions;

public class UsernameTakenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameTakenException(String username) {
	    super(username + " username is already in use, please register with another one");
	}
}
