package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import static org.example.Exercises.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Получение всех музыкальных композиций:");
        getAllMusic();
        System.out.println("Композиции без “m” и “t”:");
        getMTMusic();
//        System.out.println("Добавление композиции");
//        getNewMusic();
        System.out.println("Получение всех музыкальных композиций:");
        getAllMusic();
        insertVisitorsAndBooks();
        System.out.println("Получение всех книг:");
        getAllBooks();
        System.out.println("Получение всех книг сортированных по году:");
        getSortBooks();
        System.out.println("Получение всех книг фильтрованных по году > 2000:");
        getFilteredBooks();
    }
}
