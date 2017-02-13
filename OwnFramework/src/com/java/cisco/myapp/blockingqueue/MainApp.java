package com.java.cisco.myapp.blockingqueue;

public class MainApp {
	public static void main(String args[]){

		BlockingQueue<Message> queue = new BlockingQueue<Message>(10);
		Producer producer = new Producer(queue);
		
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		
		new Thread(producer,"Producer ").start();;
		new Thread(consumer1,"Consumer 1").start();
		new Thread(consumer2,"Consumer 2").start();
		new Thread(consumer3,"Consumer 3").start();
		
		System.out.println("All producer and consumer have been started executing");
	}
}
