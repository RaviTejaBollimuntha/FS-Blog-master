package com.fs.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fs.consts.SessionConstants;
import com.fs.entity.AdminUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User permission verification interceptor
 *
 * @author raviteja
 */
@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    Object obj = request.getSession().getAttribute(SessionConstants.SESSION_ADMIN_CURRENT_USER);
    if (null == obj || !(obj instanceof AdminUser)) {
      response.sendRedirect(request.getContextPath() + "/adminlogin");
      return false;
    }
    return true;
  }


  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
