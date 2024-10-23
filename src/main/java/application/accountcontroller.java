package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class accountcontroller {
    @FXML
    private TextField accountText;
    @FXML
    private Button submitBtn;
    String accountName;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void homewindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void submit (ActionEvent event) throws IOException {
        accountName = accountText.getText();
        System.out.println(accountName);
    }
}