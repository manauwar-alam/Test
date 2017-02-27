package com.manauwar.oops;

public class StaticNestedClassTest {
	
	public static void main(String ...a)
	{
		
		StaticNestedOuterClass.method3();
		
		System.out.println("From outside of outer class");
		StaticNestedOuterClass.StaticNestedClass staticNested = new StaticNestedOuterClass.StaticNestedClass();
		staticNested.method();
		
	}
	

}


class StaticNestedOuterClass
{
	
	
	static class StaticNestedClass
	{
		void method()
		{
			System.out.println("Inside static nested class");
		}
	}
	
	static void method3()
	{
		System.out.println("From static method");
		StaticNestedClass snc = new StaticNestedClass();
		snc.method();
	}
}
