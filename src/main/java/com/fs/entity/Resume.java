package com.fs.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Resume category
 *
 * @author raviteja
 */
public class Resume {

  /**
   * PrimaryKey
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  @Column(name = "gmt_create")
  private Date gmtCreate;

  @Column(name = "gmt_modified")
  private Date gmtModified;

  private String introduction;

  /**
   * Article content
   */
  @Column(name = "md_material")
  private String mdMaterial;

  /**
   * html article content
   */
  @Column(name = "html_material")
  private String htmlMaterial;

  /**
   * Getting PrimaryKey
   *
   * @return id - PrimaryKey
   */
  public Integer getId() {
    return id;
  }

  /**
   * Setting up PrimaryKey
   *
   * @param id PrimaryKey
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title
   */
  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  /**
   * @return gmt_create
   */
  public Date getGmtCreate() {
    return gmtCreate;
  }

  /**
   * @param gmtCreate
   */
  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  /**
   * @return gmt_modified
   */
  public Date getGmtModified() {
    return gmtModified;
  }

  /**
   * @param gmtModified
   */
  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }

  /**
   * @return introduction
   */
  public String getIntroduction() {
    return introduction;
  }

  /**
   * @param introduction
   */
  public void setIntroduction(String introduction) {
    this.introduction = introduction == null ? null : introduction.trim();
  }

  /**
   * 获�?�文章内容
   *
   * @return md_material - 文章内容
   */
  public String getMdMaterial() {
    return mdMaterial;
  }

  /**
   * 设置文章内容
   *
   * @param mdMaterial 文章内容
   */
  public void setMdMaterial(String mdMaterial) {
    this.mdMaterial = mdMaterial == null ? null : mdMaterial.trim();
  }

  public String getHtmlMaterial() {
    return htmlMaterial;
  }

  public void setHtmlMaterial(String htmlMaterial) {
    this.htmlMaterial = htmlMaterial;
  }
}