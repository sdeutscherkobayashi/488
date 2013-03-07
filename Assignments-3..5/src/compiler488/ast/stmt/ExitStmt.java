package compiler488.ast.stmt;

import compiler488.ast.expn.*;
import compiler488.semantics.*;

/**
 * Represents the command to exit from a loop.
 */

public class ExitStmt extends Stmt {

	// condition for 'exit when'
	private Expn expn = null;

	/* Exit with no value given will have level 1 */
	private Integer level = 1 ;

	/** Returns the string <b>"exit"</b> or <b>"exit when e"</b>"
            or  <b>"exit"</b> level  or  <b>"exit"</b> level  when e
	*/
	@Override
	public String toString() {
		  {
		    String stmt = "exit " ;
	 	    if( level >= 0 )
			stmt = stmt + level + " " ;
                    if( expn != null )
		        stmt = stmt + "when " + expn + " " ;
		    return stmt ;
		  }
	}

	public Expn getExpn() {
		return expn;
	}

	public void setExpn(Expn expn) {
		this.expn = expn;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * Ensure expression is a valid condition and the exit level
	 * is valid
	 */
	public void doSemantics() {
		/* Check whe exit condition if it is given */
		if (expn != null) {
			expn.doSemantics();

			if (!expn.isBool()) {
				throw new TypeException("Invalid Type for condition " +
						expn + ", non-boolean conditional given");
			}
		}

    int currentLoopDepth = Semantics.getCurrentLoopDepth();

		if (level > currentLoopDepth) {
			throw new LoopExitException("Invalid exit statement, tried to " +
					"exit from loop " + level + " with loop depth of " + currentLoopDepth);
		}
	}
}
