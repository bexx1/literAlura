package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;
    private List<String> languages;
    private Integer download_count;

// CONSTRUCTOR
    public Book() {}
    public Book(BookData bookData) {
        this.title = bookData.title();
        var data = bookData.author();
        AuthorData authorData = new AuthorData(data.getName(), data.getBirth_year(), data.getDeath_year());
        this.author = new Author(authorData);
        this.languages = bookData.languages();
        this.download_count = bookData.download_count();
    }


// GETTERS
    public String getTitle() {return title;}
    public List<String> getLanguages() {return languages;}
    public Integer getDownload_count() {return download_count;}
    public Author getAuthor() {return author;}
    // TO STRING

    @Override
    public String toString() {
        return "Book: " + '\n' +
                "title='" + title + '\n' +
                "author=" + author + '\n' +
                "languages=" + languages + '\n' +
                "download_count=" + download_count;
    }
}
