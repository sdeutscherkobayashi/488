package compiler488.ast.stmt;

import compiler488.ast.ASTList;
import compiler488.ast.Printable;
import compiler488.ast.expn.Expn;
import compiler488.semantics.TypeException;

/**
 * The command to write data on the output device.
 */
public class PutStmt extends Stmt {
	private ASTList<Printable> outputs; // The objects to be printed.

	public PutStmt () {
		outputs = new ASTList<Printable> ();
	}

	/** Returns a description of the <b>put</b> statement. */
	@Override
	public String toString() {
		return "put " + outputs;
	}

	public ASTList<Printable> getOutputs() {
		return outputs;
	}

	public void setOutputs(ASTList<Printable> outputs) {
		this.outputs = outputs;
	}

	public void doSemantics() {
		/* Only need to do semantic if output is an expr */
		for (int i = 0; i < outputs.size(); i++) {
			if (outputs.get(i) instanceof Expn) {
				((Expn) outputs.get(i)).doSemantics();

        /* ensure expr is of type int */
        if (((Expn) outputs.get(i)).isBool()) {
          throw new TypeException("Invalid type, operand must be " +
            "IntegerType");
        }
      }
		}
	}
}
