package com.fs.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.fs.entity.Article;
import com.fs.entity.dto.form.ArticleSearchForm;
import com.fs.framework.mapper.IMyMapper;
import com.fs.mapper.provider.ArticleSqlProvider;

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