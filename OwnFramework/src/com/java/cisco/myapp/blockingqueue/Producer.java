package com.java.cisco.myapp.blockingqueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;
	
	public Producer(BlockingQueue<Message> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=100;i++){
			Message msg = new Message(""+i);
			try {
				Thread.sleep(200);
			
				queue.put(msg);
				System.out.println("Produced "+msg.getMsg()+" by "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		Message msg = new Message("Exit");
		try {		
			queue.put(msg);
			System.out.println("Produced "+msg.getMsg()+" by "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
