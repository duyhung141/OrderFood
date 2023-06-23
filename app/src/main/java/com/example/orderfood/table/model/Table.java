package com.example.orderfood.table.model;

public class Table {
    private String title;
    private int image;

    public Table(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}