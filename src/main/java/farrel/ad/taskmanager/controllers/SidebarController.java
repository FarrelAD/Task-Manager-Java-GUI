package farrel.ad.taskmanager.controllers;

import farrel.ad.taskmanager.helper.SceneHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class SidebarController {

    private static Stage mainStage;

    @FXML
    private Label appTitle;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button calendarButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button accountButton;

    @FXML
    public void initialize() {
        dashboardButton.setOnMouseEntered(e -> dashboardButton.setCursor(Cursor.HAND));
        calendarButton.setOnMouseEntered(e -> calendarButton.setCursor(Cursor.HAND));
        settingsButton.setOnMouseEntered(e -> settingsButton.setCursor(Cursor.HAND));
        accountButton.setOnMouseEntered(e -> accountButton.setCursor(Cursor.HAND));

        dashboardButton.setOnAction(e -> showDashboard());
        calendarButton.setOnAction(e -> showCalendar());
        settingsButton.setOnAction(e -> showSettings());
        accountButton.setOnAction(e -> showAccount());
    }

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    private void showDashboard() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/Dashboard.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<String, Double> sceneDimension = SceneHelper.getSceneDimension(0.8);
        Scene scene = new Scene(root, sceneDimension.get("width"), sceneDimension.get("height"));

        mainStage.setScene(scene);
    }

    private void showCalendar() {

    }

    private void showSettings() {

    }

    private void showAccount() {

    }
}
