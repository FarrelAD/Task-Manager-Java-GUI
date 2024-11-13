module farrel.ad.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens farrel.ad.taskmanager to javafx.fxml;
    exports farrel.ad.taskmanager;
    exports farrel.ad.taskmanager.controllers;
    opens farrel.ad.taskmanager.controllers to javafx.fxml;
    exports farrel.ad.taskmanager.storage;
    opens farrel.ad.taskmanager.storage to javafx.fxml;
}