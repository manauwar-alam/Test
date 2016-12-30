package com.manauwar;

public class MyWaitAndNotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Test monitorObject = new Test();
	Boolean wasSignalled = false;
	
	
	public void doWait()
	{
		synchronized(monitorObject)
		{
			while(!wasSignalled)
			{
				try {
					monitorObject.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			wasSignalled = false;
		}
	}
	
	
	public void doNotify()
	{
		synchronized (monitorObject) {
			wasSignalled = true;
			monitorObject.notify();
			
		}
	}

}
