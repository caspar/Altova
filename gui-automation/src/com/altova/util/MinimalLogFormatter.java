package com.altova.util;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * A formatter for the most minimal log output. It shows the log level, and the message.
 * 
 * @author Havard Rast Blok
 *
 */
public class MinimalLogFormatter extends SimpleFormatter {
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer();
		buf.append(rec.getLevel());
		buf.append(": ");
		buf.append(formatMessage(rec));
		buf.append('\n');

		return buf.toString();
	}
}
