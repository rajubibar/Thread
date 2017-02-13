package com.java.cisco.myapp.ownthreadpool;

public class Task implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(500);
			System.out.println();
			System.out.println(Thread.currentThread().getName() +"currently executing the task");
		}catch(InterruptedException iex){
			iex.printStackTrace();
		}
	}

}
