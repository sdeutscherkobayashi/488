package compiler488.ast.stmt;

import java.io.PrintStream;

import compiler488.ast.Indentable;
import compiler488.ast.expn.Expn;
import compiler488.semantics.*;
import compiler488.symbol.*;

/**
 * The command to return from a procedure.
 */
public class ReturnStmt extends Stmt {

	/**
	 * Print <b>return</b> on a line, by itself.
	 * 
	 * @param out
	 *            Where to print.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		Indentable.printIndentOn(out, depth);
		out.println("return ");
	}

	public void doSemantics() {
		SemanticsScope current = Semantics.getCurrentScope();
		String routineName    = current.getRoutineName();

		if (routineName == null) {
			throw new InvalidReturnException("Invalid return statement, return outside of proc definition");
		}

		SymbolTableEntry entry = Semantics.findTableEntry(routineName);

		if (entry.getKind() != Kind.PROC) {
			throw new InvalidReturnException("Invalid return statement, return inside a function def");
		}
	}
}
