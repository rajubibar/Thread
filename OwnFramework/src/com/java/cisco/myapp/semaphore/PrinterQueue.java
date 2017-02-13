package com.java.cisco.myapp.semaphore;

import java.util.concurrent.Semaphore;

public class PrinterQueue {

	private Semaphore queue ;
	
	public PrinterQueue(){
		queue = new Semaphore(1);
	}
	
	public void printJob(Object obj){
		try {
			queue.acquire();
			System.out.println(Thread.currentThread().getName()+" PrinterQueue has get a job");
			Thread.sleep(200);
			System.out.println(Thread.currentThread().getName()+" Job printed" );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			queue.release();
			System.out.println(Thread.currentThread().getName() +" Job has been released");
			
		}
		
	}
}
