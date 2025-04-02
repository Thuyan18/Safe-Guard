package com.hungn.safeliving;



public class AlertItem {
    private String title;
    private String author;
    private String description;
    private String type; // "MUA" hoặc "NANG"

    public AlertItem(String title, String author, String description, String type) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}