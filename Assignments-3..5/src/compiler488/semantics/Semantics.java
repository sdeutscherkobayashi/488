package compiler488.semantics;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import compiler488.ast.AST;
import compiler488.ast.stmt.Program;
import compiler488.ast.type.Type;
import compiler488.symbol.*;

/** Implement semantic analysis for compiler 488
 *  @version $ CSC488S Winter 2012/2013  2013-01-28  11:27 $
 *  @author  <B> Put your names here </B>
 */
public class Semantics {

     public static final String version =
     "  CSC488S Winter 2012/2013  2013-01-28  11:27 " ;

        /** flag for tracing semantic analysis */
	private boolean traceSemantics = false;
	/** file sink for semantic analysis trace */
	private String traceFile = new String();
	public FileWriter Tracer;
	public File f;

  /* List of all symbol tables */
  private static List<SymbolTable> tables;

  /* List of all declared scopes */
  private static List<SemanticsScope> scopes;

  /* Stores the scope that is currently being checked */
  private static SemanticsScope current;

     /** SemanticAnalyzer constructor */
	public Semantics (){

	}

  public static void doSemanticAnalysis(Program program) {
    tables = new ArrayList<SymbolTable>();
    program.doSemantics();
  }

  public static void declareScope() {
    int lexicDepth;

    /* Increment the current depth */
    if (current == null) {
      lexicDepth = 0;
    } else {
      lexicDepth = current.getLexicDepth() + 1;
    }

    /* Add the new scope */
    scopes.add(new SemanticsScope(lexicDepth));

    current = scopes.get(scopes.size() - 1);
  }

  public static void removeScope() {
    // when we remove the current scope then the scope above is the new current
    SemanticsScope previous = scopes.get(scopes.indexOf(current) - 1);

    tables.remove(current);
    current = previous;
  }

  public static void addTableEntry(String name, Kind kind, AST value, Type type) {
    if (canAdd(name)) {
      current.getTable().addEntry(name, kind, value, type);
    } else {
      throw new ScopeException("Cannot declare " + name + " in scope");
    }
  }

  private static boolean canAdd(String name) {
    // loop over all scopes to check for any table entries
    // with the given name (note all scopes prior to current)
    // are above current and have the same namespace
    for (SemanticsScope scope : scopes) {
      if (scope.getTable().hasEntry(name)) return false;
    }

    return true;
  }

	/**  semanticsInitialize - called once by the parser at the      */
	/*                        start of  compilation                 */
	void Initialize() {

	   /*   Initialize the symbol table             */

	   // Symbol.Initialize();

	   /*********************************************/
	   /*  Additional initialization code for the   */
	   /*  semantic analysis module                 */
	   /*  GOES HERE                                */
	   /*********************************************/

	}

	/**  semanticsFinalize - called by the parser once at the        */
	/*                      end of compilation                      */
	void Finalize(){

	  /*  Finalize the symbol table                 */

	  // Symbol.Finalize();

	   /*********************************************/
	  /*  Additional finalization code for the      */
	  /*  semantics analysis module                 */
	  /*  GOES here.                                */
	  /**********************************************/

	}

	/**
	 *  Perform one semantic analysis action
         *  @param  actionNumber  semantic analysis action number
         */
	void semanticAction( int actionNumber ) {

	if( traceSemantics ){
		if(traceFile.length() > 0 ){
	 		//output trace to the file represented by traceFile
	 		try{
	 			//open the file for writing and append to it
	 			File f = new File(traceFile);
	 		    Tracer = new FileWriter(traceFile, true);

	 		    Tracer.write("Sematics: S" + actionNumber + "\n");
	 		    //always be sure to close the file
	 		    Tracer.close();
	 		}
	 		catch (IOException e) {
	 		  System.out.println(traceFile +
				" could be opened/created.  It may be in use.");
	 	  	}
	 	}
	 	else{
	 		//output the trace to standard out.
	 		System.out.println("Sematics: S" + actionNumber );
	 	}

	}

	   /*************************************************************/
	   /*  Code to implement each semantic action GOES HERE         */
	   /*  This stub semantic analyzer just prints the actionNumber */
	   /*                                                           */
           /*  FEEL FREE TO ignore or replace this procedure            */
	   /*************************************************************/

	   System.out.println("Semantic Action: S" + actionNumber  );
	   return ;
	}

	// ADDITIONAL FUNCTIONS TO IMPLEMENT SEMANTIC ANALYSIS GO HERE

}
