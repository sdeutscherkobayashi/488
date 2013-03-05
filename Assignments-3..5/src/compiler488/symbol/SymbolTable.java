package compiler488.symbol;

import java.io.*;
import compiler488.ast.decl.*;
import compiler488.ast.expn.*;
import compiler488.ast.stmt.*;
import compiler488.ast.type.*;
import compiler488.ast.*;

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

	/** String used by Main to print symbol table
         *  version information.
         */

	public final static String version =
	   "  CSC488S Winter 2012/2013   2013-01-28  11:29 " ;

        /* The symbol table in hash table form
         * 4 arrays for putting Symbol names, associated type,
         * upper and lower bound in case it's an array declaration
         */

        private int BigHashTable = 1024;    //Tables size
        /* First column of the table is to store the symbol's name, also the
         * hashcode is determine by the hashCode() of the name String */
        private String[] SymbolName =  new String[BigHashTable];
        private Type[] SymbolType =  new Type[BigHashTable];    //Type
        private int[] Size =  new int[BigHashTable];    //Size, if it's an array
        private int[] Lower =  new int[BigHashTable];   //Array lower bound
        private int[] Upper =  new int[BigHashTable];   //Array upper bound

	/** Symbol Table  constructor
         *  Create and initialize a symbol table
	 */
	public SymbolTable  (Program programAST){
            ASTList declList = programAST.getDeclarations();

            MultiDeclarations MultiDecl;
            Type VarType;
            ASTList Elements;
            DeclarationPart VarPart;
            ArrayDeclPart ArrayVarPart;

            String VarName;
            int HashValue;
            for(int i = 0; i < declList.size(); i++)
            {
                if(declList.get(i) instanceof MultiDeclarations)
                {   //Mulit-part variables
                    MultiDecl = (MultiDeclarations) declList.get(i);
                    VarType = MultiDecl.getType();
                    Elements = MultiDecl.getElements();
                    for(int j = 0; j < Elements.size(); j++)
                    {   //Depth search into the Multi-part declaration
                        if(Elements.get(i) instanceof DeclarationPart)
                        {   //Variable
                            VarPart = (DeclarationPart) Elements.get(j);
                            VarName = VarPart.getName();
                            HashValue = VarName.hashCode();
                            SymbolName[HashValue % BigHashTable] = VarName;
                            SymbolType[HashValue % BigHashTable] = VarType;
                        }
                        else if(Elements.get(i) instanceof ArrayDeclPart)
                        {   //Array
                            ArrayVarPart = (ArrayDeclPart) Elements.get(i);
                            VarName = ArrayVarPart.getName();
                            HashValue = VarName.hashCode();
                            SymbolName[HashValue % BigHashTable] = VarName;
                            SymbolType[HashValue % BigHashTable] = VarType;
                            Size[HashValue % BigHashTable] = ArrayVarPart.getSize();
                            Lower[HashValue % BigHashTable] = ArrayVarPart.getLowerBoundary();
                            Upper[HashValue % BigHashTable] = ArrayVarPart.getUpperBoundary();
                        }
                    }
                }
            }
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

        public Type searchType (String variablename)
        {
            int HashValue = variablename.hashCode();
            return SymbolType[HashValue % BigHashTable];
        }

        public int searchSize (String variablename)
        {
            int HashValue = variablename.hashCode();
            return Size[HashValue % BigHashTable];
        }

        public int searchUpper (String variablename)
        {
            int HashValue = variablename.hashCode();
            return Upper[HashValue % BigHashTable];
        }

        public int searchLower (String variablename)
        {
            int HashValue = variablename.hashCode();
            return Lower[HashValue % BigHashTable];
        }
}

