package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer birth_year;
    private Integer death_year;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

// CONSTRUCTOR
    public Author() {}
    public Author(AuthorData authorData) {
        String[] author = authorData.name().split(",");
        this.name = author[1] + " " + author[0];
        this.birth_year = authorData.birth_year();
        this.death_year = authorData.death_year();
    }

// GETTERS
    public Long getId() {return id;}
    public String getName() {return name;}
    public Integer getBirth_year() {return birth_year;}
    public Integer getDeath_year() {return death_year;}
    public List<Book> getBooks() {return books;}

// SETTERS
    public void setBooks(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

// METHODS
    public List<String> allBooks() {
        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

// TO STRING
    @Override
    public String toString() {
        return '\n' + " Author: " + '\n' +
                "   name=" + name + '\n' +
                "   birth_year=" + birth_year + '\n' +
                "   death_year=" + death_year + '\n';
    }
}