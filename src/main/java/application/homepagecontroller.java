package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class homepagecontroller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void account(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("account.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}