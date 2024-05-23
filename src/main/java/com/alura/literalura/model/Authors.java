package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authors", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private Integer birth_year;
    private Integer death_year;
    @ManyToOne
    private Book book;

// CONSTRUCTOR
    public Authors() {}
    public Authors(AuthorsData authorsData, Book book) {
        String[] author = authorsData.name().split(",");
        this.name = author[1] + " " + author[0];
        this.birth_year = authorsData.birth_year();
        this.death_year = authorsData.death_year();
        this.book = book;
    }

// GETTERS
    public Integer getId() {return id;}
    public String getName() {return name;}
    public Integer getBirth_year() {return birth_year;}
    public Integer getDeath_year() {return death_year;}

// TO STRING

    @Override
    public String toString() {
        return '\n' + " Author: " + '\n' +
                "   name=" + name + '\n' +
                "   birth_year=" + birth_year + '\n' +
                "   death_year=" + death_year + '\n';
    }
}