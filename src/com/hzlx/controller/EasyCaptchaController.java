package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.EasyCaptchaService;
import com.hzlx.service.impl.EasyCaptchaServiceImpl;
import com.wf.captcha.ArithmeticCaptcha;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h3>background-management-system</h3>
 * <p>验证码Controller层</p>
 *
 * @author : 李永富
 * @date : 2023-06-01 14:34
 **/

@Controller
@RequestMapping("/api/captcha")
public class EasyCaptchaController extends HttpServlet {
    private EasyCaptchaService easyCaptchaService = new EasyCaptchaServiceImpl();

    @RequestMapping("/code")
    @com.hzlx.annotation.HttpServlet
    public void captcha(HttpServletRequest request, HttpServletResponse response){
        easyCaptchaService.captcha(request, response);
    }

    @RequestMapping("/check")
    @RequestParameter
    @ResponseBody
    public String check(HttpServletRequest request){
        return easyCaptchaService.check(request);
    }
}
