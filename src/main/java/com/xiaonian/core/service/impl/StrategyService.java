package com.xiaonian.core.service.impl;

import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.entity.Strategy;
import com.xiaonian.core.mapper.StrategyMapper;
import com.xiaonian.core.service.IRoleStrategyService;
import com.xiaonian.core.service.IStrategyService;
import com.xiaonian.core.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StrategyService  extends BaseService<Strategy,StrategyMapper> implements IStrategyService {

	private static Logger log = LoggerFactory.getLogger(StrategyService.class);

	@Autowired
	private IRoleStrategyService roleStrategyService;

	@Override
	public StrategyMapper getMapper()
	{
		return strategyMapper;
	}

	@Autowired
	private StrategyMapper strategyMapper;
	
	@Override
	public void enable(int id)
	{
		Strategy strategy = new Strategy();
		strategy.setId(id);
		strategy.setStatus(Constants.DATA_STATUS_NORMAL);
		strategy.setUpdateTime(DateUtils.getSystemTime());
		getMapper().updateByPrimaryKeySelective(strategy);
	}

	@Override
	public void disable(int id)
	{
		Strategy strategy = new Strategy();
		strategy.setId(id);
		strategy.setStatus(Constants.DATA_STATUS_DEL);
		strategy.setUpdateTime(DateUtils.getSystemTime());
		getMapper().updateByPrimaryKeySelective(strategy);
	}

	@Override
	public Set<String> getStrategyByAccount(String account)
	{
		return getMapper().getStrategyByAccount(account);
	}

	@Override
	public Set<String> getPermissionByAccount(String account) {
		return getMapper().getPermissionByAccount(account);
	}

    @Override
    public List<Strategy> getByRoleId(Integer id) {
		return getMapper().getByRoleId(id);
    }

	@Override
	public List<Strategy> getAllEnable() {
		Map<String,Object> params = new HashMap<>();
		params.put("status", Constants.DATA_STATUS_NORMAL);
		return getMapper().getAllByMap(params);
	}

    @Override
    public void delete(String ids) {
		roleStrategyService.deleteByStrategyIds(ids);
		deleteByIds(ids);
    }
}
