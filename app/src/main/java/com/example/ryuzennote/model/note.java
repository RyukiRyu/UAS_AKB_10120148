package com.example.ryuzennote.model;
//10120148_Ariyandi Julian Pratama_IF4

import java.io.Serializable;

public class note implements Serializable {
    String id;
    String title;
    String category;
    String desc;
    String date;
    public note(String id, String title, String category, String desc, String date){
        this.id = id;
        this.title = title;
        this.category = category;
        this.desc = desc;
        this.date = date;
    }
    public note(){
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}