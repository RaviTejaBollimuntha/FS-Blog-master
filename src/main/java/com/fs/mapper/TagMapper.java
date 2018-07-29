package com.fs.mapper;

import org.apache.ibatis.annotations.Select;

import com.fs.entity.Article;
import com.fs.entity.Tag;
import com.fs.entity.vo.TagView;
import com.fs.framework.mapper.IMyMapper;

import java.util.List;

/**
 * @author raviteja
 */
public interface TagMapper extends IMyMapper<Tag> {

  String COLUMN_LIST = "article.id,article.title,article.introduction,article.gmt_create AS gmtCreate,article.gmt_modified AS gmtModified";

  /**
   * Get the article according to the id of the tag
   *
   * @param id tag id
   *
   * @return article collection
   */
  @Select({
                  "SELECT",
                  COLUMN_LIST,
                  "FROM article,tag,tag_article",
                  "WHERE article.id = tag_article.article_id AND tag.id = tag_article.tag_id",
                  "AND tag.id = #{id}"
          })
  List<Article> selectArticleByTagId(Integer id);

  /**
   * Get all TagView
   * TagView includes the name/id of the tag and the total number of articles corresponding to the tag
   *
   * @return article collection
   */
  @Select({
                  "SELECT tag.id AS tagId,",
                  "tag.name AS tagName,",
                  "COUNT(tag_article.article_id) AS articleCount",
                  "FROM tag_article",
                  "LEFT JOIN tag",
                  "ON tag.id = tag_article.tag_id",
                  "GROUP BY tag_article.tag_id"
          })
  List<TagView> selectAllTagView();

  @Select({
                  "SELECT id,",
                  "`name` FROM tag WHERE `name` = #{tagName}"
          })
  Tag selectTagByName(String tagName);
}