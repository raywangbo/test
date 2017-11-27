package com.xiaonian.core.mapper;

import com.xiaonian.core.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role>{
    java.util.List<Role> getByAdminId(Integer adminId);
    void insertList(List list);
}