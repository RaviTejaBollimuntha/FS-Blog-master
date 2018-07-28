package me.zbl.fullstack.controller;

import me.zbl.fullstack.controller.base.BaseController;
import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.Resume;
import me.zbl.fullstack.entity.dto.form.AdminUserPwdModifyForm;
import me.zbl.fullstack.entity.dto.request.TableKeyModel;
import me.zbl.fullstack.entity.vo.BlogModifyModel;
import me.zbl.fullstack.entity.dto.form.BlogAddForm;
import me.zbl.fullstack.entity.dto.form.BlogModifyForm;
import me.zbl.fullstack.entity.dto.form.UserLoginForm;
import me.zbl.fullstack.entity.vo.ResumeModifyModel;
import me.zbl.fullstack.service.api.IAdminBlogService;
import me.zbl.fullstack.service.api.IAdminUserService;
import me.zbl.fullstack.service.api.IAdminUserService.ModifyPwdResult;
import me.zbl.fullstack.service.api.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static me.zbl.fullstack.consts.ViewConsts.*;

/**
 * AdminController
 *
 * @author raviteja
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

  @Autowired
  IAdminBlogService mBlogService;
  @Autowired
  IAdminUserService mAdminUserService;
  @Autowired
  IResumeService mResumeService;

  /**
   * Backstage home page
   */
  @GetMapping("")
  public String pAdminIndex(HttpServletRequest request, Model model) {
    return "admin/blog_manage";
  }

  /**
   * Backstage home page
   */
  @GetMapping("/index")
  public String pAdminIndex2(HttpServletRequest request, Model model) {
    return "admin/blog_manage";
  }

  /**
   * Background user login page
   */
  @GetMapping("/login")
  public String pAdminLogin(HttpServletRequest request, Model model) {
    return "admin/userlogin";
  }

  /**
   * Blog page
   */
  @GetMapping("/blogadd")
  public String pAdminBlogAdd(HttpServletRequest request, Model model) {
    return "admin/blogadd";
  }

  /**
   * Edit the blog page
   */
  @GetMapping("/blogmodify/{id}")
  public String pAdminBlogModify(HttpServletRequest request, Model model, @PathVariable Integer id) throws Exception {
    Article article = mBlogService.blogSelectByPrimaryKey(id);
    BlogModifyModel modifyModel = new BlogModifyModel(article);
    addModelAtt(model, VIEW_ARTICLE, modifyModel);
    return "admin/blog_modify";
  }

  /**
   * Blog Management page
   */
  @GetMapping("/blogmanage")
  public String pAdminBlogManage(HttpServletRequest request, Model model) {
    return "admin/blog_manage";
  }

  /**
   * Background user login verification
   */
  @PostMapping("/login.f")
  public String fAdminLogin(UserLoginForm userLoginForm) {
    return "redirect:/admin/blog_manage";
  }

  /**
   * Publish articles
   */
  @PostMapping("/blogadd.f")
  public String fAdminBlogAdd(BlogAddForm blogAddForm) {
    // TODO: 17-12-4 returns json and redirects to blog list if successful
    mBlogService.blogAdd(blogAddForm);
    return "redirect:/admin/index";
  }

  /**
   * Modify articles
   */
  @PostMapping("blog_modify.f")
  public String fAdminBlogModify(BlogModifyForm modifyForm) {
    // TODO: 17-12-4 returns json and redirects to blog list if successful
    mBlogService.blogModify(modifyForm);
    return "redirect:/admin/index";
  }


  /**
   * Get a list of blog details
   */
  @GetMapping("/blog_list.j")
  @ResponseBody
  public Object jAdminBlogList() {
    return mBlogService.getArticleList();
  }

  /**
   * Bulk delete blog
   */
  @DeleteMapping("/blog_delete.j")
  @ResponseBody
  public Object jAdminBlogDelete(@RequestBody TableKeyModel model) {
    mBlogService.blogDelete(model);
    return responseSimpleOK();
  }

  /**
   * Background User Management page
   */
  @GetMapping("/admin_user_manage")
  public String pAdminUserManage() {
    return "admin/admin_user_manage";
  }

  /**
   * Background user management json
   */
  @GetMapping("/admin_user.j")
  @ResponseBody
  public Object jAdminUserList() {
    return mAdminUserService.getAdminUserJson();
  }

  /**
   * Background user bulk delete
   */
  @DeleteMapping("/admin_use_delete.j")
  @ResponseBody
  public Object jAdminUserDelete(@RequestBody TableKeyModel model) {
    mAdminUserService.deleteAdminUser(model);
    return responseSimpleOK();
  }

  /**
   * Background User Password Change page
   */
  @GetMapping("/admin_user_pwd_modify")
  public String pAdminUserPwdModify() {
    return "admin/admin_user_pwd_modify";
  }

  /**
   * Background User Password Change
   */
  @PostMapping("/admin_user_pwd_modify.f")
  @ResponseBody
  public Object fAdminUserPwdModify(@Valid AdminUserPwdModifyForm form, BindingResult result, HttpServletRequest request) {
    if (result.hasErrors()) {
      return responseSimpleError();
    }
    ModifyPwdResult result1;
    try {
      result1 = mAdminUserService.modifyUserPwd(form, request);
    } catch (Exception e) {
      e.printStackTrace();
      return responseSimpleError();
    }
    if (result1 == ModifyPwdResult.SUCCESS) {
      return responseSimpleOK();
    } else {
      return responseSimpleError();
    }
  }

  @GetMapping("/resume_modify")
  public String pUpdateResume(Model model) throws Exception {
    Resume article = mResumeService.getResume();
    ResumeModifyModel modifyModel = new ResumeModifyModel(article);
    addModelAtt(model, VIEW_ARTICLE, modifyModel);
    return "admin/resume_modify";
  }
}
