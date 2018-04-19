package entity;
import java.util.ArrayList;
/**
*this class is used for compare two parameter 
* @author SunXiaoyong
* @version 1.0 10/12/2017
* @since    JDK1.8
*/
public class SortedArrayList<E> extends ArrayList<E> {

	/**
	 * add a parameter and sort it 
	 */
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
