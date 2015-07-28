package com.altova.robots;

/**
 * Thrown to indicated that an error was reported by the application under test.
 * This would include unexpected parsing errors in UModel, import errors in
 * XMLSpy, etc. For an application crash, see the
 * {@link ApplicationCrashedException}.
 * 
 * @author Havard Rast Blok
 * 
 * @see ApplicationCrashedException
 */
public class ApplicationErrorException extends RuntimeException {

	private static final long serialVersionUID = -7654175714532342682L;

	public ApplicationErrorException(String message) {
		super(message);
	}
}
