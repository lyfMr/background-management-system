package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.MenuInfoDao;
import com.hzlx.dao.impl.MenuInfoDaoImpl;
import com.hzlx.entity.MenuInfo;
import com.hzlx.entity.UserInfo;
import com.hzlx.entity.vo.MenuInfoVo;
import com.hzlx.service.MenuInfoService;
import com.hzlx.utils.BaseResult;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-02 09:09
 **/
public class MenuInfoServiceImpl implements MenuInfoService {
    private MenuInfoDao menuInfoDao = new MenuInfoDaoImpl();

    private List<MenuInfoVo> assemblyMenuTree(Integer userId){
        List<MenuInfo> oneMenuList = menuInfoDao.getMenuInfoListByPid(userId,-1);
        List<MenuInfoVo> menuList = new ArrayList<>();
        oneMenuList.forEach(menuInfo -> {
            MenuInfoVo menuInfoVo = menuInfoConvertMenuInfoVo(menuInfo);
            menuInfoVo.setList(menuInfoDao.getMenuInfoListByPid(userId,menuInfoVo.getId()));
            menuList.add(menuInfoVo);
        });
        return menuList;
    }

    @Override
    public String showMenu(HttpServletRequest request) {
        //获取Session中的用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(BgmsConfig.SESSION_USER_KEY);
        List<MenuInfoVo> menuInfoVos = assemblyMenuTree(userInfo.getId());
        request.setAttribute(BgmsConfig.CACHE_MENU_LIST,menuInfoVos);
        request.getSession().setAttribute(BgmsConfig.CACHE_MENU_LIST,menuInfoVos);
        return "pages/home";
    }

    @Override
    public void getMenuList(HttpServletRequest request) {
        request.setAttribute(BgmsConfig.MENU_LIST,menuInfoDao.getMenuAll());
    }

    @Override
    public String getMenu(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (id == null) {
            return BaseResult.error(20001,"请求数据异常");
        }
        MenuInfo menuInfo = menuInfoDao.getMenuInfoById(id);
        return BaseResult.success(menuInfo);
    }

    @Override
    public String editMenu(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String icon = request.getParameter("icon");
        String href = request.getParameter("href");
        Integer pId = Integer.parseInt(request.getParameter("pId"));
//        String createTime = request.getParameter("createTime");
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse(createTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Integer status = Integer.parseInt(request.getParameter("status"));


        int rows= menuInfoDao.updateMenuInfoById(id,title,icon,href,pId);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20002,"修改菜单失败");
        }
    }

    @Override
    public String deleteMenu(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        int rows= menuInfoDao.deleteMenuInfoById(id);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20002,"删除菜单失败");
        }
    }

    @Override
    public String addMenuInfo(HttpServletRequest request) {
        String title = request.getParameter("title");
        String icon = request.getParameter("icon");
        String href = request.getParameter("href");
        Integer pId = Integer.parseInt(request.getParameter("pId"));
        int rows = menuInfoDao.addMenuInfo(title,icon,href,pId);
        if (rows > 0) {
            return BaseResult.success();
        }
        return BaseResult.error(20003,"增加用户失败");
    }

    private MenuInfoVo menuInfoConvertMenuInfoVo(MenuInfo menuInfo){
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        menuInfoVo.setId(menuInfo.getId());
        menuInfoVo.setTitle(menuInfo.getTitle());
        menuInfoVo.setIcon(menuInfo.getIcon());
        menuInfoVo.setHref(menuInfo.getHref());
        menuInfoVo.setPId(menuInfo.getPId());
        menuInfoVo.setCreateTime(menuInfo.getCreateTime());
        menuInfoVo.setStatus(menuInfo.getStatus());
        return menuInfoVo;
    }
}
