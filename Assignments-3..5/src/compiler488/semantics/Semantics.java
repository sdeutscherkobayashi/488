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
    scopes = new ArrayList<SemanticsScope>();
    program.doSemantics();
  }

/**********************************************
 *            Manage Scopes                   *
 **********************************************/

  /*
   * Open a new scope with an empty SymbolTable
   */
  public static void declareScope(String routineName) {
    //System.out.println("Declare New Scope " + scopes.size());
    int lexicDepth;

    /* Increment the current depth */
    if (current == null) {
      lexicDepth = 0;
    } else {
      lexicDepth = current.getLexicDepth() + 1;
    }

    /* Add the new scope */
    SemanticsScope scope = new SemanticsScope(lexicDepth, routineName);
    scopes.add(scope);

    current = scope;
    //System.out.println("Added Scope " + scopes.size());
  }

  /*
   * Remove the current scope
   */
  public static void removeScope() {
    //System.out.println("Removing Current Scope " + scopes.size());
    // when we remove the current scope then the scope above is the new current
    int index = scopes.indexOf(current);

    if (index > 0) {
      SemanticsScope previous = scopes.get(index - 1);
      scopes.remove(current);
      current = previous;
    } else {
      scopes.remove(current);
      current = null;
    }
    //System.out.println("Removed Scope " + scopes.size());
  }

  /*
   * Return the current scope
   */
  public static SemanticsScope getCurrentScope() {
    return current;
  }

  /**
   * Add 1 to the current scope's loop depth
   */
  public static void incrementLoopDepth() {
    current.addLoop();
  }

  /**
   * Decrement 1 from the current scope's loop depth
   *
   * Throws LoopExitException if the number of
   * loops in the current is less than 1
   */
  public static void decrementLoopDepth() {
    if (current.getLoopDepth() < 1) {
      throw new LoopExitException("Invalid loop decrement");
    }

    current.removeLoop();
  }

  /*
   * Return the loop depth of the current scope
   */
  public static int getCurrentLoopDepth() {
    return current.getLoopDepth();
  }

/**********************************************
 *            Manage Symbol Tables            *
 **********************************************/

  /**
   * Add the table entry specified by name, kind, value, type
   * to the current scope.
   *
   * Throws ScopeException if there exists a declaration with
   * that name in the current scope or any containing scope.
   */
  public static void addTableEntry(String name, Kind kind, AST value, Type type) {
    if (nameExists(name)) {
      throw new ScopeException("Cannot declare " + name + " in scope");
    } else {
      current.getTable().addEntry(name, kind, value, type);
    }
  }

  /**
   * Removes the entry associated with name in the current scope.
   *
   * Throws ScopeException if name is not declared in the current
   * scope.
   */
  public static void removeTableEntry(String name) {

    /* removeEntry returns true if the entry was successfully removed */
    if (!current.getTable().removeEntry(name)) {
      throw new ScopeException("No declaration for variable " + name + " in scope");
    }
  }

  /**
   * Return the SymbolTableEntry given by name in the current scope,
   * or any containing scope, null if it does not exist.
   */
  public static SymbolTableEntry findTableEntry(String name) {
    SymbolTableEntry entry;

    for (int i = scopes.size() - 1; i >= 0; i--) {
      entry = scopes.get(i).getTable().getEntry(name);

      if (entry != null) return entry;
    }

    return null;
  }

  /**
   * Return true if a SymbolTableEntry with the given name exists in
   * the current scope or any containing scopes.
   */
  public static boolean nameExists(String name) {
    // loop over all scopes outwards to check for any table entries
    // with the given name (note all scopes prior to current)
    // are above current and have the same namespace
    for (int i = scopes.size() - 1; i >= 0; i--) {
      if (scopes.get(i).getTable().hasEntry(name)) return true;
    }

    return false;
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
