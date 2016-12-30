package com.manauwar.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueImp {

	public static void main(String[] args) {
		

		ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1024);
		
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		
		new Thread(producer).start();
        new Thread(consumer).start();

        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}



 class Consumer implements Runnable
{
	protected BlockingQueue<String> queue = null;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	public void run()
	{
		try {
			
			for(int i=1; i<=20; i++)
			{
				queue.put(i+"");
				System.out.println("put : "+i);
				Thread.sleep(1000);
			}
			
			System.out.println("Left in queue : "+queue);
//			queue.put("1");
//			Thread.sleep(1000);
//			queue.put("2");
//			Thread.sleep(1000);
//			queue.put("3");
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
 
 
 class Producer implements Runnable
 {
	 protected BlockingQueue<String> queue = null;
	 
	 public Producer(BlockingQueue<String> q) {
		 queue = q;

	 }
	 
	 public void run()
	 {
		 try {
			
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			System.out.println("take : "+queue.take());
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	 }
 }
