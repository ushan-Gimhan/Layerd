package com.service.Project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardController {

    @FXML
    private Button btblogout;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btnemployee;

    @FXML
    private Button btnparking;

    @FXML
    private Button btnpayments;

    @FXML
    private Button btnreservation;

    @FXML
    private AnchorPane loginphane;

    @FXML
    private AnchorPane secondpane;

    private void navigate(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        AnchorPane newPane = loader.load();
        secondpane.getChildren().clear();
        AnchorPane.setTopAnchor(newPane, 0.0);
        AnchorPane.setRightAnchor(newPane, 0.0);
        AnchorPane.setBottomAnchor(newPane, 0.0);
        AnchorPane.setLeftAnchor(newPane, 0.0);
        secondpane.getChildren().add(newPane);
    }
    public void clickedcustomer(ActionEvent event) throws IOException {
        navigate("/View/customer.fxml");
    }
    @FXML
    void clikcedEmployee(ActionEvent event) throws IOException {
        navigate("/View/employee.fxml");

    }

    public void clickedParking(ActionEvent event) throws IOException {
        navigate("/View/Space.fxml");
    }

    public void clickedPayments(ActionEvent event) throws IOException {
        navigate("/View/payemnt.fxml");
    }

    public void clickedReservation(ActionEvent event) throws IOException {
        navigate("/View/reservation.fxml");
    }

    public void clickedLogOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginPage.fxml"));
//        AnchorPane newPane = loader.load();
//        loginphane.getChildren().clear();
//        AnchorPane.setTopAnchor(newPane, 0.0);
//        AnchorPane.setRightAnchor(newPane, 0.0);
//        AnchorPane.setBottomAnchor(newPane, 0.0);
//        AnchorPane.setLeftAnchor(newPane, 0.0);
//        loginphane.getChildren().add(newPane);
    }


    public void  clickedDashboard( ) throws IOException {
        navigate("/View/DashBoard.fxml");

    }

}
