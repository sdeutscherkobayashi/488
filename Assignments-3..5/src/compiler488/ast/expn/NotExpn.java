package compiler488.ast.expn;

/**
 * Represents the boolean negation of an expression.
 */
public class NotExpn extends UnaryExpn {
	@Override
  public boolean isBool() {
    return true;
  }

	@Override
  public boolean isInt() {
    return false;
  }
}
