package farrel.ad.taskmanager;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private static final String CORRECT_PIN = "123123";

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Task Manager");

        // Main label
        Label greetingLabel = new Label("Welcome back!");
        greetingLabel.setFont(Font.font("Arial", 26));
        greetingLabel.setTextFill(Color.web("#333"));

        Label askPinLabel = new Label("Enter 6-Digit PIN");
        askPinLabel.setFont(Font.font("Arial", 24));
        askPinLabel.setTextFill(Color.web("#333"));

        // Create PIN entry fields
        HBox pinBox = new HBox(10);
        pinBox.setAlignment(Pos.CENTER);
        PasswordField[] pinFields = new PasswordField[6];
        for (int i = 0; i < 6; i++) {
            pinFields[i] = new PasswordField();
            pinFields[i].setPrefWidth(30);
            pinFields[i].setFont(Font.font("Arial", 20));
            pinBox.getChildren().add(pinFields[i]);
        }

        // Validation message
        Label validationLabel = new Label("");
        validationLabel.setTextFill(Color.RED);

        // Submit button
        Button submitButton = new Button("Verify");
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        submitButton.setStyle(
                "-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 5;"
        );

        submitButton.setOnMouseEntered(event -> submitButton.setStyle(
                "-fx-background-color: #45a049; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 5;"
        ));

        submitButton.setOnMouseExited(event -> submitButton.setStyle(
                "-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 5;"
        ));

        submitButton.setOnMousePressed(event -> submitButton.setStyle(
                "-fx-background-color: #388E3C; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 5;"
        ));

        submitButton.setOnMouseReleased(event -> submitButton.setStyle(
                "-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 5;"
        ));

        // Submit action
        submitButton.setOnAction(event -> {
            StringBuilder pinInput = new StringBuilder();
            for (PasswordField pf : pinFields) {
                pinInput.append(pf.getText());
            }
            if (pinInput.toString().equals(CORRECT_PIN)) {
                validationLabel.setText("Access granted!");
                validationLabel.setTextFill(Color.GREEN);
                // Open the main app features here
            } else {
                validationLabel.setText("Incorrect PIN. Please try again.");
                for (PasswordField pf : pinFields) {
                    pf.clear();
                }
            }
        });

        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/img/task-icon.png")).toString());
        primaryStage.getIcons().add(icon);


        // Main layout
        VBox layout = new VBox(20, greetingLabel, askPinLabel, pinBox, validationLabel, submitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f0f4f8; -fx-padding: 40px;");
        layout.setSpacing(15);

        Scene scene = new Scene(new StackPane(layout), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}