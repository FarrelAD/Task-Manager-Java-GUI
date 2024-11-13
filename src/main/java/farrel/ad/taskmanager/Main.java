package farrel.ad.taskmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import farrel.ad.taskmanager.controllers.LoginController;
import farrel.ad.taskmanager.storage.AppData;

public class Main extends Application {
    private static final String CORRECT_PIN = "123123";

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Task Manager");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();
        loginController.setLoginStage(primaryStage);

        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/task-icon.png"))));

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        AppData.initializeData();
        launch();
    }
}