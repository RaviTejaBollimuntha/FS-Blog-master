package com.fs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fs.controller.base.BaseController;
import com.fs.entity.Article;
import com.fs.entity.dto.form.ArticleSearchForm;
import com.fs.entity.vo.PostView;
import com.fs.entity.vo.TagView;
import com.fs.service.api.IAdminBlogService;
import com.fs.service.api.IPostsService;
import com.fs.service.api.ITagService;

import javax.servlet.http.HttpServletRequest;

import static com.fs.consts.ViewConsts.*;

import java.util.List;

/**
 * Blog Controller
 *
 * @author raviteja
 */
@Controller
public class PostContoller extends BaseController {

  @Autowired
  private IPostsService mPostService;

  @Autowired
  private ITagService mTagService;

  @Autowired
  private IAdminBlogService mBlogService;

  /**
   * Blog list page
   * View model：
   * 1.Blog list (article title/introduction/release time）
   * 2.Tags (tagId / total number of articles）
   */
  @GetMapping("/post")
  public String pPostList(HttpServletRequest request, Model model, Integer tagId) throws Exception {
    List<PostView> postViewList = null;
    if (null != tagId) {
      postViewList = mPostService.getPostListByTagId(tagId);
    } else {
      postViewList = mPostService.getPostList();
    }
    List<TagView> tagViewList = mTagService.getAllTagView();
    addModelAtt(model, VIEW_TAGLIST, tagViewList);
    addModelAtt(model, VIEW_POSTLIST, postViewList);
    return "posts";
  }

  /**
   * View article content pages
   *
   * @param id article id
   */
  @GetMapping("/blog/{id}")
  public String pFrontBlogView(HttpServletRequest request, Model model, @PathVariable Integer id) throws Exception {
    Article article = mBlogService.blogSelectByPrimaryKey(id);
    PostView postView = new PostView(article);
    addModelAtt(model, VIEW_ARTICLE, postView);
    addModelAtt(model, VIEW_TITLE, article.getTitle());
    return "article";
  }

  /**
   * Article Search Results page
   * <p>
   * Find articles based on specified criteria
   * <p>
   * View model：
   * Blog list (article title/introduction/release time）
   */
  @GetMapping("/postsearch")
  public String pPostSearch(HttpServletRequest request, Model model, ArticleSearchForm form) throws Exception {
    List<PostView> postViewList = mPostService.getPostListByArticleCondition(form);
    addModelAtt(model, VIEW_POSTLIST, postViewList);
    List<TagView> tagViewList = mTagService.getAllTagView();
    addModelAtt(model, VIEW_TAGLIST, tagViewList);
    return "posts";
  }
}
