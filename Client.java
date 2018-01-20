package entity;


import java.util.HashMap;
/**
 *this class is used for storing all clients 
 * @author SunXiaoyong
 * @version 1.0 10/12/2017
 * @since    JDK1.8
 */
public class Client implements Comparable<Client>{
	/**
	 * the first name of client
	 */
	private String firstname;
	/**
	 * the surname of client
	 */
	private String surname;
	/**
	 * the list to store client' event, max number is 3
	 */
	private HashMap<String,Integer> eventMap = new HashMap<String,Integer>();
	public final static int MAX_EVENTS_NUM = 3;
	/**
	 * @param the firstname
	 * @param the surname
	 */
	public Client(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;
	}
	public Client() {
		super();
	}
	/**
	 * @get the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @set the firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @get the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @set the surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @get the eventmap
	 */
	public HashMap<String, Integer> getEventMap() {
		return eventMap;
	}
	/**
	 * @set the eventmap
	 */
	public void setEventMap(HashMap<String, Integer> eventMap) {
		this.eventMap = eventMap;
	}
	/**
	 * print  the client firstname and surname 
	 */
	@Override
	public String toString() {
		return "Client [firstname=" + firstname + ", surname=" + surname + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public int compareTo(Client o) {
		if(this.surname.compareTo(o.surname) == 0){
			return this.firstname.compareTo(o.firstname);
		}else{
			return this.surname.compareTo(o.surname);
		}
	}
}
