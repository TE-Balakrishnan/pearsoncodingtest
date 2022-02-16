package com.ty.store.customexception;

public class StoreIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StoreIdNotFoundException(String msg) {

		super(msg);
	}
}
