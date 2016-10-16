package cs2800;
/**
 * 
 */

/**
 * @author Chloe
 *
 */
public class Entry {
  Symbol sym;
  float number;
  String str;
  Type type;

  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
  }

  public Entry(Symbol which) throws InvalidSymbolException {
    sym = which;
    type = Type.SYMBOL;
    switch (which) {
      case PLUS:
        str = "+";
        break;
      case MINUS:
        str = "-";
        break;
      case DIVIDE:
        str = "/";
        break;
      case TIMES:
        str = "*";
        break;
      case LEFT_BRACKET:
        str = "(";
        break;
      case RIGHT_BRACKET:
        str = ")";
        break;
      default:
        throw new InvalidSymbolException("InvalidSymbolException: Symbol must be valid");
    }
  }

  public Type getType() {
    return type;
  }

  public String getString() throws BadTypeException {
    if (sym == null) { // if entry is not a Symbol
      throw new BadTypeException("Bad Type Exception: Method can only be used on symbol");
    }
    return str;
  }

  public Symbol getSymbol() throws BadTypeException {
    if (sym == null) { // if entry is not a symbol
      throw new BadTypeException("Bad Type Exception: Method can only be used on symbol");
    }
    return sym;
  }

  public float getValue() throws BadTypeException {
    if (sym != null) { // if entry is a symbol
      throw new BadTypeException("Bad Type Exception: Method can only be used on float");
    }
    return number;
  }

  public boolean equals(Entry other) {
    return true;
  }

  public Entry hashCode(Entry other) {
    return null;
  }
}
