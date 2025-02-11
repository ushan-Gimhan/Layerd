package com.service.Project.Controller;

import com.service.Project.View.Tm.ReservationTm;
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
    private ComboBox<String> comboCustomerId;

    @FXML
    private DatePicker comboEndDate;

    @FXML
    private ComboBox<String> comboEndTime;

    @FXML
    private ComboBox<String> comboFloorId;

    @FXML
    private ComboBox<String> comboLotId;

    @FXML
    private ComboBox<String> comboSpaceId;

    @FXML
    private ComboBox<String> comboStartTime;

    @FXML
    private TableColumn<ReservationTm, String> custAmountColum;

    @FXML
    private TableColumn<ReservationTm, String> customerIdColumn;

    @FXML
    private TableColumn<ReservationTm, String> customerNameColumn;

    @FXML
    private DatePicker datePickerReservationDate;

    @FXML
    private TableColumn<ReservationTm, String> endDateColumn;

    @FXML
    private TableColumn<ReservationTm, String> endTimeColumn;

    @FXML
    private TableColumn<ReservationTm, String> floorIdColumn;

    @FXML
    private Label lblAmount;

    @FXML
    private TableColumn<ReservationTm, String> lotIdColumn;

    @FXML
    private TableColumn<ReservationTm, String> reservationDateColumn;

    @FXML
    private TableColumn<ReservationTm, String> reservationIdColumn;

    @FXML
    private TableView<ReservationTm> reservationTable;

    @FXML
    private TableColumn<ReservationTm, String> spaceIdColumn;

    @FXML
    private TableColumn<ReservationTm, String> startTimeColumn;

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
