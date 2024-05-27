package com.alura.literalura.main;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.service.ConsumingApi;
import com.alura.literalura.service.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConsumingApi consumingApi = new ConsumingApi();
    private ConvertData converter = new ConvertData();
    private BookRepository repository;
    private final String apiUrlStart = "https://gutendex.com//books?search=";
    List<Book> books = new ArrayList<>();

// CONSTRUCTOR
    public Main(BookRepository repository) {
        this.repository = repository;
    }

    // METHOD
    public void getMenu() {
        String menu = """
                ***********************************************
                    Choose your option by it's number:
                    1 - Search book by title
                
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
        repository.save(book);

        System.out.println(book);
    }
}
