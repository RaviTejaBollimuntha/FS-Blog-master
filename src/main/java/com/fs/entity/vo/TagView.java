package com.fs.entity.vo;

import com.fs.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Article tag view
 *
 * @author raviteja
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagView {

  private Integer tagId;
  private String tagName;
  private Integer articleCount;

  public TagView(Tag tag) {
    this.tagId = tag.getId();
    this.tagName = tag.getName();
  }
}
