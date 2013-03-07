package compiler488.semantics;

/**
 * Exception class for invalid exit statements
 */
public class LoopExitException extends RuntimeException {

  public LoopExitException(String message) {
    super(message);
  }
}
