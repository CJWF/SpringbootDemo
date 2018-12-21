package com.cj.demo.common.Util;

import com.cj.demo.common.model.Error;

/**
 * 错误获取类（-1：普通错误类，一般为用户输入错误；-2：系统错误类，一般由系统错误导致）
 */
public class ErrorUtil {

    public static Object normalError(){
        return new Error("-1","输入格式错误，请检查输入");
    }

    public static Object normalError(String errorMsg){
        return new Error("-1",errorMsg);
    }

    public static Object systemError(){
        return new Error("-2","系统异常，请联系管理员");
    }

    public static Object systemError(String errorMsg){
        return new Error("-2",errorMsg);
    }

}
