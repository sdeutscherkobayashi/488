package compiler488.ast.stmt;

import compiler488.ast.ASTList;
import compiler488.ast.expn.ReadableExpn;
import compiler488.semantics.TypeException;

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

  public void doSemantics() {
    /* confirm each input variable is type int */
    for (int i = 0; i < inputs.size(); i++) {
      if (!inputs.get(i).isInt()) {
        throw new TypeException("Invalid get statement, " +
            "expected IntegerType");
      }

      inputs.get(i).doSemantics();
    }

  }
}
