package com.cj.demo.sys.model;

public class User {
    private String userId;          //用户id
    private String userName;        //用户名
    private String userPass;        //用户密码
    private String userGender;      //用户性别
    private String userRealName;    //用户真名
    private String userIdcode;      //用户身份证
    private String userPhone;       //电话
    private String userEmail;       //email
    private String userStatus;      //用户状态
    private String userCreate;      //创建时间
    private String userUpdate;      //用户更新时间
    private String passChange;      //强制更新密码
    private String passExp;         //密码过期日期
    private String loginNo;         //登录次数
    private String lastAddr;        //最后登录地址
    private String lastIp;          //最后登录ip
    private String ErrorCount;      //登录错误次数

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserIdcode() {
        return userIdcode;
    }

    public void setUserIdcode(String userIdcode) {
        this.userIdcode = userIdcode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    public String getPassChange() {
        return passChange;
    }

    public void setPassChange(String passChange) {
        this.passChange = passChange;
    }

    public String getPassExp() {
        return passExp;
    }

    public void setPassExp(String passExp) {
        this.passExp = passExp;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getLastAddr() {
        return lastAddr;
    }

    public void setLastAddr(String lastAddr) {
        this.lastAddr = lastAddr;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(String errorCount) {
        ErrorCount = errorCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userIdcode='" + userIdcode + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userCreate='" + userCreate + '\'' +
                ", userUpdate='" + userUpdate + '\'' +
                ", passChange='" + passChange + '\'' +
                ", passExp='" + passExp + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", lastAddr='" + lastAddr + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", ErrorCount='" + ErrorCount + '\'' +
                '}';
    }
}
