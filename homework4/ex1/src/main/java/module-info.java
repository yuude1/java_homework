module org.example.javafxfirsttouch {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxfirsttouch to javafx.fxml;
    exports org.example.javafxfirsttouch;
}