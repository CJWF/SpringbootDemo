package com.cj.demo.common.Result;

public class Result {
    private int code;

    private String msg;

    public Result(ResultType resultType, String msg) {
        this.code = resultType.getCode();
        if (msg == null){
            switch (resultType){
                case SUCCESS:
                    this.msg = "执行成功！";
                    return;
                case SYSTEM_ERROR:
                    this.msg = "系统错误！";
                    return;
                case PARAM_ERROR:
                    this.msg = "请求参数错误！";
                    return;
                case BUSINESS_ERROR:
                    this.msg = "业务执行错误！";
                    return;
            }
        }else {
            this.msg = msg;
        }
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
