package com.service.Project.Controller;

import com.service.Project.Model.AllPaymentDto;
import com.service.Project.View.Tm.AllPayemntTm;
import com.service.Project.View.Tm.PaymentTm;
import com.service.Project.bo.custom.Impl.PaymentBOImpl;
import com.service.Project.bo.custom.PaymentBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class payementController implements Initializable {
    PaymentBO paymentBO = new PaymentBOImpl();

    @FXML
    private TableColumn<PaymentTm, Double> amountColumn;

    @FXML
    private ComboBox<String> comboCustId;

    @FXML
    private ComboBox<String> comboPaymentMethod;

    @FXML
    private ComboBox<String> comboReservationId;

    @FXML
    private TableColumn<PaymentTm,String> customerNameColumn;

    @FXML
    private DatePicker datePickerPaymentDate;

    @FXML
    private TableColumn<PaymentTm,String> paymentDateColumn;

    @FXML
    private TableColumn<PaymentTm, String> paymentIdColumn;

    @FXML
    private TableColumn<PaymentTm, String> paymentMethodColumn;

    @FXML
    private TableView<AllPayemntTm> paymentTable;

    @FXML
    private TableColumn<PaymentTm,String> reservationIdColumn;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtPaymentId;

    @FXML
    void Refresh(ActionEvent event) {
        txtPaymentId.setText(""); // Clears the Payment ID text field
//        comboReservationId.setValue(""); // Clears the selection in the combo box
        txtAmount.setText(""); // Clears the Amount text field
        datePickerPaymentDate.setValue(null); // Clears the date picker (sets it to no value)
        txtCustomerName.setText(""); // Clears the Customer Name text field
//        comboPaymentMethod.setValue(""); // Clears the selection in the combo box
    }

    @FXML
    void addPayment(ActionEvent event) {

    }

    @FXML
    void clikedReservation(MouseEvent event) {

    }

    @FXML
    void cmbCustCliked(MouseEvent event) {

    }

    @FXML
    void downloadTicket(ActionEvent event) {

    }

    @FXML
    void generateReport(ActionEvent event) {

    }

    @FXML
    void paymentClicked(MouseEvent event) {

    }

    @FXML
    void sendMail(ActionEvent event) {

    }

    public void loadpayTableData() throws SQLException, ClassNotFoundException {
        // Retrieve data from the database or model
        ArrayList<AllPaymentDto> paymentDtos = paymentBO.getAll();


        // Convert PaymentDto objects to PaymentTm objects
        for (AllPaymentDto paymentDto : paymentDtos) {
            AllPayemntTm paymentTm = new AllPayemntTm(
                    paymentDto.getPaymentId(),
                    paymentDto.getReservationId(),
                    paymentDto.getAmount(),
                    paymentDto.getPaymentDate(),
                    paymentDto.getPaymentMethod(),
                    paymentDto.getCustomerName()
            );
            paymentTable.getItems().add(paymentTm);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentIdColumn.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        try {
            loadpayTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
