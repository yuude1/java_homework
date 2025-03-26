package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Exercises {
    public static void getAllMusic() {
        String query = "SELECT * FROM music";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getMTMusic() {
        String query = "SELECT * FROM music WHERE LOWER(name) NOT LIKE '%m%' AND LOWER(name) NOT LIKE '%t%'";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getNewMusic() {
        String query = "INSERT INTO music (id, name) VALUES (21, 'Otonoke')";

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement()) {

            int rowsInserted = stmt.executeUpdate(query); // используем executeUpdate
            System.out.println("Добавлено строк: " + rowsInserted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertVisitorsAndBooks() {
        Gson gson = new Gson();
        String filePath = "books.json";

        try (FileReader reader = new FileReader(filePath);
             Connection conn = DatabaseManager.connect()) {

            Type listType = new TypeToken<List<Visitor>>() {}.getType();
            List<Visitor> visitors = gson.fromJson(reader, listType);

            String insertVisitorSQL = "INSERT INTO visitors (name, surname, phone, subscribed) " +
                    "VALUES (?, ?, ?, ?) ON CONFLICT (phone) DO NOTHING";

            String insertBookSQL = "INSERT INTO books (name, author, publishingYear, isbn, publisher) " +
                    "VALUES (?, ?, ?, ?, ?) ON CONFLICT (isbn) DO NOTHING";

            try (
                    PreparedStatement visitorStmt = conn.prepareStatement(insertVisitorSQL);
                    PreparedStatement bookStmt = conn.prepareStatement(insertBookSQL)
            ) {
                for (Visitor v : visitors) {
                    // Добавляем посетителя
                    visitorStmt.setString(1, v.getName());
                    visitorStmt.setString(2, v.getSurname());
                    visitorStmt.setString(3, v.getPhone());
                    visitorStmt.setBoolean(4, v.isSubscribed());
                    visitorStmt.addBatch();

                    // Добавляем книги
                    for (Book b : v.getFavoriteBooks()) {
                        bookStmt.setString(1, b.getName());
                        bookStmt.setString(2, b.getAuthor());
                        bookStmt.setInt(3, b.getPublishingYear());
                        bookStmt.setString(4, b.getIsbn());
                        bookStmt.setString(5, b.getPublisher());
                        bookStmt.addBatch();
                    }
                }

                visitorStmt.executeBatch();
                bookStmt.executeBatch();
                System.out.println("Посетители и книги добавлены.");

            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllBooks() {
        String query = "SELECT * FROM books";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("publishingYear");
                String isbn = rs.getString("isbn");
                String publisher = rs.getString("publisher");

                System.out.println(name + " | " + author + " | " + year + " | " + isbn + " | " + publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSortBooks() {
        String query = "SELECT * FROM books ORDER BY year";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("publishingYear");
                String isbn = rs.getString("isbn");
                String publisher = rs.getString("publisher");

                System.out.println(name + " | " + author + " | " + year + " | " + isbn + " | " + publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getFilteredBooks() {
        String query = "SELECT * FROM books WHERE year < 2000";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("publishingYear");
                String isbn = rs.getString("isbn");
                String publisher = rs.getString("publisher");

                System.out.println(name + " | " + author + " | " + year + " | " + isbn + " | " + publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
