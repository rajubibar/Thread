package com.java.cisco.myapp.ownthreadpool;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ThreadPool pool = new ThreadPool(2);
		Runnable task = new Task();
		pool.execute(task);
		pool.execute(task);
		pool.shutdowm();
	}
}
