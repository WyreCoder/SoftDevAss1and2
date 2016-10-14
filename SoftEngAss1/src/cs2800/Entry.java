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
	
	public String getString() {//badtype exception
		return null;
	}
	
	public Symbol getSymbol() {//badtype exception
		return other;
	}
	
	public float getValue() {//badtype exception
		return 0;
	}
}
