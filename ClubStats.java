
import java.util.List;
import java.util.Scanner;

/**
 * ClubStats.java
 */

/**
 * @author author123
 * 2017-10-28
 */
public class ClubStats {
	private static Scanner scanner = new Scanner(System.in);
	private static Club club = new Club();
	
	public static void main(String[] args) {
		while(true){
			System.out.println();
			System.out.println("1. add a new climber");
			System.out.println("2. add details of a mountain");
			System.out.println("3. statistics");
			System.out.println("0. exit");
			
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				addNewClimber();
				break;
			case "2":
				addNewMountain();
				break;
			case "3":
				showStatistic();
				break;
			case "0":
				return;
			default:
				break;
			}
		}
	}

	/**
	 * provide statistics: 
	 * the climber who has recorded the highest average	mountain height; 
	 * the highest mountain recorded by a club member;
	 * mountains recorded with a height greater than a given level;
	 */
	private static void showStatistic() {
		Climber climber = club.getHighestAverage();
		if(climber != null){
			System.out.println("the climber who has recorded the highest average mountain height: " + climber.getName());
		}else {
			System.out.println("the climber who has recorded the highest average mountain height: " + "not exist.");
		}
		
		Mountain mountain = club.getHighestMountain();
		if(mountain != null){
			System.out.println("the highest mountain recorded by a club member: " + mountain.getName());
		}else {
			System.out.println("the highest mountain recorded by a club member: " + "not exist.");
		}
		
		
		try {
			System.out.println("input level:");
			Double height = Double.valueOf(scanner.nextLine());
			List<Mountain> list = club.getGreaterThan(height);
			System.out.println("mountains recorded with a height greater than " + height + " : ");
			for (Mountain m : list) {
				System.out.println(m.getName() + " " + m.getHeight());
			}
		} catch (Exception e) {
			System.out.println("input format wrong");
		}
	}

	/**
	 * add details of a mountain (name, height) to the record for a given climber;
	 */
	private static void addNewMountain() {
		System.out.println("input Climber Name:");
		String name = scanner.nextLine();
		
		Climber climber = club.getClimber(name);
		if(climber != null){
			System.out.println("input Mountain Name:");
			name = scanner.nextLine();
			
			System.out.println("input Mountain Height:");
			Double height = Double.valueOf(scanner.nextLine());
		
			Mountain mountain = new Mountain(name, height);
			climber.add(mountain);
		}else {
			System.out.println("the climber not found");
		}
	}

	/**
	 * add a new climber to the club, given their name, age and gender;
	 */
	private static void addNewClimber() {
		try {
			System.out.println("input Name:");
			String name = scanner.nextLine();
			
			System.out.println("input Age:");
			Integer age = Integer.valueOf(scanner.nextLine());
			
			System.out.println("input Gender:");
			String gender = scanner.nextLine();
			
			Climber climber = new Climber(name, age, gender);
			club.add(climber);
			
		} catch (Exception e) {
			System.out.println("input format wrong");
		}
		
	}
}
