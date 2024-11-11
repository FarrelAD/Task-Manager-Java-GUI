module farrel.ad.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens farrel.ad.taskmanager to javafx.fxml;
    exports farrel.ad.taskmanager;
}