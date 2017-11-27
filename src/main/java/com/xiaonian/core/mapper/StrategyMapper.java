package com.xiaonian.core.mapper;

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
public interface StrategyMapper extends BaseMapper<Strategy> {

    /**
     * 根据账户获取对应角色策略
     *
     * @param account
     * @return
     */
    Set<String> getStrategyByAccount(String account);

    /**
     * 根据账号获取对应角色权限
     *
     * @param account
     * @return
     */
    Set<String> getPermissionByAccount(String account);

    /**
     * 根据角色获取对应策略
     *
     * @param roleId
     * @return
     */
    List<Strategy> getByRoleId(Integer roleId);
}