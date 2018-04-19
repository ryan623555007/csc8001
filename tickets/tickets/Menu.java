package submittedcoursework2;

import java.io.*;
import java.util.Map.Entry;

import entity.Client;

import java.util.*;

public class Menu {
	
	public static String path = "match";
	static TicketService ticketService;
	static ArrayList<Match> matchList = new ArrayList<Match>(); 
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public static void readMatchInfo() throws IOException{
		
		try{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		int matchNum = Integer.parseInt(line);
		for (int i = 0; i < matchNum; i++) {
			String matchName = reader.readLine();
			int ticketLeft = Integer.parseInt(reader.readLine());
			Match match = new Match(matchName, ticketLeft);
			matchList.add(match);
		}
		
		int clientNum = Integer.parseInt(reader.readLine());
		for (int i = 0; i < clientNum; i++) {
			String name = reader.readLine();
			String[] split = name.split(" ");
			Customer customer = new Customer(split[0], split[1]);
			
			int ticketNum = Integer.parseInt(reader.readLine());
			for (int j = 0; j < ticketNum; j++) {
				customer.getMatchMap().put(reader.readLine(), Integer.parseInt(reader.readLine()));
			}
			matchList.add(customer);
		}
		ticketService = new TicketService(matchList, customerList);
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (NumberFormatException e) {
		e.printStackTrace();
		System.out.println("file read error!");
		System.exit(0);
	}
}
	public static void saveToFile(){
		
			try {
				
				StringBuilder sb = new StringBuilder();
				
				sb.append(matchList.size() + "\r\n");
				for (Match match : matchList) {
					sb.append(match.getMatchName() + "\r\n");
					sb.append(match.getRestOfTicket() + "\r\n");
				}
				
				sb.append(customerList.size() + "\r\n");
				for (Customer customer : customerList) {
					sb.append(customer.getFirstName() + " " + customer.getLastName() + "\r\n");
				
					sb.append(customer.getMatchMap().size() + "\r\n");
					for (Entry<String, Integer> entry : customer.getMatchMap().entrySet()) {
						sb.append(entry.getKey() + "\r\n");
						sb.append(entry.getValue() + "\r\n");
					}
				}
			
				BufferedWriter writer = new BufferedWriter(new FileWriter(path));
				writer.write(sb.toString());
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public static void main(String[] args) throws IOException {
		readMatchInfo();
		try {
           options();
        }catch (Exception e){
            e.printStackTrace();
        }	    
	}
	public static  void options(){
		
	    boolean result =  true;
		Scanner scanner = new Scanner(System.in);    
	    System.out.println("r.to finish running the program");
		System.out.println("e.to display on the screen the information about all the events.");
		System.out.println("c.to display on the screen the information about all the clients");
		System.out.println("b.to update the stored data when tickets are bought by one of the registered clients.");
		System.out.println("f.to update the stored data when a registered client cancels/returns tickets.");
		System.out.println("-------------------");
		String option = scanner.nextLine();
		switch (option) {
		case "r":
		case "R":
			saveToFile();
			System.out.println("finish running the program.");
			System.out.println("see you!");
			result = false;
			break;
		case "e":
		case "E":
			printAllMatch();
			{
				for (Match match : TicketService.getMatchList()) {
					System.out.printf(String.format("%-15s%5d\n", match.getMatchName(), match.getRestOfTicket()));
				}
				System.out.println();
			}
			
			break;
			
		case "c":
		case "C":
			c();
			break;
		case "b":
		case "B":	
			b();
			break;
		case "f":
		case "F":
			f();			
		default:
			break;
		}		
	}

	public static void printAllMatch(){
		
	}
	
	public static void printAllCustomer(){
		for (Customer customer : ticketService.getCustomerList()) {
			String eventShow = "";
			for (Entry<String, Integer> entry : customer.getMatchMap().entrySet()) {
				eventShow += entry.getKey() + ":" + entry.getValue() + "   ";
			}
			System.out.printf(String.format("%-15s%-14s%-20s\n", customer.getFirstName(), customer.getLastName(), eventShow));
		}
		System.out.println();
	}
	public static void b(){
			Scanner in = new Scanner(System.in);
			System.out.println("please input event name");
			String eventName = in.nextLine();
			System.out.println("please input the first name of client");
			String firstName = in.nextLine();
			System.out.println("please input the surname of client");
			String surname = in.nextLine();
			System.out.println("please input the ticket number");
			try {
				int num = Integer.parseInt(in.nextLine());
				if(num <=0) {
					System.out.println("the ticket number should more than 0!");
				}else{
					String result = ticketService.boughtTicket(eventName, new Client(firstName,surname), num);
					System.out.println(result);
				}
			} catch (NumberFormatException e) {
				System.out.println("ticket number input error");
			}
			System.out.println();
	}
	 public static void c(){
		 System.out.println("=======================================");
			System.out.println("firstName      surName       event:tickets");
			for (Customer customer : ticketService.getCustomerList()) {
				String eventShow = "";
				for (Entry<String, Integer> entry : customer.getMatchMap().entrySet()) {
					eventShow += entry.getKey() + ":" + entry.getValue() + "   ";
				}
				System.out.printf(String.format("%-15s%-14s%-20s\n", customer.getFirstName(), customer.getLastName(), eventShow));
			}
			System.out.println();
	 }
	 
	 public static void f(){
		 	Scanner in = new Scanner(System.in);
			System.out.println("please input event name");
			String matchName = in.nextLine();
			System.out.println("please input the first name of client");
			String firstName = in.nextLine();
			System.out.println("please input the lastname of client");
			String lastName = in.nextLine();
			System.out.println("please input the ticket number");
			try {
				int num = Integer.parseInt(in.nextLine());
				if(num <=0) {
					System.out.println("the ticket number should more than 0!");
				}else{
					String result = ticketService.cancelTicket(matchName, Customer(firstName,lastName),num);
				}
			} catch (NumberFormatException e) {
				System.out.println("ticket number input error");
			}
			System.out.println();
	 }
	 


}
