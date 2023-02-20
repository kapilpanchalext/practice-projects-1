package com.app02.rediscachemysql.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2331753246157926076L;
	
	public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }	
}
