package com.alura.LiterAlura.service;

import java.util.List;

public class GutendexBook {
    private String title;
    private List<String> languages;
    private List<GutendexAuthor> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<GutendexAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<GutendexAuthor> authors) {
        this.authors = authors;
    }
}
