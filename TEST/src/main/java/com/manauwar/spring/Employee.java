package com.manauwar.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Employee {

	@Autowired
	Address address;  
	
	Employee()
	{
		System.out.println("Employee is created");
	}  
	
	public Address getAddress() {  
		return address;  
	} 
	
	
	public void setAddress(Address address) {  
		this.address = address;  
	} 
	
	void print()
	{
		System.out.println("hello Employee");
	}
	
	void display(){  
		print();  
		address.print();  
	}  


}
