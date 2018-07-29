package com.fs.entity.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Login returns Json
 *
 * @author raviteja
 */
@Setter
@Getter
public class RedirectResponse extends GlobalResponse {

  private String redirectURL;

  public RedirectResponse(int resultCode, boolean hasError, String redirectURL) {
    super(resultCode, hasError);
    setRedirectURL(redirectURL);
  }
}
