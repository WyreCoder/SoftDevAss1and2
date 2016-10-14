import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cs2800.EmptyStackException;
import cs2800.Entry;
import cs2800.Stack;

/**
 * 
 */

/**
 * @author Chloe
 *
 */
public class TestStack {
	private Stack stack;
	private Entry entry;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
		entry = new Entry();
	}
	
	//TEST2 to check top returns the last item added
	@Test
	public void pushThenTop() { 
		stack.push(entry);
		assertEquals("TEST2: push, then top", entry, stack.top());
	}

	//TEST3 to check size is correctly calculated
	@Test
	public void pushThenSize() {
		stack.push(entry);
		assertEquals("TEST3: push then size", 1, stack.size());
	}
	
	//TEST4 to check pop gives last item added
	@Test
	public void pushThenPop() {
		stack.push(entry);
		assertEquals("TEST4: Push then pop", entry, stack.pop());
	}
	
	//TEST5 to check an exception is thrown when an empty stack is popped, and pop removes top item
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
	
	//TEST6 to check size is correctly calculated for multiple items
	@Test
	public void pushTwiceThenSize() {
		stack.push(entry);
		stack.push(entry);
		assertEquals("TEST6: Push twice, then size", 2, stack.size());
	}
	
	//TEST7 to check that size is correctly calculated when items are removed
	@Test
	public void pushTwicePopThenSize() {
		stack.push(entry);
		stack.push(entry);
		stack.pop();
		assertEquals("TEST7: Push twice, pop once, then size", 1, stack.size());
	}
	
	//TEST8 to check pop works twice
	@Test
	public void pushTwicePopTwice() {
		Entry secondEntry = new Entry();
		stack.push(entry);
		stack.push(secondEntry);
		stack.pop();
		assertEquals("TEST8: Push twice, pop twice", entry, stack.pop());
	}
	
	//TEST9 to check exception thrown for top
	@Rule
	public ExpectedException expectedEx9 = ExpectedException.none();
	@Test
	public void noPushThenTop() throws Exception {
		expectedEx9.expect(EmptyStackException.class);
		expectedEx9.expectMessage("Stack is empty. No top Entry.");
		stack.top();
	}
}
