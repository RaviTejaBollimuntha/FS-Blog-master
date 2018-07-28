package me.zbl.fullstack.controller;

import me.zbl.fullstack.controller.base.BaseController;
import me.zbl.fullstack.entity.User;
import me.zbl.fullstack.entity.dto.form.UserLoginForm;
import me.zbl.fullstack.entity.dto.form.UserRegisterForm;
import me.zbl.fullstack.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static me.zbl.fullstack.consts.ViewConsts.VIEW_MSG;

/**
 * User login Controller
 *
 * @author raviteja
 */
@Controller
public class UserController extends BaseController {

  @Autowired
  private IUserService mUserService;

  /**
   * Foreground user login
   * Form submission
   */
  @PostMapping("/userlogin.f")
  public String fFrontUserLogin(HttpServletRequest request, Model model, @Valid UserLoginForm loginForm, BindingResult bindingResult) throws Exception {
    if (bindingResult.hasErrors()) {
      List<ObjectError> errors = bindingResult.getAllErrors();
      addModelAtt(model, VIEW_MSG, errors.get(0).getDefaultMessage());
      return "userlogin";
    }
    User user = mUserService.loginAuthentication(loginForm);
    if (null != user) {
      mUserService.joinSession(request, user);
      return "redirect:/";
    }
    addModelAtt(model, VIEW_MSG, "User name or password error");
    return "userlogin";
  }

  /**
   * Foreground user registration
   * Form submission
   */
  @PostMapping("/userregister.f")
  public String fFrontUserRegister(@Valid UserRegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request, Model model, User user) {
    if (bindingResult.hasErrors()) {
      List<ObjectError> errors = bindingResult.getAllErrors();
      return "redirect:/userregister";
    }
    // verification of duplicate names again
    if (mUserService.registerUsernameCheckExist(registerForm)) {
      return "redirect:/userregister";
    }
    //Password consistent check again
    if (!(registerForm.getPassword().equals(registerForm.getConfirmpassword()))) {
      return "redirect:/userregister";
    }
    mUserService.insertUser(user);
    // Jump login
    return "redirect:/userlogin";
  }

  @GetMapping("/usersignout.c")
  public String cFrontUserSignout(HttpServletRequest request) {
    mUserService.destroySession(request);
    return "redirect:index";
  }
}
