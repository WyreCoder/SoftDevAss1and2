import static org.junit.Assert.*;

import cs2800.BadTypeException;
import cs2800.Entry;
import cs2800.InvalidSymbolException;
import cs2800.Symbol;
import cs2800.Type;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/** @author Chloe
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
  public void setUp() {
    entryFloat = new Entry(testFloat);
    entrySymbol = new Entry(Symbol.PLUS);
  }

  // TEST3 to check an Entry can be created
  // wrote empty constructor
  @Test
  public void createEntryFloat() {
    assertFalse("TEST3: Entry created", entrySymbol == null);
  }

  // TEST9 to check an Entry can be created using second constructor (symbol)
  // wrote empty constructor
  @Test
  public void createEntrySymbol() {
    assertFalse("TEST9: Entry created", entryFloat == null);
  }

  // TEST10 to check that getType returns correct Type for float
  // initialise type to number in constructor, return type
  @Test
  public void getTypeFloat() {
    assertEquals("TEST10: Float Entry created, get type", Type.NUMBER, entryFloat.getType());
  }

  // TEST11 to check getType returns correct Type for Symbol
  // initialise type to symbol in constructor, return type
  @Test
  public void getTypeWithSymbol() {
    assertEquals("TEST11: Symbol Entry created, get type", Type.SYMBOL, entrySymbol.getType());
  }

  // TEST12 to test getValue
  // return 5.
  @Test
  public void getValueWithFloat() {
    assertEquals("TEST12: Create Entry, get type", testFloat, entryFloat.getValue(), 0);
  }

  // TEST13 to test getValue
  // return number.
  @Test
  public void getValueWithNewFloat() {
    entryFloat = new Entry(testFloatNew);
    assertEquals("TEST12: Create Entry, get type", testFloatNew, entryFloat.getValue(), 0);
  }

  // TEST14 to test exception thrown when getValue() used for a Type=Symbol
  // created BadTypeException.class, added throws BadTypeException to method
  @Rule
  public ExpectedException expectedEx14 = ExpectedException.none();

  @Test
  public void getValueWithSymbol() throws Exception {
    expectedEx14.expect(BadTypeException.class);
    expectedEx14.expectMessage("Bad Type Exception: Method can only be used on float");
    entrySymbol.getValue();
  }

  // TEST15 to test getString() returns String with Type=Symbol
  // added return str, initialise str in constructor to "+"
  @Test
  public void getStringWithSymbolPlus() {
    assertEquals("TEST15: Create symbol Entry, get string", entrySymbol.getString(), "+");
  }

  // TEST15 to test getString() returns String with MINUS
  // added return str, add case to constructor to choose + or -
  @Test
  public void getStringWithSymbolMinus() {
    Entry entrySymbolMinus = new Entry(Symbol.MINUS);
    assertEquals("TEST15: Create symbol Entry, get string", entrySymbolMinus.getString(), "-");
  }

  // TEST16 to test getString() returns String with DIVIDE
  // added return str, add case to constructor to add option /
  @Test
  public void getStringWithSymbolDivide() {
    Entry entrySymbolDivide = new Entry(Symbol.DIVIDE);
    assertEquals("TEST16: Create symbol Entry, get string", entrySymbolDivide.getString(), "/");
  }

  // TEST17 to test getString() returns String with TIMES
  // added return str, add case to constructor to add option *
  @Test
  public void getStringWithSymbolTimes() {
    Entry entrySymbolTimes = new Entry(Symbol.TIMES);
    assertEquals("TEST17: Create symbol Entry, get string", entrySymbolTimes.getString(), "*");
  }

  // TEST18 to test getString() returns String with LEFT_BRACKET
  // added return str, add case to constructor to choose (
  @Test
  public void getStringWithSymbolLeftBracket() {
    Entry entrySymbolLBrack = new Entry(Symbol.LEFT_BRACKET);
    assertEquals("TEST18: Create symbol Entry, get string", entrySymbolLBrack.getString(), "(");
  }

  // TEST19 to test getString() returns String with RIGHT_BRACKET
  // added return str, add case to constructor to choose )
  @Test
  public void getStringWithSymbolRightBracket() {
    Entry entrySymbolRBrack = new Entry(Symbol.RIGHT_BRACKET);
    assertEquals("TEST19: Create symbol Entry, get string", entrySymbolRBrack.getString(), ")");
  }

  // TEST20 to test getString() throws error for INVALID
  // added throws InvalidSymbolException (default case)
  @Rule
  public ExpectedException expectedEx20 = ExpectedException.none();

  @Test
  public void getStringWithSymbolInvalid() {
    expectedEx20.expect(InvalidSymbolException.class);
    expectedEx20.expectMessage("InvalidSymbolException: Symbol must be valid");
    Entry entrySymbolInvalid;
    entrySymbolInvalid = new Entry(Symbol.INVALID);
  }

  // TEST21 to test getString() throws exception with Type=number
  // added throw BadTypeException to getString()
  @Rule
  public ExpectedException expectedEx21 = ExpectedException.none();

  @Test
  public void getStringWithFloat() throws Exception {
    expectedEx21.expect(BadTypeException.class);
    expectedEx21.expectMessage("Bad Type Exception: Method can only be used on symbol");
    entryFloat.getString();
  }

  // TEST22 to test getSymbol() returns symbol with argument Type=symbol.PLUS
  // added return Type.PLUS to getSymbol()
  @Test
  public void getSymbolWithSymbol() {
    assertEquals("TEST22: getSymbol() for Entry(Symbol.PLUS)", 
        entrySymbol.getSymbol(), 
        Symbol.PLUS);
  }

  // TEST23 to test getSymbol() returns symbol with new argument
  // Type=symbol.MINUS
  // added return sym to getSymbol()
  @Test
  public void getSymbolWithNewSymbol() {
    Entry minusEntry = new Entry(Symbol.MINUS);
    assertEquals("TEST22: getSymbol() for Entry(Symbol.MINUS)", 
        minusEntry.getSymbol(), 
        Symbol.MINUS);
  }

  // TEST24 to test getSymbol() throws exception with argument Type=number
  // added throws BadTypeException
  @Rule
  public ExpectedException expectedEx24 = ExpectedException.none();

  @Test
  public void getSymbolWithFloat() {
    expectedEx24.expect(BadTypeException.class);
    expectedEx24.expectMessage("Bad Type Exception: Method can only be used on symbol");
    entryFloat.getSymbol();
  }

  // TEST25 to test Entry.equals(Entry other)
}
