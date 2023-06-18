package com.example.menubar_example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Constant for the scene dimensions
        final double WIDTH = 300.0, HEIGHT = 200.0;

        // Create the menu bar.
        MenuBar menuBar = new MenuBar();

        // Create the file menu
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().add(exitItem);

        // Register an event handler for the exit item.
        exitItem.setOnAction(event ->
        {
            stage.close();
        });

        // Add the File menu to the menu bar.
        menuBar.getMenus().add(fileMenu);

        // Add the menu bar to a BorderPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        // Create a Scene and display it
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("MenuBar");
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}