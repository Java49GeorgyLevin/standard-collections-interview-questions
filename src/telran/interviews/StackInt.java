package telran.interviews;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * 
 * All methods have to have the Complexity O[1]
 *
 */
public class StackInt<T> {
	LinkedList<Integer> stackIntList = new LinkedList<>();
	LinkedList<Integer> maxValue = new LinkedList<>();
	/** 
	 * @param num
	 * adds num in the stack
	 */
	public void push(int num) {		
		if(isEmpty()) {
			maxValue.push(num);
		} else {
			addMaxValue(num);
		}
		stackIntList.push(num);
	}
	private void addMaxValue(int num) {
		if(num >= maxValue.getFirst()) {
			maxValue.push(num);			
		}		
	}
	
	private void delMaxValue(int num) {
		if(num == maxValue.getFirst()) {
			maxValue.removeFirst();
		}
		
	}
	/**
	 * @return
	 * takes out and returns the top stack number
	 * in the case the stack is empty the exception of the class NoSuchElement should be thrown
	 */
	public int pop() {
		int last;
		if (isEmpty()) {
			throw new EmptyStackException();
		} 
		last = stackIntList.getFirst();
		stackIntList.removeFirst();
		delMaxValue(last);
				
		return last;
	}
	/**
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return stackIntList.size() == 0;
	}
	/**
	 * @return maximal value existing in the stack
	 * throws NoSuchElementException in the case the stack is empty
	 */
	public int max() {
		if(isEmpty()) {
			throw new EmptyStackException();			
		}
		return maxValue.getFirst();
	}
}
