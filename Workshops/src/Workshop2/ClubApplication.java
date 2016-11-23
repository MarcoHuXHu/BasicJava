package Workshop2;

public class ClubApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person pe = new Person("A", "B", "C");
		Facility fa = new Facility("Club", "Description");
		System.out.println(pe.getSurName());
		pe.show();
		fa.show();
	}

}
