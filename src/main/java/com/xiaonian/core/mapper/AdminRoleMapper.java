package com.xiaonian.core.mapper;

import com.xiaonian.core.entity.AdminRoleKey;

import java.util.List;

/**
 * 管理员角色
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
public interface AdminRoleMapper extends BaseMapper<AdminRoleKey> {

    void deleteByAdminId(Integer adminId);

    void addTrainRecordBatch(List<AdminRoleKey> adminuserRolesKeys);

    void deleteByRoleIds(Integer[] roleIds);
}