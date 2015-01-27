package org.spring.panda.exception;

public class PandaException extends RuntimeException {

	public PandaException() {
		super();
	}

	public PandaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PandaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PandaException(String message) {
		super(message);
	}

	public PandaException(Throwable cause) {
		super(cause);
	}

}
