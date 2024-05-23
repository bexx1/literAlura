package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Authors> authors = new ArrayList<>();
    private List<String> languages;
    private Integer download_count;

// CONSTRUCTOR
    public Book() {}
    public Book(BookData bookData) {
        this.title = bookData.title();
        this.authors = bookData.authors();
        //List<AuthorsData> authorsData = bookData.authors().stream().toList();
        //authorsData.forEach(a -> authors.add(new Authors(a, this)));
        this.languages = bookData.languages();
        this.download_count = bookData.download_count();
    }


    // GETTERS
    public String getTitle() {return title;}
    public List<String> getLanguages() {return languages;}
    public Integer getDownload_count() {return download_count;}

// TO STRING

    @Override
    public String toString() {
        return "Book: " + '\n' +
                "title='" + title + '\n' +
                "authors=" + authors + '\n' +
                "languages=" + languages + '\n' +
                "download_count=" + download_count;
    }
}
