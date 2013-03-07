package compiler488.ast.expn;

import compiler488.semantics.TypeException;
/**
 * Place holder for all binary expression where both operands must be integer
 * expressions.
 */
public class ArithExpn extends BinaryExpn {
	@Override
  public boolean isBool() {
    return false;
  }

	@Override
  public boolean isInt() {
    return true;
  }

  /*
   * Ensure left and right are of type int
   */
  public void doSemantics() {
    if (left.isBool() || right.isBool()) {
      throw new TypeException("Invalid type, both left and right " + 
          " sides of expression must be IntegerType");
    }
  }
}
