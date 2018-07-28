package me.zbl.fullstack.controller.base;

import me.zbl.fullstack.entity.dto.response.factory.GeneralJsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller base class
 *
 * @author raviteja
 */
public class BaseController {

  @Autowired
  protected GeneralJsonFactory mJsonFactory;

  /**
   * Method exception handler in Controller
   *
   * @param e exception
   *
   * @return view name
   */
  @ExceptionHandler
  public String handleException(HttpServletRequest request, Exception e) {
    return "/error";
  }

  /**
   * Add title to the page
   */
  public void setPageTitle(Model model, String title) {
    model.addAttribute("title", title);
  }

  /**
   * Get the property value in the Session based on the name
   */
  public Object getSessionAttr(HttpServletRequest request, String attrName) throws NullPointerException {
    return request.getSession().getAttribute(attrName);
  }

  /**
   * Add data to Model
   */
  public void addModelAtt(Model model, String attribute, Object value) throws Exception {
    if (null != value) {
      model.addAttribute(attribute, value);
    } else {
      throw new Exception();
    }
  }

  /**
   * Adding objects to a Session
   */
  public void addSessionAtrr(HttpServletRequest request, String attribute, Object value) {
    request.getSession().setAttribute(attribute, value);
  }

  /**
   * Return successful json
   */
  public Object responseSimpleOK() {
    return mJsonFactory.createSimpleResponse();
  }

  /**
   * Return failed json
   */
  public Object responseSimpleError() {
    return mJsonFactory.createtSimpleErrorResponse();
  }
}
