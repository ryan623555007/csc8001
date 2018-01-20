package service;

import java.io.*;

import entity.Client;
import entity.Event;
import entity.SortedArrayList;
/**
 * handle bought event and cancels/returns tickets
 * @author
 *
 */
public class TicketService {
	private SortedArrayList<Event> eventsList;
	private SortedArrayList<Client> clientsList;
	public TicketService(SortedArrayList<Event> eventsList, SortedArrayList<Client> clientsList) {
		this.eventsList = eventsList;
		this.clientsList = clientsList;
	}
	/**
	 * 
	 * @param eventName the event which the client will bought
	 * @param client the client
	 * @param ticketNum the ticket number will bought
	 * @return the bought result, if return null, bought success.
	 */
	public String boughtTicket(String eventName,Client client, int ticketNum){
		String printOutput = "the event you want to bought is no ticket ";
		
		Event targetEvent = null;
		/**
		 * find the target event
		 */
		for(Event i : eventsList) {
			if(i.getName().equals(eventName)){
				targetEvent = i;
				break;
			}
		}
		if(targetEvent != null) {
			/**
			 * find the target client
			 */
			Client targetClient = null;
			for(Client i : clientsList) {
				if(i.equals(client)) {
					targetClient = i;
					break;
				}
			}
			if(targetClient != null) {
				if(!targetClient.getEventMap().containsKey(eventName) && targetClient.getEventMap().size() >= Client.MAX_EVENTS_NUM){
					return "The client bought enough events(3).";
				}else{
					if(targetEvent.getNoOfTicketsLeft() < ticketNum) {
						
						try {	
							   FileWriter fileWriter = new FileWriter("src/output.txt");
							   fileWriter.write(printOutput);
							   fileWriter.close();
							  }catch(IOException e) {
							   System.out.println("IO Error");
							  }
							return "The left ticket of the event isn't enough."; 
					}else{
						
						if(targetClient.getEventMap().containsKey(eventName)){
							Integer value = targetClient.getEventMap().get(eventName);
							targetClient.getEventMap().put(eventName, value+ticketNum);
						}else{
							targetClient.getEventMap().put(eventName, ticketNum);
						}
						targetEvent.setNoOfTicketsLeft(targetEvent.getNoOfTicketsLeft()-ticketNum);
						return "Bought tickets success.";
					}
				}
			}else{
				return "The client isn't a valid client.";
			}
		}else{
			return "Event isn't an available event.";
		}
	}
	/**
	 * 
	 * @param eventName the event whill be cancel
	 * @param client the client who bought this event
	 * @return the cancel result
	 */
	public String cancelTicket(String eventName,Client client, int ticketsNum) {
		Event targetEvent = null;
		/**
		 * find the target event
		 */
		for(Event i : eventsList) {
			if(i.getName().equals(eventName)){
				targetEvent = i;
				break;
			}
		}
		if(targetEvent != null) {
			/**
			 * find the target client
			 */
			Client targetClient = null;
			for(Client i : clientsList) {
				if(i.equals(client)) {
					targetClient = i;
					break;
				}
			}
			if(targetClient != null) {
				int value = targetClient.getEventMap().get(eventName);
				if(value < ticketsNum) {
					return "The client didn't bought enough tickets.";
				}else if(value == ticketsNum){
					targetClient.getEventMap().remove(eventName);
				}else if(value > ticketsNum){
					targetClient.getEventMap().put(eventName, value - ticketsNum);
				}
				targetEvent.setNoOfTicketsLeft(targetEvent.getNoOfTicketsLeft()+ticketsNum);
				return "Return tickets success.";
			}else{
				return "The client isn't a valid client.";
			}
		}else{
			return "Event isn't an available event.";
		}
	}
	
	public SortedArrayList<Event> getEventsList() {
		return eventsList;
	}
	public SortedArrayList<Client> getClientsList() {
		return clientsList;
	}
}
