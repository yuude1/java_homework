module org.example.javafxfirsttouch {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ex1 to javafx.fxml;
    exports org.example.ex1;
}