package com.java.cisco.myapp.ownthreadpool;

public class ThreadPool {

	private BlockingQueue<Runnable> taskQueue;
	private boolean isShutdown = false;
	
	public ThreadPool(int nThread){
		taskQueue = new BlockingQueue<Runnable>(nThread);
		for(int i=1;i<=nThread;i++){
			ThreadPoolThread thPoolTh = new ThreadPoolThread(taskQueue, this);
			thPoolTh.setName("Thread "+i);
			System.out.println("Thread "+ i +" is created in thread pool..");
			thPoolTh.start();
		}		
	}
	
	public  synchronized void execute(Runnable task) throws InterruptedException{
		if(isShutdown){
			throw new InterruptedException("ThreadPool has been shutDown, no further tasks can be added");
		}

		this.taskQueue.put(task);
		System.out.println("Task has been added");

	}

	public boolean isShutdown() {
		return isShutdown;
	}

	public void setShutdown(boolean isShutdown) {
		this.isShutdown = isShutdown;
	}
	
	public synchronized void shutdowm(){
		this.setShutdown(true);
		System.out.println("ThreadPool SHUTDOWN initiated.");
	}
	
}
