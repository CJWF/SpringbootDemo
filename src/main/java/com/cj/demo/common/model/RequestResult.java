package com.cj.demo.common.model;

public class RequestResult {
    private boolean success;

    private Object msg;

    public RequestResult() {
    }

    public RequestResult(boolean success, Object msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
