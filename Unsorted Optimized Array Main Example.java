import java.util.ArrayList;

public class UOAMain {
	public static void main(String[] args) {
		UOA <PhoneListing> NYC = new UOA<PhoneListing>(500, true);
		
		PhoneListing tom = new PhoneListing("Tom", "1st", "743 2314");
		PhoneListing mary = new PhoneListing("Mary", "2nd", "243 334");
		PhoneListing mike = new PhoneListing("Mike", "3rd", "854 3251");
		PhoneListing joe = new PhoneListing("Joe", "4th", "917 3499");
		PhoneListing nick = new PhoneListing("Nick", "5th", "111 3847");
		PhoneListing darian = new PhoneListing("Darian", "6th", "329 3088");
		
		 NYC.insert(tom);
		 NYC.insert(mary);
		 NYC.insert(mike);
		 NYC.insert(joe);
		 NYC.insert(nick);
		 NYC.showAll();
		 NYC.update("Mike", darian);
		 System.out.println("--------------------------");
		 NYC.showAll();
		 NYC.delete("Nick");
		 System.out.println("--------------------------");
		 NYC.showAll();
		 
	}
	
}
