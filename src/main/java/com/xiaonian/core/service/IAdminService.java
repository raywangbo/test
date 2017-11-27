package com.xiaonian.core.service;

import com.xiaonian.core.entity.Admin;
import com.xiaonian.core.vo.FormAdmin;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * 管理员服务类
 * 
 * @author qqjbest
 * @since 2016年4月14日 上午10:42:38
 */
public interface IAdminService extends IBaseService<Admin>
{

	/**
	 * 登录接口
	 *  
	 * @author qqjbest
	 * @since 2016年4月28日 下午1:58:23
	 * @param adminUser
	 */
	Admin login(Admin adminUser);


	/**
	 * 根据账号获取用户
	 *
	 * @param account
	 * @return
	 */
	Admin findByAccount(String account);

	/**
	 * 更新管理员和角色关系
	 * @param admin
	 */
    void updateAdminAndRoles(FormAdmin admin);

	/**
	 * 新增管理员和角色关系
	 * @param admin
	 */
	void saveAdminAndRoles(FormAdmin admin);

	/**
	 * 重置密码
	 * @param id
	 */
	void resetPassword(Integer id);

	/**
	 * 更改密码
	 * @param account
	 * @param oldPassword
	 * @param newPassword
	 */
	void updatePassword(String account, String oldPassword, String newPassword);

	/**
	 * 获取用户角色策略
	 * @param account
	 * @return
	 */
	Set<String> getRoleStrategy(String account);

	/**
	 * excel导入admin
	 *
	 * @param excelFile
	 */
    void importExcel(MultipartFile excelFile);
}
