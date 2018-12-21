package com.cj.demo.common.Util;

import com.cj.demo.common.model.RequestResult;

public class RequestResultUtil {
    public static Object success(Object data){
        return new RequestResult(true, data);
    }

    public static Object fail(Object data){
        return new RequestResult(false, data);
    }
}
