package submittedcoursework2;

import java.util.*;

public class SortedArrayList<E> extends ArrayList<E>{
//	static ArrayList<Customer> customerList = new ArrayList<Customer>();
//	static ArrayList<Match> matchList = new ArrayList<Match>();
//	static Scanner scanner = new Scanner(System.in);
//	static ArrayList<Bought> b = new ArrayList<Bought>();
//	
//	public static void main(String args[]) {
//		try {
//           options();
//        }catch (Exception e){
//            e.printStackTrace();
//        }	    
//	}
//		 
//	public static  void options(){
//		FileIO fileio = new FileIO();
//		fileio.readMatchInformation();
//	    boolean result =  true;
//		scanner = new Scanner(System.in);    
//	    System.out.println("r.to finish running the program");
//		System.out.println("e.to display on the screen the information about all the events.");
//		System.out.println("c.to display on the screen the information about all the clients");
//		System.out.println("b.to update the stored data when tickets are bought by one of the registered clients.");
//		System.out.println("f.to update the stored data when a registered client cancels/returns tickets.");
//		System.out.println("-------------------");
//		String option = scanner.nextLine();
//		switch (option) {
//		case "r":
//		case "R":
//			
//			System.out.println("finish running the program.");
//			System.out.println("see you!");
//			result = false;
//			break;
//		case "e":
//		case "E":
//			printAllMatch();
//			break;
//		case "c":
//		case "C":
//			printAllCustomer();
//			break;
//		case "b":
//		case "B":	
//			buyTicket();
//			break;
//		case "f":
//		case "F":
//			returnTicket();			
//		default:
//			break;
//		}		
//	}
//	
//	//打印比赛名字
//	public static void printAllMatch(){
//		Collections.sort(matchList);
//		for(Match matchs : matchList){
//			System.out.println("match name is:" + matchs.getMatchName() + " , ");
//			System.out.println("rest of ticket is:" + matchs.getRestOfTicket());
//		}			
//	}
//	
//	
//	
//	//打印客户
//	public static void printAllCustomer(){
//		Collections.sort(customerList);
////		System.out.println("11111111");
//		for(Customer customers : customerList){
//			System.out.println("11111111");
//			System.out.println("customer name is:" + customers.getLastName() + "  " + customers.getFirstName());
//		}
//	}
//	
//	//买票
//	public static void buyTicket(){
//		printAllCustomer();
//		
//		System.out.println("enter a name that want to buy ticket:");
//		String name = scanner.nextLine();
//		if(checkCustomer(name)){
//			System.out.println("the customer you enter is correct");
//			printAllMatch();
//			
//			System.out.println("enter a match name:");
//			String matchName = scanner.nextLine();
//				if(checkMatch(matchName)){
//					System.out.println("the match you enter is correct");
//				
//					System.out.println("enter the quantity:");
//					int matchQuantity = scanner.nextInt();
//					scanner.nextLine();
//						if(checkBought(name,matchQuantity)){
//							Bought b1 = new Bought(name,matchName,matchQuantity);
//							b.add(b1);
//						}
//				}else{
//					System.out.println("match is invaild");
//				}
//		}else{
//			System.out.println("customer is invaild");
//		}
//		
//		options();
//	}
//	
//	//退票
//	public static void returnTicket(){
//		System.out.println("list of customer who has bought ticket:");
//		for(Bought bought : b){
//			System.out.println(bought.getName());
//		}
//		System.out.println("enter a name which want to return ticket:");
//		String cancelName = scanner.nextLine();
//		System.out.println("enter a match which want to return ticket:");
//		String cancelMatch = scanner.nextLine();
//		System.out.println("how many tickets he/she wants to return:");
//		int cancelTicket = scanner.nextInt();
//		scanner.nextLine();
//		checkInformation(cancelName, cancelMatch, cancelTicket);
//			
//		options();
//	}
//	
//	//确认信息
//	private static boolean checkInformation(String cancelName,String cancelMatch,int cancelTicket) {
//		boolean result = false;
//		boolean condition1=true;
//		boolean condition2=true;
//		boolean condition3=true;
//		
//		for(Bought bought : b){
//			condition1 = cancelName.equals(bought.getName().replace(" ", ""));
//			condition2 = cancelMatch.equals(bought.getMatchname().replace(" ",""));
//			condition3 = cancelTicket<bought.getQuantity();
//		
//		
//			if(condition1 && condition2 && condition3){
//				bought.setQuantity(bought.getQuantity()-cancelTicket);
//				for(Match match : matchList){
//					if(cancelMatch.equals(match.getMatchName().replaceAll(" ",""))){					
//						match.setRestOfTicket(match.getRestOfTicket()+cancelTicket);					
//					System.out.println(match.getMatchName() + "rest of ticket is:" + match.getRestOfTicket());
//					}
//				}	
//				result=true;
//				System.out.println("return successfully");
//			}else{
//				System.out.println("don not have enough tiket");
//				}
//		}
//		return result;	
//	}
//
//	//检查客户名字
//	public static boolean checkCustomer(String name){
//		boolean result = false; 
//		for(Customer customer : customerList){
//			if(name.equals(customer.getLastName() + " " + customer.getFirstName())){
//				result = true;
//			}
//		}
//		return result;
//	}
//	
//	//检查比赛名字
//	public static boolean checkMatch(String matchName){
//		boolean result = false;
//		for(Match match : matchList){
//			if(matchName.equals(match.getMatchName())){
//				result = true;
//			}
//		}
//		return result;
//	}
//	
//	//检查购买
//	public static boolean checkBought(String name,int t){
//		int rest=0;
//		boolean result = false;
//		for(Match match : matchList){
//			if(name.equals(match.getMatchName())){
//				rest = match.getRestOfTicket();
//				if(match.getRestOfTicket() > t){
//					System.out.println(match.getMatchName() + "have rest of ticket is:" + rest);
//					result = true;
//				}else{
//					System.out.println("don not have enough ticket");
//				}
//			}
//		}
//			return result;
//	}
	private static final long serialVersionUID = 1L;
	
		@SuppressWarnings("unchecked")
		public void addSort(Comparable<? super E> e) {
		int i = 0;
		for(i = 0;i<this.size();i++) {
			if(e.compareTo(this.get(i)) < 0){
				break;
			}
		}
		this.add(i, (E) e);
	}
	
}
