package compiler488.ast.expn;

import compiler488.ast.AST;
import compiler488.ast.Printable;

/**
 * A placeholder for all expressions.
 */
public class Expn extends AST implements Printable {
	/**
	 * Return true if the result of this expn is of BooleanType
	 */
	public boolean isBool() {
		return false;
	}

	/**
	 * Return true if the result of this expn is of IntegerType
	 */
	public boolean isInt() {
		return false;
	}
}
