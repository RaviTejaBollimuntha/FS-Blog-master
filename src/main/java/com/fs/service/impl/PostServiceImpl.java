package com.fs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.entity.Article;
import com.fs.entity.dto.form.ArticleSearchForm;
import com.fs.entity.vo.PostView;
import com.fs.mapper.ArticleMapper;
import com.fs.service.api.IPostsService;
import com.fs.service.base.BaseViewTransableService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Blog business implementation class
 *
 * @author raviteja
 */
@Service
public class PostServiceImpl extends BaseViewTransableService<Article, PostView> implements IPostsService {

  @Autowired
  ArticleMapper mPostMapper;

  @Override
  public List<PostView> getPostList() {
    List<Article> articles = mPostMapper.getPostViewAllArticles();
    List<PostView> postViewList = transEntityToView(articles);
    return postViewList;
  }

  @Override
  @Deprecated
  public List<PostView> getPostListByDate(Date start, Date end) {
    return null;
  }

  @Override
  public List<PostView> getPostListByTagId(Integer tagId) {
    List<Article> articlelist = mPostMapper.getArticleListByTagId(tagId);
    List<PostView> postViewList = transEntityToView(articlelist);
    return postViewList;
  }

  @Override
  public List<PostView> getPostListByArticleCondition(ArticleSearchForm form) {
    Article article = new Article();
    article.setTitle(form.getName());
    List<Article> articleList = mPostMapper.getArticleListByCondition(form);
    return transEntityToView(articleList);
  }

  @Override
  protected List<PostView> transEntityToView(List<Article> entityList) {
    List<PostView> postViewsList = new ArrayList<>();
    Iterator it = entityList.iterator();
    while (it.hasNext()) {
      Article article = (Article) it.next();
      PostView postView = new PostView(article);
      postViewsList.add(postView);
    }
    return postViewsList;
  }
}
