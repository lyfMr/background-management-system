package com.hzlx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <h3>mavenCreat</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-05-09 14:24
 **/
@SuppressWarnings({"all"})
public class PropertiesUtil {
    static Properties properties;
    //私有化无参构造器，防止实例化对象
    private PropertiesUtil(){}
    //使用静态代码块创建对象
    static {
        properties = new Properties();
    }


    public static void load(String fileName){

        InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName + ".properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println("加载配置文件异常！");
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return properties.get(key).toString();
    }
}
