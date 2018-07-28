package me.zbl.fullstack.mapper;

import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.dto.form.ArticleSearchForm;
import me.zbl.fullstack.framework.mapper.IMyMapper;
import me.zbl.fullstack.mapper.provider.ArticleSqlProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author raviteja
 */
public interface ArticleMapper extends IMyMapper<Article> {

  String COLUMN_LIST = "article.id,title,introduction,article.gmt_create AS gmtCreate,article.gmt_modified AS gmtModified";

  @Select({
                  "SELECT",
                  COLUMN_LIST,
                  "FROM",
                  "article",
                  "ORDER BY article.gmt_create DESC"
          })
  List<Article> getPostViewAllArticles();

  /**
   * Find articles by tag id
   *
   * @param id tag id
   *
   * @return eligible articles
   */
  @Select({
                  "SELECT",
                  COLUMN_LIST,
                  "FROM article",
                  "INNER JOIN tag_article",
                  "ON tag_article.article_id = article.id",
                  "AND tag_article.tag_id=#{id}",
                  "ORDER BY article.gmt_create DESC"
          })
  List<Article> getArticleListByTagId(Integer id);

  /**
   * Find articles by criteria
   *
   * @param form condition form
   *
   * @return eligible articles
   */
  @SelectProvider(type = ArticleSqlProvider.class, method = "getArticleByCondition")
  List<Article> getArticleListByCondition(ArticleSearchForm form);
}