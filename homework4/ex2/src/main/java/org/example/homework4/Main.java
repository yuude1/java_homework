package org.example.homework4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    private Label label;

    @FXML
    private TextField textField;

    @FXML
    private Button button;

    @FXML
    private CheckBox checkBoxLabel;

    @FXML
    private CheckBox checkBoxTextField;

    @FXML
    private CheckBox checkBoxButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(this);
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("JavaFX CheckBox Example");
        primaryStage.show();
    }

    // Обработчик для чекбокса рядом с Label
    @FXML
    private void handleCheckBoxLabel() {
        label.setVisible(checkBoxLabel.isSelected());
    }

    // Обработчик для чекбокса рядом с TextField
    @FXML
    private void handleCheckBoxTextField() {
        textField.setVisible(checkBoxTextField.isSelected());
    }

    // Обработчик для чекбокса рядом с Button
    @FXML
    private void handleCheckBoxButton() {
        button.setVisible(checkBoxButton.isSelected());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
