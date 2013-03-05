package compiler488.ast.expn;

/**
 * Represents the boolean negation of an expression.
 */
public class NotExpn extends UnaryExpn {
  public boolean isBool() {
    return true;
  }

  public boolean isInteger() {
    return false;
  }
}
