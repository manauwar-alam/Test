package com.manauwar.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierUsingClient {

	public static void main(String ...a)
	{
		CyclicBarrier cb =new CyclicBarrier(3);

		Runnable one = new MessageOne(cb);
		Runnable two = new Messagetwo(cb);
		Runnable three = new Messagethird(cb);

		Thread first = new Thread(one);
		Thread second = new Thread(two);
		Thread third = new Thread(three);


		first.start();
		second.start();
		third.start();
	}

}


class MessageOne implements Runnable{
	CyclicBarrier cb;
	MessageOne(CyclicBarrier cb)
	{
		this.cb=cb;
	}
	@Override
	public void run()
	{
		try {
			System.out.println("This is from Message one now awaiting ");
			cb.await();
			//Thread.currentThread().sleep(2000);
			System.out.println(" thread one wait completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Messagetwo implements Runnable{
	CyclicBarrier cb;
	Messagetwo(CyclicBarrier cb)
	{
		this.cb=cb;
	}
	@Override
	public void run()
	{

		try {
			System.out.println("This is from Message two");
//			Thread.sleep(20000);
			cb.await();
			System.out.println("This is from Message two wait completed");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Messagethird implements Runnable{
	CyclicBarrier cb;
	Messagethird(CyclicBarrier cb)
	{
		this.cb=cb;
	}
	@Override
	public void run()
	{
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("This is from Message third");
	}
}