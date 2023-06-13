package com.hzlx.filter;

import com.hzlx.component.BgmsConfig;
import com.hzlx.entity.UserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-04 23:36
 **/
@WebFilter(urlPatterns = {"/bgms"})
public class Filter_B_CheckSession  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if ("/bgms".equals(request.getRequestURI())){
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute(BgmsConfig.SESSION_USER_KEY);
            if (userInfo == null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/api+/menu/showMenuTree");
            }
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
