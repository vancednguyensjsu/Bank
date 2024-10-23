module dev2.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens application to javafx.fxml;
    exports application;
}