package com.service.Project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class reservationController {

    @FXML
    private ComboBox<?> comboCustomerId;

    @FXML
    private DatePicker comboEndDate;

    @FXML
    private ComboBox<?> comboEndTime;

    @FXML
    private ComboBox<?> comboFloorId;

    @FXML
    private ComboBox<?> comboLotId;

    @FXML
    private ComboBox<?> comboSpaceId;

    @FXML
    private ComboBox<?> comboStartTime;

    @FXML
    private TableColumn<?, ?> custAmountColum;

    @FXML
    private TableColumn<?, ?> customerIdColumn;

    @FXML
    private TableColumn<?, ?> customerNameColumn;

    @FXML
    private DatePicker datePickerReservationDate;

    @FXML
    private TableColumn<?, ?> endDateColumn;

    @FXML
    private TableColumn<?, ?> endTimeColumn;

    @FXML
    private TableColumn<?, ?> floorIdColumn;

    @FXML
    private Label lblAmount;

    @FXML
    private TableColumn<?, ?> lotIdColumn;

    @FXML
    private TableColumn<?, ?> reservationDateColumn;

    @FXML
    private TableColumn<?, ?> reservationIdColumn;

    @FXML
    private TableView<?> reservationTable;

    @FXML
    private TableColumn<?, ?> spaceIdColumn;

    @FXML
    private TableColumn<?, ?> startTimeColumn;

    @FXML
    private Label txtAmount;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtReservationId;

    @FXML
    void GenarateReport(ActionEvent event) {

    }

    @FXML
    void addReservation(ActionEvent event) {

    }

    @FXML
    void clearFields(ActionEvent event) {

    }

    @FXML
    void deleteReservation(ActionEvent event) {

    }

    @FXML
    void makePayment(ActionEvent event) {

    }

    @FXML
    void reservationClicked(MouseEvent event) {

    }

    @FXML
    void selectCustId(MouseEvent event) {

    }

    @FXML
    void updateReservation(ActionEvent event) {

    }

}
