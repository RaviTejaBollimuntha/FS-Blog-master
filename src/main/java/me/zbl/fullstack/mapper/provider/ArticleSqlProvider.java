package me.zbl.fullstack.mapper.provider;

import me.zbl.fullstack.entity.dto.form.ArticleSearchForm;
import org.apache.ibatis.jdbc.SQL;

/**
 * Article Dynamic SQL providers
 *
 * @author raviteja
 */
public class ArticleSqlProvider {

  public String getArticleByCondition(ArticleSearchForm form) {
    return new SQL() {{
      SELECT("article.id,title,introduction,article.gmt_create AS gmtCreate,article.gmt_modified AS gmtModified");
      FROM("article");
      if (form.getName() != null) {
        WHERE("article.title LIKE CONCAT ('%','" + form.getName() + "','%')");
      }
    }}.toString();
  }
}
