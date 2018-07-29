package com.fs.entity.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Modify blog forms
 *
 * @author raviteja
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogModifyForm {

  /**
   * ID of the modified blog
   */
  @NotEmpty
  private Integer id;

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
