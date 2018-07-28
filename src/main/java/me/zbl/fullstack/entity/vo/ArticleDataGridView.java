package me.zbl.fullstack.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zbl.fullstack.entity.Article;

import java.util.Date;

/**
 * Blog batch management list view
 *
 * @author raviteja
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDataGridView {

  private Integer id;

  private String title;

  private Date gmtCreate;

  private Date gmtModified;

  private String introduction;

  public ArticleDataGridView(Article article) {
    this.id = article.getId();
    this.title = article.getTitle();
    this.gmtModified = article.getGmtModified();
    this.gmtCreate = article.getGmtCreate();
    this.introduction = article.getIntroduction();
  }
}