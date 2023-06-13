package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.MenuInfoService;
import com.hzlx.service.impl.MenuInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-04 17:34
 **/
@Controller
@RequestMapping("/api/menu")
public class MenuInfoController {
    private MenuInfoService menuInfoService = new MenuInfoServiceImpl();

    @RequestMapping("/showMenuTree")
    @RequestParameter
    public String showMenuTree(HttpServletRequest request){
        return menuInfoService.showMenu(request);
    }

    @RequestMapping("/menuList")
    @RequestParameter
    public String menuList(HttpServletRequest request){
        menuInfoService.getMenuList(request);
        return "pages/menu_list";
    }

    @RequestMapping("/getMenu")
    @RequestParameter
    @ResponseBody
    public String getMenu(HttpServletRequest request){
        return menuInfoService.getMenu(request);
    }

    @RequestMapping("/editMenu")
    @ResponseBody
    @RequestParameter
    public String editMenu(HttpServletRequest request){
        return menuInfoService.editMenu(request);
    }

    @RequestMapping("/deleteMenu")
    @ResponseBody
    @RequestParameter
    public String deleteMenu(HttpServletRequest request){
        return menuInfoService.deleteMenu(request);
    }

    @RequestMapping("/addMenu")
    @ResponseBody
    @RequestParameter
    public String addMenu(HttpServletRequest request){
        return menuInfoService.addMenuInfo(request);
    }
}
