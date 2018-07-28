package me.zbl.fullstack.entity.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Find article forms
 *
 * @author ravviteja
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSearchForm {

  /**
   * Article title
   */
  @NotEmpty
  private String name;
}
