package net.hblok.util;

import java.util.Stack;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * 
 * @author Havard Rast Blok
 * 
 */
public class HierarchyXMLFormatter extends XMLFormatter {

	protected Stack<Level> hierarcy = new Stack<Level>();

	@Override
	public synchronized String format(LogRecord record) {
		StringBuffer sb = new StringBuffer(600);

		Level level = record.getLevel();
		String lvlName = level.getName().toLowerCase();
		int intValue = level.intValue();

		if (intValue > Level.SEVERE.intValue()) {
			if (hierarcy.size() == 0 || intValue < hierarcy.peek().intValue()) {
				hierarcy.push(level);
			} else {
				sb.append(popStack(intValue));
				hierarcy.push(level);
			}

			sb.append(getIndent());
			sb.append("<" + lvlName + " message=\"" + record.getMessage()
					+ "\">\n");

			return sb.toString();
		} else {
			return super.format(record);
		}

	}

	@Override
	public String getTail(Handler h) {
		StringBuffer sb = new StringBuffer();
		sb.append(popStack(Integer.MAX_VALUE));
		sb.append(super.getTail(h));
		return sb.toString();
	}
	
	@Override
	public String getHead(Handler h) {
		String header = super.getHead(h);
		//remove the default DTD string from the Java XML logging API
		return header.replaceAll("<!DOCTYPE log SYSTEM \"logger.dtd\">\n", "");
	}

	private String popStack(int intValue) {
		StringBuffer sb = new StringBuffer();

		if (hierarcy.size() > 0) {
			Level top = hierarcy.peek();
			int stackValue = top.intValue();
			while (stackValue <= intValue) {
				sb.append(getIndent());
				sb.append("</" + top.getName().toLowerCase() + ">\n");

				hierarcy.pop();
				if (hierarcy.isEmpty()) {
					break;
				} else {
					top = hierarcy.peek();
					stackValue = top.intValue();
				}
			}
		}

		return sb.toString();
	}

	private String getIndent() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hierarcy.size(); i++) {
			sb.append("  ");
		}

		return sb.toString();
	}

	/**
	 * 
	 * For testing only
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.setProperty("java.util.logging.config.file", "C:/user_files/work/robots/cvs/robots/src/net/hblok/util/logging.properties");
		
		// HierarchyXMLFormatter f = new HierarchyXMLFormatter();
		Logger logger = Logger.getLogger("net.hblok.util");
		logger.log(HierarchyLevel.SUITE, "the suite");
		logger.log(HierarchyLevel.TEST, "the first test");
		logger.severe("severe 1");
		logger.severe("severe 2");
		logger.log(HierarchyLevel.TEST, "the second test");
		logger.severe("severe 3");
		logger.log(HierarchyLevel.SUITE, "the second suite");
		logger.log(HierarchyLevel.TEST, "the third test");
		logger.severe("severe 4");
		
		
		String logfile = System.getProperty("java.util.logging.config.file");
		System.out.println("logfile="+logfile);
	}
}
