package com.xiaonian.core.service;

import com.xiaonian.core.entity.Strategy;

import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
public interface IStrategyService extends IBaseService<Strategy>{
	
	/**
	 * 启用
	 *  
	 * @author qqjbest
	 * @since 2017年10月10日 15:21:19
	 * @param id
	 */
	void enable(int id);

	/**
	 * 禁用
	 *  
	 * @author qqjbest
	 * @since 2017年10月10日 15:21:19
	 * @param id
	 */
	void disable(int id);

	/**
	 * 根据账号获取角色策略
	 *
	 * @param account
	 * @return
	 */
	Set<String> getStrategyByAccount(String account);

	/**
	 * 根据账号获取角色权限
	 *
	 * @param account
	 * @return
	 */
	Set<String> getPermissionByAccount(String account);

	/**
	 * 根据角色id获取策略
	 *
	 * @param id
	 * @return
	 */
    List<Strategy> getByRoleId(Integer id);

	/**
	 * 获取所有状态正常的策略
	 *
	 * @return
	 */
	List<Strategy> getAllEnable();

	/**
	 *  根据策略ids删除
	 * @param ids
	 */
    void delete(String ids);
}
