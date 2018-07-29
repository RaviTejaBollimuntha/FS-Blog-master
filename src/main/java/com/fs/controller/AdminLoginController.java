package com.fs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fs.controller.base.BaseController;
import com.fs.entity.AdminUser;
import com.fs.entity.dto.form.UserLoginForm;
import com.fs.service.api.IAdminUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Background login Controller
 *
 * @author raviteja
 */
@Controller
public class AdminLoginController extends BaseController {

  @Autowired
  private IAdminUserService mAdminService;

  /**
   * Background user login page
   */
  @GetMapping("/adminlogin")
  public String pAdminLogin() {
    return "admin/userlogin";
  }

  /**
   * Background user login page
   */
  @GetMapping("/adminlogin/index")
  public String pAdminLoginIndex() {
    return "admin/userlogin";
  }

 /**
   * Background user login verification
   */
  @PostMapping("/adminlogin/login.f")
  public String fAdminLogin(@Valid UserLoginForm userLoginForm, BindingResult bindingResult, HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
      List<ObjectError> errors = bindingResult.getAllErrors();
      return "redirect:/adminlogin?msg=" + errors.get(0).getDefaultMessage();
    }
    AdminUser user = mAdminService.checkAdminUserExist(userLoginForm);
    if (null != user) {
      mAdminService.joinSession(request, user);
      return "redirect:/admin/index";
    }
    return "redirect:/adminlogin?msg=Login failed";
  }
}
