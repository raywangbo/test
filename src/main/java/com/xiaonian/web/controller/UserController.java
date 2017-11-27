package com.xiaonian.web.controller;

import com.github.pagehelper.PageHelper;
import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.bean.ResponseBean;
import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.constanst.ErrCodeConstants;
import com.xiaonian.core.entity.User;
import com.xiaonian.core.service.IUserService;
import com.xiaonian.core.utils.CommonUtil;
import com.xiaonian.core.vo.JSONUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 *
 * @auther Ray
 * @create 2017/11/15 14:23
 */
@Controller
@RequestMapping(value = "/user",method = RequestMethod.GET)
public class UserController  extends CrudController<User,IUserService>
{

    @Autowired
    private IUserService userService;
    /**
     * 获取所有用户
     * @Auther Ray
     * @Date 2017/11/15 14:29
     * @param
     */
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public @ResponseBody
    PagerBean<User> getAllUser(PagerBean<User> pagerBean)
    {
        return super.getAll(pagerBean);
    }

    @Override
    public IUserService getService() {
        return userService;
    }
}
