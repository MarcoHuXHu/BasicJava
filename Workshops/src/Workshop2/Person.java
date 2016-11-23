package Workshop2;

public class Person {
	protected String surName;
	protected String firstName;
	protected String secondName;
	
	// Constructors
	public Person(String surName, String firstName, String secondName) {
		//super();
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	public Person() {
		this("","","");
	}
	// Properties
	public String getSurName() {
		return surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	// show
	public void show() {
		System.out.println(firstName + " " + secondName);
	}
	@Override
	public String toString() {
		return firstName + " " + secondName;
	}
}
