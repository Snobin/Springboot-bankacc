package com.example.demo.exception;

@SuppressWarnings("serial")
public class RecordCreateException extends Exception {

	public RecordCreateException() {
		super();
	}

	public RecordCreateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RecordCreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordCreateException(String message) {
		super(message);
	}

	public RecordCreateException(Throwable cause) {
		super(cause);
	}

}
