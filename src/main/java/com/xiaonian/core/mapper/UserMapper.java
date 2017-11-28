package com.xiaonian.core.mapper;
import com.xiaonian.core.entity.User;
import com.xiaonian.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}