package com.po.passwordonline.model;


public class Users {

    private long id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private long status;
    private String publicKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String toStringBy() {
        return id + "," + userName + "," + password + "," + email + "," + phone + "," + email + "," + status;
    }
}
