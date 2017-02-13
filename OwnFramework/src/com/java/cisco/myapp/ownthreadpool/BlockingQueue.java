package com.java.cisco.myapp.ownthreadpool;

import java.util.LinkedList;

public class BlockingQueue<T> {

	private LinkedList<T> queue = new LinkedList<T>();
	private int limit = Integer.MAX_VALUE;
	
	public BlockingQueue(int limit){
		this.limit = limit;
	}
	  
	public synchronized void put(T t){
		while(this.queue.size() == this.limit){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.queue.size() == 0){
			notifyAll();
		}
		this.queue.add(t);
	}
	
	public synchronized T poll() throws InterruptedException{
		while(this.queue.size() == 0){
			wait();
		}
		if(this.queue.size() == this.limit){
			notifyAll();
		}
		
		T t = this.queue.poll();
		return t;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
