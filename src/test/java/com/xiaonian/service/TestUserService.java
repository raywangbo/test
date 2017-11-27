package com.xiaonian.service;

import com.xiaonian.baseTest.SpringTestCase;
import com.xiaonian.core.entity.User;
import com.xiaonian.core.service.IUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import org.eclipse.jetty.util.ajax.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试用户服务
 *
 * @auther Ray
 * @create 2017/11/20 9:11
 */
public class TestUserService extends SpringTestCase{
    @Autowired
    IUserService userService;

    private static final Logger LOGGER = Logger.getLogger(TestUserService.class);
    @Test
    public void testService(){
//        List<User> users = userService.getAllUser();
//        LOGGER.info("++++++++++++++++++++++++++++++++++++++++"+ JSON.toString(ArrayUtils.toString(users)));
    }
}
