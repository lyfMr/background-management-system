package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.BaseResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-09 10:39
 **/
public class BusinessInfoServiceImpl implements BusinessInfoService {
    private BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();

    @Override
    public void getAllBusinessInfo(HttpServletRequest request) {
        List<BusinessInfo> allBusinessInfo = businessInfoDao.getAllBusinessInfo();
        request.setAttribute(BgmsConfig.BUSINESS_LIST, allBusinessInfo);
    }

    @Override
    public String addBusinessInfo(HttpServletRequest request) {
        String storeName = request.getParameter("storeName");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String avatar = request.getParameter("avatar");
        int row = businessInfoDao.addBusinessInfo(storeName, tel, address, avatar);
        if (row >0){
            return BaseResult.success();
        }
        return BaseResult.error(20003,"商铺添加失败！");
    }

    @Override
    public String getBusinessInfoById(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id")) ;
        BusinessInfo businessInfoById = businessInfoDao.getBusinessInfoById(id);
        if (businessInfoById == null) {
            return BaseResult.error(20003,"数据获取错误！");
        }
        return BaseResult.success(businessInfoById);
    }

    @Override
    public String updateBusinessInfo(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        String storeName = request.getParameter("storeName");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String avatar = request.getParameter("avatar");

        if (businessInfoDao.updateBusinessInfo(id, storeName, tel, address, avatar) > 0) {

            return BaseResult.success();
        }

        return BaseResult.error(20003,"数据获取错误！");
    }

    @Override
    public String updateBusinessStatus(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Integer status = Integer.parseInt(request.getParameter("status"));
        if (status == 1){
            status = 0;
        } else {
            status = 1;
        }


        if (businessInfoDao.updateBusinessStatus(id, status) > 0) {
            return BaseResult.success();
        }
        return BaseResult.error(20003,"删除失败！");
    }
}
