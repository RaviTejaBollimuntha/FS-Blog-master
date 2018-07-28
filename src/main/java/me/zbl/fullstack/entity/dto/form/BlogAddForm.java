package me.zbl.fullstack.entity.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Post a blog form
 *
 * @author raviteja
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogAddForm {

  /**
   * Article title
   */
  @NotEmpty
  private String title;

  /**
   * markdown content
   */
  private String mdMaterial;

  /**
   * markdown to html content
   */
  private String htmlMaterial;

  /**
   * Article Description
   */
  private String description;

  /**
   * Original tags
   */
  private String rawTags;
}
