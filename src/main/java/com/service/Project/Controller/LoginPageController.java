package com.service.Project.Controller;

import com.service.Project.dao.custom.StartPageDAO;
import com.service.Project.dao.custom.impl.StartPageImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageController {


    public AnchorPane loginphane;
    @FXML
    private Button btnlogin;

    @FXML
    private Label lblpassowrd;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtpassword;

    public LoginPageController() throws SQLException, ClassNotFoundException, IOException {
    }

    @FXML
    void ClickedForgot(MouseEvent event) {

    }
    static  String name;
    String password;

    StartPageDAO startPageDAO = new StartPageImpl();
    @FXML
    void clicked(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
       name = txtname.getText();
       password = txtpassword.getText();
       txtname.setStyle(txtname.getStyle() + ";-fx-border-color: #7367F0;");
       txtpassword.setStyle(txtpassword.getStyle() + ";-fx-border-color: #7367F0;");
       check();

    }

    void check() throws IOException, SQLException, ClassNotFoundException {
        if (startPageDAO.checkValidUser(name, password)) {
            navigate("/View/DashBoard.fxml");
        } else {
            txtpassword.setStyle(txtpassword.getStyle() + "-fx-border-color:red;");
            txtname.setStyle(txtname.getStyle() + ";-fx-border-color: red;");
            new Alert(Alert.AlertType.INFORMATION, "Invalid User name Or password!!! tyr Again").show();
        }
    }

    private void navigate(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        AnchorPane newPane = loader.load();

        AnchorPane.setTopAnchor(newPane, 0.0);
        AnchorPane.setRightAnchor(newPane, 0.0);
        AnchorPane.setBottomAnchor(newPane, 0.0);
        AnchorPane.setLeftAnchor(newPane, 0.0);
        loginphane.getChildren().add(newPane);

    }
}
