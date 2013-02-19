package compiler488.ast.stmt;

import java.io.PrintStream;

import compiler488.ast.Indentable;

/**
 * Represents a infinite loop. 
 */
public class LoopStmt extends Stmt {

	protected Stmt body ;	  // body of the loop

	public Stmt getBody() {
		return body;
	}

	public void setBody(Stmt body) {
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
		body.printOn(out, depth + 1);
		Indentable.printIndentOnLn(out, depth, " pool ");
	}
}
