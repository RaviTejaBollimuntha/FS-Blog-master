package com.fs.entity;

import java.util.Date;
import javax.persistence.*;

/**
 * Common user classes
 *
 * @author raviteja
 */
public class User {

  /**
   * PrimaryKey
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * Username
   */
  private String username;

  private String password;

  @Column(name = "birth_date")
  private Date birthDate;

  private String nickname;

  private String email;

  private String github;

  private String qq;

  private String wecaht;

  /**
   * avatar url
   */
  private String avatar;

  /**
   * Status/0: normal/1: ban
   */
  private Integer status;

  /**
   * Level
   */
  private Integer level;

  @Column(name = "gmt_create")
  private Date gmtCreate;

  @Column(name = "gmt_modified")
  private Date gmtModified;

  private String hobby;

  private String motto;

  @Column(name = "md_info")
  private String mdInfo;

  /**
   *  getting PrimaryKey
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
   * Get username
   *
   * @return username-username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set user name
   *
   * @param username
   */
  public User setUsername(String username) {
    this.username = username == null ? null : username.trim();
    return this;
  }

  /**
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password
   */
  public User setPassword(String password) {
    this.password = password == null ? null : password.trim();
    return this;
  }

  /**
   * @return birth_date
   */
  public Date getBirthDate() {
    return birthDate;
  }

  /**
   * @param birthDate
   */
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * @return nickname
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * @param nickname
   */
  public void setNickname(String nickname) {
    this.nickname = nickname == null ? null : nickname.trim();
  }

  /**
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   */
  public void setEmail(String email) {
    this.email = email == null ? null : email.trim();
  }

  /**
   * @return github
   */
  public String getGithub() {
    return github;
  }

  /**
   * @param github
   */
  public void setGithub(String github) {
    this.github = github == null ? null : github.trim();
  }

  /**
   * @return qq
   */
  public String getQq() {
    return qq;
  }

  /**
   * @param qq
   */
  public void setQq(String qq) {
    this.qq = qq == null ? null : qq.trim();
  }

  /**
   * @return wecaht
   */
  public String getWecaht() {
    return wecaht;
  }

  /**
   * @param wecaht
   */
  public void setWecaht(String wecaht) {
    this.wecaht = wecaht == null ? null : wecaht.trim();
  }

  /**
   * Get avatar url
   *
   * @return avatar-avatar url
   */
  public String getAvatar() {
    return avatar;
  }

  /**
   * Set avatar url
   *
   * @param avatar URL
   */
  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  /**
   *  get status / 0:normal / 1: ban
   *
   * @return status-status/0: normal/1: blocked
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * Set status/0: normal/1: ban
   *
   * @param status/0: normal/1: blocked
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * Get rank
   *
   * @return level-level
   */
  public Integer getLevel() {
    return level;
  }

  /**
   * Set level
   *
   * @param level
   */
  public void setLevel(Integer level) {
    this.level = level;
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
   * @return hobby
   */
  public String getHobby() {
    return hobby;
  }

  /**
   * @param hobby
   */
  public void setHobby(String hobby) {
    this.hobby = hobby == null ? null : hobby.trim();
  }

  /**
   * @return motto
   */
  public String getMotto() {
    return motto;
  }

  /**
   * @param motto
   */
  public void setMotto(String motto) {
    this.motto = motto == null ? null : motto.trim();
  }

  /**
   * @return md_info
   */
  public String getMdInfo() {
    return mdInfo;
  }

  /**
   * @param mdInfo
   */
  public void setMdInfo(String mdInfo) {
    this.mdInfo = mdInfo == null ? null : mdInfo.trim();
  }
}