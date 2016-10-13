import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@Test
	public void pushThenTop() { 
		stack.push(5);
		assertEquals("TEST1: push, then top", 5, stack.top());
	}

	@Test
	public void pushThenSize() {
		stack.push(3);
		assertEquals("TEST2: push then size", 1, stack.size());
	}
	
	@Test
	public void pushThenPop() {
		stack.push(2);
		assertEquals("TEST3: Push then pop", 2, stack.pop());
	}
	
	@Test
	public void pushPopThenTop() {
		stack.push(5);
		stack.pop();
		assertEquals("TEST4: Push, pop, then top", null, stack.top());
	}

}
