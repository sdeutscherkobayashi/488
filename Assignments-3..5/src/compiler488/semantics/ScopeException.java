package compiler488.semantics;

/* Exception class for incorrect scope usage
 *
 *  @version $ CSC488S Winter 2012/2013  2013-01-28  11:27 $
 *  @author  <B>Put your names here </B>
 */
public class ScopeException extends RuntimeException {
	public ScopeException(String message) {
		super(message);
	}
}
