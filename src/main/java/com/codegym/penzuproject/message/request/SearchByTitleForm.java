package com.codegym.penzuproject.message.request;

public class SearchByTitleForm {
    private String title;

    public SearchByTitleForm() {
    }

    public SearchByTitleForm(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
