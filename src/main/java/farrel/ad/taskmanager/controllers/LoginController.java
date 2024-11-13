package farrel.ad.taskmanager.controllers;

import farrel.ad.taskmanager.helper.SceneHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class LoginController {
    private static final String CORRECT_PIN = "123123";
    private static Stage loginStage;
    private static Stage mainStage;

    @FXML
    private PasswordField pinField1, pinField2, pinField3, pinField4, pinField5, pinField6;
    @FXML
    private Label validationLabel;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        PasswordField[] pinFields = {pinField1, pinField2, pinField3, pinField4, pinField5, pinField6};
        for (int i = 0; i < pinFields.length; i++) {
            final int index = i;
            pinFields[i].setOnKeyTyped(event -> handlePinFieldFocus(event, pinFields, index));
        }

        submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        submitButton.setOnMousePressed(e -> submitButton.setStyle("-fx-background-color: #388E3C; -fx-text-fill: white; -fx-background-radius: 5;"));
        submitButton.setOnMouseReleased(e -> submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));

        submitButton.setOnAction(event -> verifyPin(pinFields));
    }

    public void setLoginStage(Stage stage) {
        loginStage = stage;
    }

    private void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void handlePinFieldFocus(KeyEvent event, PasswordField[] pinFields, int index) {
        PasswordField currentField = pinFields[index];
        if (currentField.getText().length() == 1 && index < pinFields.length - 1) {
            pinFields[index + 1].requestFocus();
        }
    }

    public void verifyPin(PasswordField[] pinFields) {
        StringBuilder pinInput = new StringBuilder();
        for (PasswordField pf : pinFields) {
            pinInput.append(pf.getText());
        }

        if (pinInput.toString().equals(CORRECT_PIN)) {
            validationLabel.setText("Access granted!");
            validationLabel.setTextFill(Color.GREEN);

            // Close the current stage window
            this.loginStage.close();

            FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
            FXMLLoader sidebarLoader = new FXMLLoader(getClass().getResource("/components/Sidebar.fxml"));
            Parent dashboardRoot;
            try {
                dashboardRoot = dashboardLoader.load();
                sidebarLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.setMainStage(new Stage());
            SidebarController.setMainStage(this.getMainStage());
            DashboardController.setMainStage(this.getMainStage());

            Map<String, Double> sceneDimension = SceneHelper.getSceneDimension(0.8);
            Scene scene = new Scene(dashboardRoot, sceneDimension.get("width"), sceneDimension.get("height"));

            mainStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/task-icon.png"))));
            mainStage.setScene(scene);
            mainStage.show();
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
