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
	
	//TEST2
	@Test
	public void pushThenTop() { 
		stack.push(entry);
		assertEquals("TEST2: push, then top", entry, stack.top());
	}

	//TEST3
	@Test
	public void pushThenSize() {
		stack.push(entry);
		assertEquals("TEST3: push then size", 1, stack.size());
	}
	
	//TEST4
	@Test
	public void pushThenPop() throws EmptyStackException {
		stack.push(entry);
		assertEquals("TEST4: Push then pop", entry, stack.pop());
	}
	
	//TEST5
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Test
	public void pushPopThenTop() throws Exception {
		expectedEx.expect(EmptyStackException.class);
		expectedEx.expectMessage("Stack is empty. Cannot pop.");
		stack.push(entry);
		stack.pop();
		stack.pop();
	}
	
	//TEST6
	@Test
	public void pushTwiceThenSize() {
		stack.push(entry);
		stack.push(entry);
		assertEquals("TEST6: Push twice, then size", 2, stack.size());
	}
	
	//TEST7
	@Test
	public void pushTwicePopThenSize() {
		stack.push(entry);
		stack.push(entry);
		stack.pop();
		assertEquals("TEST7: Push twice, pop once, then size", 1, stack.size());
	}
	
	//TEST8
	@Test
	public void pushTwicePopTwice() {
		stack.push(entry);
		stack.push(entry);
		stack.pop();
		assertEquals("TEST8: Push twice, pop twice", entry, stack.pop());
	}
	
}
