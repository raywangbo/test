package com.xiaonian.core.service.impl;

import com.xiaonian.core.entity.AdminRoleKey;
import com.xiaonian.core.mapper.AdminRoleMapper;
import com.xiaonian.core.service.IAdminRoleService;
import com.xiaonian.core.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService  extends BaseService<AdminRoleKey,AdminRoleMapper> implements IAdminRoleService {

	private static Logger log = LoggerFactory.getLogger(AdminRoleService.class);

	@Override
	public AdminRoleMapper getMapper()
	{
		return adminRoleMapper;
	}

	@Autowired
	private AdminRoleMapper adminRoleMapper;

	@Override
	public void deleteByAdminId(Integer adminId) {
		getMapper().deleteByAdminId(adminId);
	}

	@Override
	public void addTrainRecordBatch(List<AdminRoleKey> adminuserRolesKeys) {
		getMapper().addTrainRecordBatch(adminuserRolesKeys);
	}

    @Override
    public void deleteByRoleIds(String roleIds) {
		getMapper().deleteByRoleIds(CommonUtil.strArray2intArray(roleIds.trim().split(",")));
    }
}
