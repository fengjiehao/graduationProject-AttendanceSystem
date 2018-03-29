package com.fjh.model;

public class Users {
    private String user;

    private String password;

    private String name;

    private Integer ruletype;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRuletype() {
        return ruletype;
    }

    public void setRuletype(Integer ruletype) {
        this.ruletype = ruletype;
    }
}