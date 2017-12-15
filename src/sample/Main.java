package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.peer.DialogPeer;
import java.io.IOException;
import java.util.Collection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene mainFrame = new Scene(root);
        primaryStage.setScene(mainFrame);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

    public void newGame(ActionEvent event) {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void ShowScores(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Score.fxml"));
        stage.setTitle("Score");

        Scene mainFrame = new Scene(root);
        stage.setScene(mainFrame);
        stage.setResizable(false);
        stage.show();
    }

    public void settings(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage.setTitle("Settings");
        Scene mainFrame = new Scene(root);
        stage.setScene(mainFrame);
        stage.show();
    }
}
