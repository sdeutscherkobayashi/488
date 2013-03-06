package compiler488.ast.expn;

import compiler488.ast.type.*;
import compiler488.semantics.Semantics;
import compiler488.semantics.ScopeException;
import compiler488.symbol.*;

/**
 *  References to a scalar variable.
 */
public class IdentExpn extends ReadableExpn
    {
    private String ident;  	// name of the identifier

    /**
     * Returns the name of the variable or function.
     */
    @Override
	public String toString () { return ident; }

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	/**
	 * Ensure ident has been declared in an accessible scope
	 */
	public void doSemantics() {
		SymbolTableEntry entry = Semantics.findTableEntry(ident);

		if (entry == null) {
			throw new ScopeException("variable with name " + ident + " not declared in scope");
		}
	}

	@Override
	public boolean isBool() {
		/* Find the entry - if we get here it should exist */
		SymbolTableEntry entry = Semantics.findTableEntry(ident);
    Type t = entry.getType();

	  return t instanceof BooleanType;
	}

	@Override
	public boolean isInt() {
		/* Find the entry - if we get here it should exist */
		SymbolTableEntry entry = Semantics.findTableEntry(ident);
    Type t = entry.getType();

	  return t instanceof IntegerType;
	}
}
