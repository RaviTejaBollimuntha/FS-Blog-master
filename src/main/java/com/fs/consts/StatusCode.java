package com.fs.consts;

/**
 * Response state constant class
 *
 * @author raviteja
 */
public class StatusCode {

  /**
   * Is it abnormal
   */
  public static final boolean WITH_ERROR = true;
  public static final boolean NO_ERROR = false;
  /**
   * Successful certification
   */
  public static final int AUTH_PASS = 101;
  /**
   * Authentication failure
   */
  public static final int AUTH_FAIL = 102;
  /**
   * Receive success
   */
  public static final int RESPONSE_OK = 201;
  /**
   * Redirect
   */
  public static final int REDIRECT = 302;
  /**
   * Query failed
   */
  public static final int QUERY_ERROR = 501;
  /**
   * Server exception
   */
  public static final int SERVER_EXCEPTION = 502;
}
