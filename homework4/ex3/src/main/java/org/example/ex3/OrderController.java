package org.example.ex3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderController {

    @FXML private CheckBox dish1, dish2, dish3, dish4, dish5;
    @FXML private Label totalPriceLabel;
    @FXML private Button orderButton;

    private final double[] dishPrices = {10.0, 15.0, 20.0, 25.0, 30.0};

    @FXML
    public void initialize() {
        dish1.setOnAction(event -> updateTotalPrice());
        dish2.setOnAction(event -> updateTotalPrice());
        dish3.setOnAction(event -> updateTotalPrice());
        dish4.setOnAction(event -> updateTotalPrice());
        dish5.setOnAction(event -> updateTotalPrice());
    }

    private void updateTotalPrice() {
        double total = 0;
        if (dish1.isSelected()) total += dishPrices[0];
        if (dish2.isSelected()) total += dishPrices[1];
        if (dish3.isSelected()) total += dishPrices[2];
        if (dish4.isSelected()) total += dishPrices[3];
        if (dish5.isSelected()) total += dishPrices[4];

        totalPriceLabel.setText("Total: $" + total);
    }

    @FXML
    private void placeOrder(ActionEvent event) throws IOException {
        List<String> selectedDishes = new ArrayList<>();
        if (dish1.isSelected()) selectedDishes.add("Dish 1 - $10");
        if (dish2.isSelected()) selectedDishes.add("Dish 2 - $15");
        if (dish3.isSelected()) selectedDishes.add("Dish 3 - $20");
        if (dish4.isSelected()) selectedDishes.add("Dish 4 - $25");
        if (dish5.isSelected()) selectedDishes.add("Dish 5 - $30");

        double total = selectedDishes.stream()
                .mapToDouble(s -> Double.parseDouble(s.split("- \\$")[1]))
                .sum();

        // Загружаем второе окно
        FXMLLoader loader = new FXMLLoader(getClass().getResource("summary.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        // Передаём данные во второе окно
        SummaryController controller = loader.getController();
        controller.setOrderDetails(selectedDishes, total);

        stage.setTitle("Order Summary");
        stage.show();
    }
}
