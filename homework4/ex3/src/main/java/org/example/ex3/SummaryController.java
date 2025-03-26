package org.example.ex3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.List;

public class SummaryController {

    @FXML private TextArea orderDetails;
    @FXML private Label totalPriceLabel;

    public void setOrderDetails(List<String> dishes, double total) {
        StringBuilder orderText = new StringBuilder();
        for (String dish : dishes) {
            orderText.append(dish).append("\n");
        }
        orderDetails.setText(orderText.toString());
        totalPriceLabel.setText("Total: $" + total);
    }
}
