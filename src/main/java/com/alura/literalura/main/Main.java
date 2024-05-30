package com.alura.literalura.main;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.service.BookService;
import com.alura.literalura.service.ConsumingApi;
import com.alura.literalura.service.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConsumingApi consumingApi = new ConsumingApi();
    private ConvertData converter = new ConvertData();
    private BookService bookService = new BookService();
    private final String apiUrlStart = "https://gutendex.com//books?search=";

// CONSTRUCTOR
    public Main(BookService bookService) {
        this.bookService = bookService;
    }

    // METHOD
    public void getMenu() {
        String menu = """
                ***********************************************
                    Choose your option by it's number:
                    1 - Search book by title
                    2 - Show list of books registered
                    3 - Show list of authors registered
                    4 - Show list of authors that were/are alive in ... year
                    5 - Show list of books in ... language
                
                    0 - Exit
                ***********************************************
                """;
        int option = -1;

        while ( option != 0 ) {
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch ( option ) {
                case 1:
                    getBook();
                    break;
                default:
                    System.out.println("bye bye!");
                    break;
            }
        }

    }

// CASE 1
    private BookData getBookData() {
        System.out.println("Insert the name of the book: ");
        String bookTitle = scanner.nextLine();

        var bookJson = consumingApi.getApiData(apiUrlStart + bookTitle.toLowerCase().replace(" ", "%20"));
        ResultsData resultsData = converter.getData(bookJson, ResultsData.class);
        BookData bookData = resultsData.results().get(0);

        return bookData;
    }
    private void getBook() {
        BookData bookData = getBookData();
        Book book = new Book(bookData);

        // getting the first author in the array inside bookData and putting him into the Author class
        var firstAuthor = bookData.authors().get(0);
        AuthorData authorData = new AuthorData(firstAuthor.name(), firstAuthor.birth_year(), firstAuthor.death_year());
        Author author = new Author(authorData);

        book.setAuthor(author);
        bookService.saveBook(book);
    }
}
