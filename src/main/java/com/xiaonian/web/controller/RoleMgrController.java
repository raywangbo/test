package com.xiaonian.web.controller;

import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.bean.ResponseBean;
import com.xiaonian.core.entity.Role;
import com.xiaonian.core.service.IRoleService;
import com.xiaonian.core.utils.CommonUtil;
import com.xiaonian.core.utils.ValidatorUtil;
import com.xiaonian.core.vo.FormRole;
import com.xiaonian.core.vo.VoRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色控制层
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
@Controller
@RequestMapping("/admin/role")
public class RoleMgrController extends CrudController<Role, IRoleService>{
	@Autowired
	private IRoleService roleService;
	
	@Override
	public IRoleService getService()
	{
		return roleService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody
	PagerBean<Role> getAll(PagerBean<Role> pager)
	{	
		return super.getAll(pager);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	VoRole get(@PathVariable("id") Integer id)
	{
		Role role = roleService.getById(id);
		VoRole jsonrole = new VoRole();
		CommonUtil.copyPropertiesIgnoreNull(role, jsonrole);
		jsonrole.setCreateTime(role.getCreateTime().getTime());
		return jsonrole;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	ResponseBean post(FormRole role)
	{
		roleService.saveRoleAndStrategys(role);
		return toResponseJson();
	}

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseBean put(FormRole role)
    {
		roleService.updateRoleAndStrategys(role);
        return toResponseJson();
    }

    @RequestMapping(value = "{ids}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseBean del(String ids)
	{
		getService().delete(ids);
		return toResponseJson();
	}


	@RequestMapping(value = "/getByAdminId")
	public @ResponseBody List<VoRole> getByAdminId(Integer id)
	{
		List<VoRole> voRoles = new ArrayList<>();
		List<Role> ownRoles = new ArrayList<>();
		if(ValidatorUtil.isNotNull(id))
		{
			ownRoles = getService().getByAdminId(id);
		}
		for (Role Role : ownRoles)
		{
			VoRole tempRoels = new VoRole();
			CommonUtil.copyPropertiesIgnoreNull(Role, tempRoels);
			tempRoels.setOwn(true);
			voRoles.add(tempRoels);
		}

		List<Role> allRole = getService().getAllEnable();
		allRole.removeAll(ownRoles);
		for (Role Role : allRole)
		{
			VoRole tempRoels = new VoRole();
			CommonUtil.copyPropertiesIgnoreNull(Role, tempRoels);
			voRoles.add(tempRoels);
		}
		return voRoles;
	}

	@RequestMapping(value ="/enable", method = RequestMethod.POST)
	public @ResponseBody ResponseBean enable(Integer id)
	{
		getService().enable(id);
		return toResponseJson();
	}

	@RequestMapping(value ="/disable", method = RequestMethod.POST)
	public @ResponseBody ResponseBean disable(Integer id)
	{
		getService().disable(id);
		return toResponseJson();
	}

}
