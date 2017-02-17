package com.manauwar.concurrency;

class OdEv {
	static	int i = 1;
	
	
		public void printOdd() {
			synchronized(this) {
					if(i%2!=0) {
						System.out.println("Printing odd numbers..... "+i);
						i++;
						this.notify();
					}	
						try {
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
		}
		
		public void printEven() {
			synchronized(this) {
					if(i%2==0) {
						System.out.println("Printing even numbers..... "+i);
						i++;
						this.notify();
					}	
						try {
							if(i<=20)
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
			}
		}
	
}


public class ThreadDemo {
	static OdEv obj = new OdEv();
	public static void main(String args[]) {
	  Thread oddThread = new Thread() {
		public void run() {
			for(int i=0;i<10;i++) {
				obj.printOdd();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	  };
		
	  Thread evenThread = new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					obj.printEven();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		  };	
		
		
		try {
			oddThread.start();
			evenThread.start();
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.out.println("Printing over");
		
} 
}
