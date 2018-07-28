package me.zbl.fullstack.controller;

import me.zbl.fullstack.controller.base.BaseController;
import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.vo.PostView;
import me.zbl.fullstack.entity.vo.TagView;
import me.zbl.fullstack.entity.dto.form.ArticleSearchForm;
import me.zbl.fullstack.service.api.IAdminBlogService;
import me.zbl.fullstack.service.api.IPostsService;
import me.zbl.fullstack.service.api.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static me.zbl.fullstack.consts.ViewConsts.*;

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
