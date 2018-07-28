package me.zbl.fullstack.service.api;


import me.zbl.fullstack.entity.User;
import me.zbl.fullstack.entity.dto.form.UserLoginForm;
import me.zbl.fullstack.entity.dto.form.UserRegisterForm;

import javax.servlet.http.HttpServletRequest;

/**
 * User information operation interface
 *
 * @author raviteja
 */
public interface IUserService {

 /**
   * Login verification
   *
   * @param loginForm login form
   *
   * @return if validated by returning the User entity
   */
  User loginAuthentication(UserLoginForm loginForm);

  /**
   * Double-check the user name in user registration
   *
   * @param registerForm registration form
   *
   * @return: does the user population exist
   */
  boolean registerUsernameCheckExist(UserRegisterForm registerForm);

  /**
   * Save user
   *
   * @param user
   */
  void insertUser(User user);

  /**
   * Add user information to the session
   *
   * @param request user request
   * information for the current user of @param user
   */
  void joinSession(HttpServletRequest request, User user);

  /**
   * Destroy user information from session
   *
   * @param request user request
   */
  void destroySession(HttpServletRequest request);
}
