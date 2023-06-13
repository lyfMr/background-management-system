package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>background-management-system</h3>
 * <p>验证码Controller层</p>
 *
 * @author : 李永富
 * @date : 2023-06-01 14:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    private String tel;
    private String address;
    private Integer sex;
    private String avatar;
    private Date createTime;
    private Integer status;
}
