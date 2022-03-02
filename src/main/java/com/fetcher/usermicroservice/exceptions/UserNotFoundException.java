package com.fetcher.usermicroservice.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String username) {
	    super("Could not find user " + username);
	}
}
