package org.example.javafxfirsttouch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WordSwapperController {

    @FXML private TextField firstField;
    @FXML private TextField secondField;
    @FXML private Button swapButton;

    private boolean direction = true;

    @FXML
    private void swapText() {
        if (direction) {
            secondField.setText(firstField.getText());
            firstField.clear();
            swapButton.setText("←");
        } else {
            firstField.setText(secondField.getText());
            secondField.clear();
            swapButton.setText("→");
        }
        direction = !direction;
    }
}
