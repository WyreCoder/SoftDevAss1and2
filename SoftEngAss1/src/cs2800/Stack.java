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
	private int size = 0;
	
	public void push(Entry entry) {
		size += 1;
		entry.setNext(top);	//top of stack is now new entry's 'next'
		top = entry;		//new entry is top of stack
	}
	
	public Entry top() {
		return top;
	}

	public int size() {
		return size;
	}

	public Entry pop() throws EmptyStackException{
		if (top == null) {	//if stack is empty
			throw new EmptyStackException("Stack is empty. Can not pop.");
		}
		size -= 1;
		Entry oldTop = top;	//set aside top value
		top = top.getNext();//bring next Entry to top
		return oldTop;		//return previous top value
	}

}
