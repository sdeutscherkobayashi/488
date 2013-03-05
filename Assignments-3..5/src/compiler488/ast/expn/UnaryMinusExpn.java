package compiler488.ast.expn;

/**
 * Represents negation of an integer expression
 */
public class UnaryMinusExpn extends UnaryExpn {
  public boolean isBool() {
    return false;
  }

  public boolean isInteger() {
    return true;
  }
}
