package com.app.drive.exception;



public class CalendarAccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CalendarAccessDeniedException(String message)  {
        super(message);
    }
}
