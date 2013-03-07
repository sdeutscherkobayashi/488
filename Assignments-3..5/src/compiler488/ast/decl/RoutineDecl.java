package compiler488.ast.decl;

import java.io.PrintStream;

import compiler488.ast.AST;
import compiler488.ast.ASTList;
import compiler488.ast.Indentable;
import compiler488.ast.type.*;
import compiler488.semantics.*;
import compiler488.symbol.*;


/**
 * Represents the declaration of a function or procedure.
 */
public class RoutineDecl extends Declaration {
	/*
	 * The formal parameters of the function/procedure and the
	 * statements to execute when the procedure is called.
	 */
	private RoutineBody routineBody;

	/**
	 * Returns a string indicating that this is a function with
	 * return type or a procedure, name, Type parameters, if any,
	 * are listed later by routineBody
	 */
	@Override
	public String toString() {
	  if(type==null)
	    {
	      return "proc " + name;
	    }
	  else
	    {
	      return type + " " + name  ;
	    }
	}

	/**
	 * Prints a description of the function/procedure.
	 *
	 * @param out
	 *            Where to print the description.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		Indentable.printIndentOn(out, depth, this + " ");
		routineBody.printOn(out, depth);
	}

	public RoutineBody getRoutineBody() {
		return routineBody;
	}

	public void setRoutineBody(RoutineBody routineBody) {
		this.routineBody = routineBody;
	}

	public void doSemantics() {

		SymbolTableEntry entry = Semantics.findTableEntry(name);

		/* Add routine decl first since it is needed by the body */

		/* there is a forward decl */
		if (entry != null) {

			/* name has been declared and is not a forward decl */
			if (!(entry.getValue() instanceof RoutineDecl)) {
				throw new ScopeException("Invalid declaration of routine, " + name +
						" alredy exists in scope");
			}

			/* must be a forward decl */
      RoutineDecl decl = (RoutineDecl) entry.getValue();

			/*
			 * Make sure the forward decl is the same kind of routine as this
			 * one. This should also inadvertently confirm whether they are
			 * both procedures / functions.
			 */
			if (decl.getType() != type) {
				throw new TypeException("Invalid declaration of routine, " +
					"forward decl for "	+ name +  " must match");
			}

			/* Make sure parameters of forward decl match the new ones */
			ASTList<ScalarDecl> newParams = routineBody.getParameters();
			ASTList<ScalarDecl> fwdParams = decl.getRoutineBody().getParameters();


			if (fwdParams == null && newParams != null) {
				throw new ScopeException("Invalid procedure call, " + name + " expects 0 newParams but " +
						newParams.size() + " given");
			}

			/*
       * Ensure that the forward decl and the new one are consistent with their arguments
       */
			if (fwdParams != null && newParams != null) {

        /* Check number of params */
				if (fwdParams.size() != newParams.size()) {
					throw new ScopeException("Invalid procedure call, " + name + " expects " +
							fwdParams.size() + " newParams but given " + newParams.size());
				}

        /* Check each pair of params type */
				for (int i = 0; i < fwdParams.size(); i++) {

          Type newType = newParams.get(i).getType();
          Type fwdType = fwdParams.get(i).getType();

					if (fwdType.getClass() != newType.getClass()) {
						throw new TypeException("Invalid type for argument " + newParams.get(i) +
								" expected type " + fwdType);
					}
				}
			}	

			/* have the forward declaration contain this RoutineDecl */
			Semantics.editTableEntry(name, this);

		/* no forward decl */
		} else {
			/* if type null its a proc */
			if (type == null) {
				Semantics.addTableEntry(name, Kind.PROC, this, type);
			} else {
				Semantics.addTableEntry(name, Kind.FUNC, this, type);
			}
		}

		routineBody.doSemantics();
	}
}
