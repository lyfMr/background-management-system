package com.hzlx.dao.impl;

import com.hzlx.dao.RoleInfoDao;
import com.hzlx.entity.RoleInfo;
import com.hzlx.utils.BaseDao;

import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-07 14:58
 **/
public class RoleInfoDaoImpl extends BaseDao<RoleInfo> implements RoleInfoDao {
    @Override
    public List<RoleInfo> getRoleAll() {
        String sql = "select * from t_role_info";

        return selectListForObject(sql,RoleInfo.class);
    }

    @Override
    public int addRole(String roleName) {
        String sql = "insert into t_role_info value(default,?,now(),default)";
        return executeUpdate(sql,roleName);
    }

    @Override
    public int updateRole() {
        return 0;
    }

    @Override
    public int deletRole() {
        return 0;
    }
}
