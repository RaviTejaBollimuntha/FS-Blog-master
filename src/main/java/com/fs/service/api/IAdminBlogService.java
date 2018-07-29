package com.fs.service.api;

import java.util.List;

import com.fs.entity.Article;
import com.fs.entity.dto.form.BlogAddForm;
import com.fs.entity.dto.form.BlogModifyForm;
import com.fs.entity.dto.request.TableKeyModel;
import com.fs.entity.vo.ArticleDataGridView;

/**
 * Backend blog post interface
 *
 * @author ravi teja
 */
public interface IAdminBlogService {

  /**
   * Add articles
   *
   * @param form
   */
  void blogAdd(BlogAddForm form);

  /**
   * Get articles by id
   *
   * @param id id
   *
   * @return article entity
   */
  Article blogSelectByPrimaryKey(Integer id);

  /**
   * Get a list of all articles
   *
   * @return article List View entity collection
   */
  List<ArticleDataGridView> getArticleList();

  /**
   * Delete articles based on id
   *
   * @param model data model
   */
  void blogDelete(TableKeyModel model);

  /**
   * Modify published articles
   *
   * @param form
   */
  void blogModify(BlogModifyForm form);
}
