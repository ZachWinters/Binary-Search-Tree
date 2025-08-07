package cs1501.p1;

/**
 * Simple custom exception
 */
public class MissingKeyException extends Exception {

    MissingKeyException() { super(); }

    MissingKeyException(String msg) { super(msg); }

}

