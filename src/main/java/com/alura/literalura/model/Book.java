package com.alura.literalura.model;

public class Book {
    private String title;
    private String authors;
    private String languages;
    private Integer download_count;

// CONSTRUCTOR
    public Book(String title, String authors, String languages, Integer download_count) {
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.download_count = download_count;
    }


// GETTERS
    public String getTitle() {return title;}
    public String getAuthors() {return authors;}
    public String getLanguages() {return languages;}
    public Integer getDownload_count() {return download_count;}

// TO STRING

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", languages='" + languages + '\'' +
                ", download_count='" + download_count + '\'' +
                '}';
    }
}
