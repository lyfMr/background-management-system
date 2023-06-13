package com.hzlx.dao.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.utils.BaseDao;

import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-09 10:34
 **/
public class BusinessInfoDaoImpl extends BaseDao<BusinessInfo> implements BusinessInfoDao {
    @Override
    public List<BusinessInfo> getAllBusinessInfo() {
        String sql = "select * from t_business_info ";
        return selectListForObject(sql,BusinessInfo.class);
    }

    @Override
    public int addBusinessInfo(String storeName, String tel, String address, String avatar) {
        String sql = "INSERT into t_business_info value(default,?,?,?,?,now(),default)";
        return executeUpdate(sql,storeName,tel,address,avatar);
    }

    @Override
    public BusinessInfo getBusinessInfoById(Integer id) {
        String sql ="select * from t_business_info where id=?";
        return selectOne(sql,BusinessInfo.class,id);
    }

    @Override
    public int updateBusinessInfo(Integer id, String storeName, String tel, String address, String avatar) {
        String sql = "update t_business_info set store_name=?,tel=?,address=?,avatar=? where id=?";
        return executeUpdate(sql,storeName,tel,address,avatar,id);
    }

    @Override
    public int updateBusinessStatus(int id, Integer status) {
        String sql = "update t_business_info set status=? where id=?";
        return executeUpdate(sql,status,id);
    }
}
