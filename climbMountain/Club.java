
import java.util.ArrayList;
import java.util.List;

/**
 * Club.java
 */

/**
 * @author author123
 * 2017-10-28
 */
public class Club {

	private List<Climber> climbers = new ArrayList<>();
	
	/**
	 * @return The climber who has recorded the highest average mountain height
	 */
	public Climber getHighestAverage(){
		Climber maxClimber = null;
		Double maxAverage = 0.0;
		for (Climber climber : climbers) {
			if(climber.getAverageHeight() > maxAverage){
				maxAverage = climber.getAverageHeight();
				maxClimber = climber;
			}
		}
		return maxClimber;
	}
	
	/**
	 * @return The highest mountain recorded by a member of the club.
	 */
	public Mountain getHighestMountain(){
		Mountain highest = null;
		Double maxHeight = 0.0;
		for (Climber climber : climbers) {
			if(climber.getHighest().getHeight() > maxHeight){
				maxHeight = climber.getHighest().getHeight();
				highest = climber.getHighest();
			}
		}
		return highest;
	}
	
	/**
	 * @param height given level
	 * @return A list of all mountains that have been recorded, that are higher than a given level.
	 */
	public List<Mountain> getGreaterThan(double height){
		List<Mountain> ret = new ArrayList<>();
		for (Climber climber : climbers) {
			ret.addAll(climber.getGreaterThan(height));
		}
		return ret;
	}

	/**
	 * @param climber
	 */
	public void add(Climber climber) {
		climbers.add(climber);
	}
	
	/**
	 * @param name for search
	 * @return the climber of given name, if not found return null
	 */
	public Climber getClimber(String name){
		for (Climber climber : climbers) {
			if(climber.getName().equals(name)){
				return climber;
			}
		}
		return null;
	}
}




