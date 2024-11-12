package farrel.ad.taskmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LoginController {
    private static final String CORRECT_PIN = "123123";

    @FXML
    private PasswordField pinField0, pinField1, pinField2, pinField3, pinField4, pinField5;
    @FXML
    private Label validationLabel;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        // Add focus handling and character limit for each pin field
        PasswordField[] pinFields = {pinField0, pinField1, pinField2, pinField3, pinField4, pinField5};
        for (int i = 0; i < pinFields.length; i++) {
            final int index = i;
            pinFields[i].setOnKeyTyped(event -> handlePinFieldFocus(event, pinFields, index));
        }

        // Submit button hover effects
        submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        submitButton.setOnMousePressed(e -> submitButton.setStyle("-fx-background-color: #388E3C; -fx-text-fill: white; -fx-background-radius: 5;"));
        submitButton.setOnMouseReleased(e -> submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));

        // Set button action
        submitButton.setOnAction(event -> verifyPin(pinFields));
    }

    private void handlePinFieldFocus(KeyEvent event, PasswordField[] pinFields, int index) {
        PasswordField currentField = pinFields[index];
        if (currentField.getText().length() == 1 && index < pinFields.length - 1) {
            pinFields[index + 1].requestFocus();
        }
    }

    private void verifyPin(PasswordField[] pinFields) {
        StringBuilder pinInput = new StringBuilder();
        for (PasswordField pf : pinFields) {
            pinInput.append(pf.getText());
        }

        if (pinInput.toString().equals(CORRECT_PIN)) {
            validationLabel.setText("Access granted!");
            validationLabel.setTextFill(Color.GREEN);
            // Add code here to close the stage or proceed further
        } else {
            validationLabel.setText("Incorrect PIN. Please try again.");
            validationLabel.setTextFill(Color.RED);
            for (PasswordField pf : pinFields) {
                pf.clear();
            }
            pinFields[0].requestFocus();
        }
    }
}
