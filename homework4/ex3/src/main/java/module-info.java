module org.example.ex3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ex3 to javafx.fxml;
    exports org.example.ex3;
}