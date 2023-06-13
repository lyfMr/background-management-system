package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-09 09:36
 **/
@Controller
@RequestMapping("/api/business")
public class BusinessInfoController {

    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();

    @RequestMapping("/getAllBusiness")
    @RequestParameter
    public String getAllBusiness(HttpServletRequest request){
        businessInfoService.getAllBusinessInfo(request);
        return "pages/business_list";
    }

    @RequestMapping("/addBusiness")
    @ResponseBody
    @RequestParameter
    public String addBusinessInfo(HttpServletRequest request){
        return businessInfoService.addBusinessInfo(request);
    }

    @RequestMapping("/getBusinessById")
    @ResponseBody
    @RequestParameter
    public String getBusinessInfoById(HttpServletRequest request){
        return businessInfoService.getBusinessInfoById(request);
    }

    @RequestMapping("/updateBusiness")
    @ResponseBody
    @RequestParameter
    public String updateBusinessInfo(HttpServletRequest request){
        return businessInfoService.updateBusinessInfo(request);
    }

    @RequestMapping("/updateBusinessStatus")
    @ResponseBody
    @RequestParameter
    public String updateBusinessStatus(HttpServletRequest request){
        return businessInfoService.updateBusinessStatus(request);
    }
}
