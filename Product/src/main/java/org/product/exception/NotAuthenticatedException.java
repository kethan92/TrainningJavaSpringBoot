package org.product.exception;

public class NotAuthenticatedException extends RuntimeException {

	private static final long serialVersionUID = -6835144709329077012L;
	
	
	public NotAuthenticatedException(String message) {
		super(message);
	}
}
