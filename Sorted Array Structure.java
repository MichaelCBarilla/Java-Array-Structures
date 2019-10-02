
public class MySortedArray{
	//Fields
	private int next = 0;
	private int nodeMax;
	private Person[] data;
	
	//Constructors
	MySortedArray() {
		nodeMax = 10;
		data = new Person[nodeMax];
	}
	
	MySortedArray(int n) {
		nodeMax = n;
		data = new Person[nodeMax];
	}
	//Methods
	void insert(Person newNode) {
		String targetKey = newNode.getName();
		if (isEmpty()) {
			data[next] = newNode;
			next++;
			return;
		}
		if (next == 1) {
			if (targetKey.compareTo(data[0].getName()) < 0) {
				Person temp = data[0];
				 data[0] = newNode.deepCopy();
				 data[1] = temp;
			} else {
				data[1] = newNode.deepCopy();
			}
			next++;
			return;
		}
		int low = 0;
		int high = next - 1;
		int i = (low + high) / 2;
		while (!(targetKey.compareTo(data[i].getName()) < 0
				&& targetKey.compareTo(data[i - 1].getName()) > 0)) {
			if (targetKey.compareTo(data[i].getName()) < 0) {
				high = i - 1;
			}
			if(targetKey.compareTo(data[i].getName()) > 0) {
				low = i + 1;
			}
			i = (low + high) / 2;
		}
	}
	
	void delete(String targetKey) {
		int low = 0;
		int high = next - 1;
		int i = (low + high) / 2;
		while (!targetKey.equalsIgnoreCase(data[i].getName())) {
			if (targetKey.compareTo(data[i].getName()) < 0) {
				high = i - 1;
			}
			if(targetKey.compareTo(data[i].getName()) > 0) {
				low = i + 1;
			}
			i = (low + high) / 2;
		}
		for (int j = i; j < next - 1; j++) {
			data[j] = data[j + 1];
		}
		next--;
		data[next] = null;
	}
	
	Person fetch(String targetKey) {
		int low = 0;
		int high = next - 1;
		int i = (low + high) / 2;
		while (!targetKey.equalsIgnoreCase(data[i].getName()) && high != low) {
			if (targetKey.compareTo(data[i].getName()) < 0) {
				high = i - 1;
			}
			if(targetKey.compareTo(data[i].getName()) > 0) {
				low = i + 1;
			}
			i = (low + high) / 2;
		}
		if (!targetKey.equalsIgnoreCase(data[i].getName())) {
			return null;
		}
		return data[i].deepCopy();
	}
	
	void update(String targetKey, Person newNode) {
		if (isEmpty()) {
			System.out.println("The data set is empty");
			return;
		}
		if (next == 1) {
			if (targetKey.equalsIgnoreCase(data[0].getName())) {
				data[0] = newNode.deepCopy();
			} else {
				System.out.println("Name not found");
			}
			return;
		}
		if (next == 2) {
			for (int k = 0; k < 2; k++) {
				if (targetKey.equalsIgnoreCase(data[k].getName())) {
					data[k] = newNode.deepCopy();
					return;
				} 
			}
			System.out.println("Name not found");
			return;
		}
		int low = 0;
		int high = next - 1;
		int i = (low + high) / 2;
		while (!targetKey.equalsIgnoreCase(data[i].getName()) && high != low) {
			if (targetKey.compareTo(data[i].getName()) < 0) {
				high = i - 1;
			}
			if(targetKey.compareTo(data[i].getName()) > 0) {
				low = i + 1;
			}
			i = (low + high) / 2;
		}
		data[i] = newNode.deepCopy();
	}
	
	boolean isEmpty() {
		if (next == 0) {
			return true;
		} else {
			return false;
		}
	}
}