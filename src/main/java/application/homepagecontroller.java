package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.time.LocalDate;

public class homepagecontroller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void account(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("account.fxml")); //create a load for fxml file
        root = loader.load(); //make the loader load
        accountcontroller accountcon = loader.getController();// load in instance of account.fxml
        accountcon.defaultdate(); //use the instance to load in the date before the user get there
        //root = FXMLLoader.load(getClass().getResource("account.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}