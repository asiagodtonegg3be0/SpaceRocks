package com.spacerocks;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    // Main method for debugging. To be deleted once the Java project has been built
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }

    // Start method is the method that will launch the JavaFX application
    public void start(Stage gameStage) {

        // Create the screen object and generate the main window
        Screen screen = new Screen(gameStage);
        screen.createMainWindow();
    }
}