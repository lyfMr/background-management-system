package com.hzlx.service.impl;

import com.google.gson.Gson;
import com.hzlx.dao.RoleInfoDao;
import com.hzlx.dao.impl.RoleInfoDaoImpl;
import com.hzlx.entity.RoleInfo;
import com.hzlx.service.RoleInfoService;
import com.hzlx.utils.BaseResult;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-07 16:20
 **/
public class RoleInfoServiceImpl implements RoleInfoService {

    private RoleInfoDao roleInfoDao = new RoleInfoDaoImpl();
    @Override
    public void getAllRole(HttpServletRequest request) {
        List<RoleInfo> roleAll = roleInfoDao.getRoleAll();
        request.setAttribute("roleList", roleAll);
//        Gson gson = new Gson();
//        BaseResult.success(gson.toJson(roleAll));
    }

    @Override
    public String addRole(HttpServletRequest request) {
        String roleName = request.getParameter("name");

        if (roleInfoDao.addRole(roleName) > 0){
            return BaseResult.success();
        }
        return BaseResult.error(20003,"添加失败");
    }
}
