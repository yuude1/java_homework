module org.example.ex4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ex4 to javafx.fxml;
    exports org.example.ex4;
}