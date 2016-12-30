package com.manauwar.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchImp {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(3);
		Wait wait = new Wait(latch);
		Decrementer dec = new Decrementer(latch);
		
		new Thread(wait).start();
		new Thread(dec).start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}


class Wait implements Runnable
{
	CountDownLatch latch = null;
	public Wait(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run()
	{
		try {
			System.out.println("Waiting");
			latch.await();
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Waiter released, starting my work");
	}
}

class Decrementer implements Runnable
{
	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {


		try {

			latch.countDown();
			System.out.println("Countdown 1");
			Thread.sleep(1000);

			latch.countDown();
			System.out.println("Countdown 2");
			Thread.sleep(1000);

			latch.countDown();
			System.out.println("Countdown 3");
			Thread.sleep(1000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}


}
