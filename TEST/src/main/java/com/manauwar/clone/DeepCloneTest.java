package com.manauwar.clone;

import java.util.ArrayList;
import java.util.List;

public class DeepCloneTest {

	public static void main(String args[]) {
		Programmer javaguru = new Programmer("John", 31);

		javaguru.addCertificates("OCPJP");
		javaguru.addCertificates("OCMJD");
		javaguru.addCertificates("PMP");
		javaguru.addCertificates("CISM");

		System.out.println("Real Java Guru : {} " + javaguru);
		
		
		Programmer clone = javaguru.clone();
		
		System.out.println("Clone of Java Guru : {} " + clone);

		// let's add another certification to java guru
		javaguru.addCertificates("Oracle DBA");
		
		System.out.println("Real Java Guru after change : {} " + javaguru);
		System.out.println("Clone of Java Guru : {} " + clone);

	}
}

class Programmer implements Cloneable {

	private String name;
	private int age;
	private List<String> certifications;

	public Programmer(String name, int age) {

		this.name = name;
		this.age = age;
		this.certifications = new ArrayList<String>();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCertificates(String certs) {
		certifications.add(certs);
	}

	@Override
	public String toString() {
		return String.format("%s, %d, Certifications: %s", name, age, certifications.toString());
	}

	@Override
	protected Programmer clone() {
		Programmer clone = null;
		try {
			clone = (Programmer) super.clone();
			clone.certifications = new ArrayList<String>(certifications); // deep copying
																	
		} catch (CloneNotSupportedException cns) {
			System.out.println("Error while cloning programmer " + cns);
		}
		return clone;

	}
}
