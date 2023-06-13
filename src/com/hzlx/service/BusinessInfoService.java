package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;

public interface BusinessInfoService {
    /**
     * 获取全部商家
     * @return
     */
    void getAllBusinessInfo(HttpServletRequest request);

    String addBusinessInfo(HttpServletRequest request);

    String getBusinessInfoById(HttpServletRequest request);

    String updateBusinessInfo(HttpServletRequest request);

    String updateBusinessStatus(HttpServletRequest request);
}
