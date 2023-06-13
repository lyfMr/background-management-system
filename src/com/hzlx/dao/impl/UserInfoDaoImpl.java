package com.hzlx.dao.impl;

import com.hzlx.dao.UserInfoDao;
import com.hzlx.entity.UserInfo;
import com.hzlx.utils.BaseDao;

import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-01 16:31
 **/
public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public UserInfo getUserInfoByUserNameAndPassword(String userName, String password) {
        String sql = "select * from t_user_info where `user_name`=? and `password`=? ";
        return selectOne(sql,UserInfo.class,userName,password);
    }

    @Override
    public List<UserInfo> getAllUser() {
        String sql = "select * from t_user_info";
        return selectListForObject(sql,UserInfo.class);
    }

    @Override
    public UserInfo getUserById(Integer id) {
        String sql = "select * from t_user_info where id=?";
        return selectOne(sql,UserInfo.class,id);
    }

    @Override
    public int addUser(String userName, String password, String nickName, String tel, String address, Integer sex, String avatar) {
        String sql = "insert into t_user_info value(default,?,?,?,?,?,?,?,now(),default)";
        return executeUpdate(sql,userName,password,nickName,tel,address,sex,avatar);
    }

    @Override
    public int updateUser(Integer id, String userName, String nickName, String tel, String address, Integer sex, String avatar) {
        String sql = "update t_user_info set user_name=?,nick_name=?,tel=?,address=?,sex=?,avatar=? where id = ?";
        return executeUpdate(sql,userName,nickName,tel,address,sex,avatar,id);
    }

    @Override
    public int deleteUser(Integer id,Integer status) {
        String sql = "update t_user_info set status=? where id=?";
        return executeUpdate(sql,status,id);
    }
}
