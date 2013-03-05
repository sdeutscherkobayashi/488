package compiler488.symbol;

/**
 * Enum for the language specific kinds of type for symbol table
 * entries
 *
 *  @version $ CSC488S Winter 2012/2013   2013-01-28  11:29 $
 *  @author  <B>sdeutscherkobayashi, viky chow</B>
 */
public enum Kind {

  ARRAY   ("array"),
  FUNC ("func"),
  PROC ("proc"),
  SCALAR  ("scalar");

  private String name;

  private Kind(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
