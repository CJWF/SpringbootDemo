package com.cj.demo.sys.model;

public class Switch {
    private String kCode;       //编码
    private String vName;       //名称
    private int switchType;     //开关类型
    private String pCode;       //父编码
    private String gId;         //组id
    private int sortNum;        //排序

    public String getkCode() {
        return kCode;
    }

    public void setkCode(String kCode) {
        this.kCode = kCode;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public int getSwitchType() {
        return switchType;
    }

    public void setSwitchType(int switchType) {
        this.switchType = switchType;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "kCode='" + kCode + '\'' +
                ", vName='" + vName + '\'' +
                ", switchType=" + switchType +
                ", pCode='" + pCode + '\'' +
                ", gId='" + gId + '\'' +
                ", sortNum=" + sortNum +
                '}';
    }
}
