package compiler488.ast.stmt;

import java.io.PrintStream;

import compiler488.ast.Indentable;
import compiler488.ast.expn.Expn;
import compiler488.ast.type.*;
import compiler488.semantics.*;
import compiler488.symbol.*;

/**
 * The command to return from a function or procedure.
 */
public class ResultStmt extends Stmt {
	// The value to be returned by a function.
	private Expn value = null;

	/**
	 * Print <b>result</b>  expression on a line, by itself.
	 *
	 * @param out
	 *            Where to print.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		Indentable.printIndentOn(out, depth);
		out.println("result " + value );
	}

	public Expn getValue() {
		return value;
	}

	public void setValue(Expn value) {
		this.value = value;
	}

	public void doSemantics() {
		value.doSemantics();

		SemanticsScope current = Semantics.getCurrentScope();
		String routineName    = current.getRoutineName();

		if (routineName == null) {
			throw new InvalidResultException("Invalid result statement, result outside of function definition");
		}

		SymbolTableEntry entry = Semantics.findTableEntry(routineName);

		if (entry.getKind() != Kind.FUNC) {
			throw new InvalidResultException("Invalid result statement, result inside a procedure def");
		}

		/* Check function type is the same as result */
		Type t = entry.getType();

		if ((t instanceof BooleanType) && !(value.isBool())) {
			throw new TypeException("Invalid result type, expected " + t);
		}

		if ((t instanceof IntegerType) && !(value.isInt())) {
			throw new TypeException("Invalid result type, expected " + t);
		}
	}
}
