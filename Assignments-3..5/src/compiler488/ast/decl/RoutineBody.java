package compiler488.ast.decl;

import java.io.PrintStream;

import compiler488.ast.ASTList;
import compiler488.ast.Indentable;
import compiler488.ast.stmt.Scope;
import compiler488.semantics.Semantics;

/**
 * Represents the parameters and instructions associated with a
 * function or procedure.
 */
public class RoutineBody extends Indentable {
	private ASTList<ScalarDecl> parameters; // The formal parameters of the routine.

	private Scope body; // Execute this scope when routine is called.

	/**
	 * Print a description of the formal parameters and the scope for this
	 * routine.
	 * 
	 * @param out
	 *            Where to print the description.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		if (parameters != null)
			out.println("(" + parameters + ")");
		else
			out.println(" ( ) ");
    if (body != null)
      body.printOn(out, depth);
	}

	public Scope getBody() {
		return body;
	}

	public void setBody(Scope body) {
		this.body = body;
	}

	public ASTList<ScalarDecl> getParameters() {
		return parameters;
	}

	public void setParameters(ASTList<ScalarDecl> parameters) {
		this.parameters = parameters;
	}

	public void doSemantics() {
		/* If this routine has parameters then declare each of them */

		/* NOTE: We need params to be available only within the scope 
		 * of the routine body. To do this we will declare them in the
		 * current scope above the routine body and then remove them
		 * following the semantic analysis of the body
		 */
		boolean hasParams = parameters != null;

		if (hasParams) {
			for (int i = 0; i < parameters.size(); i++) {
				parameters.get(i).doSemantics();
			}
		}

		/* Check routine body */
		if (body != null) {
			body.doSemantics();
		}

		/* Remove the routine params from the current scope */
		if (hasParams) {
			for (int i = 0; i < parameters.size(); i++) {
				Semantics.removeTableEntry(parameters.get(i).name);
			}
		}
	}
}
