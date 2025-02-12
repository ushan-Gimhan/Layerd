package com.service.Project.Controller;

import com.service.Project.DBConnection.DbConnection;
import com.service.Project.Model.CustomerDto;
import com.service.Project.Model.ResavationDto;
import com.service.Project.Model.Reservationdto;
import com.service.Project.View.Tm.ReservationTm;
import com.service.Project.bo.custom.*;
import com.service.Project.bo.custom.Impl.*;
import com.service.Project.entity.AllReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class reservationController implements Initializable {

    ParkingLotBO parkingLotBO = new ParkingLotBOImpl();
    FloorBO floorBO=new FloorBOImpl();
    ParkingSpaceBO spaceBO = new ParkingSpaceBOImpl();
    CustomerBO customerBO = new CustomerBOImpl();
    ReservationBO reservationBO = new ReservationBOImpl();


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
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass().getResourceAsStream("/Reports/U_Reservation.jrxml")
            );

            Connection connection = DbConnection.getInstance().getConnection();

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    null,
                    connection
            );
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addReservation(ActionEvent event) {
        try {
            String reservationId = txtReservationId.getText();
            String customerId = comboCustomerId.getValue();
            String lotId = comboLotId.getValue();
            String floorId = comboFloorId.getValue();
            String spaceId = comboSpaceId.getValue();
            LocalDate reservationDate = datePickerReservationDate.getValue();
            LocalTime startTime = LocalTime.parse(comboStartTime.getValue());
            LocalTime endTime = LocalTime.parse(comboEndTime.getValue());
            String customerName = txtCustomerName.getText();
            LocalDate endDate = comboEndDate.getValue();
            Double amount = Double.valueOf(txtAmount.getText());

            LocalDateTime startDateTime = LocalDateTime.of(reservationDate, startTime);
            LocalDateTime endDateTime = LocalDateTime.of(endDate, endTime);
            Duration parkingDuration = Duration.between(startDateTime, endDateTime);

            long hours = parkingDuration.toHours();
            long minutes = parkingDuration.toMinutes() % 60;

//            Double price =customerModel.getPrice(customerId);
//            Double total =((hours*price)+(minutes*price));
//            String totalString = String.format("%.2f",100);

//            lblAmount.setText(totalString);
            ResavationDto resavationDto = new ResavationDto(reservationId,startTime,endTime,customerId,spaceId,reservationDate,endDate,amount);

            boolean isSaved = reservationBO.save(resavationDto);

            if (isSaved) {
                clearInputs();
                txtReservationId.setText(reservationBO.generateID());
                loadTableData();
                new Alert(Alert.AlertType.INFORMATION, "Add Reservation SuccessFully...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to Add reservation...!").show();
            }
//
//            clearInputs();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Reservation added successfully!");
            alert.show();
            loadTableData();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to add reservation. " + e.getMessage());
            alert.show();
        }
    }

    @FXML
    void clearFields(ActionEvent event) throws SQLException, ClassNotFoundException {
        clearInputs();
    }

    @FXML
    void deleteReservation(ActionEvent event) throws SQLException, ClassNotFoundException {
        String resId = txtReservationId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = reservationBO.delete(resId);
            if (isDeleted ) {
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
                clearInputs();
                loadTableData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void makePayment(ActionEvent event) {

    }

    @FXML
    void reservationClicked(MouseEvent event) {
        ReservationTm reservation = reservationTable.getSelectionModel().getSelectedItem();

        if(reservation != null) {
            txtReservationId.setText(reservation.getReservationId());
            comboCustomerId.setValue(reservation.getCustomerId());
            comboLotId.setValue(reservation.getLotId());
            comboFloorId.setValue(reservation.getFloorId());
            comboSpaceId.setValue(reservation.getSpaceId());
//            datePickerReservationDate.setValue(reservation.getReservationDate().toString().);
//            comboEndDate.setValue(reservation.getEndDate().toString());
            comboStartTime.setValue(reservation.getStartTime().toString());
            comboEndTime.setValue(reservation.getEndTime().toString());
            txtCustomerName.setText(reservation.getCustomerName());
            txtAmount.setText(String.valueOf(reservation.getAmount()));
        }
    }

    @FXML
    void selectCustId(MouseEvent event) {
        String selectecustId = comboCustomerId.getSelectionModel().getSelectedItem();
//        CustomerDto CatDTO = customerModel.findById(selectecustId);
//
//        if (CatDTO != null) {
//            txtCustomerName.setText(CatDTO.getName());
//            String email = CatDTO.getEmail();
//        }
    }

    @FXML
    void updateReservation(ActionEvent event) throws SQLException, ClassNotFoundException {
        String reservationId = txtReservationId.getText();
        String customerId = comboCustomerId.getValue();
        String lotId = comboLotId.getValue();
        String floorId = comboFloorId.getValue();
        String spaceId = comboSpaceId.getValue();
        LocalDate reservationDate = datePickerReservationDate.getValue();
        LocalTime startTime = LocalTime.parse(comboStartTime.getValue());
        LocalTime endTime = LocalTime.parse(comboEndTime.getValue());
        String customerName = txtCustomerName.getText();
        LocalDate endDate = comboEndDate.getValue();
        Double amount = Double.valueOf(txtAmount.getText());

        ResavationDto resavationDto = new ResavationDto(reservationId,startTime,endTime,customerId,spaceId,reservationDate,endDate,amount);

        boolean isUpdated = reservationBO.update(resavationDto);

        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION, "Reservation Updated...!").show();
            loadTableData();
            clearInputs();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to update Reservation...!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        lotIdColumn.setCellValueFactory(new PropertyValueFactory<>("lotId"));
        floorIdColumn.setCellValueFactory(new PropertyValueFactory<>("floorId"));
        spaceIdColumn.setCellValueFactory(new PropertyValueFactory<>("spaceId"));
        reservationDateColumn.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        custAmountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));


        ArrayList<String> itemIds = null;
        try {
            itemIds = customerBO.getAllCustIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(itemIds);
        comboCustomerId.setItems(observableList);

        ArrayList<String> itemIds1 = null;
        try {
            itemIds1 = parkingLotBO.getAllLotId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<String> observableList1 = FXCollections.observableArrayList();
        observableList1.addAll(itemIds1);
        comboLotId.setItems(observableList1);

        ArrayList<String> itemIds2 = null;
        try {
            itemIds2 = floorBO.getAllfloors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<String> observableList2 = FXCollections.observableArrayList();
        observableList2.addAll(itemIds2);
        comboFloorId.setItems(observableList2);

        ArrayList<String> itemIds3 = null;
        try {
            itemIds3 = spaceBO.getAllFloorIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<String> observableList3 = FXCollections.observableArrayList();
        observableList3.addAll(itemIds3);
        comboSpaceId.setItems(observableList3);

        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d:00", i);
        }
        comboStartTime.setItems(FXCollections.observableArrayList(hours));
        comboEndTime.setItems(FXCollections.observableArrayList(hours));
//
//        nextReservationId();
        try {
            loadTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void loadTableData() throws SQLException, ClassNotFoundException {
        ArrayList<Reservationdto> reservations = reservationBO.getAllData();

        ObservableList<ReservationTm> reservationTmObservableList = FXCollections.observableArrayList();

        for (Reservationdto reservation : reservations) {
            ReservationTm reservationTm = new ReservationTm(
                    reservation.getReservationId(),
                    reservation.getCustomerId(),
                    reservation.getLotId(),
                    reservation.getFloorId(),
                    reservation.getSpaceId(),
                    reservation.getReservationDate(),
                    reservation.getEndDate(),
                    reservation.getStartTime(),
                    reservation.getEndTime(),
                    reservation.getCustomerName(),
                    reservation.getAmount()
            );
            reservationTmObservableList.add(reservationTm);
        }
        reservationTable.setItems(reservationTmObservableList);
    }
    void clearInputs() throws SQLException, ClassNotFoundException {
        txtReservationId.clear();
        comboCustomerId.setValue(null);
        comboLotId.setValue(null);
        comboFloorId.setValue(null);
        comboSpaceId.setValue(null);
        datePickerReservationDate.setValue(null);
        comboStartTime.setValue(null);
        comboEndTime.setValue(null);
        comboEndDate.setValue(null);
        txtAmount.setText(String.valueOf(0.00));
        txtCustomerName.clear();
        loadTableData();
        txtReservationId.setText(reservationBO.generateID());
    }
}
