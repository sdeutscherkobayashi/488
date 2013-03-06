package compiler488.symbol;

import java.util.List;
import java.util.ArrayList;

import compiler488.ast.type.Type;
import compiler488.ast.AST;

/** Symbol Table
 *  This almost empty class is a framework for implementing
 *  a Symbol Table class for the CSC488S compiler
 *
 *  Each implementation can change/modify/delete this class
 *  as they see fit.
 *
 *  @version $ CSC488S Winter 2012/2013   2013-01-28  11:29 $
 *  @author  <B> PUT YOUR NAMES HERE </B>
 */

public class SymbolTable {

	public final static String version =
	   "  CSC488S Winter 2012/2013   2013-01-28  11:29 " ;

  /* The symbol table in hash table form */
  private List<SymbolTableEntry> entries;

	/*
   * Create and initialize a symbol table
	 */
	public SymbolTable (){
    entries = new ArrayList<SymbolTableEntry>();
	}

	/**  Initialize - called once by semantic analysis
	 *                at the start of  compilation
	 *                May be unnecessary if constructor
 	 *                does all required initialization
	 */
	public void Initialize() {

	   /**   Initialize the symbol table
	    *	Any additional symbol table initialization
	    *  GOES HERE
	    */

	}

	/**  Finalize - called once by Semantics at the end of compilation
	 *              May be unnecessary
	 */
	public void Finalize(){

	  /**  Additional finalization code for the
	   *  symbol table  class GOES HERE.
	   *
	   */
	}


	/** The rest of Symbol Table
	 *  Data structures, public and private functions
 	 *  to implement the Symbol Table
	 *  GO HERE.
	 */

   /**
    * Return true if this SymbolTable contains SymbolTableEntry with the given name
    */
   public boolean hasEntry(String name) {
     for (SymbolTableEntry entry : entries) {
       if (entry.getName().equals(name)) {
         return true;
       }
     }

     return false;
   }

   /**
    * Add a new SymbolTableEntry given by name, kind, value, type. Return true if
    * the new entry was successfully inserted
    */
   public boolean addEntry(String name, Kind kind, AST value, Type type) {

     // add the new entry if it does not already exist
     if (hasEntry(name)) {
       return false;
     }

     entries.add(new SymbolTableEntry(name, kind, value, type));
     return true;
   }

   /**
    * Remove the entry associated with name and return true
    * if it was successfully removed
    */
   public boolean removeEntry(String name) {

     for (SymbolTableEntry entry : entries) {
       if (entry.getName().equals(name)) {
         entries.remove(entry);
         return true;
       }
     }

     return false;
   }

   /*
    * Return the SymbolTableEntry given by name if there is one, null if there is not.
    */
   public SymbolTableEntry getEntry(String name) {
    // System.out.println("Get entry " + name + " in symbol table");
    // System.out.println(entries.size());
     for (SymbolTableEntry entry : entries) {
       if (entry.getName().equals(name)) {
         return entry;
       }
     }

     return null;

   }
}

