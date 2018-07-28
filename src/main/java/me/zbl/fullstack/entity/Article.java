package me.zbl.fullstack.entity;

import java.util.Date;
import javax.persistence.*;

/**
 * Article categories
 *
 * @author raviteja
 */
public class Article {

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
   * html Article content
   */
  @Column(name = "html_material")
  private String htmlMaterial;

  /**
   * getting PrimaryKey
   *
   * @return id - PrimaryKey
   */
  public Integer getId() {
    return id;
  }

  /**
   * setting PrimaryKey
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
   * Get article content
   *
   * @return md_material-article content
   */
  public String getMdMaterial() {
    return mdMaterial;
  }

  /**
   * Set up article content
   *
   * @param mdMaterial article content
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