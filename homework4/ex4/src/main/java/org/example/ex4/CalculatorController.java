package org.example.ex4;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();

        if (start) {
            display.setText("");
            start = false;
        }
        display.setText(display.getText() + value);
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();

        if (!display.getText().isEmpty()) {
            num1 = Double.parseDouble(display.getText());
            operator = value;
            display.setText("");
        }
    }

    @FXML
    private void handleEquals() {
        if (operator.isEmpty() || display.getText().isEmpty()) return;

        double num2 = Double.parseDouble(display.getText());
        double result = 0;

        try {
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        display.setText("Ошибка");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            operator = "";
            start = true;
        } catch (Exception e) {
            display.setText("Ошибка");
        }
    }

    @FXML
    private void handleClear() {
        display.setText("");
        num1 = 0;
        operator = "";
        start = true;
    }
}
