package com.example.hello;

public class App {
    public static void main(String[] args) {
        HelloApplication.main(args);
    }
}

//--module-path "C:\Program Files\Java\javafx-sdk-17.0.10\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.web,javafx.media
//jpackage --type msi --app-version "2.0" --input . --dest . --main-jar .\Hello.jar --main-class com.exemple.hello.HelloApplication --module-path "C:\Program Files\Java\javafx-jmods-17.0.10" --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.web --win-shortcut --win-menu --icon "1.ico" --name "Open" --jlink-options --bind-services
