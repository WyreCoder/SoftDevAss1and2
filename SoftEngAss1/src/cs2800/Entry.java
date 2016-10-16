package cs2800;
/**
 * 
 */

/**
 * @author Chloe
 *
 */
public class Entry {
	Symbol other;
	float number;
	String str;
	Type type;
	
	public Entry(float value) {
		number = value;
		type = Type.NUMBER;
	}
	
	public Entry(Symbol which) {
		other = which;
		type = Type.SYMBOL;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getString() throws BadTypeException {
		if (other == null) {							// if entry is not a Symbol
			throw new BadTypeException("Bad Type Exception: Method can only be used on ");
		}
		return str;
	}
	
	public Symbol getSymbol() throws BadTypeException {
		if (other == null) {			// if entry is not a symbol
			throw new BadTypeException("Bad Type Exception: Method can only be used on ");
		}
		return other;
	}
	
	public float getValue() throws BadTypeException {
		if (other != null) {			// if entry is a symbol
			throw new BadTypeException("Bad Type Exception: Method can only be used on float");
		}
		return number;
	}
}
