/**
 * 
 */
package cs2800;
/**
 * @author Chloe
 *
 */
public class Stack {
	private Entry top;
	
	public void push(int i) {
		 
	}
	
	public Entry top() {
		return top;
	}

	public int size() {
		return 1;
	}

	public Entry pop() {
		Entry oldTop = top;
		top = null;
		return oldTop;
	}

}
