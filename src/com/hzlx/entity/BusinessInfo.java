package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-09 10:30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo {
    private Integer id;
    private String storeName;
    private String tel;
    private String address;
    private String avatar;
    private Date createTime;
    private Integer status;
}
