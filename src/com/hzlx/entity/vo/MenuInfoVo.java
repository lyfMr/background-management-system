package com.hzlx.entity.vo;

import com.hzlx.entity.MenuInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-02 08:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfoVo extends MenuInfo implements Serializable {
    private List<MenuInfo> list;
}
