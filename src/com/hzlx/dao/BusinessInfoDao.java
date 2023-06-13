package com.hzlx.dao;

import com.hzlx.entity.BusinessInfo;

import java.util.List;

public interface BusinessInfoDao {
    List<BusinessInfo> getAllBusinessInfo();
    int addBusinessInfo(String storeName,String tel,String address,String avatar);
    BusinessInfo getBusinessInfoById(Integer id);
    int updateBusinessInfo(Integer id,String storeName,String tel,String address,String avatar);

    int updateBusinessStatus(int id, Integer status);
}
