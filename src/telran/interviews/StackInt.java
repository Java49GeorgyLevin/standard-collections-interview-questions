package telran.interviews;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * 
 * All methods have to have the Complexity O[1]
 *
 */
public class StackInt<T> {
//TODO fields
	LinkedList<Integer> stackIntList = new LinkedList<>();
	/**
	 * 
	 * @param num
	 * adds num in the stack
	 */
	public void push(int num) {
		stackIntList.push(num);
	}
	/**
	 * 
	 * @return
	 * takes out and returns the top stack number
	 * in the case the stack is empty the exception of the class NoSuchElement should be thrown
	 */
	public int pop() {
		int last;
		if (stackIntList.size() == 0) {
			throw new EmptyStackException();
		} else {
			last = stackIntList.getFirst();
			stackIntList.removeFirst();
		}		
		return last;
	}
	/**
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		//TODO
		return stackIntList.size() == 0;
	}
	/**
	 * 
	 * @return maximal value existing in the stack
	 * throws NoSuchElementException in the case the stack is empty
	 */
	public int max() {
		if(stackIntList.size() ==0) {
			throw new EmptyStackException();			
		}
		return stackIntList.stream().max(Comparator.naturalOrder()).get();
	}
}
