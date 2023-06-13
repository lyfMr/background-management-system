package com.hzlx.service;

import com.hzlx.entity.vo.MenuInfoVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MenuInfoService {
    String showMenu(HttpServletRequest request);
    void getMenuList(HttpServletRequest request);
    String getMenu(HttpServletRequest request);
    String editMenu(HttpServletRequest request);
    String deleteMenu(HttpServletRequest request);
    String addMenuInfo(HttpServletRequest request);
}
