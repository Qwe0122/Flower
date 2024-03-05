module com.example.hello {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires javafx.web;


    opens com.example.hello to javafx.fxml,javafx.media,javafx.graphics,javafx.controls,javafx.web;
    exports com.example.hello;
}