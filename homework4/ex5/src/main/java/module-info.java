module org.example.ex5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ex5 to javafx.fxml;
    exports org.example.ex5;
}