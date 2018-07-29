package com.fs.service.api;

import java.util.List;

import com.fs.entity.vo.TagView;

/**
 * Article label related business interfaces
 *
 * @author ravi teja
 */
public interface ITagService {

  /**
   * Get all Tag views
   *
   * @return Tag view
   */
  List<TagView> getAllTagView();
}
