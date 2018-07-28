package me.zbl.fullstack.entity.dto.response.factory;

import me.zbl.fullstack.entity.dto.response.RedirectResponse;
import me.zbl.fullstack.entity.dto.response.SimpleResponse;
import org.springframework.stereotype.Component;

import static me.zbl.fullstack.consts.StatusCode.*;

/**
 * Generic Json factory class
 *
 * @author raviteja
 */
@Component(value = "generalJsonFactory")
public class GeneralJsonFactory implements JsonFactory {

  /**
   * Universal normal response
   */
  @Override
  public SimpleResponse createSimpleResponse() {
    return new SimpleResponse(RESPONSE_OK, NO_ERROR);
  }

  @Override
  public SimpleResponse createtSimpleErrorResponse() {
    return new SimpleResponse(RESPONSE_OK, WITH_ERROR);
  }

  /**
   * Uniform response with parameters
   * param resultCode status code
   *
   * does @param hasError require exception
   */
  @Override
  public SimpleResponse createSimpleResponse(int resultCode, boolean hasError) {
    return new SimpleResponse(resultCode, hasError);
  }

  @Override
  public RedirectResponse createRedirectResponse(int resultCode, boolean hasError, String redirectURL) {
    return new RedirectResponse(resultCode, hasError, redirectURL);
  }
}
