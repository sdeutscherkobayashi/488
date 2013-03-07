package compiler488.ast.expn;

import compiler488.semantics.TypeException;

/**
 * Place holder for all binary expression where both operands could be either
 * integer or boolean expressions. e.g. = and not = comparisons
 */
public class EqualsExpn extends BinaryExpn {
	@Override
  public boolean isBool() {
    return true;
  }

	@Override
  public boolean isInt() {
    return false;
  }

  /*
   * Ensure left and right are the same type
   */
  public void doSemantics() {
    if (left.isBool() != right.isBool()) {
      throw new TypeException("Invalid type, both left and right " + 
          " sides of expression must be the same type");
    }
  }
}
