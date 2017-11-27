package com.xiaonian.core.service;

import com.xiaonian.core.entity.RoleStrategyKey;

import java.util.List;

/**
 * 
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
public interface IRoleStrategyService extends IBaseService<RoleStrategyKey>{
    /**
     * 根据角色ids删除角色策略
     * @param roleIds
     */
    void deleteByRoleIds(String roleIds);

    /**
     * 根据策略ids删除角色策略
     * @param strategyIds
     */
    void deleteByStrategyIds(String strategyIds);

    /**
     * 批量新增
     * @param roleStrategyKeys
     */
    void addTrainRecordBatch(List<RoleStrategyKey> roleStrategyKeys);

    /**
     * 根据角色id删除角色策略
     *
     * @param id
     */
    void deleteByRoleId(Integer id);
}
