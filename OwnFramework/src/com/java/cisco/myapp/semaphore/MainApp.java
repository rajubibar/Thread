package com.java.cisco.myapp.semaphore;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrinterQueue queue = new PrinterQueue();
		
		Thread thread[]= new  Thread[11];
		
		for(int i=1;i<=10;i++){
			thread[i] = new Thread(new PrintJob(queue),"Thread "+i);
		}
		for(int i=1;i<=10;i++){
			thread[i].start();
		}
	}

}
