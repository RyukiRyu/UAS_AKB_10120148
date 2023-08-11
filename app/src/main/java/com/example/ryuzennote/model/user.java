package com.example.ryuzennote.model;
//10120148_Ariyandi Julian Pratama_IF4

public class user {
    String userId, name, profile;
    public user(String userId, String name, String profile) {
        this.userId = userId;
        this.name = name;
        this.profile = profile;
    }
    public user() {
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
}