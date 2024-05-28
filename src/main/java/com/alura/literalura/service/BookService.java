package com.alura.literalura.service;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public void saveBook(Book book) {
        Book bookAlreadySaved = bookRepository.getByTitle(book.getTitle());

        if(bookAlreadySaved == null) {
            Author author = book.getAuthor();

            Author authorAlreadySaved = authorRepository.findByNameContainingIgnoreCase(author.getName());
            if(authorAlreadySaved != null) {
                book.setAuthor(authorAlreadySaved);
                authorAlreadySaved.setBooks(book);
            } else {
                Author savedAuthor = authorRepository.save(author);
                book.setAuthor(savedAuthor);
                savedAuthor.setBooks(book);
            }

            bookRepository.save(book);
            System.out.println("Book added successfully!!");
        } else {
            System.out.println("This book has already been entered");
        }
    }
}
