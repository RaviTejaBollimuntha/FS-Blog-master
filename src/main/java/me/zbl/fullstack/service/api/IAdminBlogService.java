package me.zbl.fullstack.service.api;

import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.vo.ArticleDataGridView;
import me.zbl.fullstack.entity.dto.request.TableKeyModel;
import me.zbl.fullstack.entity.dto.form.BlogAddForm;
import me.zbl.fullstack.entity.dto.form.BlogModifyForm;

import java.util.List;

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
