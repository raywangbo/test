package com.xiaonian.service;

import com.xiaonian.baseTest.SpringTestCase;
import com.xiaonian.core.service.IAdminService;
import com.xiaonian.core.vo.FormAdmin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 角色服务类测试
 * 
 * @author qqjbest
 * @since 2016年7月8日 下午5:30:22
 */
public class TestAdminService extends SpringTestCase
{
	@Autowired
	private IAdminService adminService;
	
	@Test
	public void testResetPassword()
	{
		adminService.resetPassword(1);
	}

	@Test
	public void testUpdatePassword()
	{
		adminService.updatePassword("qqj","1234567","123456");
	}

	@Test
	public void testSaveAdminAndRoles()
	{
		FormAdmin formAdmin = new FormAdmin();
		formAdmin.setName("qq");
		formAdmin.setAccount("qq");
		formAdmin.setLocked(false);
		formAdmin.setRoles("1");
		adminService.saveAdminAndRoles(formAdmin);
	}
}
