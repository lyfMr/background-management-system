package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;

public interface RoleInfoService {
    void getAllRole(HttpServletRequest request);
    String addRole(HttpServletRequest request);
}
