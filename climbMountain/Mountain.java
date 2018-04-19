

/**
 * Mountain.java
 * 
 */

/**
 * @author author123
 * 2017-10-28
 */


public class Mountain {
	private String name;//name of mountain
	private Double height;//height of mountain(in metres)

	
	/**
	 * @param name
	 * @param height
	 */
	public Mountain(String name, Double height) {
		this.name = name;
		this.height = height;
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
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
}
