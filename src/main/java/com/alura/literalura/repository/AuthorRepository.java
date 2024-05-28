package com.alura.literalura.repository;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByNameContainingIgnoreCase(String name);
}
