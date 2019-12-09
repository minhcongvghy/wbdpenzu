package com.codegym.penzuproject.message.request;

public class SearchAlbumsByTitle {
    private String title;

    public SearchAlbumsByTitle(String title) {
        this.title = title;
    }

    public SearchAlbumsByTitle() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
