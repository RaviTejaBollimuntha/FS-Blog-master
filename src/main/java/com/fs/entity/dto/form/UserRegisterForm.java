package com.fs.entity.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fs.consts.DataConsts;

/**
 * User registration form
 *
 * @author raviteja
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterForm {

  /**
   * Username
   */
  @Length(max = DataConsts.USERNAME_MAX_LENGTH)
  @NotEmpty(message = "Username cannot be empty")
  private String username;

  /**
   * Password
   */
  @Length(max = DataConsts.PASSWORD_MAX_LENGTH)
  @NotEmpty(message = "The password cannot be empty")
  private String password;

  /**
   * Confirm password
   */
  @Length(max = DataConsts.PASSWORD_MAX_LENGTH)
  @NotEmpty(message = "Please confirm the password again.")
  private String confirmpassword;
}
