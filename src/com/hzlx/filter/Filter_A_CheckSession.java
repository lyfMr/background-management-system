package com.hzlx.filter;

import com.hzlx.component.BgmsConfig;
import com.hzlx.entity.UserInfo;
import com.hzlx.utils.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-02 10:56
 **/
@WebFilter(urlPatterns = {"/api/*"})
public class Filter_A_CheckSession implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (filterRequests(request)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(BgmsConfig.SESSION_USER_KEY);
        if (userInfo == null){
            response.sendRedirect("/bgms/");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * 过滤请求
     * @param request
     * @return 结果true就放行，false就拦截
     */
    private boolean filterRequests(HttpServletRequest request){
        PropertiesUtil.load("config");
        String excludeUrls = PropertiesUtil.getValue("exclude.urls");
        String[] urls = excludeUrls.split(",");
        for (String url : urls) {
            if (request.getRequestURI().equals(request.getContextPath()+url)){
                return true;
            }
        }
        return false;
    }
}
