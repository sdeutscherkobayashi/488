package compiler488.ast.stmt;

import compiler488.ast.ASTList;
import compiler488.ast.expn.ReadableExpn;

/**
 * The command to read data into one or more variables.
 */
public class GetStmt extends Stmt {
	
	private ASTList<ReadableExpn> inputs; // A list of locations to put the values read.

	public GetStmt () {
		inputs = new ASTList<ReadableExpn> ();
	}
	
	/** Returns a string describing the <b>get</b> statement. */
	@Override
	public String toString() {
		return "get " + inputs;
	}

	public ASTList<ReadableExpn> getInputs() {
		return inputs;
	}

	public void setInputs(ASTList<ReadableExpn> inputs) {
		this.inputs = inputs;
	}
}
