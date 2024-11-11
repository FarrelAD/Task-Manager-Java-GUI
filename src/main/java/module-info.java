module farrel.ad.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens farrel.ad.taskmanager to javafx.fxml;
    exports farrel.ad.taskmanager;
}