package compiler488.symbol;

import compiler488.ast.type.Type;
import compiler488.ast.AST;

/** SymbolTableEntry
 * A generic entry in a SymbolTable that includes a name, kind, value, and type
 *
 *  @version $ CSC488S Winter 2012/2013   2013-01-28  11:29 $
 *  @author  <B>sdeutscherkobayashi, viky chow</B>
 */
public class SymbolTableEntry {

  /* the name of the identifier associated with this entry */
  private String name;

  /* the kind of type e.g. scalar */
  private Kind kind;

  /* The AST class instance associated with this entry */
  private AST value;

  /* The AST type associated with this entry */
  private Type type;

  public SymbolTableEntry(String name, Kind kind, AST value, Type type) {
    this.name  = name;
    this.kind  = kind;
    this.value = value;
    this.type  = type;
  }

  public String getName() {
    return name;
  }

  public SymbolTableEntry setName(String name) {
    this.name = name;
    return this;
  }

  public Kind getKind() {
    return kind;
  }

  public SymbolTableEntry setKind(Kind kind) {
    this.kind = kind;
    return this;
  }

  public AST getValue() {
    return value;
  }

  public SymbolTableEntry setValue(AST value) {
    this.value = value;
    return this;
  }

  public Type getType() {
    return type;
  }

  public SymbolTableEntry setType(Type type) {
    this.type = type;
    return this;
  }
}
