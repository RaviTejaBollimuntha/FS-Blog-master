package me.zbl.fullstack.entity.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zbl.fullstack.consts.DataConsts;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Background user password modification
 *
 * @author raviteja
 * @date 18-1-25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserPwdModifyForm {

  @NotEmpty
  @Length(max = DataConsts.PASSWORD_MAX_LENGTH)
  private String oriPwd;
  @NotEmpty
  @Length(max = DataConsts.PASSWORD_MAX_LENGTH)
  private String newPwd;
  @NotEmpty
  @Length(max = DataConsts.PASSWORD_MAX_LENGTH)
  private String confirmPwd;
}
