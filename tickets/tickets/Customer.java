package submittedcoursework2;

import java.util.HashMap;

public class Customer implements Comparable<Customer>{
	private String firstName;
	private String lastName;
	private HashMap<String,Integer> matchMap = new HashMap<String,Integer>();
	public final static int MAX_EVENTS_NUM = 3;
	

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	
	}
	public String getFirstName() {
		return firstName;
	}
	public void setName(String name1,String name2) {
		firstName = name1;
		lastName=name2;
	}
	public String getLastName() {
		return lastName;
	}


	public HashMap<String, Integer> getMatchMap() {
		return matchMap;
	}
	public void setMatchMap(HashMap<String, Integer> matchMap) {
		this.matchMap = matchMap;
	}
	@Override
	public int compareTo(Customer o) {
		
		return this.lastName.compareTo(o.lastName);
	}
	public String toString(){
		return "lastName" + lastName + ",firstName" + lastName;
	}
	
	
}
