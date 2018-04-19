package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.util.Scanner;

import entity.Client;
import entity.Event;
import entity.SortedArrayList;
import service.TicketService;

/**
*this class used SortedArrayList class and list main menu about all of the functions
* @author SunXiaoyong
* @version 1.0 10/12/2017
* @since    JDK1.8
*/
public class Main {
	public final static String INPUT_FILE = "data.txt";
	public static TicketService ticketService;
	/**
	 * read the data from file
	 */
	static {
		try {
			File file = new File(INPUT_FILE);
			if (!file.exists()) {
				file.createNewFile();
			}
			SortedArrayList<Event> eventsList = new SortedArrayList<Event>();
			SortedArrayList<Client> clientsList = new SortedArrayList<Client>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			/**
			 * read event
			 */
			int eventNum = Integer.parseInt(line);
			for (int i = 0; i < eventNum; i++) {
				String eventName = reader.readLine();
				int ticketLeft = Integer.parseInt(reader.readLine());
				eventsList.add(new Event(eventName, ticketLeft));
			}
			/**
			 * read client
			 */
			int clientNum = Integer.parseInt(reader.readLine());
			for (int i = 0; i < clientNum; i++) {
				String name = reader.readLine();
				String[] split = name.split(" ");
				Client c = new Client(split[0], split[1]);
				/**
				 * read client tickets
				 */
				int ticketNum = Integer.parseInt(reader.readLine());
				for (int j = 0; j < ticketNum; j++) {
					c.getEventMap().put(reader.readLine(), Integer.parseInt(reader.readLine()));
				}
				clientsList.add(c);
			}
			ticketService = new TicketService(eventsList, clientsList);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("file read error!");
			System.exit(0);
		}
	}

	/**
	 * save events and client to file
	 */
	public static void saveToFile() {
		try {
			File file = new File(INPUT_FILE);
			if (!file.exists()) {
				file.createNewFile();
			}
			/**
			 * buffered string
			 */
			StringBuilder sb = new StringBuilder();
			SortedArrayList<Client> clientsList = ticketService.getClientsList();
			SortedArrayList<Event> eventsList = ticketService.getEventsList();
			/**
			 * save events
			 */
			sb.append(eventsList.size() + "\r\n");
			for (Event i : eventsList) {
				sb.append(i.getName() + "\r\n");
				sb.append(i.getNoOfTicketsLeft() + "\r\n");
			}
			/**
			 * save clients
			 */
			sb.append(clientsList.size() + "\r\n");
			for (Client i : clientsList) {
				sb.append(i.getFirstname() + " " + i.getSurname() + "\r\n");
				/**
				 * save the event tickets of client
				 */
				sb.append(i.getEventMap().size() + "\r\n");
				for (Entry<String, Integer> entry : i.getEventMap().entrySet()) {
					sb.append(entry.getKey() + "\r\n");
					sb.append(entry.getValue() + "\r\n");
				}
			}
			/**
			 * write to file
			 */
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * show the UI for the user
	 */
	public static void show() {
		System.out.println("f. finish running the program and save the data");
		System.out.println("e. display the all events");
		System.out.println("c. display the all clients");
		System.out.println("b. bought tickets by one of the registered clients.");
		System.out.println("r. registered client cancels/returns tickets.");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			show();
			System.out.println("\nplease input your option:");
			String op = in.nextLine();
			switch (op) {
			case "f":
				System.out.println("Good bye!");
				saveToFile();
				flag = false;
				break;
			case "e":
				System.out.println("==========================");
				System.out.println("eventName      ticketsLeft");
				for (Event i : ticketService.getEventsList()) {
					System.out.printf(String.format("%-15s%5d\n", i.getName(), i.getNoOfTicketsLeft()));
				}
				System.out.println();
				break;
			case "c":
				System.out.println("=======================================");
				System.out.println("firstName      surName       event:tickets");
				for (Client i : ticketService.getClientsList()) {
					String eventShow = "";
					for (Entry<String, Integer> entry : i.getEventMap().entrySet()) {
						eventShow += entry.getKey() + ":" + entry.getValue() + "   ";
					}
					System.out.printf(String.format("%-15s%-14s%-20s\n", i.getFirstname(), i.getSurname(), eventShow));
				}
				System.out.println();
				break;
			case "b":
			{
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
				break;
			case "r":
			{
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
						String result = ticketService.cancelTicket(eventName, new Client(firstName,surname), num);
						System.out.println(result);
					}
				} catch (NumberFormatException e) {
					System.out.println("ticket number input error");
				}
				System.out.println();
			}
				break;
			default:
				System.out.println("input error!\n");
				break;
			}
		}

	}
}
