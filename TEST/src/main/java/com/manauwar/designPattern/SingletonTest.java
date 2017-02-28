package com.manauwar.designPattern;

import com.manauwar.Test;

public class SingletonTest {
	
		
	
	//And this can be called from clients :
		public static void main(String[] args) {
			Singleton.INSTANCE.getTest();
			Singleton.getInstance().getTest();
		    }

		
		enum Singleton
		{
		    INSTANCE;

		    // instance vars, constructor
		    private final Test test;

		    Singleton()
		    {
		        // Initialize the connection
		    	test = new Test("xyz");
		    }

		    // Static getter
		    public static Singleton getInstance()
		    {
		        return INSTANCE;
		    }

		    public Test getTest()
		    {
		    	System.out.println(test);
		        return test;
		    }
		}
}


