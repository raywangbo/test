package com.xiaonian.service;

import com.xiaonian.baseTest.SpringTestCase;
import com.xiaonian.core.entity.Role;
import com.xiaonian.core.service.IRoleService;
import com.xiaonian.core.vo.FormRole;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 角色服务类测试
 * 
 * @author qqjbest
 * @since 2016年7月8日 下午5:30:22
 */
public class TestRoleService extends SpringTestCase
{
	@Autowired
	private IRoleService roleService;
	
	@Test
	 public void testDelete()
	 {
		roleService.delete("1");
		Role role = roleService.getById(1);
		Assert.assertNull(role);
	 }

	@Test
	public void testSaveRoleAndStrategys()
	{
		FormRole formRole = new FormRole();
		formRole.setName("饮水机管理员");
		formRole.setRemark("饮水机管理员备注");
		formRole.setStatus((byte)0);
		formRole.setStrategys("1");
		roleService.saveRoleAndStrategys(formRole);
	}

	@Test
	public void testUpdateRoleAndStrategys()
	{
		FormRole formRole = new FormRole();
		formRole.setId(3);
		formRole.setName("饮水机管理员");
		formRole.setRemark("饮水机管理员备注");
		formRole.setStatus((byte)0);
		formRole.setStrategys("1,2");
		roleService.updateRoleAndStrategys(formRole);
	}

}
