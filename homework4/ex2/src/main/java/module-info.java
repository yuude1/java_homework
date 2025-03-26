module org.example.homework4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.homework4 to javafx.fxml;
    exports org.example.homework4;
}