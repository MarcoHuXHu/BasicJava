package Workshop3;

import Workshop2.Person;

public class testSuperSubClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test super-class and sub-class
		// Employee is derived from Person
		Person e, f;
		Employee m;//, n;
		e = new Employee("", "Edmund", "Ang");
		f = new Person("", "Adeline", "Boo");
		m = new Employee("", "Edmund", "Ang");
		//n = new Person("", "Adeline", "Boo");
		// Error as cannot store a super-class object in a sub-class variable
		//Employee l = f; 
		// Correct as store a sub-class object in a super-class variable. Or, let's say g is more abstract than m, so g can store m
		Person g = m;
		e.show();
		f.show();
		m.show();
		g.show();
	}

}
