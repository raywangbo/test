package com.xiaonian.core.mapper;

import com.xiaonian.core.entity.RoleStrategyKey;

import java.util.List;

/**
 * 角色策略
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
public interface RoleStrategyMapper extends BaseMapper<RoleStrategyKey> {
    void deleteByRoleIds(Integer[] roleIds);

    void deleteByStrategyIds(Integer[] strategyIds);

    void addTrainRecordBatch(List<RoleStrategyKey> roleStrategyKeys);

    void deleteByRoleId(Integer roleId);
}