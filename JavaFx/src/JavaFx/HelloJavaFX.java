package JavaFx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HelloJavaFX extends Application {
    private static String currentUser;
    private static final Map<String, String> users = new HashMap<>();
    private List<Double> expenses = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Expense Tracker App");

        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label titleLabel = new Label("Expense Tracker Menu");
        titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        grid.add(titleLabel, 0, 0);

        Button addExpenseButton = new Button("Add Expense");
        addExpenseButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        addExpenseButton.setOnAction(e -> addExpense());
        grid.add(addExpenseButton, 0, 1);

        Button viewExpensesButton = new Button("View Expenses");
        viewExpensesButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        viewExpensesButton.setOnAction(e -> viewExpenses());
        grid.add(viewExpensesButton, 0, 2);

        Button calculateTotalExpenseButton = new Button("Calculate Total Expense");
        calculateTotalExpenseButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");
        calculateTotalExpenseButton.setOnAction(e -> calculateTotalExpense());
        grid.add(calculateTotalExpenseButton, 0, 3);

        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-background-color: #e53935; -fx-text-fill: white;");
        exitButton.setOnAction(e -> exitProgram());
        grid.add(exitButton, 0, 4);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void addExpense() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Expense");
        dialog.setHeaderText("Enter the expense amount:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(amountStr -> {
            try {
                double amount = Double.parseDouble(amountStr);
                expenses.add(amount);
                showAlert("Expense added successfully.", "Expense Tracker");
            } catch (NumberFormatException e) {
                showAlert("Invalid input. Please enter a valid number.", "Expense Tracker");
            }
        });
    }

    private void viewExpenses() {
        StringBuilder resultStringBuilder = new StringBuilder("Expense List\n");
        for (int i = 0; i < expenses.size(); i++) {
            resultStringBuilder.append(i + 1).append(". $").append(expenses.get(i)).append("\n");
        }
        showAlert(resultStringBuilder.toString(), "Expense Tracker");
    }

    private void calculateTotalExpense() {
        double total = expenses.stream().mapToDouble(Double::doubleValue).sum();
        showAlert("Total Expense: $" + total, "Expense Tracker");
    }

    private void exitProgram() {
        showAlert("Exiting Expense Tracker. Goodbye!", "Expense Tracker");
        System.exit(0);
    }

    private void showAlert(String content, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
