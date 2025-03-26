package org.example;
import java.util.List;
import lombok.Data;

@Data
public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private List<Book> favoriteBooks;
}
