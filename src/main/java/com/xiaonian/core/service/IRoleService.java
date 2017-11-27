package com.xiaonian.core.service;

import com.xiaonian.core.entity.Role;
import com.xiaonian.core.vo.FormRole;

import java.util.List;

/**
 * 角色服务类
 * 
 * @author qqjbest
 * @since 2016年7月8日 下午1:59:52
 */
public interface IRoleService extends IBaseService<Role>
{

    /**
     * 根据管理员id获取
     * @param adminId
     * @return
     */
    List<Role> getByAdminId(Integer adminId);

    /**
     * 启用
     *
     * @param id
     */
    void enable(Integer id);

    /**
     * 禁用
     *
     * @param id
     */
    void disable(Integer id);

    /**
     * 获取所有正常角色
     *
     * @return
     */
    List<Role> getAllEnable();

    /**
     * 删除
     *
     * @param ids
     */
    void delete(String ids);

    /**
     * 保存角色和角色策略
     * @param role
     */
    void saveRoleAndStrategys(FormRole role);

    /**
     * 更新角色和角色策略
     * @param role
     */
    void updateRoleAndStrategys(FormRole role);

    void insertList(List list);
}
