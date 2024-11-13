package farrel.ad.taskmanager.controllers;

import farrel.ad.taskmanager.models.Project;
import farrel.ad.taskmanager.storage.AppData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class DashboardController {
    private Stage mainStage;

    private static final int MAX_COLUMNS = 3;

    @FXML
    private GridPane projectsGrid;

    @FXML
    private void initialize() {
        updateProjectsList();
    }

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
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

            projectsGrid.add(layout, col, row);

            col++;
            if (col == MAX_COLUMNS) {
                col = 0;
                row++;
            }
        }
    }
}
