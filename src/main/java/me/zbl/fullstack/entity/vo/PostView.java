package me.zbl.fullstack.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.zbl.fullstack.entity.Article;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Blog list view
 *
 * @author raviteja
 */
@Getter
@Setter
@AllArgsConstructor
public class PostView {

  private Integer id;
  private String title;
  private String description;
  private String dateTime;
  private String htmlMaterial;

  /**
   *  constructor
   *
   * @param article
   */
  public PostView(Article article) {
    id = article.getId();
    title = article.getTitle();
    description = article.getIntroduction();
    dateTime = DateFormatUtils.format(article.getGmtCreate(), "yyyy-MM-dd HH:mm");
    htmlMaterial = article.getHtmlMaterial();
  }
}
