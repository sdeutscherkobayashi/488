package compiler488.ast.expn;

import compiler488.semantics.TypeException;

/**
 * Place holder for all ordered comparisions expression where both operands must
 * be integer expressions. e.g. < , > etc. comparisons
 */
public class CompareExpn extends BinaryExpn {
	@Override
  public boolean isBool() {
    return true;
  }

	@Override
  public boolean isInt() {
    return false;
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
