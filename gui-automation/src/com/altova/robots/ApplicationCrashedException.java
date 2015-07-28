package com.altova.robots;

/**
 * This is exception is used to indicate that the application under test
 * crashed. For application errors that did not cause a crash, see the
 * {@link ApplicationErrorException}.
 * 
 * @author Havard Rast Blok
 * 
 * @see ApplicationErrorException
 */
public class ApplicationCrashedException extends RuntimeException {

	private static final long serialVersionUID = 5683385958442036933L;

	public ApplicationCrashedException(String message) {
		super(message);
	}

	public ApplicationCrashedException() {
		super();
	}

	public ApplicationCrashedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationCrashedException(Throwable cause) {
		super(cause);
	}

}
