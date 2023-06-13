package com.hzlx.dao;

import com.hzlx.entity.MenuInfo;
import com.hzlx.entity.vo.MenuInfoVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MenuInfoDao {
    List<MenuInfo> getMenuInfoListByPid(Integer userId,Integer pid);

    List<Map<String,Object>> getMenuAll();

    MenuInfo getMenuInfoById(Integer id);

    int updateMenuInfoById(Integer id, String title, String icon, String href, Integer pId);

    int deleteMenuInfoById(Integer id);

    int addMenuInfo(String title, String icon, String href, Integer pId);
}
