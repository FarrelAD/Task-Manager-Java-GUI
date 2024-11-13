package farrel.ad.taskmanager.controllers;

import farrel.ad.taskmanager.helper.SceneHelper;
import farrel.ad.taskmanager.models.Project;
import farrel.ad.taskmanager.storage.AppData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class DashboardController {
    private static Stage mainStage;

    private static final int MAX_COLUMNS = 3;

    @FXML
    private GridPane projectsGrid;

    @FXML
    private void initialize() {
        updateProjectsList();
    }

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public void updateProjectsList() {
        projectsGrid.getChildren().clear();

        int row = 0;
        int col = 0;

        for (Map.Entry<String, Project> entry : AppData.getProjectsData().entrySet()) {
            VBox layout = new VBox(20);
            Label label = new Label(entry.getKey());

            layout.setStyle("""
                -fx-background-color: #FFFFFF;
                -fx-border-color: #DDDDDD;
                -fx-border-radius: 10px;
                -fx-padding: 20px;
                -fx-alignment: CENTER;
                -fx-effect: dropshadow(gaussian, #888888, 5, 0.5, 2, 2);
                -fx-cursor: hand;
                -fx-transition: transform 0.2s ease-in-out;
            """);

            layout.getChildren().add(label);
            layout.setOnMouseClicked(e -> showTasks());

            projectsGrid.add(layout, col, row);

            col++;
            if (col == MAX_COLUMNS) {
                col = 0;
                row++;
            }
        }
    }

    public void showTasks() {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/KanbanTask.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<String, Double> sceneDimension = SceneHelper.getSceneDimension(0.8);
        Scene scene = new Scene(root, sceneDimension.get("width"), sceneDimension.get("height"));
        mainStage.setScene(scene);
    }
}
