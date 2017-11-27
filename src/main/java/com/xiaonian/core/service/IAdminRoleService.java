package com.xiaonian.core.service;

import com.xiaonian.core.entity.AdminRoleKey;

import java.util.List;

/**
 * 用户角色服务类
 * 
 * @author qqjbest
 * @since 2016年7月8日 下午3:45:35
 */
public interface IAdminRoleService extends IBaseService<AdminRoleKey>
{

    /**
     * 根据管理员id解除管理员和角色的关系
     *
     * @param adminId
     */
    void deleteByAdminId(Integer adminId);

    /**
     * 批量新增管理员角色关系
     *
     * @param adminuserRolesKeys
     */
    void addTrainRecordBatch(List<AdminRoleKey> adminuserRolesKeys);

    /**
     * 根据角色ids删除
     *
     * @param roleIds
     */
    void deleteByRoleIds(String roleIds);
}
