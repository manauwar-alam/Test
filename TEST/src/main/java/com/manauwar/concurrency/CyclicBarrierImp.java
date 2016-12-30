package com.manauwar.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//it is a barrier that all threads must wait at, until all threads reach it, before any of the threads can continue

public class CyclicBarrierImp {


	public static void main(String[] args) {

		Runnable barrier1Action = new Runnable() {

			public void run()
			{
				System.out.println("All parties have arrived at barrier1");
			}
		};

		Runnable barrier2Action = new Runnable() {

			public void run()
			{
				System.out.println("All parties have arrived at barrier2");
			}
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);


		new Thread(barrierRunnable1,"Thread-1").start();
		new Thread(barrierRunnable2,"Thread-2").start();

	}

}


class CyclicBarrierRunnable implements Runnable
{
	CyclicBarrier barrier1 = null;
	CyclicBarrier barrier2 = null;

	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {

		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);

			System.out.println(Thread.currentThread().getName()+" waiting at barrier1");
			barrier1.await();
			System.out.println(Thread.currentThread().getName()+" crossed barrier1");

			System.out.println(Thread.currentThread().getName()+" waiting at barrier2");
			barrier2.await();
			System.out.println(Thread.currentThread().getName()+" crossed barrier2");
			
			System.out.println(Thread.currentThread().getName()+" Thread done");


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}