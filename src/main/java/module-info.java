module com.application.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.application.application to javafx.fxml;
    exports com.application.application;
}