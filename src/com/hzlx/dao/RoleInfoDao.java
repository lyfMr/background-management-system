package com.hzlx.dao;

import com.hzlx.entity.RoleInfo;

import java.util.List;
import java.util.Map;

public interface RoleInfoDao {
    List<RoleInfo> getRoleAll();
    int addRole(String roleName);
    int updateRole();
    int deletRole();
}
