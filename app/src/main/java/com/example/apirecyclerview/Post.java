package com.example.apirecyclerview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {
    private String title;
    @SerializedName("body")
    private String text;
    public Post(int userId, int id, String title, String text) {
        this.title = title;
        this.text = text;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
}
