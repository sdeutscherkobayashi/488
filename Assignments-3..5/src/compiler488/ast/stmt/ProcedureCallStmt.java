package compiler488.ast.stmt;

import compiler488.ast.ASTList;
import compiler488.ast.type.*;
import compiler488.ast.decl.ScalarDecl;
import compiler488.ast.decl.RoutineDecl;
import compiler488.ast.expn.Expn;
import compiler488.semantics.*;
import compiler488.symbol.SymbolTableEntry;
/**
 * Represents calling a procedure.
 */
public class ProcedureCallStmt extends Stmt {
	private String name; // The name of the procedure being called.

	private ASTList<Expn> arguments; // The arguments passed to the procedure.

	/** Returns a string describing the procedure call. */
	@Override
	public String toString() {
		if (arguments!=null)
			return "Procedure call: " + name + " (" + arguments + ")";
		else
			return "Procedure call: " + name + " ( ) ";
	}

	public ASTList<Expn> getArguments() {
		return arguments;
	}

	public void setArguments(ASTList<Expn> args) {
		this.arguments = args;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void doSemantics() {

		if (arguments != null) {
			/* check individual args */
			for (int i = 0; i < arguments.size(); i++) {
				arguments.get(i).doSemantics();
			}
		}

		/* get the entry associated with the call name */
    SymbolTableEntry entry = Semantics.findTableEntry(name);

		if (entry == null) {
			throw new ScopeException("Invalid function/procedure call, " + name + " not declared in scope");
		}

		/* Check that the correct params are given */
		RoutineDecl decl           = (RoutineDecl) entry.getValue();
		ASTList<ScalarDecl> params = decl.getRoutineBody().getParameters();

    if (params == null && arguments != null) {
			throw new ScopeException("Invalid function/procedure call, " + name + " expects 0 arguments but " +
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
				throw new ScopeException("Invalid function/procedure call, " + name + " expects " +
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
