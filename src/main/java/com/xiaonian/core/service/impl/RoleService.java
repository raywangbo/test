package com.xiaonian.core.service.impl;

import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.entity.Role;
import com.xiaonian.core.entity.RoleStrategyKey;
import com.xiaonian.core.mapper.RoleMapper;
import com.xiaonian.core.service.IAdminRoleService;
import com.xiaonian.core.service.IRoleService;
import com.xiaonian.core.service.IRoleStrategyService;
import com.xiaonian.core.utils.CommonUtil;
import com.xiaonian.core.utils.DateUtils;
import com.xiaonian.core.utils.ValidatorUtil;
import com.xiaonian.core.vo.FormRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class RoleService extends BaseService<Role,RoleMapper> implements IRoleService {

    private static Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private IAdminRoleService adminRoleService;

    @Autowired
    private IRoleStrategyService roleStrategyService;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleMapper getMapper()
    {
        return roleMapper;
    }

    @Override
    public List<Role> getByAdminId(Integer adminId) {
        return getMapper().getByAdminId(adminId);
    }

    @Override
    public void enable(Integer id) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(Constants.DATA_STATUS_NORMAL);
        role.setUpdateTime(DateUtils.getSystemTime());
        getMapper().updateByPrimaryKeySelective(role);
    }

    @Override
    public void disable(Integer id) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(Constants.DATA_STATUS_DEL);
        role.setUpdateTime(DateUtils.getSystemTime());
        getMapper().updateByPrimaryKeySelective(role);
    }

    @Override
    public List<Role> getAllEnable() {
        Map<String,Object> params = new HashMap<>();
        params.put("status", Constants.DATA_STATUS_NORMAL);
        return getMapper().getAllByMap(params);
    }

    @Override
    public void delete(String ids) {
        //1.根据ids删除用户角色
        adminRoleService.deleteByRoleIds(ids);
        //2.根据ids删除角色策略
        roleStrategyService.deleteByRoleIds(ids);
        //3.根据ids删除角色
        deleteByIds(ids);
    }

    @Override
    public void saveRoleAndStrategys(FormRole role) {
        //1.新增角色
        Role newRole = new Role();
        CommonUtil.copyPropertiesIgnoreNull(role, newRole);
        Timestamp currTime = DateUtils.getSystemTime();
        newRole.setCreateTime(currTime);
        newRole.setUpdateTime(currTime);
        save(newRole);
        //2.新增角色策略
        addTrainRecordBatchRoleStrategys(newRole.getId(), role.getStrategys());
    }

    @Override
    public void updateRoleAndStrategys(FormRole role) {
        Role existRole = new Role();
        CommonUtil.copyPropertiesIgnoreNull(role,existRole);
        existRole.setUpdateTime(DateUtils.getSystemTime());
        update(existRole);

        roleStrategyService.deleteByRoleId(role.getId());

        addTrainRecordBatchRoleStrategys(role.getId(), role.getStrategys());


    }

    @Override
    public void insertList(List list) {
         roleMapper.insertList(list);
    }

    /**
     * 批量新增角色策略
     * @param id
     * @param strategys
     */
    private void addTrainRecordBatchRoleStrategys(Integer roleId, String strategys) {
        if(ValidatorUtil.isNotNull(strategys))
        {
            List<RoleStrategyKey> roleStrategyKeys = new ArrayList<>();
            for (String strategyId : strategys.split(","))
            {
                RoleStrategyKey roleStrategyKey = new RoleStrategyKey();
                roleStrategyKey.setRoleId(roleId);
                roleStrategyKey.setStrategyId(Integer.parseInt(strategyId));
                roleStrategyKeys.add(roleStrategyKey);
            }
            roleStrategyService.addTrainRecordBatch(roleStrategyKeys);
        }

    }
}
