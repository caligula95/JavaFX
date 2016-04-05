package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Main;
import sample.model.InToPostnew;
import sample.model.Model;
import sample.model.ParsePostnew;

import java.io.*;

/**
 * Created by Denis on 31.03.2016.
 */
public class ExtendController {
    @FXML
    private Button btnB;
    @FXML
    private TextField display;
    private String operator = "";
    Controller controller = new Controller();
    Main main = new Main();

    public void dataEntering(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        display.setText(display.getText()+value);
    }

    public void commandAction(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        display.setText(display.getText()+" "+ value + " ");
    }

    public void backOnStep(ActionEvent actionEvent) {
        String st = display.getText(), st1;
        for (int i = 0; i< st.length(); i++) {
            st1 = st.substring(0, st.length()-1);
            display.setText(st1);
        }
    }

    public void clearCommand(ActionEvent actionEvent) {
        display.setText("");
    }

    public void openFile(ActionEvent actionEvent) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open document");
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("Text files txt", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(controller.primaryStage);
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

    public void complexCounting(ActionEvent actionEvent) {
        Stage primaryStage =  new Stage();
        Main main = new Main();
        try {
            main.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) btnB.getScene().getWindow();
        stage.close();
    }
    public void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void saveResult(ActionEvent actionEvent) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save int text file");
        FileChooser.ExtensionFilter extensionFilter = new
                FileChooser.ExtensionFilter("Save in 'txt' format", "*txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(controller.primaryStage);
        PrintWriter pr=new PrintWriter(new BufferedWriter(new FileWriter(file)));
        String s="";
        if (file != null) {
             s = display.getText();
        }
        pr.print(s);
        pr.flush();
        pr.close();
    }

    public void clearDisplay(ActionEvent actionEvent) {
        display.setText("");
    }
    public void about(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/about.fxml"));
            controller.primaryStage.setTitle("About");
            Scene scene = new Scene(root);
            controller.primaryStage.setResizable(false);
            controller.primaryStage.setScene(scene);
            controller.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void resultAction(ActionEvent actionEvent) {
        InToPostnew intoPost;
        ParsePostnew parsePost;
        // TODO Auto-generated method stub
        String input = display.getText();
        String output;
        double out;
        intoPost = new InToPostnew(input);
        output = intoPost.doTrans();
        parsePost = new ParsePostnew(output);
        out = parsePost.doParse();
        display.setText(display.getText()+" = " + out);
    }

    public void bracketsEnter(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        if (value.equals("("))
        display.setText(display.getText() + value + " ");
        else if (value.equals(")"))
            display.setText(display.getText() + " " + value + " ");
    }

    public void minisCommand(ActionEvent actionEvent) {
        display.setText(display.getText()+"-");
    }

    public void oneDeleteX(ActionEvent actionEvent) {
        double number1 = Double.parseDouble(display.getText());
        if (number1!=0) {
            display.setText(new Model().oneDeleteX(number1)+"");
        }
    }

    public void factorialCount(ActionEvent actionEvent) {
            display.setText(display.getText()+" !" );
    }
}
