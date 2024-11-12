package farrel.ad.taskmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import farrel.ad.taskmanager.models.*;
import farrel.ad.taskmanager.helper.*;

public class Main extends Application {
    private static final String CORRECT_PIN = "123123";
    private static HashMap<String, Project> projectsData = new HashMap<>();
    private static Stage mainAppStage;

    private static void dataInit() {
        Project softwareDevelopment = new Project("Software Development");
        softwareDevelopment.addTask(new Task("Code Review", "Review the latest pull requests", "To Do"));
        softwareDevelopment.addTask(new Task("Fix Bugs", "Address bugs in the user authentication system", "In Progress"));
        softwareDevelopment.addTask(new Task("Write Unit Tests", "Write unit tests for new features", "To Do"));
        softwareDevelopment.addTask(new Task("Deploy to Production", "Deploy the updated code to production", "Done"));
        softwareDevelopment.addTask(new Task("Refactor Code", "Refactor legacy code for better readability", "To Do"));
        softwareDevelopment.addTask(new Task("Attend Stand-up Meeting", "Daily team stand-up meeting for updates", "Done"));
        softwareDevelopment.addTask(new Task("Document API Endpoints", "Document all API endpoints for the backend", "To Do"));
        softwareDevelopment.addTask(new Task("Collaborate on New Features", "Brainstorm new features with the product team", "In Progress"));

        // Project 2: Personal Website
        Project personalWebsite = new Project("Personal Website");
        personalWebsite.addTask(new Task("Design Homepage", "Create a design for the homepage", "To Do"));
        personalWebsite.addTask(new Task("Build Blog Section", "Develop the blog section with dynamic content", "In Progress"));
        personalWebsite.addTask(new Task("Optimize Images", "Reduce image sizes for faster load times", "Done"));
        personalWebsite.addTask(new Task("Set Up Hosting", "Choose a hosting platform and deploy the website", "To Do"));
        personalWebsite.addTask(new Task("Add Contact Form", "Create a contact form on the website", "To Do"));
        personalWebsite.addTask(new Task("Create About Me Page", "Write content for the About Me page", "In Progress"));
        personalWebsite.addTask(new Task("SEO Optimization", "Optimize website for search engines", "To Do"));
        personalWebsite.addTask(new Task("Integrate Analytics", "Set up Google Analytics for tracking visitors", "In Progress"));

        // Project 3: Exercise Routine
        Project exerciseRoutine = new Project("Exercise Routine");
        exerciseRoutine.addTask(new Task("Morning Stretch", "Stretch for 15 minutes in the morning", "Done"));
        exerciseRoutine.addTask(new Task("Go for a Run", "Run 5 kilometers in the evening", "In Progress"));
        exerciseRoutine.addTask(new Task("Yoga Session", "Attend an online yoga class", "To Do"));
        exerciseRoutine.addTask(new Task("Strength Training", "Lift weights for strength building", "To Do"));
        exerciseRoutine.addTask(new Task("Track Nutrition", "Log daily calories and nutrition intake", "In Progress"));
        exerciseRoutine.addTask(new Task("Meditation", "Meditate for 10 minutes before bed", "To Do"));
        exerciseRoutine.addTask(new Task("Stretch After Run", "Do stretching exercises after a run", "To Do"));
        exerciseRoutine.addTask(new Task("Attend Fitness Class", "Join a fitness class at the local gym", "Done"));

        // Project 4: Learning New Technology
        Project learningNewTech = new Project("Learning New Technology");
        learningNewTech.addTask(new Task("Learn JavaScript ES6", "Study ES6 features like async/await and promises", "To Do"));
        learningNewTech.addTask(new Task("Build a Simple React App", "Create a basic to-do list app using React", "To Do"));
        learningNewTech.addTask(new Task("Watch a Tutorial on Node.js", "Watch a 2-hour tutorial on Node.js basics", "In Progress"));
        learningNewTech.addTask(new Task("Write a Blog Post on React", "Write a blog post to explain React basics", "Done"));
        learningNewTech.addTask(new Task("Read a Book on Python", "Read 'Automate the Boring Stuff with Python'", "To Do"));
        learningNewTech.addTask(new Task("Complete a Full-Stack Tutorial", "Complete a full-stack JavaScript tutorial", "In Progress"));
        learningNewTech.addTask(new Task("Contribute to an Open Source Project", "Submit a pull request to an open source repo", "To Do"));
        learningNewTech.addTask(new Task("Practice Algorithms", "Solve 5 coding problems on LeetCode", "Done"));

        projectsData.put(softwareDevelopment.getProjectName(), softwareDevelopment);
        projectsData.put(personalWebsite.getProjectName(), personalWebsite);
        projectsData.put(exerciseRoutine.getProjectName(), exerciseRoutine);
        projectsData.put(learningNewTech.getProjectName(), learningNewTech);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Task Manager");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/Login.fxml")));

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void mainApp() {
        mainAppStage = new Stage();
        // Icon app
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/img/task-icon.png")).toString());
        mainAppStage.getIcons().add(icon);

        mainAppStage.setTitle("Task Manager");
        mainAppStage.setScene(dashboardScene());
        mainAppStage.show();
    }

    private VBox getSidebar() {
        VBox sidebar = new VBox(20);
        sidebar.setPrefWidth(200);
        sidebar.setStyle("-fx-background-color: #2C3E50;");
        sidebar.setAlignment(Pos.TOP_CENTER);

        Button dashboardButton = new Button("Dashboard");
        Button calendarButton = new Button("Calendar");
        Button settingsButton = new Button("Settings");
        Button accountButton = new Button("Account");

        dashboardButton.setMaxWidth(Double.MAX_VALUE);
        calendarButton.setMaxWidth(Double.MAX_VALUE);
        settingsButton.setMaxWidth(Double.MAX_VALUE);
        accountButton.setMaxWidth(Double.MAX_VALUE);

        dashboardButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        calendarButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        settingsButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        accountButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        dashboardButton.setStyle("-fx-background-color: #34495E; -fx-text-fill: white;");
        calendarButton.setStyle("-fx-background-color: #34495E; -fx-text-fill: white;");
        settingsButton.setStyle("-fx-background-color: #34495E; -fx-text-fill: white;");
        accountButton.setStyle("-fx-background-color: #34495E; -fx-text-fill: white;");

        dashboardButton.setOnAction(e -> {
            mainAppStage.setScene(dashboardScene());
        });

        dashboardButton.setOnMouseEntered(e -> {
            dashboardButton.setCursor(Cursor.HAND);
        });

        calendarButton.setOnMouseEntered(e -> {
            calendarButton.setCursor(Cursor.HAND);
        });

        settingsButton.setOnMouseEntered(e -> {
            settingsButton.setCursor(Cursor.HAND);
        });

        accountButton.setOnMouseEntered(e -> {
            accountButton.setCursor(Cursor.HAND);
        });

        sidebar.getChildren().addAll(dashboardButton, calendarButton, settingsButton, accountButton);
        return sidebar;
    }

    private Scene dashboardScene() {
        GridPane projectGrid = new GridPane();
        projectGrid.setHgap(50);
        projectGrid.setVgap(20);
        projectGrid.setAlignment(Pos.CENTER);

        // Add project cards
        int index = 0;
        for (Map.Entry<String, Project> entry : projectsData.entrySet()) {
            VBox projectCard = new VBox();
            projectCard.setPrefWidth(200);
            projectCard.setAlignment(Pos.CENTER);
            projectCard.setStyle("""
                -fx-background-color: #3498DB;
                -fx-border-radius: 10;
                -fx-padding: 20px;
                """);

            Project project = entry.getValue();
            String projectName = entry.getKey();

            // Project Title
            Label projectTitle = new Label(projectName);
            projectTitle.setFont(Font.font("Arial", 18));
            projectTitle.setStyle("-fx-text-fill: white;");

//            Image projectImage = new Image("file:" + "");
//            ImageView projectImageView = new ImageView(projectImage);
//            projectImageView.setFitWidth(150);
//            projectImageView.setFitHeight(100);
//            projectImageView.setPreserveRatio(true);

            // Open Kanban board when the project is clicked
            projectCard.getChildren().addAll(projectTitle);
            projectCard.setOnMouseClicked(event -> showKanbanBoard(project));

            // Add project button to the grid (grid layout)
            projectGrid.add(projectCard, index % 3, index / 3);
            index++;
        }

        // Main layout (Sidebar + Main View)
        HBox layout = new HBox(50, getSidebar(), projectGrid);
        layout.setStyle("-fx-background-color: #ECF0F1;");

        Map<String, Double> sceneDimension = SceneHelper.getSceneDimension(0.8);
        return new Scene(layout, sceneDimension.get("width"), sceneDimension.get("height"));
    }

    private void showKanbanBoard(Project project) {
        // Kanban columns for To-Do, In Progress, Done
        VBox todoColumn = createKanbanColumn("To-Do", project, 0);
        VBox inProgressColumn = createKanbanColumn("In Progress", project, 1);
        VBox doneColumn = createKanbanColumn("Done", project, 2);

        HBox kanbanLayout = new HBox(20, getSidebar(), todoColumn, inProgressColumn, doneColumn);
        HBox.setMargin(getSidebar(), new Insets(0));

        Map<String, Double> sceneDimension = SceneHelper.getSceneDimension(0.8);

        Scene kanbanScene = new Scene(kanbanLayout, sceneDimension.get("width"), sceneDimension.get("height"));
        mainAppStage.setScene(kanbanScene);
    }

    private VBox createKanbanColumn(String columnName, Project project, int taskIndex) {
        VBox column = new VBox(10);
        column.setStyle("-fx-background-color: #BDC3C7; -fx-padding: 10px; -fx-border-radius: 5;");
        column.setPrefWidth(250);

        // Column header
        Label columnHeader = new Label(columnName);
        columnHeader.setFont(Font.font("Arial", 18));
        column.getChildren().add(columnHeader);

        // Add tasks to the column
        for (Task task : project.getTasks()) {
            Button taskButton = new Button(task.getName());
            taskButton.setStyle("-fx-background-color: #16A085; -fx-text-fill: white;");
            taskButton.setPrefWidth(230);
            taskButton.setFont(Font.font("Arial", 14));
            column.getChildren().add(taskButton);

            // Add action to task (for edit, delete, etc.)
            taskButton.setOnAction(event -> {
                // Handle task click (e.g., show options to edit or delete)
                System.out.println("Task clicked: " + task);
            });
        }

        return column;
    }

    public static void main(String[] args) {
        dataInit();
        launch();
    }
}