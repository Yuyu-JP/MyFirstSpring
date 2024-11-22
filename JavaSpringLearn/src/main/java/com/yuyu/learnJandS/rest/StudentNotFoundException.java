package com.yuyu.learnJandS.rest;

public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
