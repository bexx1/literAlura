package com.alura.literalura.main;

import com.alura.literalura.service.ConsumingApi;
import com.alura.literalura.service.ConvertData;

import java.util.Scanner;

public class Main {
    public Scanner scanner = new Scanner(System.in);
    public ConsumingApi consumingApi = new ConsumingApi();
    public ConvertData converter = new ConvertData();

// CONSTANTS
    private final String apiUrlStart = "https://gutendex.com//books?search=";

// METHODS
    public void showMenu() {
        System.out.println("Insert the name of a book");
        String bookName = scanner.nextLine();

        var jsonBook = consumingApi.getApiData(apiUrlStart + bookName.replace(" ", "+"));
    }
}
