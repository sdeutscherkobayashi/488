/* The following code was generated by JFlex 1.4.1 on 1/31/13 7:36 PM */


/* This is one of the original comments, included for attribution:
 *
 * File Name: csc488.flex
 * To Create: jflex csc488.flex
 *
 * and then after the parser is created
 * > javac Lexer.java
 */

/* This is the user-code section.  
 * It will be copied verbatim into the class generated by JFlex.
 */
package compiler488.parser;

import java_cup.runtime.*;
import compiler488.parser.sym;		// cup generated symbols
      

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 1/31/13 7:36 PM from the specification file
 * <tt>/h/u4/g0/00/g0kobe/488/a2.b/Assignment2/src/compiler488/parser/csc488.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\54\1\5\1\0\1\54\1\5\22\0\1\54\1\25\1\4"+
    "\2\0\1\6\1\26\1\0\1\7\1\10\1\17\1\15\1\23\1\16"+
    "\1\22\1\20\12\1\1\24\1\0\1\14\1\21\1\13\2\0\32\2"+
    "\1\11\1\0\1\12\1\0\1\3\1\0\1\41\1\36\1\43\1\45"+
    "\1\33\1\47\1\34\1\53\1\30\1\2\1\52\1\40\1\2\1\31"+
    "\1\37\1\42\1\2\1\35\1\44\1\32\1\51\1\2\1\50\1\46"+
    "\2\2\1\0\1\27\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\13\3\1\0\1\27\1\3\1\30\16\3\1\31\6\3"+
    "\1\32\2\3\1\33\7\3\1\34\5\3\1\35\1\36"+
    "\1\37\1\40\4\3\1\41\1\42\1\43\1\44\2\3"+
    "\1\45\3\3\1\46\2\3\1\47\1\3\1\50\1\51"+
    "\2\3\1\52\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\55\0\132\0\207\0\264\0\55\0\341\0\55"+
    "\0\55\0\55\0\55\0\55\0\55\0\55\0\55\0\55"+
    "\0\55\0\55\0\55\0\55\0\55\0\55\0\55\0\55"+
    "\0\u010e\0\u013b\0\u0168\0\u0195\0\u01c2\0\u01ef\0\u021c\0\u0249"+
    "\0\u0276\0\u02a3\0\u02d0\0\264\0\55\0\u02fd\0\207\0\u032a"+
    "\0\u0357\0\u0384\0\u03b1\0\u03de\0\u040b\0\u0438\0\u0465\0\u0492"+
    "\0\u04bf\0\u04ec\0\u0519\0\u0546\0\u0573\0\207\0\u05a0\0\u05cd"+
    "\0\u05fa\0\u0627\0\u0654\0\u0681\0\207\0\u06ae\0\u06db\0\207"+
    "\0\u0708\0\u0735\0\u0762\0\u078f\0\u07bc\0\u07e9\0\u0816\0\207"+
    "\0\u0843\0\u0870\0\u089d\0\u08ca\0\u08f7\0\207\0\207\0\207"+
    "\0\207\0\u0924\0\u0951\0\u097e\0\u09ab\0\207\0\207\0\207"+
    "\0\207\0\u09d8\0\u0a05\0\207\0\u0a32\0\u0a5f\0\u0a8c\0\207"+
    "\0\u0ab9\0\u0ae6\0\207\0\u0b13\0\207\0\207\0\u0b40\0\u0b6d"+
    "\0\207\0\207\0\207";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\4\1\32\1\33\1\34\1\35\1\36\1\4"+
    "\1\37\1\4\1\40\1\4\1\41\2\4\1\42\1\43"+
    "\3\4\1\6\56\0\1\3\54\0\3\4\24\0\24\4"+
    "\1\0\4\44\2\45\47\44\5\7\1\0\47\7\1\0"+
    "\3\4\24\0\1\4\1\46\15\4\1\47\4\4\2\0"+
    "\3\4\24\0\5\4\1\50\15\4\1\51\2\0\3\4"+
    "\24\0\1\4\1\52\6\4\1\53\5\4\1\54\5\4"+
    "\2\0\3\4\24\0\3\4\1\55\20\4\2\0\3\4"+
    "\24\0\3\4\1\56\20\4\2\0\3\4\24\0\3\4"+
    "\1\57\3\4\1\60\14\4\2\0\3\4\24\0\7\4"+
    "\1\61\14\4\2\0\3\4\24\0\5\4\1\62\1\4"+
    "\1\63\11\4\1\64\2\4\2\0\3\4\24\0\22\4"+
    "\1\65\1\4\2\0\3\4\24\0\1\66\6\4\1\67"+
    "\1\4\1\70\12\4\2\0\3\4\24\0\23\4\1\71"+
    "\2\0\3\4\24\0\2\4\1\72\21\4\2\0\3\4"+
    "\24\0\21\4\1\73\2\4\2\0\3\4\24\0\3\4"+
    "\1\74\20\4\2\0\3\4\24\0\15\4\1\75\6\4"+
    "\2\0\3\4\24\0\14\4\1\76\7\4\2\0\3\4"+
    "\24\0\1\77\23\4\2\0\3\4\24\0\2\4\1\100"+
    "\21\4\2\0\3\4\24\0\2\4\1\101\11\4\1\102"+
    "\7\4\2\0\3\4\24\0\4\4\1\103\17\4\2\0"+
    "\3\4\24\0\7\4\1\104\14\4\2\0\3\4\24\0"+
    "\7\4\1\105\14\4\2\0\3\4\24\0\7\4\1\106"+
    "\14\4\2\0\3\4\24\0\7\4\1\107\14\4\2\0"+
    "\3\4\24\0\2\4\1\110\21\4\2\0\3\4\24\0"+
    "\1\111\23\4\2\0\3\4\24\0\5\4\1\112\16\4"+
    "\2\0\3\4\24\0\10\4\1\113\13\4\2\0\3\4"+
    "\24\0\3\4\1\114\20\4\2\0\3\4\24\0\3\4"+
    "\1\115\20\4\2\0\3\4\24\0\3\4\1\116\20\4"+
    "\2\0\3\4\24\0\1\4\1\117\22\4\2\0\3\4"+
    "\24\0\3\4\1\120\20\4\2\0\3\4\24\0\2\4"+
    "\1\121\21\4\2\0\3\4\24\0\21\4\1\122\2\4"+
    "\2\0\3\4\24\0\21\4\1\123\2\4\2\0\3\4"+
    "\24\0\1\124\23\4\2\0\3\4\24\0\10\4\1\125"+
    "\13\4\2\0\3\4\24\0\12\4\1\126\11\4\2\0"+
    "\3\4\24\0\13\4\1\127\10\4\2\0\3\4\24\0"+
    "\10\4\1\130\13\4\2\0\3\4\24\0\12\4\1\131"+
    "\11\4\2\0\3\4\24\0\20\4\1\132\3\4\2\0"+
    "\3\4\24\0\14\4\1\133\7\4\2\0\3\4\24\0"+
    "\1\4\1\134\22\4\2\0\3\4\24\0\4\4\1\135"+
    "\17\4\2\0\3\4\24\0\5\4\1\136\16\4\2\0"+
    "\3\4\24\0\10\4\1\137\13\4\2\0\3\4\24\0"+
    "\1\4\1\140\22\4\2\0\3\4\24\0\3\4\1\141"+
    "\20\4\2\0\3\4\24\0\11\4\1\142\12\4\2\0"+
    "\3\4\24\0\3\4\1\143\20\4\2\0\3\4\24\0"+
    "\3\4\1\144\20\4\2\0\3\4\24\0\1\4\1\145"+
    "\22\4\2\0\3\4\24\0\2\4\1\146\21\4\2\0"+
    "\3\4\24\0\11\4\1\147\12\4\2\0\3\4\24\0"+
    "\5\4\1\150\16\4\2\0\3\4\24\0\5\4\1\151"+
    "\16\4\2\0\3\4\24\0\1\4\1\152\22\4\2\0"+
    "\3\4\24\0\15\4\1\153\6\4\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2970];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\1\1\21\11\13\1\1\0"+
    "\1\11\106\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    /* The interface to the CUP generated parser requires that the lexer
     * return java_cup.runtime.Symbol objects.  Each Symbol must have a
     * `type`, which is an integer value, and must have a corresponding
     * entry in sym.java.  The file sym.java is generated by CUP.  The
     * entries in sym.java correspond to the terminals defined in the
     * CUP parser specification.
     *
     * Here are some functions to help create Symbols for CUP.
     */

    /* For tokens with no value. */
    private Symbol symbol(int type)
	{
        return new Symbol(type, yyline, yycolumn);
	}
    
    /* For tokens with a value of type Object. */
    private Symbol symbol(int type, Object value)
	{
        return new Symbol(type, yyline, yycolumn, value);
	}

    /* String for printing version in Main */
    public final static String version = 
     " $Revision: 1.5 $ $Date: 2013/01/04 16:27:40 $ $Author: dw $ " ;



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 128) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { /* ignore whitespace */
          }
        case 45: break;
        case 9: 
          { return symbol(sym.R_SQUARE);
          }
        case 46: break;
        case 27: 
          { return symbol(sym.GET);
          }
        case 47: break;
        case 37: 
          { return symbol(sym.WHEN);
          }
        case 48: break;
        case 3: 
          { return symbol(sym.IDENT, yytext ());
          }
        case 49: break;
        case 26: 
          { return symbol(sym.END);
          }
        case 50: break;
        case 28: 
          { return symbol(sym.PUT);
          }
        case 51: break;
        case 23: 
          { return symbol(sym.TEXTCONST,
				yytext().substring(1,yytext().length()-1));
          }
        case 52: break;
        case 38: 
          { return symbol(sym.BEGIN);
          }
        case 53: break;
        case 20: 
          { return symbol(sym.NOT);
          }
        case 54: break;
        case 21: 
          { return symbol(sym.AND);
          }
        case 55: break;
        case 7: 
          { return symbol(sym.R_PAREN);
          }
        case 56: break;
        case 40: 
          { return symbol(sym.RETURN);
          }
        case 57: break;
        case 12: 
          { return symbol(sym.PLUS);
          }
        case 58: break;
        case 33: 
          { return symbol(sym.LOOP);
          }
        case 59: break;
        case 32: 
          { return symbol(sym.EXIT);
          }
        case 60: break;
        case 11: 
          { return symbol(sym.LESS);
          }
        case 61: break;
        case 29: 
          { return symbol(sym.TRUE);
          }
        case 62: break;
        case 44: 
          { return symbol(sym.FORWARD);
          }
        case 63: break;
        case 14: 
          { return symbol(sym.TIMES);
          }
        case 64: break;
        case 31: 
          { return symbol(sym.ELSE);
          }
        case 65: break;
        case 19: 
          { return symbol(sym.COLON);
          }
        case 66: break;
        case 30: 
          { return symbol(sym.THEN);
          }
        case 67: break;
        case 10: 
          { return symbol(sym.GREATER);
          }
        case 68: break;
        case 16: 
          { return symbol(sym.EQUAL);
          }
        case 69: break;
        case 5: 
          { /* discard comments  */
          }
        case 70: break;
        case 34: 
          { return symbol(sym.PROCEDURE);
          }
        case 71: break;
        case 24: 
          { return symbol(sym.IF);
          }
        case 72: break;
        case 1: 
          { throw new RuntimeException("Illegal character <"+yytext()+">");
          }
        case 73: break;
        case 36: 
          { return symbol(sym.SKIP);
          }
        case 74: break;
        case 22: 
          { return symbol(sym.OR);
          }
        case 75: break;
        case 41: 
          { return symbol(sym.RESULT);
          }
        case 76: break;
        case 42: 
          { return symbol(sym.INTEGER);
          }
        case 77: break;
        case 6: 
          { return symbol(sym.L_PAREN);
          }
        case 78: break;
        case 13: 
          { return symbol(sym.MINUS);
          }
        case 79: break;
        case 8: 
          { return symbol(sym.L_SQUARE);
          }
        case 80: break;
        case 43: 
          { return symbol(sym.BOOLEAN);
          }
        case 81: break;
        case 15: 
          { return symbol(sym.DIVIDE);
          }
        case 82: break;
        case 2: 
          { return symbol(sym.INTCONST,
						Integer.valueOf (yytext()));
          }
        case 83: break;
        case 35: 
          { return symbol(sym.POOL);
          }
        case 84: break;
        case 18: 
          { return symbol(sym.COMMA);
          }
        case 85: break;
        case 39: 
          { return symbol(sym.FALSE);
          }
        case 86: break;
        case 17: 
          { return symbol(sym.DOT);
          }
        case 87: break;
        case 25: 
          { return symbol(sym.FI);
          }
        case 88: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
