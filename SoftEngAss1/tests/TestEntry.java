import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs2800.Entry;
import cs2800.Symbol;
import cs2800.Type;

/**
 * 
 */

/**
 * @author Chloe
 *
 */
public class TestEntry {
	private float testFloat = 5;
	private Entry entryFloat;
	private Entry entrySymbol;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		entryFloat = new Entry(testFloat);
		entrySymbol = new Entry(Symbol.PLUS);
	}
	
	//TEST1 to check an Entry can be created
	@Test
	public void createEntryFloat() {
		assertFalse("TEST1: Entry created", entryFloat == null);
	}
	
	//TEST9 to check an Entry can be created using second method
	@Test
	public void createEntrySymbol() {
		assertFalse("TEST9: Entry created", entryFloat == null);
	}
		
	//TEST10 to check that getType returns correct Type for float
	@Test
	public void getTypeFloat() {
		assertEquals("TEST10: Entry created, get type", entryFloat.getType(), Type.NUMBER);
	}
	
	//TEST11 to check getType returns correct Type for Symbol
	@Test
	public void getTypeSymbol() {
		assertEquals("TEST11: Entry created, get type", entryFloat.getType(), Type.NUMBER);
	}
}
