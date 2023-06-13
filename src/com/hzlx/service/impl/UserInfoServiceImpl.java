package com.hzlx.service.impl;

import com.google.gson.Gson;
import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.UserInfoDao;
import com.hzlx.dao.impl.UserInfoDaoImpl;
import com.hzlx.entity.UserInfo;
import com.hzlx.service.UserInfoService;
import com.hzlx.utils.BaseResult;
import com.hzlx.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-01 16:38
 **/
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    //, HttpServletResponse response
    @Override
    public String login(HttpServletRequest request) {
        //获取用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //非空校验
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return BaseResult.error(10001,"用户名和密码不能为空！");
        }
        //给密码加密
        String encryptPwd = MD5Utils.encryptMD5(password, userName);
        UserInfo userInfo = userInfoDao.getUserInfoByUserNameAndPassword(userName, encryptPwd);
        if (userInfo == null){
            return BaseResult.error(10002,"账号或密码错误！");
        }
        request.getSession().setAttribute(BgmsConfig.SESSION_USER_KEY,userInfo);
        return BaseResult.success();
    }

    @Override
    public void getAllUser(HttpServletRequest request) {
        List<UserInfo> userList = userInfoDao.getAllUser();
        request.setAttribute(BgmsConfig.USER_LIST,userList);

    }

    @Override
    public String getUserById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserInfo userById = userInfoDao.getUserById(id);

        if (userById == null) {
            return BaseResult.error(20004,"请求数据异常");
        }
        return BaseResult.success(userById);
    }

    @Override
    public String addUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String nikeName = request.getParameter("nikeName");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        Integer sex = Integer.parseInt(request.getParameter("sex"));
        String avatar = request.getParameter("avatar");
        String passwordS = MD5Utils.encryptMD5(password, userName);
        int rows = userInfoDao.addUser(userName, passwordS, nikeName, tel, address, sex, avatar);
        if (rows > 0) {
            return BaseResult.success();
        }

        return BaseResult.error(20003,"用户添加失败！");
    }

    @Override
    public String updateUser(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String nikeName = request.getParameter("nikeName");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        Integer sex = Integer.parseInt(request.getParameter("sex"));
        String avatar = request.getParameter("avatar");
        int rows = userInfoDao.updateUser(id, userName, nikeName, tel, address, sex, avatar);
        if (rows > 0) {
            return BaseResult.success();
        }

        return BaseResult.error(20004,"用户更新失败！");
    }

    @Override
    public String deleteUser(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer status = Integer.parseInt(request.getParameter("status"));
        if (status == 1){
            status = 0;
        } else {
            status = 1;
        }
        if (userInfoDao.deleteUser(id,status) > 0) {
            return BaseResult.success();
        }
        return BaseResult.error(20005,"用户删除失败！");
    }


}
