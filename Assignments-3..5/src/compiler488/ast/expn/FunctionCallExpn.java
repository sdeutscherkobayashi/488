package compiler488.ast.expn;

import compiler488.ast.ASTList;
import compiler488.ast.*;
import compiler488.ast.decl.ScalarDecl;
import compiler488.ast.decl.RoutineDecl;
import compiler488.ast.type.*;
import compiler488.semantics.*;
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

	public void doSemantics() {

		if (arguments != null) {
			/* check individual args */
			for (int i = 0; i < arguments.size(); i++) {
				arguments.get(i).doSemantics();
			}
		}

		/* get the entry associated with the call name */
    SymbolTableEntry entry = Semantics.findTableEntry(ident);

		if (entry == null) {
			throw new ScopeException("Invalid function call, " + ident + " not declared in scope");
		}

		if (entry.getKind() != Kind.FUNC) {
			throw new TypeException("Invalid function call, " + ident + " does not declare a function");
		}

		/* Check that the correct params are given */
		RoutineDecl decl           = (RoutineDecl) entry.getValue();
		ASTList<ScalarDecl> params = decl.getRoutineBody().getParameters();

    if (params == null && arguments != null) {
			throw new ScopeException("Invalid function call, " + ident + " expects 0 arguments but " +
					arguments.size() + " given");
		}

		/*
		 * If both are non null then need to check if both have same size
		 * and each corresponding entry has the same type. If they are both
		 * null then we are done.
		 *
		 * Could improve this by changing the AST types to have empty lists
		 * rather then being null but no time.
		 */
		if (params != null && arguments != null) {

			if (params.size() != arguments.size()) {
				throw new ScopeException("Invalid procedure call, " + ident + " expects " +
						params.size() + " arguments but given " + arguments.size());
			}

			for (int i = 0; i < params.size(); i++) {
				Type t = params.get(i).getType();

				if ((t instanceof BooleanType) && !(arguments.get(i).isBool())) {
					throw new TypeException("Invalid type for argument " + arguments.get(i) +
							" expected type " + t);
				}

				if ((t instanceof IntegerType) && !(arguments.get(i).isInt())) {
					throw new TypeException("Invalid type for argument " + arguments.get(i) +
							" expected type " + t);
				}
			}
		}	
	}
}
