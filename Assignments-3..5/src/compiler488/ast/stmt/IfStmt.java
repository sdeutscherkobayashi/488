package compiler488.ast.stmt;

import java.io.PrintStream;

import compiler488.ast.Indentable;
import compiler488.ast.expn.Expn;
import compiler488.ast.ASTList;

/**
 * Represents an if-then or an if-then-else construct.
 */
public class IfStmt extends Stmt {

  /**
   * Notice that whenTrue and whenFalse are now of type ASTList<Stmt>
   * where the original implementations they were single Stmt. This
   * has been changed to follow the structure of the grammar as defined
   * by "the original java.cup" starter code.
   */

	// The condition that determines which branch to execute.
	private Expn condition;

	// Represents the statements to execute when the condition is true.
	private ASTList<Stmt> whenTrue;

	// Represents the statements to execute when the condition is false.
	private ASTList<Stmt> whenFalse = null;

	/**
	 * Print a description of the <b>if-then-else</b> construct. If the
	 * <b>else</b> part is empty, just print an <b>if-then</b> construct.
	 *
	 * @param out
	 *            Where to print the description.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		Indentable.printIndentOnLn(out, depth, "if " + condition + " then ");
    whenTrue.printOnSeperateLines(out, depth + 1);

		if (whenFalse != null) {
			Indentable.printIndentOnLn(out, depth, "else");
      whenFalse.printOnSeperateLines(out, depth + 1);
		}

		Indentable.printIndentOnLn(out, depth, "fi");
	}

	public Expn getCondition() {
		return condition;
	}

	public void setCondition(Expn condition) {
		this.condition = condition;
	}

	public ASTList<Stmt> getWhenFalse() {
		return whenFalse;
	}

	public void setWhenFalse(ASTList<Stmt> whenFalse) {
		this.whenFalse = whenFalse;
	}

	public ASTList<Stmt> getWhenTrue() {
		return whenTrue;
	}

	public void setWhenTrue(ASTList<Stmt> whenTrue) {
		this.whenTrue = whenTrue;
	}
}
