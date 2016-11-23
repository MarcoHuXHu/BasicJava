package Workshop2;

public class Facility {
	protected String name;
	protected String description;
	
	// Constructors
	public Facility(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public Facility() {
		this("", "");
	}	
	// Properties
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	// show
	public void show() {
		System.out.println(name + ": " + description);
	}
	@Override
	public String toString() {
		return name + ": " + description;
	}
	// 添加了comparTo, 才能用Collections.sort()
	public int compareTo(Facility facility2) {
		return this.name.compareTo(facility2.name); 
	}
}
