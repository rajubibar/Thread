package com.java.cisco.myapp.ownthreadpool;

public class ThreadPoolThread extends Thread {

	private BlockingQueue<Runnable> taskQueue;
	private ThreadPool pool;
	
	public ThreadPoolThread(BlockingQueue<Runnable> taskQueue,ThreadPool pool){
		this.taskQueue = taskQueue;
		this.pool = pool;
	}
	
	public void run(){
		try{
		while(true){
			System.out.println(Thread.currentThread().getName() +" is Ready to execute the task");
			
			Runnable runnable = this.taskQueue.poll();
			System.out.println(Thread.currentThread().getName() +" has taken the task");
			
			runnable.run();
			System.out.println(Thread.currentThread().getName() +" has executed the task");
			
			
			if(this.pool.isShutdown() && this.taskQueue.getLimit() == 0){
				this.interrupt();
			}
			Thread.sleep(1);
		}
	}catch(InterruptedException iex){
		iex.printStackTrace();
	}
	}
}
