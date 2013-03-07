package compiler488.ast.expn;

/**
 * Place holder for all binary expression where both operands must be boolean
 * expressions.
 */
public class BoolExpn extends BinaryExpn {
	@Override
  public boolean isBool() {
    return true;
  }

	@Override
  public boolean isInt() {
    return false;
	}
}
