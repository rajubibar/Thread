package com.java.cisco.myapp.blockingqueue;

import java.util.LinkedList;
//import java.util.List;

public class BlockingQueue<T> {

	private LinkedList<T> queue = new LinkedList<T>();
	private int limit = Integer.MAX_VALUE;
	
	public BlockingQueue(int limit){
		this.limit = limit;
	}
	
	public  synchronized void put(T t) throws InterruptedException{
		while(this.queue.size() == limit){
			wait();
		}
		if(this.queue.size() == 0){
			notifyAll();
		}
		queue.add(t);
	}
	
	public synchronized T poll() throws InterruptedException{
		while(this.queue.size()==0){
			wait();
		}
		if(this.queue.size() == limit){
			notifyAll();
		}
		T t= queue.poll();
		return t;
	}
}
