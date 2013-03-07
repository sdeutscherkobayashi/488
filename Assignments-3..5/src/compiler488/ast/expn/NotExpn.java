package compiler488.ast.expn;

import compiler488.semantics.TypeException;

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

  /*
   * Check that the operand is of type bool
   */
  public void doSemantics() {
    if (operand.isInt()) {
      throw new TypeException("Invalid type, operand must be " + 
        "BooleanType");
    }
  }
}
