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

  /**
   * This will hold the stack items (Entries), with the bottom of the stack
   * being list(0).
   * 
   */
  private ArrayList<Entry> list = new ArrayList<Entry>();

  /**
   * This method adds an item onto the stack by adding it to the ArrayList.
   * 
   * @param entry
   *          is an instance of the Object class Entry. This is the Entry passed
   *          to be pushed to the stack.
   */
  public void push(Entry entry) {
    list.add(entry);
  }

  /**
   * This method adds
   * 
   * @return
   * @throws EmptyStackException
   */
  public Entry top() throws EmptyStackException {
    if (size() <= 0) {
      throw new EmptyStackException("Stack is empty. No top Entry.");
    }
    return list.get(size() - 1); // return Entry from last index
  }

  public int size() {
    return list.size();
  }

  public Entry pop() throws EmptyStackException {
    if (size() <= 0) { // if stack is empty
      throw new EmptyStackException("Stack is empty. Cannot pop.");
    }
    Entry top = top(); // note top Entry
    list.remove(size() - 1); // remove top Entry from stack
    return top; // return noted top Entry
  }

}
