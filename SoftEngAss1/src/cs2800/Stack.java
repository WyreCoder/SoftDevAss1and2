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
		return list.get(size()-1);	// return Entry from last index
	}

	public int size() {
		return list.size();
	}

	public Entry pop() throws EmptyStackException {
		if (size() <= 0) {			// if stack is empty
			throw new EmptyStackException("Stack is empty. Cannot pop.");
		}
		Entry top = top();			// note top Entry
		list.remove(size()-1);		// remove top Entry from stack
		return top;					// return noted top Entry
	}

}
