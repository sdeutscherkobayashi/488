package compiler488.ast.expn;

import compiler488.ast.ASTList;
import compiler488.ast.*;
import compiler488.ast.type.*;
import compiler488.semantics.Semantics;
import compiler488.semantics.ScopeException;
import compiler488.symbol.*;
/**
 * Represents a function call with or without arguments.
 */
public class FunctionCallExpn extends Expn {
	private String ident; // The name of the function.

	private ASTList<Expn> arguments; // The arguments passed to the function.

	/** Returns a string describing the function call. */
	@Override
	public String toString() {
		if (arguments!=null) {
			return ident + " (" + arguments + ")";
		}
		else
			return ident + " ( ) " ;
	}

	public ASTList<Expn> getArguments() {
		return arguments;
	}

	public void setArguments(ASTList<Expn> args) {
		this.arguments = args;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
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
