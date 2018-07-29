package com.fs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.entity.Tag;
import com.fs.entity.vo.TagView;
import com.fs.mapper.TagMapper;
import com.fs.service.api.ITagService;
import com.fs.service.base.BaseViewTransableService;

import java.util.ArrayList;
import java.util.List;

/**
 * Article label related business implementation class
 *
 * @author raviteja
 */
@Service
public class TagServiceImpl extends BaseViewTransableService<Tag, TagView> implements ITagService {

  @Autowired
  TagMapper mTagMapper;

  @Override
  protected List<TagView> transEntityToView(List<Tag> entityList) {
    List<TagView> tagViews = new ArrayList<>();
    for (Tag tag : entityList) {
      TagView tagView = new TagView(tag);
      tagViews.add(tagView);
    }
    return tagViews;
  }

  @Override
  public List<TagView> getAllTagView() {
    return mTagMapper.selectAllTagView();
  }
}
