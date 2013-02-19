package compiler488.runtime;

/** Exception subclass for reporting machine run time  errors 
 * @version $ CSC488S Winter 2012/2013  2013-01-28  11:24 $
 * @author Danny House
 */
public class ExecutionException  extends Exception
{
  public  ExecutionException( String msg )
  {
    super( msg ) ;
  }
}
