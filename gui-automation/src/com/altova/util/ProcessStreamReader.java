package com.altova.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.altova.util.LoggerUtils.logger;

/**
 * Forwards the output streams, stdout and stderr, of a Process
 * to the JVM equivalents. 
 * 
 * @author Havard Rast Blok
 *
 */
public class ProcessStreamReader implements Runnable   {

	private Process ps;
	
	private BufferedInputStream stdout;
	
	private BufferedInputStream stderr;
	
	private Thread parentThread;
	
	public ProcessStreamReader(Process ps) {
		if(ps==null) {
			throw new NullPointerException("ps argument cannot be null");
		}
		
		this.ps = ps;
		this.stdout = new BufferedInputStream(ps.getInputStream());
		this.stderr = new BufferedInputStream(ps.getErrorStream());
		this.parentThread = Thread.currentThread();
		
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		logger.finer("Started ProcessStreamReader thread");
		int i = 0;
		
		do {
			i++;
			if(i%100 == 0) {
				logger.finest("parentThread.isAlive(): "+parentThread.isAlive());
				i=0;
			}
			
			forward();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {} //ignore
		} while(!hasTerminated() && parentThread.isAlive());
		
		forward();
		logger.finest("parentThread is dead. Killing the started process, if not already terminated.");
		if(!hasTerminated()) {
			logger.warning("Process had to be killed forcefully. "+
							"This might indicate an error with the script or the application under test");
			ps.destroy();
		}
	}
	
	private void forward() {
		try {
			forwardStream(stdout, System.out);
			forwardStream(stderr, System.err);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void forwardStream(InputStream input, OutputStream output) throws IOException {
		int size = input.available();
		if(size > 0) {
			byte buf[] = new byte[size];
			int read = input.read(buf);
			if(read > 0) {
				output.write(buf, 0, read);
				output.flush();
			}
		}
	}
	
	public boolean hasTerminated() {
		try {
			ps.exitValue();
			return true;
		}
		catch(IllegalThreadStateException e) {
			return false;
		}
	}
}
