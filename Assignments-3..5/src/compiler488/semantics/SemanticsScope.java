package compiler488.semantics;

import compiler488.symbol.SymbolTable;

/** Implement semantic analysis for compiler 488
 *  @version $ CSC488S Winter 2012/2013  2013-01-28  11:27 $
 *  @author  <B> sdeutscherkobayashi vikychow</B>
 */
public class SemanticsScope {

  private int lexicDepth;

  /* The number of loops in this scope */
  private int loopDepth;

  private SymbolTable table;

  public SemanticsScope(int lexicDepth) {
    this.lexicDepth = lexicDepth;
    this.table      = new SymbolTable();
    this.loopDepth  = 0;
  }

  public int getLexicDepth() {
    return lexicDepth;
  }

  public SymbolTable getTable() {
    return table;
  }

  public int getLoopDepth() {
    return loopDepth;
  }

  /*
   * Add a loop to this scope
   */
  public void addLoop() {
    loopDepth += 1;
  }

  /*
   * Remove 1 loop from this scope
   */
  public void removeLoop() {
    loopDepth -= 1;
  }
}
