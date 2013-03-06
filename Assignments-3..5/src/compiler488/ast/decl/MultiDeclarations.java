package compiler488.ast.decl;

import java.io.PrintStream;

import compiler488.ast.ASTList;
import compiler488.ast.Indentable;
import compiler488.semantics.*;
import compiler488.symbol.Kind;


/**
 * Holds the declaration of multiple elements.
 */
public class MultiDeclarations extends Declaration {
	/* The elements being declared */
	private ASTList<DeclarationPart> elements;

	public MultiDeclarations () {
		elements = new ASTList<DeclarationPart> ();
	}

	/**
	 * Returns a string that describes the array.
	 */
	@Override
	public String toString() {
		return  type + ": " + elements;
	}


	/**
	 * Print the multiple declarations of the same type.
	 *
	 * @param out
	 *            Where to print the description.
	 * @param depth
	 *            How much indentation to use while printing.
	 */
	@Override
	public void printOn(PrintStream out, int depth) {
		//out.println(elements);
		Indentable.printIndentOn (out, depth, this + "\n");
	}


	public ASTList<DeclarationPart> getElements() {
		return elements;
	}

	public void setElements(ASTList<DeclarationPart> elements) {
		this.elements = elements;
	}

	public void doSemantics() {
		for (int i = 0; i < elements.size(); i++) {
			DeclarationPart part = elements.get(i);
			part.doSemantics();

			/* Try to add the declaration to the symbol table */
			if (part instanceof ArrayDeclPart) {
				Semantics.addTableEntry(part.getName(), Kind.ARRAY, part, type);

			} else if (part instanceof DeclarationPart) {
				Semantics.addTableEntry(part.getName(), Kind.SCALAR, part, type);
			}
		}
	}
}
