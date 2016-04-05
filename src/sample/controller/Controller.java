package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Main;
import sample.model.Model;

import java.io.*;

public class Controller {
    @FXML
    private Button btnT;
    @FXML
    TextField display;
    private String operator = "";
    private double number1 = 0;
    Stage primaryStage = new Stage();



        @FXML
    public void dataEntering(ActionEvent actionEvent) {
     //   if (actionEvent.) display.setText("1");
            String value = ((Button)actionEvent.getSource()).getText();
            display.setText(display.getText()+value);


    }

    @FXML
    public void commandAction(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
        }
        else {
            if (operator.isEmpty()) return;
            display.setText(new Model().operate(number1, Double.parseDouble(display.getText()), operator)+"");
            operator = "";
        }

    }

    public void openFile(ActionEvent actionEvent) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open document");
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("Text files txt", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file!=null) {

            BufferedReader br = new BufferedReader(new FileReader(file));
            // FileReader br = new FileReader(file);
            String tmp;
            String allStr = "";
            while ((tmp = br.readLine())!=null) {
                allStr = allStr + tmp;
            }
            display.setText(allStr);
            br.close();
        }
    }

    public void clearDisplay(ActionEvent actionEvent) {
        display.setText("");
    }

    public void complexCounting(ActionEvent actionEvent) {
       //  primaryStage = new Stage();
        try {
          Parent root = FXMLLoader.load(getClass().getResource("../view/extend.fxml"));
            primaryStage.setTitle("Calculator");
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            // scene.getStylesheets().add(0, "my.css");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) btnT.getScene().getWindow();
        stage.close();
    }

    public void closeApp(ActionEvent actionEvent) throws Exception {
       System.exit(0);

    }

    public void saveResult(ActionEvent actionEvent) throws Exception{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save int text file");
        FileChooser.ExtensionFilter extensionFilter = new
                FileChooser.ExtensionFilter("Save in 'txt' format", "*txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(primaryStage);
        PrintWriter pr=new PrintWriter(new BufferedWriter(new FileWriter(file)));
        String s="";
        if (file != null) {
            s = display.getText();
        }
        pr.print(s);
        pr.flush();
        pr.close();
    }

    public void about(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/about.fxml"));
            primaryStage.setTitle("About");
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearCommand(ActionEvent actionEvent) {

        display.setText("");
    }

    public void backOnStep(ActionEvent actionEvent) {
        String st = display.getText(), st1;
        for (int i = 0; i< st.length(); i++) {
            st1 = st.substring(0, st.length()-1);
            display.setText(st1);
        }


    }

    public void minisCommand(ActionEvent actionEvent) {
        display.setText(display.getText()+"-");
    }

    public void keyInput(Event event) {
        String value = "";
        display.setText(value);
        /*if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
        }
        else {
            if (operator.isEmpty()) return;
            display.setText(new Model().operate(number1, Double.parseDouble(display.getText()), operator)+"");
            operator = "";
        }*/
    }

    public void keyType(Event event) {

    }
}