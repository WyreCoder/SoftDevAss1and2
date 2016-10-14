/**
 * 
 */
package cs2800;

import java.util.ArrayList;

/**
 * @author Chloe
 *
 */
public class Stack {
	private ArrayList<Entry> list = new ArrayList<Entry>();;
	
	public void push(Entry entry) {
		list.add(entry);
	}
	
	public Entry top() throws EmptyStackException {
		if (size() <= 0) {
			throw new EmptyStackException("Stack is empty. No top Entry.");
		}
		return list.get(size());
	}

	public int size() {
		return list.size();
	}

	public Entry pop() throws EmptyStackException {
		if (size() == 0) {	// if stack is empty
			throw new EmptyStackException("Stack is empty. Can not pop.");
		}
		Entry top = top();	// note top Entry
		list.remove(size());// remove top Entry from stack
		return top;			// return noted top Entry
	}

}
