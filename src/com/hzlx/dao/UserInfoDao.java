package com.hzlx.dao;

import com.hzlx.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    /**
     * 根据用户名和密码获取用户信息
     * @param userName 用户名
     * @param password 密码
     * @return 用户对象（UserInfo）
     */
    UserInfo getUserInfoByUserNameAndPassword(String userName, String password);

    List<UserInfo> getAllUser();
    UserInfo getUserById(Integer id);
    int addUser(String userName,String password,String nickName,String tel,String address,Integer sex,String avatar);
    int updateUser(Integer id,String userName,String nickName,String tel,String address,Integer sex,String avatar);
    int deleteUser(Integer id,Integer status);
}
