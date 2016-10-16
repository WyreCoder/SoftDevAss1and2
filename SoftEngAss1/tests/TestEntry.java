import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cs2800.BadTypeException;
import cs2800.EmptyStackException;
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
	private float testFloatNew = 7;
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
	//wrote empty constructor
	@Test
	public void createEntryFloat() {
		assertFalse("TEST1: Entry created", entrySymbol== null);
	}
	
	//TEST9 to check an Entry can be created using second method
	//wrote empty constructor
	@Test
	public void createEntrySymbol() {
		assertFalse("TEST9: Entry created", entryFloat == null);
	}
		
	//TEST10 to check that getType returns correct Type for float
	//initialise type to number in constructor, return type
	@Test
	public void getTypeFloat() {
		assertEquals("TEST10: Float Entry created, get type", Type.NUMBER, entryFloat.getType());
	}
	
	//TEST11 to check getType returns correct Type for Symbol
	//initialise type to symbol in constructor, return type
	@Test
	public void getTypeSymbol() {
		assertEquals("TEST11: Symbol Entry created, get type", Type.SYMBOL, entrySymbol.getType());
	}
	
	//TEST12 to test getValue
	//return 5.
	@Test
	public void getValueFloat() {
		assertEquals("TEST12: Create Entry, get type", testFloat, entryFloat.getValue(), 0);
	}
	
	//TEST13 to test getValue
	//return number.
	@Test
	public void getValueNewFloat() {
		entryFloat = new Entry(testFloatNew);
		assertEquals("TEST12: Create Entry, get type", testFloatNew, entryFloat.getValue(), 0);
	}
	
	//TEST14 to test exception thrown when getValue() used for a Type=Symbol
	//created BadTypeException.class, added throws BadTypeException to method
	@Rule
	public ExpectedException expectedEx13 = ExpectedException.none();
	@Test
	public void getValueSymbol() throws Exception {
		expectedEx13.expect(BadTypeException.class);
		expectedEx13.expectMessage("Bad Type Exception: Method can only be used on float");
		entrySymbol.getValue();
	}
	
	//TEST15 to test getString() returns String with Type=Symbol
	//added return str, initialise str by adding String of symbol in Symbol.enum
	
	//TEST16 to test getString() throws exception with Type=number
	
	//TEST17 to test getSymbol() returns symbol with Type=symbol
	
	//TEST18 to test getSymbol() throws exception with Type=number
	
}
