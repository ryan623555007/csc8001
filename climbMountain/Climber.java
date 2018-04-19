import java.util.ArrayList;
import java.util.List;

/**
 * Climber.java
 * 
 */

/**
 * @author author123
 * 2017-10-28
 */
public class Climber {
	private String name;
	private Integer age;
	private String gender;
	private List<Mountain> mountains;
	
	
	
	/**
	 * @param name
	 * @param age
	 * @param gender
	 * @param mountains
	 */
	public Climber(String name, Integer age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mountains = new ArrayList<>();
	}


	/**
	 * @return the highest Mountain object
	 */
	public Mountain getHighest(){
		Mountain highest = null;
		Double maxHeight = 0.0;
		for (Mountain mountain : mountains) {
			if(mountain.getHeight() > maxHeight){
				maxHeight = mountain.getHeight();
				highest = mountain;
			}
		}
		return highest;
	}

	/**
	 * @return The average height mountain recorded by this climber
	 */
	public Double getAverageHeight(){
		Double average = 0.0;
		for (Mountain mountain : mountains) {
			average += mountain.getHeight();
		}
		
		if(mountains.size() > 0){
			average = average / mountains.size();
		}
		
		return average;
	}
	
	
	/**
	 * @param height the given height
	 * @return A list of all mountains recorded by the climber with a height greater than a given level
	 */
	public List<Mountain> getGreaterThan(double height){
		List<Mountain> ret = new ArrayList<>();
		for (Mountain mountain : mountains) {
			if(mountain.getHeight() > height){
				ret.add(mountain);
			}
		}
		return ret;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}



	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}



	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}



	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}



	/**
	 * @return the mountains
	 */
	public List<Mountain> getMountains() {
		return mountains;
	}



	/**
	 * @param mountains the mountains to set
	 */
	public void setMountains(List<Mountain> mountains) {
		this.mountains = mountains;
	}


	/**
	 * @param mountain
	 */
	public void add(Mountain mountain) {
		mountains.add(mountain);
	}
}
