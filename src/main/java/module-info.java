module com.example.hello {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires javafx.web;
    requires org.fxyz3d.importers;
    requires org.fxyz3d.core;
    requires jimStlMeshImporterJFX;


    opens com.example.hello to javafx.fxml,javafx.media,javafx.graphics,javafx.controls,javafx.web,org.fxyz3d.importers,org.fxyz3d.core;
    exports com.example.hello;
}