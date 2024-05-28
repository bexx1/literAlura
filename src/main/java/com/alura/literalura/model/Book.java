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
    private String authorName;
    private List<String> languages;
    private Integer download_count;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

// CONSTRUCTOR
    public Book() {}
    public Book(BookData bookData) {
        this.title = bookData.title();
        this.authorName = bookData.authors().get(0).name();
        this.languages = bookData.languages();
        this.download_count = bookData.download_count();
    }


// GETTERS
    public String getTitle() {return title;}
    public List<String> getLanguages() {return languages;}
    public Integer getDownload_count() {return download_count;}
    public Author getAuthor() {return author;}

// SETTERS
    public void setAuthor(Author author) {this.author = author;}

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
