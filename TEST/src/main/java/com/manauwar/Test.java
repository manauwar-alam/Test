package com.manauwar;

public class Test {
	String s = null;
	public Test(String s)
	{
		System.out.println("Test class called "+s);
	}
	
	public Test()
	{
		
		
	}

	public void myMethod()
	{
		System.out.println("Test class called "+s);
	}
	
	public String toString()
	{
		return s;
	}

}
