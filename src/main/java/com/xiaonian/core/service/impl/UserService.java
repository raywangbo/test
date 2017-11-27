package com.xiaonian.core.service.impl;

import com.xiaonian.core.entity.User;
import com.xiaonian.core.mapper.UserMapper;
import com.xiaonian.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @auther Ray
 * @create 2017/11/15 14:40
 */
@Service
public class UserService extends BaseService<User,UserMapper> implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserMapper getMapper() {
        return userMapper;
    }


}
