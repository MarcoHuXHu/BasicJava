package Workshop3;

import Workshop2.Person;

public class Employee extends Person {
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String surName, String firstName, String secondName) {
		super(surName, firstName, secondName);
		// TODO Auto-generated constructor stub
	}

	public void show() {
		System.out.println(firstName + "~~~" + secondName);
	}
	public String toString() {
		return firstName + "~~~" + secondName;
	}
}
