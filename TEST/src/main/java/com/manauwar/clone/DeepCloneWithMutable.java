package com.manauwar.clone;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class DeepCloneWithMutable {

	public static void main(String args[]) {

		// deep cloning Collection in Java

		Collection<Employee> org = new HashSet<>();
		org.add(new Employee("Joe", "Manager"));
		org.add(new Employee("Tim", "Developer"));
		org.add(new Employee("Frank", "Developer"));

		// creating copy of Collection using copy constructor
		Collection<Employee> copy = new HashSet<>(org);
		System.out.println("Original Collection {} " + org);
		System.out.println("Copy of Collection using copy constructor {} " + copy);

		Iterator<Employee> itr = org.iterator();

		while (itr.hasNext()) {

			itr.next().setDesignation("staff");

		}

		System.out.println("Original Collection after modification {} " + org);

		System.out.println("Copy of Collection without modification {} " + copy);
		
		
		System.out.println("\n\nNow Actual " + copy);
		Collection<Employee> copy2 = new HashSet<Employee>(copy.size());
		Iterator<Employee> iterator = copy.iterator();

		while (iterator.hasNext()) {
			copy2.add(iterator.next().clone());
		}
		
		Iterator<Employee> itr2 = copy.iterator();

		while (itr2.hasNext()) {

			itr2.next().setDesignation("Hero");

		}

		

		System.out.println("Original Collection after modification {} " + copy);

		System.out.println("Copy of Collection without modification with deep cloning {} " + copy2);

	}

}

class Employee implements Cloneable {

	private String name;
	private String designation;

	public Employee(String name, String designation) {

		this.name = name;
		this.designation = designation;

	}

	public String getDesignation() {

		return designation;

	}

	public void setDesignation(String designation) {

		this.designation = designation;

	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;

	}

	@Override
	public String toString() {

		return String.format("%s: %s", name, designation);

	}

	@Override
	protected Employee clone() {

		Employee clone = null;

		try {
			clone = (Employee) super.clone();

		} catch (CloneNotSupportedException e) {

			throw new RuntimeException(e); // won't happen

		}

		return clone;

	}

}
