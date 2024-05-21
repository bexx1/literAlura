package com.alura.literalura.main;

import com.alura.literalura.service.ConsumingApi;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConsumingApi consumingApi = new ConsumingApi();
    private final String apiUrlStart = "https://gutendex.com//books?search=";

// METHOD
    public void getMenu() {
        System.out.println("Choose the book you want by it's title: ");
        String bookTitle = scanner.nextLine();

        var bookJson = consumingApi.getApiData(apiUrlStart + bookTitle.replace(" ", "+"));
    }
}
