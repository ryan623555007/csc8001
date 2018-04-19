package submittedcoursework2;

import entity.Customer;
import entity.Match;
import entity.SortedArrayList;

public class TicketService {
	private SortedArrayList<Match> MatchList;
	private SortedArrayList<Customer> CustomerList;
	public TicketService(SortedArrayList<Match> MatchList, SortedArrayList<Customer> CustomerList) {
		this.MatchList = MatchList;
		this.CustomerList = CustomerList;
	}
	
	public String boughtTicket(String MatchName,Customer Customer, int ticketNum){
		Match targetMatch = null;
		/**
		 * find the target Match
		 */
		for(Match match : MatchList) {
			if(match.getMatchName().equals(MatchName)){
				targetMatch = match;
				break;
			}
		}
		if(targetMatch != null) {
			/**
			 * find the target Customer
			 */
			Customer targetCustomer = null;
			for(Customer customer : CustomerList) {
				if(customer.equals(Customer)) {
					targetCustomer = customer;
					break;
				}
			}
			if(targetCustomer != null) {
				if(!targetCustomer.getMatchMap().containsKey(MatchName) && 
						targetCustomer.getMatchMap().size() >= Customer.MAX_MatchS_NUM){
					return "The Customer bought enough Matchs(3).";
				}else{
					if(targetMatch.getRestOfTicket() < ticketNum) {
						return "The left ticket of the Match isn't enough.";
					}else{
						
						if(targetCustomer.getMatchMap().containsKey(MatchName)){
							Integer value = targetCustomer.getMatchMap().get(MatchName);
							targetCustomer.getMatchMap().put(MatchName, value+ticketNum);
						}else{
							targetCustomer.getMatchMap().put(MatchName, ticketNum);
						}
						targetMatch.setNoOfTicketsLeft(targetMatch.getNoOfTicketsLeft()-ticketNum);
						return "Bought tickets success.";
					}
				}
			}else{
				return "The Customer isn't a valid Customer.";
			}
		}else{
			return "Match isn't an available Match.";
		}
	}
	
	public String cancelTicket(String MatchName,Customer Customer, int ticketsNum) {
		Match targetMatch = null;
		/**
		 * find the target Match
		 */
		for(Match match : MatchList) {
			if(match.getMatchName().equals(MatchName)){
				targetMatch = match;
				break;
			}
		}
		if(targetMatch != null) {
			/**
			 * find the target Customer
			 */
			Customer targetCustomer = null;
			for(Customer customer : CustomerList) {
				if(customer.equals(Customer)) {
					targetCustomer = customer;
					break;
				}
			}
			if(targetCustomer != null) {
				int value = targetCustomer.getMatchMap().get(MatchName);
				if(value < ticketsNum) {
					return "The Customer didn't bought enough tickets.";
				}else if(value == ticketsNum){
					targetCustomer.getMatchMap().remove(MatchName);
				}else if(value > ticketsNum){
					targetCustomer.getMatchMap().put(MatchName, value - ticketsNum);
				}
				targetMatch.setRestOfTicket(restOfTicket);(targetMatch.getRestOfTicket()+ticketsNum);
				return "Return tickets success.";
			}else{
				return "The Customer isn't a valid Customer.";
			}
		}else{
			return "Match isn't an available Match.";
		}
	}
	
	public  SortedArrayList<Match> getMatchList() {
		return MatchList;
	}
	public SortedArrayList<Customer> getCustomerList() {
		return CustomerList;
	}
}
