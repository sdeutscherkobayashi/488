package compiler488.ast.expn;

/**
 * Place holder for all binary expression where both operands must be integer
 * expressions.
 */
public class ArithExpn extends BinaryExpn {
  public boolean isBool() {
    return false;
  }

  public boolean isInteger() {
    return true;
  }
}
