package telran.interviews;

import java.util.Arrays;
import java.util.HashMap;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	//TODO
	HashMap<String, Integer> hashMap;
		//= new HashMap<>();
	int size;
//	Integer[] ar;
		//= {};
	public MyArray(int size) {
		this.size = size;
		hashMap = new HashMap<>(size);
//		ar = new Integer[size];
		for(Integer i = 0;i < size;i++) {
			hashMap.merge(i.toString(), null, (a, b) -> a + b); 
		}
		//TODO
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		//TODO
		for(int i = 0;i < size;i++) {
//			this.
//			hashMap.values() = 5;
		}
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		//TODO
		return null;
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		//TODO
	}
}
