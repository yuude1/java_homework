package org.example.ex5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FlagController {

    @FXML private ToggleGroup topColorGroup;
    @FXML private ToggleGroup middleColorGroup;
    @FXML private ToggleGroup bottomColorGroup;

    @FXML private Label resultLabel;

    @FXML
    private void handleDraw() {
        // Получаем выбранные значения
        String topColor = ((RadioButton) topColorGroup.getSelectedToggle()).getText();
        String middleColor = ((RadioButton) middleColorGroup.getSelectedToggle()).getText();
        String bottomColor = ((RadioButton) bottomColorGroup.getSelectedToggle()).getText();

        // Вывод результата
        resultLabel.setText("Выбранные цвета: " + topColor + ", " + middleColor + ", " + bottomColor);
    }
}
