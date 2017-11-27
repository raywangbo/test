package com.xiaonian.web.controller;

import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.bean.ResponseBean;
import com.xiaonian.core.entity.Admin;
import com.xiaonian.core.service.IAdminService;
import com.xiaonian.core.utils.BusinessUtil;
import com.xiaonian.core.utils.CommonUtil;
import com.xiaonian.core.utils.ExcelUtil;
import com.xiaonian.core.vo.FormAdmin;
import com.xiaonian.core.vo.VoAdmin;
import com.xiaonian.core.vo.VoExport;
import com.xiaonian.web.model.Key;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 管理员管理
 * 
 * @author qqjbest
 * @since 2016年7月12日 上午10:50:51
 */
@Controller
@RequestMapping(value = "/admin/admin")
public class AdminMgrController extends CrudController<Admin, IAdminService>
{
	private static Logger log = LoggerFactory.getLogger(AdminMgrController.class);

	@Autowired
	private IAdminService adminService;

	@RequestMapping(value = "/all")
	public @ResponseBody
	PagerBean<Admin> getAll(PagerBean<Admin> pager)
	{
		return super.getAll(pager);
	}

	@Override
	public IAdminService getService() {
		return adminService;
	}

	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public @ResponseBody ResponseBean login(@ModelAttribute(Key.admin) Admin admin)
	{
		Set<String> roleStrategy = null;
		try
		{
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(admin.getAccount(), admin.getPassword());
			subject.login(token);
			roleStrategy = getService().getRoleStrategy(admin.getAccount());
		}
		catch (UnknownAccountException e) {
			return toErrorResponseJson("账号或密码错误");
		} catch (IncorrectCredentialsException e) {
			return toErrorResponseJson("账号或密码错误");
		} catch (ExcessiveAttemptsException e) {
			return toErrorResponseJson("登录失败多次，账户锁定10分钟!");
		}
		return toResponseData(roleStrategy);
	}

	/**
	 * 跳转页面设计
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{id}/edit",method=RequestMethod.GET)
	public String goListHotKey(Model model, HttpServletRequest request, @PathVariable("id")String id){
		request.getSession().setAttribute("ttt","ccc");
		return "/test";
	}

	/**
	 * 查看
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public @ResponseBody VoAdmin get(@PathVariable("id") Integer id)
	{
		Admin admin = adminService.getById(id);
		VoAdmin jsonAdmin = new VoAdmin();
		CommonUtil.copyPropertiesIgnoreNull(admin, jsonAdmin);
		return jsonAdmin;
	}

	/**
	 * 修改
	 * @param admin
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody
	ResponseBean update(FormAdmin admin)
	{
		getService().updateAdminAndRoles(admin);
		return toResponseJson();
	}

	/**
	 * 重置密码
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST)
	public @ResponseBody ResponseBean resetPassword(Integer id)
	{
		getService().resetPassword(id);
		return toResponseJson();
	}

	/**
	 * 修改密码
	 * @param account
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value="/updPassword", method=RequestMethod.POST)
	public @ResponseBody ResponseBean updPassword(String account, String oldPassword, String newPassword)
	{
		getService().updatePassword(account, oldPassword, newPassword);
		BusinessUtil.logout(account);
		return toResponseJson();
	}

	/**
	 * 新增
	 * @param admin
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	ResponseBean save(FormAdmin admin)
	{
		getService().saveAdminAndRoles(admin);
		return toResponseJson();
	}

	/**
	 * 导出报表
	 */
	@RequestMapping(value="/export", method = RequestMethod.GET)
	public @ResponseBody void export(HttpServletResponse response, HttpServletRequest request)
	{
		try{
			VoExport export = new VoExport();
			export.setCloumnCount((byte)3);
			export.setCloumnTitles(new String[]{"用户名","账号","密码"});
			export.setFieldNames(new String[]{"name","account","password"});
			List<Map<String,Object>> datas = new ArrayList<>();
			Map<String,Object> params = new HashedMap();
			params.put("name","清江");
			params.put("account","qqj");
			params.put("password","123");
			datas.add(params);
			export.setTopTitle("用户列表");
			export.setDatas(datas);
			export.setFileName("用户管理");
			ExcelUtil.export(export, response, request);
		} catch (Exception e) {

		}
	}

    /**
     * 导入excel
     *
     * @param response
     * @param request
     * @param file
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public @ResponseBody void importExcel(HttpServletResponse response, HttpServletRequest request, MultipartFile file)
    {
        getService().importExcel(file);
    }
}