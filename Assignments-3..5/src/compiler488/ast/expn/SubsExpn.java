package compiler488.ast.expn;

import compiler488.ast.Readable;
import compiler488.ast.type.*;

import compiler488.semantics.Semantics;
import compiler488.semantics.ScopeException;
import compiler488.symbol.*;

/**
 * References to an array element variable
 * 
 * Treat array subscript operation as a special form of unary expression.
 * operand must be an integer expression
 */
public class SubsExpn extends UnaryExpn implements Readable {

	private String variable; // name of the array variable

	/** Returns a string that represents the array subscript. */
	@Override
	public String toString() {
		return (variable + "[" + operand + "]");
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	/**
	 * Ensure variable has been declared in an accessible scope
	 */
	public void doSemantics() {
		SymbolTableEntry entry = Semantics.findTableEntry(variable);

		if (entry == null) {
			throw new ScopeException("variable with name " + variable + " not declared in scope");
		}
	}

	@Override
	public boolean isBool() {
		/* Find the entry - if we get here it should exist */
		SymbolTableEntry entry = Semantics.findTableEntry(variable);
    Type t = entry.getType();

	  return t instanceof BooleanType;
	}

	@Override
	public boolean isInt() {
		/* Find the entry - if we get here it should exist */
		SymbolTableEntry entry = Semantics.findTableEntry(variable);
    Type t = entry.getType();

	  return t instanceof IntegerType;
	}
}
