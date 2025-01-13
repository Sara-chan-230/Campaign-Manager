package com.example.campaignmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);
        Image icon = new Image("file:C:\\Users\\ADM\\IdeaProjects\\Campaign Manager\\src\\main\\java\\com\\example\\campaignmanager\\investment.png");
        if (icon.isError()) {
            System.out.println("Error loading icon!");
        } else {
            stage.getIcons().add(icon);
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-Programme.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Sign In");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
