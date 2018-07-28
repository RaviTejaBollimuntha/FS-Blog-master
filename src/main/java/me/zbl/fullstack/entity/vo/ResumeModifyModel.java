package me.zbl.fullstack.entity.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.Resume;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Resume modification form
 * <p>
 *
 * @author raviteja
 * @date 17-12-4
 */
@Setter
@Getter
@NoArgsConstructor
public class ResumeModifyModel {

  @NotEmpty
  private Integer id;

  @NotEmpty
  private String title;

  private String mdMaterial;

  private String description;

  public ResumeModifyModel(Resume article) {
    this.id = article.getId();
    this.title = article.getTitle();
    this.mdMaterial = article.getMdMaterial();
    this.description = article.getIntroduction();
  }
}
