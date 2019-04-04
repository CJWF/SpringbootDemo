package com.cj.demo.common.Result;

public enum ResultType {
    SUCCESS(1),SYSTEM_ERROR(-1),PARAM_ERROR(-2),BUSINESS_ERROR(-3);

    private int code;

    ResultType(int index) {
        this.code = index;
    }

    public int getCode() {
        return code;
    }

}
