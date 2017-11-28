package com.xiaonian.web.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 根据id获取用户信息
     * @Auther Ray
     * @Date 2017/11/28 8:54
     * @param id 用户id
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public @ResponseBody
    ResponseBean getUserById(Integer id){
        User user = userService.getById(id);
        JSONUser jsonUser = new JSONUser();
        CommonUtil.copyPropertiesIgnoreNull(user,jsonUser);

        return toJson("用户获取成功",jsonUser);
    }

    /**
     * 更新用户信息
     * @Auther Ray
     * @Date 2017/11/28 8:56
     * @param user 用户id
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public @ResponseBody
    ResponseBean updateUser(User user){
        userService.update(user);
        return toJson("用户更新成功",null);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public @ResponseBody
    ResponseBean deleteUser(String id){
        userService.deleteByIds(id);
        return toJson("删除用户成功",null);
    }
    @Override
    public IUserService getService() {
        return userService;
    }

    /**
     * 返回ResponseBean获取信息成功对象
     * @Auther Ray
     * @Date 2017/11/28 18:56
     * @param msg
     */
    private ResponseBean toJson(String msg,Object data){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(msg);
        responseBean.setErrCode(ErrCodeConstants.ERR_0_SUCCESS);
        responseBean.setStatus(Constants.API_STATUS_SUCCESS);
        responseBean.setData(data);
        return responseBean;
    }
}
