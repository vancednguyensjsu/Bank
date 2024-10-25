package application;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class accountcontroller {
    @FXML
    private TextField accountTextField;
    @FXML
    private Button submitBtn;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private TextField balanceTextField;
    @FXML
    private Text balanceErrorText, dateErrorText, accountErrorText, balanceErrorText2;
    String accountName, dateOpening;
    double balance;
    int inputchecker;//used to check if each input is filled before writing to the file
    private Stage stage;
    private Scene scene;
    private Parent root;
    LocalDate today = LocalDate.now();

    public void homewindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(ActionEvent event) {
        try {
            inputchecker = 0;
            //checks if account the field is null or empty
            if(accountTextField.getText() == null || accountTextField.getText().trim().isEmpty()) {
                accountErrorText.setOpacity(1); //make accoutErrorText appear on the ui
                accountTextField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;" ); //puts a red border
            }
            else {
                inputchecker += 1;
                accountErrorText.setOpacity(0); //makes accounterrortext disappear
                accountTextField.setStyle(null); //the red border will disappear
                accountName = accountTextField.getText(); //get the string from the account text field
                System.out.println(accountName);
            }
            //checks the datepicker is empty or today's date
            if(dateTextField.getValue() == null || dateTextField.getValue() == today) {
                dateErrorText.setOpacity(1);//make error text appear
                dateTextField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;" );//show red border
            }
            else {
                inputchecker += 1;
                dateErrorText.setOpacity(0); //make error text disappear
                dateTextField.setStyle(null); //make red border disappear
                dateOpening = dateTextField.getValue().toString(); //convert datepicker's value to string and store it
                System.out.println(dateOpening);
            }
            if(balanceTextField.getText() == null || balanceTextField.getText().trim().isEmpty()) {
                balanceErrorText.setOpacity(1); //make error text appear
                balanceTextField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;" );// puts red border
            }
            else {
                inputchecker += 1;
                balanceErrorText.setOpacity(0); //make error text disappear
                balanceErrorText2.setOpacity(0);
                balanceTextField.setStyle(null); // remove border
                balance = Double.parseDouble(balanceTextField.getText());//put the data into balance as a double
                System.out.println(balance);
            }
            if(inputchecker == 3 ) {
                //this where the file writing will be
                System.out.println(dateOpening + " " + accountName + " " + balance);
            }
        }
        catch (NumberFormatException e) { //catches the error in balancetextField is a number isn't entered
            balanceTextField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;" );
            balanceErrorText2.setOpacity(1);
        }
        catch (NullPointerException e){
            dateTextField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;" );
            dateErrorText.setOpacity(1);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void defaultdate() { //set the datepicker to todays date
        dateTextField.setValue(today);
    }
}
