package com.fms2.fms2.login.domain;

public class User {
    private String name;  //员工姓名
    private String keyWord;
    private String userName;//账号
    private String password;//密码
    private boolean user;//是否是用户
    private String role;//角色
    private String newPwd;
    private String confirmPwd;

    public String getNewPwd() {
        return newPwd;
    }
    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
    public String getConfirmPwd() {
        return confirmPwd;
    }
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isUser() {
        return user;
    }
    public void setUser(boolean user) {
        this.user = user;
    }

}
