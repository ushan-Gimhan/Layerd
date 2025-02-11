package com.service.Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent load=FXMLLoader.load(getClass().getResource("/View/LoginPage.fxmla"));

        Image image=new Image("/images/download.jpg");

        Scene scene=new Scene(load);
        stage.setScene(scene);
        stage.setTitle("PARKING LOT");
        stage.getIcons().add(image);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
