package entity;

import java.util.PrimitiveIterator.OfDouble;
import java.util.jar.Attributes.Name;

/**
*this class is used for storing all events 
* @author SunXiaoyong
* @version 1.0 10/12/2017
* @since    JDK1.8
*/
public class Event implements Comparable<Event>{
	/**
	 * the event name
	 */
	private String name;
	/**
	 * the number of tickets available for this event
	 */
	private Integer noOfTicketsLeft;
	public Event() {
		super();
	}
	/**
	 * Constructor to initial parameter
	 */
	public Event(String name, Integer noOfTicketsLeft) {
		super();
		this.name = name;
		this.noOfTicketsLeft = noOfTicketsLeft;
	}
	/**
	 * @get name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @set name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @get the amount of tickets 
	 */
	public Integer getNoOfTicketsLeft() {
		return noOfTicketsLeft;
	}
	/**
	 * @set the amount of tickets 
	 */
	public void setNoOfTicketsLeft(Integer noOfTicketsLeft) {
		this.noOfTicketsLeft = noOfTicketsLeft;
	}
	/**
	 * print the name and amount of tickets
	 */
	@Override
	public String toString() {
		return "Event [name=" + name + ", noOfTicketsLeft=" + noOfTicketsLeft + "]";
	}
	/**
	 * compare two object
	 */
	@Override
	public int compareTo(Event o) {
		return this.name.compareTo(o.name);
	}
	
}
