package com.fs.entity.dto.response;

/**
 * Simple Json response class
 *
 * @author raviteja
 */
public class SimpleResponse extends GlobalResponse {

  public SimpleResponse(int resultCode, boolean hasError) {
    super(resultCode, hasError);
  }
}
