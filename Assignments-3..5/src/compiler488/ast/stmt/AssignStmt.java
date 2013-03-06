package compiler488.ast.stmt;

import compiler488.ast.expn.Expn;
import compiler488.ast.expn.FunctionCallExpn;
import compiler488.ast.expn.IdentExpn;
import compiler488.ast.expn.SubsExpn;
import compiler488.ast.expn.ReadableExpn;
import compiler488.ast.type.*;
import compiler488.semantics.*;
import compiler488.symbol.SymbolTableEntry;

/**
 * Holds the assignment of an expression to a variable.
 */
public class AssignStmt extends Stmt {
	/*
	 * lval is the location being assigned to, and rval is the value being
	 * assigned.
	 */
	private Expn rval;
  private ReadableExpn lval;

	/** Returns a string that describes the assignment statement. */
	@Override
	public String toString() {
		return "Assignment: " + lval + " := " + rval;
	}

	public ReadableExpn getLval() {
		return lval;
	}

	public void setLval(ReadableExpn lval) {
		this.lval = lval;
	}

	public Expn getRval() {
		return rval;
	}

	public void setRval(Expn rval) {
		this.rval = rval;
	}

	public void doSemantics() {
    lval.doSemantics();
		rval.doSemantics();

		/* Get the identifier accociated with this AssignStmt */
		String name = null;

		if (lval instanceof SubsExpn) {
			name = ((SubsExpn) lval).getVariable();
		} else if (lval instanceof IdentExpn) {
			name = ((IdentExpn) lval).getIdent();
		}

		/* Find the entry - if we get here it should exist */
		SymbolTableEntry entry = Semantics.findTableEntry(name);
    Type t = entry.getType();

		/* Check left and right side for function calls*/
		if (rval instanceof FunctionCallExpn) {
			FunctionCallExpn func = (FunctionCallExpn) rval;

			/* Should exist from rval.doSemantics */
			SymbolTableEntry funcEntry = Semantics.findTableEntry(func.getIdent());

      if ((t instanceof BooleanType) && !(funcEntry.getType() instanceof BooleanType)) {
				throw new TypeException("Invalid assignment statement for variable " + lval +
						" of type " + t);
			}
			
      if ((t instanceof IntegerType) && !(funcEntry.getType() instanceof IntegerType)) {
				throw new TypeException("Invalid assignment statement for variable " + lval +
						" of type " + t);
			}

		/* Use these checks for expns that support isBool/Int */
		} else {
			/* Ensure the left and right side are the same type */
			if ((t instanceof BooleanType) && !rval.isBool()) {
				throw new TypeException("Invalid assignment statement for variable " + lval +
						" of type " + t);
			}

			if ((t instanceof IntegerType) && !rval.isInt()) {
				throw new TypeException("Invalid assignment statement for variable " + lval +
						" of type " + t);
			}
		}


		
	}
}
