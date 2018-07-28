package me.zbl.fullstack.service.api;

import me.zbl.fullstack.entity.vo.TagView;

import java.util.List;

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
