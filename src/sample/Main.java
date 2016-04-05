package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.controller.Controller;

import java.awt.event.InputEvent;

public class Main extends Application {
    private Stage primaryStage = new Stage();
    @FXML
    TextField display;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        getPrimaryStage().setTitle("Calculator");
        Scene scene = new Scene(root);
        getPrimaryStage().setResizable(false);
       // scene.getStylesheets().add(0, "my.css");
        getPrimaryStage().setScene(scene);
        getPrimaryStage().show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCharacter().equals(" "))
                    System.out.println("Hel");
            }
        });
    }

    public void hideMethod(){
       this.primaryStage.hide();
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
