package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-07 14:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfo implements Serializable {
    private Integer id;
    private String name;
    private Date createTime;
    private Integer status;

    public String a;
}
