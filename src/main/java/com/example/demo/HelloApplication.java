package com.example.demo;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Circle path = new Circle();
        //add viewer as well, similar to augen
        path.radiusProperty().bind(viewer.widthProperty.fivide(2));
        path.setRotate(-90);
        //layout center with new path, same for y
        path.layoutXProperty().bind(viewer.heightProperty.divide(2));
        Line Hand = new Line(0,50,0,0);

        //Maybe add key value pairing here with inerpolator
        PathTransition p  =new PathTransition(Duration.seconds(60), path, Hand, );
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        p.setCycleCount(Timeline.INDEFINITE);
        p.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //Here goes the time from our system
        p.jumpTo(Duration.seconds(25));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}