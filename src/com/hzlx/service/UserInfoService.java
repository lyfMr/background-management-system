package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserInfoService {
    /**
     * 用户登陆方法
     * @param request http请求，用户获取用户提交数据

     * @return
     */
    //, HttpServletResponse response
    String login(HttpServletRequest request);

    void getAllUser(HttpServletRequest request);

    String getUserById(HttpServletRequest request);

    String addUser(HttpServletRequest request);

    String updateUser(HttpServletRequest request);

    String deleteUser(HttpServletRequest request);

}
