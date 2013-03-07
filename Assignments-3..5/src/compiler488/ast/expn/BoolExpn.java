package compiler488.ast.expn;

import compiler488.semantics.TypeException;
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

  /*
   * Ensure left and right are of type bool
   */
  public void doSemantics() {
    if (left.isInt() || right.isInt()) {
      throw new TypeException("Invalid type, both left and right " + 
          " sides of expression must be BooleanType");
    }
  }
}
