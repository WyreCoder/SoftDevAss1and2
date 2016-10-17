import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import softeng.cs2800.EmptyStackException;
import softeng.cs2800.Entry;
import softeng.cs2800.Stack;

/**
 * <h1>JUnit Test Class for Stack Class</h1>
 * Tests developed here dictate the development of the Stack class.
 * Test numbers are spread across this test class and TestEntry.
 * This is because one test needed to be made in TestEntry to 
 *     implement part of the Entry class before I could continue with 
 *         the Stack class.
 * @author Chloe
 */
public class TestStack {
  private Stack stack;
  private Entry entry;
  private float testFloat = 5;

  /**
   * This method is run before each test and prepares a new instance 
   * of Stack and a new instance of Entry to use in the tests.
   */
  @Before
  public void setUp() {
    stack = new Stack();
    entry = new Entry(testFloat);
  }

  /**
   * <h1>TEST1</h1> 
   * A test to check top() returns the last item added to the stack.
   * First implemented top() to return 4.
   * Test later refactored test to implement Entries instead of ints after TEST3.
   * top() changed to return an integer, top, which was a field of Stack. Later 
   * I changed this to return the top Entry in an ArrayList. Originally, I had 
   * implemented a linked list, such that each Entry has a field Entry next.
   */
  @Test
  public void pushThenTop() {
    stack.push(entry);
    assertEquals("TEST2: push, then top", entry, stack.top());
  }

  /**
   * <h1>TEST2</h1> 
   * A test to check that an int, size, is returned correctly.
   * size() coded to return 1.
   * Test later refactored to push Entry instead of int after TEST3.
   */
  @Test
  public void pushThenSize() {
    stack.push(entry);
    assertEquals("TEST3: push then size", 1, stack.size());
  }

  /**
   * <h1>TEST4</h1>
   * A test to check pop returns the last item added.
   * Here I implemented Entry in TEST3 in TestEntry.class.
   * pop() coded to return Entry.getNext().
   * Changed code to use arrayList instead of Entry.getNext().
   * Implemented return last list item instead.
   */
  @Test
  public void pushThenPop() {
    stack.push(entry);
    assertEquals("TEST4: Push then pop", entry, stack.pop());
  }

  /**
   * <h1>TEST5</h1>
   * A test to check an exception is thrown when an empty stack is popped, and
   * pop() removes top item from stack.
   * Wrote EmptyStackException.class. Added throws EmpyStackException. Added removal
   * of top item.
   */
  @Rule
  public ExpectedException expectedEx5 = ExpectedException.none();
  
  @Test
  public void pushPopThenTop() throws Exception {
    expectedEx5.expect(EmptyStackException.class);
    expectedEx5.expectMessage("Stack is empty. Cannot pop.");
    stack.push(entry);
    stack.pop();
    stack.pop();
  }

  /**
   * <h1>TEST6</h1>
   * A test to check size is correctly calculated for multiple items.
   * Changed from returning 1 to returning list size using size().
   */
  @Test
  public void pushTwiceThenSize() {
    stack.push(entry);
    stack.push(entry);
    assertEquals("TEST6: Push twice, then size", 2, stack.size());
  }

  /**
   * <h1>TEST7</h1>
   * A test to check that size is correctly calculated when items are removed.
   * No changes to code required here.
   */
  @Test
  public void pushTwicePopThenSize() {
    stack.push(entry);
    stack.push(entry);
    stack.pop();
    assertEquals("TEST7: Push twice, pop once, then size", 1, stack.size());
  }

  /**
   * <h1>TEST8</h1>
   * A test to check pop works twice.
   * No changes to code made.
   */
  @Test
  public void pushTwicePopTwice() {
    Entry secondEntry = new Entry(testFloat);
    stack.push(entry);
    stack.push(secondEntry);
    stack.pop();
    assertEquals("TEST8: Push twice, pop twice", entry, stack.pop());
  }

  /**
   * <h1>TEST9</h1>
   * A test to check an exception is thrown for top() if stack is empty.
   * Added check for empty stack and throws EmptyStackException to top().
   */
  @Rule
  public ExpectedException expectedEx9 = ExpectedException.none();
  
  @Test
  public void noPushThenTop() throws Exception {
    expectedEx9.expect(EmptyStackException.class);
    expectedEx9.expectMessage("Stack is empty. No top Entry.");
    stack.top();
  }
}
