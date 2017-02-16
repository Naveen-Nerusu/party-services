package com.jns.party;

public class UserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public UserAlreadyExistsException() {
		super();
	}
	
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public UserAlreadyExistsException(String msg, String id) {
		super(msg);
	}
	
	public UserAlreadyExistsException(String msg, Throwable t) {
		super(msg, t);
	}

}
