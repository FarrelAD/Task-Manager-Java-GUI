package farrel.ad.taskmanager.controllers;

import farrel.ad.taskmanager.models.Task;
import farrel.ad.taskmanager.storage.AppData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class KanbanTaskController {

    private static String projectName;

    @FXML
    private VBox todoColumn;

    @FXML
    private VBox inProgressColumn;

    @FXML
    private VBox doneColumn;

    @FXML
    private void initialize() {
        updateTasksList();
    }

    public static void setData(String project) {
        projectName = project;
    }

    private void updateTasksList() {
        for (Task task : AppData.getTasksData(projectName)) {
            Button taskButton = new Button(task.getName());

            taskButton.setPrefWidth(230);
            taskButton.setStyle("""
                -fx-background-color: #16A085;
                -fx-text-fill: white;
                -fx-background-color: #D2C7FF;
                -fx-text-fill: #0D0D55;
                -fx-font-weight: bold;
                -fx-font-size: 18px;
                -fx-alignment: center-left;
                -fx-border-color: black;
                -fx-border-width: 2px;
            """);

            switch (task.getStatus()) {
                case "To Do": todoColumn.getChildren().add(taskButton);
                    break;
                case "In Progress": inProgressColumn.getChildren().add(taskButton);
                    break;
                case "Done": doneColumn.getChildren().add(taskButton);
                    break;
            }
        }
    }
}
