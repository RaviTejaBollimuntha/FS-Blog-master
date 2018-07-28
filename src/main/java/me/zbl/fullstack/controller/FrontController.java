package me.zbl.fullstack.controller;

import me.zbl.fullstack.controller.base.BaseController;
import me.zbl.fullstack.service.api.IAdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Foreground page Controller
 *
 * @author raviteja
 */
@Controller
public class FrontController extends BaseController {

  @Autowired
  private IAdminBlogService mBlogService;

  /**
   * Error page
   */
  @GetMapping("/error")
  public String pErrorPage(HttpServletRequest request, Model model) {
    return "error";
  }

  /**
   * Front desk home
   * GET * 
   */

  @GetMapping("/index")
  public String pFrontIndex(HttpServletRequest request, Model model) {
    return "index";
  }

  /**
   * Front desk home
   * POST
   */
  @PostMapping("/index")
  public String pFrontIndexPost(HttpServletRequest request, Model model) {
    return "index";
  }

  /**
   * Foreground user login page
   */
  @GetMapping("/userlogin")
  public String pFrontUserLogin(HttpServletRequest request, Model model) {
    return "userlogin";
  }

  /**
   * Foreground user registration
   */
  @GetMapping("/userregister")
  public String pFrontUserRegister(HttpServletRequest request, Model model) {
    return "register";
  }

}
