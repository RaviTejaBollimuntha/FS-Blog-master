package com.fs.entity.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User login form
 *
 * @author raviteja
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginForm {

  /**
   * username
   */
  @NotEmpty(message = "username cannot be empty")
  private String username;

  /**
   * password
   */
  @NotEmpty(message = "password cannot be empty")
  private String password;

  /**
   * Remember to log in
   */
  private String rememberme;
}