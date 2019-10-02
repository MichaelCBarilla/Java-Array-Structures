
public class PhoneListing implements KeyMode {
	//Fields
	private String name;
	private String address;
	private String number;
	
	//Constructors
	PhoneListing(String n, String a, String num) {
		name = n;
		address = a;
		number = num;
	}
	
	//Methods
	public String toString() {
		return ("Name is " + name +
					"\nAddress is " + address +
					"\nNumber is " + number + 
					"\n");
	}
	
	public KeyMode deepCopy() {
		PhoneListing clone = new PhoneListing (name, address, number);
		return clone;
	}
	
	public int compareTo(Object targetKey) {
		String tKey = (String) targetKey; 
		return (name.compareTo(tKey));
	}
	
	public Object getKey() {
		return name;
	}
	
}