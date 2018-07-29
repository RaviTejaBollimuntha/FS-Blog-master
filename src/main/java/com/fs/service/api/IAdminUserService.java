package com.fs.service.api;

import javax.servlet.http.HttpServletRequest;

import com.fs.entity.AdminUser;
import com.fs.entity.dto.form.AdminUserPwdModifyForm;
import com.fs.entity.dto.form.UserLoginForm;
import com.fs.entity.dto.request.TableKeyModel;

import java.util.List;

/**
 * Background User Service
 *
 * @ author raviteja
 */
public interface IAdminUserService {

  /**
   * Change Password results
   */
  enum ModifyPwdResult {
    /**
     * Two different passwords
     */
    NOT_EQUAL("Two different passwords."),
   /**
     * Original password error
     */
    ORI_PWD_ERROR("Original password input error"),
   /**
     * Modified successfully
     */
    SUCCESS("Modified successfully");

    String name;

    ModifyPwdResult(String name) {
      this.name = name;
    }
  }

  /**
   * Verify that the user exists
   *
   * @param form user information
   *
   * @return is present
   */
  AdminUser checkAdminUserExist(UserLoginForm form);

 /**
   * Add user information to the session
   *
   * @param request user request
   * information for the current user of @param user
   */
  void joinSession(HttpServletRequest request, AdminUser user);

  /**
   * Destroy user information from session
   *
   * @param request user request
   */
  void destroySession(HttpServletRequest request);

  /**
   * Get a list of background users
   *
   * @return background user json
   */
  List<AdminUser> getAdminUserJson();

  /**
   * Bulk delete users
   *
   * @param model user primary key to be deleted
   */
  void deleteAdminUser(TableKeyModel model);

  /**
   * Background User Password Change
   *
   * @param form to modify the Password Form
   * @param request to get the current user
   *
   * @return modify result
   */
  ModifyPwdResult modifyUserPwd(AdminUserPwdModifyForm form, HttpServletRequest request);
}
