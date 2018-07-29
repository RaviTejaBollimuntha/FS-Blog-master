package com.fs.entity.dto.response.factory;

import com.fs.entity.dto.response.RedirectResponse;
import com.fs.entity.dto.response.SimpleResponse;


/**
 * Json entity factory class interface
 *
 * @author raviteja
 */
public interface JsonFactory {

  /**
   * Get a simple response entity
   *
   * @return response entity
   */
  SimpleResponse createSimpleResponse();

  /**
   * Get simple error entities
   *
   * @return response entity
   */
  SimpleResponse createtSimpleErrorResponse();

  /**
   * Get a simple response entity
   *
   * @param resultCode result status code
   * does @param hasError contain errors
   *
   * @return response entity
   */
  SimpleResponse createSimpleResponse(int resultCode, boolean hasError);

  /**
   * Get the redirect response entity
   *
   * @param resultCode result status code
   * does @param hasError contain errors
   * @param redirectURL redirect url
   *
   * @return
   */
  RedirectResponse createRedirectResponse(int resultCode, boolean hasError, String redirectURL);
}
