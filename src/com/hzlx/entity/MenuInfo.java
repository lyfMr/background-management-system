package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class MenuInfo {
    private Integer id;
    private String title;
    private String icon;
    private String href;
    private Integer pId;
    private Date createTime;
    private Integer status;
}
