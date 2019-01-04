package com.cj.demo.sys.model;

public class SwitchGroup {
    private String gId;         //组Id
    private String gName;       //组名称
    private String pId;         //父id
    private int sortNum;     //排序

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public String toString() {
        return "SwitchGroup{" +
                "gId='" + gId + '\'' +
                ", gName='" + gName + '\'' +
                ", pId='" + pId + '\'' +
                ", sortNum=" + sortNum +
                '}';
    }
}
