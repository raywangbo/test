package com.xiaonian.core.service.impl;

import com.xiaonian.core.entity.RoleStrategyKey;
import com.xiaonian.core.mapper.RoleStrategyMapper;
import com.xiaonian.core.service.IRoleStrategyService;
import com.xiaonian.core.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleStrategyService  extends BaseService<RoleStrategyKey,RoleStrategyMapper> implements IRoleStrategyService {

	private static Logger log = LoggerFactory.getLogger(RoleStrategyService.class);

	@Override
	public RoleStrategyMapper getMapper()
	{
		return roleStrategyMapper;
	}

	@Autowired
	private RoleStrategyMapper roleStrategyMapper;

	@Override
	public void deleteByRoleIds(String roleIds) {
		getMapper().deleteByRoleIds(CommonUtil.strArray2intArray(roleIds.split(",")));
	}

    @Override
    public void deleteByStrategyIds(String strategyIds) {
        getMapper().deleteByStrategyIds(CommonUtil.strArray2intArray(strategyIds.trim().split(",")));
    }

    @Override
    public void addTrainRecordBatch(List<RoleStrategyKey> roleStrategyKeys) {
		getMapper().addTrainRecordBatch(roleStrategyKeys);
    }

    @Override
    public void deleteByRoleId(Integer id) {
        getMapper().deleteByRoleId(id);
    }
}
