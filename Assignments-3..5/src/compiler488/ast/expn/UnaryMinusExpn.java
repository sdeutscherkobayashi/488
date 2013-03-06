package compiler488.ast.expn;

/**
 * Represents negation of an integer expression
 */
public class UnaryMinusExpn extends UnaryExpn {
	@Override
  public boolean isBool() {
    return false;
  }

	@Override
  public boolean isInt() {
    return true;
  }
}
