package com.java.cisco.myapp.semaphore;

public class PrintJob implements Runnable {

	private PrinterQueue queue;
	
	public PrintJob(PrinterQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
      System.out.println("Printer queue going to print the job "+Thread.currentThread().getName());
      queue.printJob(new Object());
	}

}
