package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.UserInfoService;
import com.hzlx.service.impl.UserInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-01 23:21
 **/
@Controller
@RequestMapping("/api/user")
public class UserInfoController {
    private UserInfoService userInfoService = new UserInfoServiceImpl();

    @RequestMapping("/login")
    @ResponseBody
    @RequestParameter
    public String login(HttpServletRequest request){
        return userInfoService.login(request);
    }

    @RequestMapping("/getAllUser")
    @RequestParameter
    public String getAllUser(HttpServletRequest request){
        userInfoService.getAllUser(request);
        return "pages/user_list";
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    @RequestParameter
    public String getUserById(HttpServletRequest request){
        return userInfoService.getUserById(request);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    @RequestParameter
    public String addUser(HttpServletRequest request){
        return userInfoService.addUser(request);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    @RequestParameter
    public String updateUser(HttpServletRequest request){
        return userInfoService.updateUser(request);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    @RequestParameter
    public String deleteUser(HttpServletRequest request){
        return userInfoService.deleteUser(request);
    }
}
