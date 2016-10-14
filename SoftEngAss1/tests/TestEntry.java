import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs2800.Entry;

/**
 * 
 */

/**
 * @author Chloe
 *
 */
public class TestEntry {
	private Entry entry;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		entry = new Entry();
	}
	
	//TEST1
	@Test
	public void createEntry() {
		assertFalse("TEST1: Entry created", entry == null);
	}

}
