package org.example.ex5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FlagController {

    @FXML private RadioButton radio1_1, radio1_2, radio1_3;
    @FXML private RadioButton radio2_1, radio2_2, radio2_3;
    @FXML private RadioButton radio3_1, radio3_2, radio3_3;
    @FXML private Label resultLabel;

    private ToggleGroup group1 = new ToggleGroup();
    private ToggleGroup group2 = new ToggleGroup();
    private ToggleGroup group3 = new ToggleGroup();

    @FXML
    public void initialize() {
        // Привязка RadioButton к группам
        radio1_1.setToggleGroup(group1);
        radio1_2.setToggleGroup(group1);
        radio1_3.setToggleGroup(group1);

        radio2_1.setToggleGroup(group2);
        radio2_2.setToggleGroup(group2);
        radio2_3.setToggleGroup(group2);

        radio3_1.setToggleGroup(group3);
        radio3_2.setToggleGroup(group3);
        radio3_3.setToggleGroup(group3);
    }

    @FXML
    private void drawFlag() {
        String color1 = getSelectedColor(group1);
        String color2 = getSelectedColor(group2);
        String color3 = getSelectedColor(group3);

        if (color1 != null && color2 != null && color3 != null) {
            resultLabel.setText(color1 + ", " + color2 + ", " + color3);
        } else {
            resultLabel.setText("Выберите все три цвета!");
        }
    }

    private String getSelectedColor(ToggleGroup group) {
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        return (selected != null) ? selected.getText() : null;
    }
}
