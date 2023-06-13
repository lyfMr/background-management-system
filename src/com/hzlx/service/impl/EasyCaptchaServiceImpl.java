package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.service.EasyCaptchaService;
import com.hzlx.utils.BaseResult;
import com.wf.captcha.ArithmeticCaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-05 15:41
 **/
public class EasyCaptchaServiceImpl implements EasyCaptchaService {
    @Override
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        // 几位数运算，默认是两位
        captcha.setLen(3);
        // 获取运算的公式：3+2=?
        captcha.getArithmeticString();
//        captcha.text();  // 获取运算的结果：5
        // 验证码存入session
        request.getSession().setAttribute(BgmsConfig.CAPTCHA_CODE, captcha.text().toLowerCase());
        try {
            captcha.out(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String check(HttpServletRequest request) {
        //用户传入的验证码
        String code = request.getParameter("code");
        //Session中的验证码
        String captcha = (String) request.getSession().getAttribute(BgmsConfig.CAPTCHA_CODE);

        if (captcha.equals(code)){
            return BaseResult.success();
        }
        return BaseResult.error(10003,"验证码错误");
    }
}
