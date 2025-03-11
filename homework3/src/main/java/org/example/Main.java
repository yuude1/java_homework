package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // Читаем JSON из файла
        try (FileReader reader = new FileReader("books.json")) {
            Type listType = new TypeToken<List<Visitor>>() {
            }.getType();
            List<Visitor> visitors = gson.fromJson(reader, listType);
            // Выводим список посетителей

            visitors.forEach(visitor -> {
                System.out.println("Name: " + visitor.getName());
                System.out.println("Surname: " + visitor.getSurname());
                System.out.println("Phone: " + visitor.getPhone());
                System.out.println("Subscribed: " + visitor.isSubscribed());
                System.out.println("Favorite Books: ");
                visitor.getFavoriteBooks().forEach(b ->
                        System.out.println(" - " + b.getName() + " (" + b.getAuthor() + ")"));
                System.out.println("--------------------");

            });
            System.out.println("Количество посетителей " + visitors.size());
            System.out.println("--------------------");

            System.out.println("Список уникальных книг, отсортированных по году издания: ");
            visitors.stream()
                    .flatMap(v -> v.getFavoriteBooks().stream())
                    .distinct()
                    .sorted(Comparator.comparing((Book::getPublishingYear)))
                    .forEach(b -> System.out.println(" - " + b.getName() + " (" + b.getAuthor() + ", " + b.getPublishingYear() + " )"));

            boolean isAuthorFavorite = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream()).anyMatch(book -> book.getAuthor().equalsIgnoreCase("Jane Austen"));
            System.out.println(isAuthorFavorite ? "Автор 'Jane Austen' есть!" : "Нет такого автора!");
            System.out.println("--------------------");

            OptionalInt maxFavoriteBooks = visitors.stream()
                    .mapToInt(visitor -> visitor.getFavoriteBooks().size()).max();
            maxFavoriteBooks.ifPresent(
                    max -> System.out.println("Максимальное количетво книг: " + max)
            );

            List<Visitor> subscribedVisitors = visitors.stream()
                    .filter(Visitor::isSubscribed)
                    .collect(Collectors.toList());

            double avgFavoriteBooks = visitors.stream()
                    .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                    .average().orElse(0);

            System.out.println("Среднее количетво избранных книг: " + avgFavoriteBooks);
            List<SmsMessage> smsMessages = subscribedVisitors.stream().map(visitor -> {
                        int bookCount = visitor.getFavoriteBooks().size();
                        String message;

                        if (bookCount > avgFavoriteBooks) {
                            message = "you are a bookworm";
                        } else if (bookCount < avgFavoriteBooks) {
                            message = "read more";
                        } else {
                            message = "fine";
                        }
                        return new SmsMessage(visitor.getPhone(), message);
                    })
                    .collect(Collectors.toList());

            smsMessages.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
