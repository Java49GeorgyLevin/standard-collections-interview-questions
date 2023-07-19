package telran.interviews;

import java.util.HashMap;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	//TODO
	HashMap<Integer, T> hashMap;
	private int size;
	private T value;
	public MyArray(int size) {
		this.size = size;
		hashMap = new HashMap<>();
			
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		this.value = value;
		hashMap = new HashMap<>();
		}
	
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */

	public T get(int index) {
		if(index < 0 || index > size - 1) {
			return null;
		}
		return hashMap.get(index) == null ? value : hashMap.get(index);
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
				
		hashMap.put(index, value);
	}
}
