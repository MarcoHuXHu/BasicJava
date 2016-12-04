package Workshop4;

import java.util.ArrayList;

public class testGeneric<E> {
	private ArrayList<E> storage;
	public testGeneric() {
		storage = new ArrayList<E>();
	}
	public boolean add(E item) {
		storage.add(item);
		return true;
	}
	public E getItem(int i) {
		return storage.get(i);
	}
}
