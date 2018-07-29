package com.fs.entity.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Unify Json-scoped entity classes
 *
 * @author raviteja
 */
@Getter
@Setter
public class GlobalResponse {

  protected int resultCode;
  protected boolean hasError;

  private GlobalResponse() {

  }

  public GlobalResponse(int resultCode, boolean hasError) {
    this.resultCode = resultCode;
    this.hasError = hasError;
  }
}
