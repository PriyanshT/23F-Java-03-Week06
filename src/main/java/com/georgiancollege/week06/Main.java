package com.georgiancollege.week06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/create-book-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Create Book!");
        stage.getIcons().add(new Image("file:src/main/resources/com/georgiancollege/week06/icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}