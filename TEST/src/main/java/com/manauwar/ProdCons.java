package com.manauwar;

class PdCns{
	static int i ;
	static boolean flag=true;
	
	public void produce() {
		synchronized(this) {
			if(flag) {
				i++;
				System.out.println("Item produced......"+i+"       "+System.nanoTime());
				this.notify();
				flag=false;
			}
			else {
				try {
					System.out.println(Thread.currentThread().getName()+" is waiting.....   "+System.nanoTime());
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public void consume() {
		synchronized(this) {
			if(!flag) {
				System.out.println("Item consumed......"+i+"       "+System.nanoTime());
				this.notify();
				flag=true;
			}
			else {
				try {
					System.out.println(Thread.currentThread().getName()+" is waiting.....   "+System.nanoTime());
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	  }
	}
}
public class ProdCons {
public static void main(String args[]) {
	final PdCns obj = new PdCns();
	Thread producer  = new Thread () {
		public void run() {
			for(int i=0;i<5;i++) {
				obj.produce();
			}
		}
	};
	
	Thread consumer  = new Thread () {
		public void run() {
			for(int i=0;i<5;i++) {
				obj.consume();
			}
		}
	};
	producer.start();
	producer.setName("Producer");
	consumer.start();
	consumer.setName("Consumer");
	try {
		producer.join();
		consumer.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
