package com.xiaonian.core.mapper;
import com.xiaonian.core.entity.User;
import com.xiaonian.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}