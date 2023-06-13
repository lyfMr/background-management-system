package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.RoleInfoService;
import com.hzlx.service.impl.RoleInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-07 14:36
 **/
@Controller
@RequestMapping("/api/role")
public class RoleInfoController {
    private RoleInfoService roleInfoService = new RoleInfoServiceImpl();

    @RequestMapping("/getAllRole")
    @RequestParameter
    public String roleList(HttpServletRequest request){
        roleInfoService.getAllRole(request);
        return "pages/role_list";
    }

    @RequestMapping("/addRole")
    @RequestParameter
    public String addRole(HttpServletRequest request){

        return roleInfoService.addRole(request);
    }


}
