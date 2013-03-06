package compiler488.ast.decl;

import compiler488.ast.AST;
import compiler488.semantics.Semantics;
import compiler488.symbol.Kind;
/**
 * Represents the declaration of a simple variable.
 */

public class ScalarDecl extends Declaration {

	/**
	 * Returns a string describing the name and type of the object being
	 * declared.
	 */
	@Override
	public String toString() {
		return  type + " " + name ;
	}
	
	public void doSemantics() {

		/* Simply add this decl to the current scope */
		Semantics.addTableEntry(name, Kind.SCALAR, this, type);
	}
}
