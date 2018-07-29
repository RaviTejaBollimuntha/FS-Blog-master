package com.fs.service.api;

import java.util.Date;
import java.util.List;

import com.fs.entity.dto.form.ArticleSearchForm;
import com.fs.entity.vo.PostView;

/**
 * Blog service interface
 *
 * @author ravi teja
 */
public interface IPostsService {

  /**
   * Get all blogs
   *
   * @return blog view entity collection
   */
  List<PostView> getPostList();

  /**
   * Get a blog based on date conditions
   *
   * @param start time
   * @param end time
   *
   * @return blog view collection
   */
  List<PostView> getPostListByDate(Date start, Date end);

  /**
   * Find articles based on Tag ID
   *
   * @param tagId tag ID
   *
   * @return article
   */
  List<PostView> getPostListByTagId(Integer tagId);

  /**
   * Filter articles based on specific criteria
   *
   * @param form condition form
   *
   * @return article
   */
  List<PostView> getPostListByArticleCondition(ArticleSearchForm form);
}
