package com.xiaonian.core.service.impl;

import com.xiaonian.core.common.exception.RestServiceException;
import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.constanst.ErrCodeConstants;
import com.xiaonian.core.entity.Admin;
import com.xiaonian.core.entity.AdminRoleKey;
import com.xiaonian.core.mapper.AdminMapper;
import com.xiaonian.core.realm.PasswordHelper;
import com.xiaonian.core.service.IAdminRoleService;
import com.xiaonian.core.service.IAdminService;
import com.xiaonian.core.service.IStrategyService;
import com.xiaonian.core.utils.BusinessUtil;
import com.xiaonian.core.utils.CommonUtil;
import com.xiaonian.core.utils.ValidatorUtil;
import com.xiaonian.core.vo.FormAdmin;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class AdminService extends BaseService<Admin,AdminMapper> implements IAdminService {

    private static Logger log = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminMapper adminuserMapper;

	@Autowired
	private IAdminRoleService adminRoleService;

	@Autowired
	private PasswordHelper passwordHelper;

	@Autowired
	private IStrategyService strategyService;

	@Override
	public AdminMapper getMapper()
	{
		return adminuserMapper;
	}

	@Override
	public Admin login(Admin adminUser)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("password", adminUser.getPassword());
		params.put("account", adminUser.getAccount());
		List<Admin> adminusers = getMapper().getAllByMap(params);
		Admin loginAdmin = null;
		if(ValidatorUtil.isNotNull(adminusers) && adminusers.size() ==1) 
		{
			loginAdmin = adminusers.get(0);
		}
		return loginAdmin;
	}

	@Override
	public Admin findByAccount(String account) {
		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		List<Admin> adminusers = getMapper().getAllByMap(params);
		if(ValidatorUtil.isNotNull(adminusers))
		{
			return adminusers.get(0);
		}
		return null;
	}

    @Override
    public void updateAdminAndRoles(FormAdmin admin) {
		//修改姓名等信息
		Admin existAdmin = getMapper().selectByPrimaryKey(admin.getId());
		CommonUtil.copyPropertiesIgnoreNull(admin, existAdmin);
		getMapper().updateByPrimaryKeySelective(existAdmin);

		//管理员角色重新建立联系
		adminRoleService.deleteByAdminId(admin.getId());
		addTrainRecordBatchAdminRole(admin.getId(), admin.getRoles());

		//退出登录
		BusinessUtil.logout(existAdmin.getAccount());
    }

	@Override
	public void saveAdminAndRoles(FormAdmin admin) {
		Admin newAdmin = new Admin();
		CommonUtil.copyPropertiesIgnoreNull(admin, newAdmin);
		createAdmin(newAdmin);
		addTrainRecordBatchAdminRole(newAdmin.getId(), admin.getRoles());
	}

	@Override
	public void resetPassword(Integer id) {
		Admin admin = getMapper().selectByPrimaryKey(id);
		admin.setPassword("1234567");
		passwordHelper.encryptPassword(admin);
		getMapper().updateByPrimaryKeySelective(admin);
	}

	@Override
	public void updatePassword(String account, String oldPassword, String newPassword) {
		Admin admin = getByAccount(account);
		if(!passwordHelper.checkPassword(admin, oldPassword))
		{
			throw new RestServiceException("旧密码错误", ErrCodeConstants.ERR_2000_BUSINESS_ERR, Constants.API_STATUS_FAILURE);
		}
		admin.setPassword(newPassword);
		passwordHelper.encryptPassword(admin);
		getMapper().updateByPrimaryKeySelective(admin);
	}

	@Override
	public Set<String> getRoleStrategy(String account) {
		return strategyService.getPermissionByAccount(account);
	}

    @Override
    public void importExcel(MultipartFile excelFile){
		List<Admin> admins = excelToAdmin(excelFile);
		//todo something

    }

	/**
	 * excel行转admin对象
	 * @param sheet
	 * @return
	 */
	private List<Admin> excelToAdmin(MultipartFile excelFile) {
		List<Admin> retAdmins = new ArrayList<>();
		CommonsMultipartFile cf = (CommonsMultipartFile) excelFile;
		InputStream inputStream = null;
		Workbook  wk = null;
		try {
            inputStream = cf.getInputStream();
			wk = Workbook.getWorkbook(inputStream);
			Sheet sheet = wk.getSheet(0);
			int rowNum = sheet.getRows();
			for (int i = 2; i < rowNum; i++) {
				Admin info = new Admin();
				info.setName(sheet.getCell(0, i).getContents());
				info.setAccount(sheet.getCell(1, i).getContents());
                info.setPassword(sheet.getCell(2, i).getContents());
				retAdmins.add(info);
			}
		} catch (Exception e) {
			log.error("excelToAdmin Exception", e);
		} finally {
			wk.close();
			try {
				inputStream.close();
			} catch (IOException e) {
				log.error("inputStream close Exception", e);
			}
		}
		return retAdmins;
	}

	private Admin getByAccount(String account) {
		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		params.put("locked", 0);
		List<Admin> adminusers = getAll(params);
		if(ValidatorUtil.isNotNull(adminusers) && adminusers.size() > 0)
		{
			return adminusers.get(0);
		}
		return null;
	}


	/**
	 * 创建管理员
	 *
	 * @param newAdmin
	 */
	private void createAdmin(Admin admin) {
		admin.setPassword("1234567");
		passwordHelper.encryptPassword(admin);
		getMapper().insertSelective(admin);
	}

	private void addTrainRecordBatchAdminRole(Integer adminId, String roles) {

		if(ValidatorUtil.isNotNull(roles))
		{
			List<AdminRoleKey> adminuserRolesKeys = new ArrayList<>();
			for (String rolesId : roles.split(","))
			{
				AdminRoleKey tempKey = new AdminRoleKey();
				tempKey.setAdminId(adminId);
				tempKey.setRoleId(Integer.parseInt(rolesId));
				adminuserRolesKeys.add(tempKey);
			}
			adminRoleService.addTrainRecordBatch(adminuserRolesKeys);
		}
	}


}
