package com.altova.util;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * Log handler which writes to standard out (instead of std.err).
 * 
 * @author Havard Rast Blok
 *
 */
public class StdOutHandler extends StreamHandler {
	public StdOutHandler() {
		setOutputStream(System.out);
	}

	/*
	 * Override to avoid buffering of log records
	 * 
	 * (non-Javadoc)
	 * @see java.util.logging.StreamHandler#publish(java.util.logging.LogRecord)
	 */
	public void publish(LogRecord record) {
		super.publish(record);
		super.flush();
	}
}
