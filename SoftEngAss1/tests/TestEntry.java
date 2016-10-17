import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import softeng.cs2800.BadTypeException;
import softeng.cs2800.Entry;
import softeng.cs2800.InvalidSymbolException;
import softeng.cs2800.Symbol;
import softeng.cs2800.Type;

/** 
 * <h1>JUnit Test Class for Entry Class</h1>
 * Tests developed here dictate the development of the Entry class.
 * Test numbers are spread across this test class and TestStack.
 * @author Chloe
 */
public class TestEntry {
  private float testFloat = 5;
  private float testFloatSecondary = 7;
  private Entry entryFloat;
  private Entry entryFloatSecondary;
  private Entry entrySymbol;
  private Entry minusEntry;
  private Entry plusEntry;
  private Entry divideEntry;
  private Entry timesEntry;
  private Entry leftBracketEntry;
  private Entry rightBracketEntry;

  /**
   * This method is run before each test.
   * It creates various instances of the Entry class to use within the tests.
   */
  @Before
  public void setUp() {
    entryFloat = new Entry(testFloat);
    entryFloatSecondary = new Entry(testFloatSecondary);
    entrySymbol = new Entry(Symbol.PLUS);
    minusEntry = new Entry(Symbol.MINUS);
    plusEntry = new Entry(Symbol.PLUS);
    divideEntry = new Entry(Symbol.DIVIDE);
    timesEntry = new Entry(Symbol.TIMES);
    leftBracketEntry = new Entry(Symbol.LEFT_BRACKET);
    rightBracketEntry = new Entry(Symbol.RIGHT_BRACKET);
  }

  /**
   * <h1>TEST3</h1>
   * A Test to check that an Entry can be created.
   * I simply added empty constructor to Entry.class.
   * At first this constructor took no arguments as it was simply used to
   *     create any instance of the class to aid in the Stack tests.
   * Once I had finished TestStack, I added the float parameter.
   */
  @Test
  public void createEntryFloat() {
    assertFalse("TEST3: Entry created", entrySymbol == null);
  }

  /**
   * <h1>TEST9</h1>
   * A test to check an Entry can be created using a second constructor which takes
   *     a symbol instead of a float as argument.
   * I added another empty constructor, which takes an instance of Symbol as 
   *     argument.
   */
  @Test
  public void createEntrySymbol() {
    assertFalse("TEST9: Entry created", entryFloat == null);
  }

  /**
   * <h1>TEST10</h1>
   * A test to check that getType() returns the correct Type for a float entry.
   * Added getType() which simply returned Type.NUMBER.
   */
  @Test
  public void getTypeFloat() {
    assertEquals("TEST10: Float Entry created, get type", Type.NUMBER, entryFloat.getType());
  }

  /**
   * <h1>TEST11</h1>
   * A test to check getType() returns correct Type for a symbol entry.
   * I initialised type to symbol/float in respective constructors.
   * Changed getType() to return field Type type.
   */
  @Test
  public void getTypeWithSymbol() {
    assertEquals("TEST11: Symbol Entry created, get type", Type.SYMBOL, entrySymbol.getType());
  }

  /**
   * <h1>TEST12</h1>
   * A tes to test getValue().
   * Set getValue() to return 5.
   */
  @Test
  public void getValueWithFloat() {
    assertEquals("TEST12: Create Entry, get type", testFloat, entryFloat.getValue(), 0);
  }

  /**
   * <h1>TEST13</h1> 
   * A test to test getValue().
   * Modified getValue() to return number, which I 
   *     initialised in the float constructor.
   */
  @Test
  public void getValueWithDifferentFloat() {
    assertEquals("TEST12: Create Entry, get type", 
        testFloatSecondary, 
        entryFloatSecondary.getValue(), 0);
  }

  /**
   * <h1>TEST14</h1> 
   * A test to test exception thrown when getValue() used for a Type=Symbol.
   * I created BadTypeException.class, added throws BadTypeException to method.
   */
  @Rule
  public ExpectedException expectedEx14 = ExpectedException.none();

  @Test
  public void getValueWithSymbol() throws Exception {
    expectedEx14.expect(BadTypeException.class);
    expectedEx14.expectMessage("Bad Type Exception: Method can only be used on float");
    entrySymbol.getValue();
  }

  /**
   * <h1>TEST15</h1>
   * A test to test that getString() returns String with Type=Symbol.
   * Added return str, initialise str in constructor to "+".
   */
  @Test
  public void getStringWithSymbolPlus() {
    assertEquals("TEST15: Create symbol Entry, get string", entrySymbol.getString(), "+");
  }

  /**
   * <h1>TEST15</h1>
   * A test to test that getString() returns String with MINUS.
   * Add case to constructor to choose "+" or "-".
   */
  @Test
  public void getStringWithSymbolMinus() {
    assertEquals("TEST15: Create symbol Entry, get string", minusEntry.getString(), "-");
  }

  /**
   * <h1>TEST16</h1>
   * A test to test that getString() returns String with DIVIDE.
   * Add case to constructor to add option "/".
   */
  @Test
  public void getStringWithSymbolDivide() {
    assertEquals("TEST16: Create symbol Entry, get string", divideEntry.getString(), "/");
  }

  /**
   * <h1>TEST17</h1>
   * A test to test that getString() returns String with TIMES.
   * Add case to constructor to add option "*".
   */
  @Test
  public void getStringWithSymbolTimes() {
    assertEquals("TEST17: Create symbol Entry, get string", timesEntry.getString(), "*");
  }

  /**
   * <h1>TEST18</h1>
   * A test to test that getString() returns String with LEFT_BRACKET.
   * Add case to constructor to add option "(".
   */
  @Test
  public void getStringWithSymbolLeftBracket() {
    assertEquals("TEST18: Create symbol Entry, get string", leftBracketEntry.getString(), "(");
  }

  /**
   * <h1>TEST19</h1>
   * A test to test that getString() returns String with RIGHT_BRACKET.
   * Add case to constructor to add option ")".
   */
  @Test
  public void getStringWithSymbolRightBracket() {
    assertEquals("TEST19: Create symbol Entry, get string", rightBracketEntry.getString(), ")");
  }

  /**
   * <h1>TEST20</h1>
   * A test to test that getString() throws error for INVALID.
   * Added throws InvalidSymbolException (default case) to switch case.
   */
  @Rule
  public ExpectedException expectedEx20 = ExpectedException.none();

  @Test
  public void getStringWithSymbolInvalid() {
    expectedEx20.expect(InvalidSymbolException.class);
    expectedEx20.expectMessage("InvalidSymbolException: Symbol must be valid");
    Entry invalidEntry = new Entry(Symbol.INVALID);
    invalidEntry.getString();   //added to remove 'value not used' warning.
  }

  /**
   * <h1>TEST21</h1>
   * A test to test getString() throws exception with Type.NUMBER.
   * Added throw BadTypeException to getString().
   */
  @Rule
  public ExpectedException expectedEx21 = ExpectedException.none();

  @Test
  public void getStringWithFloat() throws Exception {
    expectedEx21.expect(BadTypeException.class);
    expectedEx21.expectMessage("Bad Type Exception: Method can only be used on symbol");
    entryFloat.getString();
  }

  /**
   * <h1>TEST22</h1>
   * A test to test getSymbol() returns symbol Symbol.PLUS.
   * Changed getSymbol() to return Symbol.PLUS.
   */
  @Test
  public void getSymbolWithSymbol() {
    assertEquals("TEST22: getSymbol() for Entry(Symbol.PLUS)", 
        entrySymbol.getSymbol(), 
        Symbol.PLUS);
  }

  /**
   * <h1>TEST23</h1>
   * A test to test that getSymbol() returns symbol with argument 
   *     with symbol different to PLUS.
   * Changed getSymbol() to return the field Symbol sym instead of Symbol.PLUS.
   */
  @Test
  public void getSymbolWithNewSymbol() {
    assertEquals("TEST22: getSymbol() for Entry(Symbol.MINUS)", 
        minusEntry.getSymbol(), 
        Symbol.MINUS);
  }

  /**
   * <h1>TEST24</h1>
   * A test to test that getSymbol() throws exception with argument type = Type.NUMBER.
   * Added throws BadTypeException.
   */
  @Rule
  public ExpectedException expectedEx24 = ExpectedException.none();

  @Test
  public void getSymbolWithFloat() {
    expectedEx24.expect(BadTypeException.class);
    expectedEx24.expectMessage("Bad Type Exception: Method can only be used on symbol");
    entryFloat.getSymbol();
  }

  /**
   * <h1>TEST25</h1>
   * A test to test Entry.equals(Entry other), 
   *     where Entry.getSymbol()=PLUS and other.getSymbol()=PLUS.
   * Added Entry check to ensure Object is an instance of Entry.
   * Coded method to return true.
   * After TEST32, method changed to simply return a comparison of the hashCodes.
   */
  @Test
  public void equalsPlusPlus() {
    assertTrue(entrySymbol.equals(plusEntry));
  }
  
  /**
   * <h1>TEST26</h1>
   * A test to test Entry.equals(Entry other) 
   *     where Entry.getSymbol()=PLUS and other.getSymbol()=MINUS
   * Added type and getString() comparisons.
   * After TEST32, method changed to simply return a comparison of the hashCodes.
   */
  @Test
  public void equalsPlusMinus() {
    assertFalse(entrySymbol.equals(minusEntry));
  }
  
  /**
   * <h1>TEST27</h1>
   * A test to test Entry.equals(Entry other) where Entry and other hold the same float value.
   * Added a float/Symbol condition.
   * Will return true if float.
   * After TEST32, method changed to simply return a comparison of the hashCodes.
   */
  @Test
  public void equalsFloatSameFloat() {
    entryFloatSecondary = new Entry(testFloat);
    assertTrue(entryFloat.equals(entryFloatSecondary));
  }
  
  /**
   * <h1>TEST28</h1>
   * A test to test different float values compared using equals().
   * Added type and value comparisons.
   * After TEST32, method changed to simply return a comparison of the hashCodes.
   */
  @Test
  public void equalsFloatDifferentFloat() {
    assertFalse(entryFloat.equals(entryFloatSecondary));
  }
  
  /**
   * <h1>TEST29</h1>
   * A test to test hashCode() comparison for Entries with matching floats.
   * Added hashCode override and determining fields.
   */
  @Test
  public void hashCodeEqualsFloats() {
    entryFloatSecondary = new Entry(testFloat);
    assertTrue(entryFloat.hashCode() == entryFloatSecondary.hashCode());
  }
  
  /**
   * <h1>TEST30</h1> 
   * A test to test hashCode() comparison for mismatched floats.
   * No change to code required.
   */
  @Test
  public void hashCodeNotEqualsFloats() {
    assertFalse(entryFloat.hashCode() == entryFloatSecondary.hashCode());
  }
  
  /**
   * <h1>TEST31</h1> 
   * A test to test hashCode() comparison for matching symbols.
   * No change to code required.
   */
  @Test
  public void hashCodeEqualsSymbols() {
    assertTrue(entrySymbol.hashCode() == plusEntry.hashCode());
  }
  
  /**
   * <h1>TEST32</h1> 
   * A test to test hashCode() comparison for mismatched symbols.
   * No change to code required.
   */
  @Test
  public void hashCodeNotEqualsSymbols() {
    assertFalse(minusEntry.hashCode() == plusEntry.hashCode());
  }
  
  /**
   * <h1>CHANGE LOG</h1>
   * Rewrite equals() using the new hashCode() method.
   * Changed the equals() method to simply return the comparison of the hashCode() methods.
   */
}
