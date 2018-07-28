package me.zbl.fullstack.service.impl;

import me.zbl.fullstack.consts.SessionConstants;
import me.zbl.fullstack.entity.AdminUser;
import me.zbl.fullstack.entity.dto.form.AdminUserPwdModifyForm;
import me.zbl.fullstack.entity.dto.form.UserLoginForm;
import me.zbl.fullstack.entity.dto.request.TableKeyModel;
import me.zbl.fullstack.mapper.AdminUserMapper;
import me.zbl.fullstack.service.api.IAdminUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Background user service implementation class
 *
 * @author raviteja
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService {

  @Autowired
  private AdminUserMapper mAdminUserMapper;

  @Override
  public AdminUser checkAdminUserExist(UserLoginForm form) {
    AdminUser adminUser = new AdminUser();
    adminUser.setUsername(form.getUsername());
    adminUser.setPassword(DigestUtils.md5Hex(form.getPassword()));
    List<AdminUser> adminUsers = mAdminUserMapper.select(adminUser);
    if (null != adminUsers && adminUsers.size() > 0) {
      return adminUsers.get(0);
    }
    return null;
  }

  @Override
  public void joinSession(HttpServletRequest request, AdminUser user) {
    HttpSession requestSession = request.getSession(true);
    requestSession.setAttribute(SessionConstants.SESSION_ADMIN_CURRENT_USER, user);
  }

  @Override
  public void destroySession(HttpServletRequest request) {
    HttpSession requestSession = request.getSession(true);
    requestSession.removeAttribute(SessionConstants.SESSION_ADMIN_CURRENT_USER);
  }

  @Override
  public List<AdminUser> getAdminUserJson() {
    return mAdminUserMapper.selectAll();
  }

  @Override
  public void deleteAdminUser(TableKeyModel model) {
    for (Integer id : model.getIds()) {
      mAdminUserMapper.deleteByPrimaryKey(id);
    }
  }

  @Override
  public ModifyPwdResult modifyUserPwd(AdminUserPwdModifyForm form, HttpServletRequest request) {
    String oriPwd = form.getOriPwd();
    String newPwd = form.getNewPwd();
    String confirmPwd = form.getConfirmPwd();
    if (!StringUtils.equals(newPwd, confirmPwd)) {
      // Two different passwords.
      return ModifyPwdResult.NOT_EQUAL;
    }
    AdminUser user = (AdminUser) request.getSession().getAttribute(SessionConstants.SESSION_ADMIN_CURRENT_USER);
    // Is the password correct?
    if (StringUtils.equals(DigestUtils.md5Hex(oriPwd), user.getPassword())) {
      user.setPassword(DigestUtils.md5Hex(newPwd));
      // Update password
      mAdminUserMapper.updateByPrimaryKeySelective(user);
      return ModifyPwdResult.SUCCESS;
    } else {
      // Original password error
      return ModifyPwdResult.ORI_PWD_ERROR;
    }
  }
}
