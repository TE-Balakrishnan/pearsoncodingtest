package com.ty.store.customexception;

public class InvalidOptionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOptionException(String msg) {

		super(msg);
	}
}
