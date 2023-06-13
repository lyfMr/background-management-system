package com.hzlx.utils;

import com.google.gson.Gson;
import lombok.*;

/**
 * <h3>java-web-3021</h3>
 * <p>返回体</p>
 *
 * @author : 李永富
 * @date : 2023-05-24 22:14
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static String success(){
        Gson gson = new Gson();
        return gson.toJson(new BaseResult(200,"success",null));
    }

    public static <T> String success(T data){
        Gson gson = new Gson();
        return gson.toJson(new BaseResult(200,"success",data));
    }

    public static <T> String error(Integer code, String msg){
        Gson gson = new Gson();
        return gson.toJson(new BaseResult(code,msg,null));
    }


}
