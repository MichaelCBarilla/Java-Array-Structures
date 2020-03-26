
public class UOA<T> {
	//Fields
	private int next;
	private T[] data;
	private int size;
	private boolean expandable;
	
	//Constructors
	public UOA() {
		next = 0;
		size = 100;
		data = (T[])new Object[size];
	}
	
	public UOA(int s, boolean e) {
		next = 0;
		data = (T[]) new Object[s];
		size = s;
		expandable = e;
	}
	
	//Methods
	public boolean insert(T newNode) {
		KeyMode node = (KeyMode) newNode;
		if (expandable && next >= size) {										//Check for expansion
			size = size * 2;																		
			T[] temp = data;																
			T[] larger = (T[]) new Object[size];									
			data = larger;																		
			System.arraycopy(temp, 0, data, 0, temp.length);			
			temp = null;																		
			larger = null;
		}																								
		
		if (expandable == false && next >= size) {						//Check
			return false;																							
		}																								
		
		data[next] = (T) node.deepCopy();										//Insert
		next++;
		return true;
	}																									
	
	public KeyMode fetch(Object targetKey) {
		KeyMode node = (KeyMode) data[0];									//Fetch
		T temp;
		int i = 0;
		while (i < next && node.compareTo(targetKey) != 0) {
			i++;
			node = (KeyMode) data[i];
		}
		if (i == next) {
			return null;
		}
		node = node.deepCopy();
		// Optimizing/Bubbling most used data towards top.
		if (i != 0) {																				//Bubble up node
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}
		return node;
	}

	public boolean delete(Object targetKey) {
		KeyMode node = (KeyMode) data[0];									//Delete
		int i = 0;
		while (i < next && node.compareTo(targetKey) != 0) {
			i++;
			node = (KeyMode) data[i];
		}
		if (i == next) {
			return false;
		}
		next--;
		data[i] = data[next];															//Garbage Collection
		data[next] = null;
		return true;
	}
	
	public boolean update(Object targetKey, T newNode) {
		KeyMode node = (KeyMode) data[0];									//Update
		int i = 0;
		while (i < next && node.compareTo(targetKey) != 0) {
			i++;
			node = (KeyMode) data[i];
		}
		if (i == next) {
			return false;
		}
		node = (KeyMode) newNode;
		data[i] = (T) node.deepCopy();
		return true;
	}
	public void showAll() {
		for (int i = 0; i < next; i++) {
			System.out.println(data[i].toString());
		}
	}
}
