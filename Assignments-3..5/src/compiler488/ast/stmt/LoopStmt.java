package compiler488.ast.stmt;

import java.io.PrintStream;

import compiler488.ast.Indentable;
import compiler488.ast.ASTList;
import compiler488.semantics.Semantics;

/**
 * Represents a infinite loop. 
 */
public class LoopStmt extends Stmt {

	protected ASTList<Stmt> body ;	  // body of the loop

	public ASTList<Stmt> getBody() {
		return body;
	}

	public void setBody(ASTList<Stmt> body) {
		this.body = body;
	}

	/**
	 * Print a description of the <b>loop-pool</b> construct.
	 * 
	 * @param out
	 *            Where to print the description.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		Indentable.printIndentOnLn(out, depth, "loop " );
		body.printOnSeperateLines(out, depth + 1);
		Indentable.printIndentOnLn(out, depth, " pool ");
	}

	/*
	 * Update the current scope's loop depth and check semantics of
	 * the loop body
	 */
	public void doSemantics() {
		Semantics.incrementLoopDepth();

		for (int i = 0; i < body.size(); i++) {
			body.get(i).doSemantics();
		}

		Semantics.decrementLoopDepth();
	}
}
