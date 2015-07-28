package com.altova.robots;

public class ScriptMistakeException extends RuntimeException {

    static final long serialVersionUID = -6166339367715566523L;
	
	public ScriptMistakeException() {
		super();
	}

	public ScriptMistakeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScriptMistakeException(String s) {
		super(s);
	}

	public ScriptMistakeException(Throwable cause) {
		super(cause);
	}
	
}
