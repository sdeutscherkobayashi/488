package compiler488.ast.expn;

import compiler488.semantics.TypeException;

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

  /*
   * Check that the operand is of type int
   */
  public void doSemantics() {
    if (operand.isBool()) {
      throw new TypeException("Invalid type, operand must be " + 
        "IntegerType");
    }
  }
}
