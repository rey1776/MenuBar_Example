package com.example.menubar_example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleMenu extends Application {

    private MenuBar menuBar;
    private Menu fileMenu;
    private Menu textMenu;
    private MenuItem exitItem;
    private RadioMenuItem blackItem;
    private RadioMenuItem redItem;
    private RadioMenuItem greenItem;
    private RadioMenuItem blueItem;
    private CheckMenuItem visibleItem;
    private Label outputLabel;

    @Override
    public void start(Stage stage) throws IOException {

        // Constant for the scene dimensions
        final double WIDTH = 300.0, HEIGHT = 200.0;

        // Create the Label control.
        outputLabel = new Label("Hello World");
        outputLabel.setFont(new Font("Arial", 100));

        // Create the menu bar.
        MenuBar menuBar = new MenuBar();
        // Create the file menu
        buildFileMenu(stage);

        // Create the Text menu.
        buildTextMenu();

        // Add the File & Text menu to the menu bar.
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(textMenu);

        // Add the menu bar to a BorderPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(outputLabel);

        // Create a Scene and display it
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("MenuBar");
        stage.show();

    }

    private void buildFileMenu(Stage stage)
    {
        // Create the File Menu object.
        fileMenu = new Menu("_File");

        // Create the Exit MenuItem object.
        exitItem = new MenuItem("E_xit");

        // Register an event handler for the Exit item.
        exitItem.setOnAction(event ->
        {
            stage.close();
        });

        // Add the Exit item to the File menu.
        fileMenu.getItems().add(exitItem);
    }

    private void buildTextMenu()
    {
        // Create the Text Menu Object.
        textMenu = new Menu("_Text");

        // Create the menu items for the Text menu.
        blackItem = new RadioMenuItem("_Black");
        redItem = new RadioMenuItem("_Red");
        greenItem = new RadioMenuItem("_Green");
        blueItem = new RadioMenuItem("Blu_e");
        visibleItem = new CheckMenuItem("_Visible");

        // Select the Black and Visible menu items.
        blackItem.setSelected(true);
        visibleItem.setSelected(true);

        // Add the RadioMenuItems to a ToggleGroup.
        ToggleGroup textToggleGroup = new ToggleGroup();
        blackItem.setToggleGroup(textToggleGroup);
        redItem.setToggleGroup(textToggleGroup);
        greenItem.setToggleGroup(textToggleGroup);
        blueItem.setToggleGroup(textToggleGroup);

        // Register event handler for the menu Items.
        blackItem.setOnAction( event ->
        {
            outputLabel.setStyle("-fx-text-fill: black");
        });

        redItem.setOnAction( event ->
        {
            outputLabel.setStyle("-fx-text-fill: red");
        });

        greenItem.setOnAction( event ->
        {
            outputLabel.setStyle("-fx-text-fill: green");
        });

        blueItem.setOnAction( event ->
        {
            outputLabel.setStyle("-fx-text-fill: blue");
        });

        visibleItem.setOnAction(event ->
        {
            if(outputLabel.isVisible())
                outputLabel.setVisible(false);
            else
                outputLabel.setVisible(true);
        });

        // Add the Menu items to the Text menu.
        textMenu.getItems().add(blackItem);
        textMenu.getItems().add(redItem);
        textMenu.getItems().add(greenItem);
        textMenu.getItems().add(blueItem);
        textMenu.getItems().add(new SeparatorMenuItem());
        textMenu.getItems().add(visibleItem);
    }

    public static void main(String[] args) {
        launch();
    }
}