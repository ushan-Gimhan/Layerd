package com.service.Project.Controller;

import com.service.Project.Model.AllPaymentDto;
import com.service.Project.Model.CustomerDto;
import com.service.Project.Model.PayementDto;
import com.service.Project.View.Tm.AllPayemntTm;
import com.service.Project.View.Tm.PaymentTm;
import com.service.Project.bo.custom.CustomerBO;
import com.service.Project.bo.custom.Impl.CustomerBOImpl;
import com.service.Project.bo.custom.Impl.PaymentBOImpl;
import com.service.Project.bo.custom.Impl.ReservationBOImpl;
import com.service.Project.bo.custom.PaymentBO;
import com.service.Project.bo.custom.ReservationBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class payementController implements Initializable {
    PaymentBO paymentBO = new PaymentBOImpl();
    CustomerBO customerBO = new CustomerBOImpl();
    ReservationBO reservationBO = new ReservationBOImpl();

    @FXML
    private TableColumn<AllPayemntTm,String> amountColumn;

    @FXML
    private ComboBox<String> comboCustId;

    @FXML
    private ComboBox<String> comboPaymentMethod;

    @FXML
    private ComboBox<String> comboReservationId;

    @FXML
    private TableColumn<AllPayemntTm,String> customerNameColumn;

    @FXML
    private DatePicker datePickerPaymentDate;

    @FXML
    private TableColumn<AllPayemntTm,String> paymentDateColumn;

    @FXML
    private TableColumn<AllPayemntTm,String> paymentIdColumn;

    @FXML
    private TableColumn<AllPayemntTm,String> paymentMethodColumn;

    @FXML
    private TableView<AllPayemntTm> paymentTable;

    @FXML
    private TableColumn<AllPayemntTm,String> reservationIdColumn;

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
    void addPayment(ActionEvent event) throws SQLException, ClassNotFoundException {
        String payId=txtPaymentId.getText();
        String customerName = txtCustomerName.getText();
        Double amount = Double.valueOf(txtAmount.getText());
        String payMentType =comboPaymentMethod.getSelectionModel().getSelectedItem().toString();
        String custName = txtCustomerName.getText();
        LocalDate paymentDate = datePickerPaymentDate.getValue();
        String custId = comboCustId.getSelectionModel().getSelectedItem().toString();
        System.out.println(paymentDate);


        if (payMentType == null) {
            new Alert(Alert.AlertType.ERROR, "Please select Payment Method..!").show();
        }
        if(comboCustId == null){
            new Alert(Alert.AlertType.ERROR,"Please select Customer ID!").show();
        }

        ArrayList<String> customer= customerBO.getAllCustIds();

        ObservableList<String> observable = FXCollections.observableArrayList();
        observable.addAll(customer);
        comboCustId.setItems(observable);

        if (paymentDate != null) {
            Date payDate = Date.from(paymentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("Payment Date: " + payDate);
        } else {
            System.out.println("No date selected");
        }
        PayementDto payDto = new PayementDto(payId,amount,paymentDate,payMentType,custId);
        boolean isSaved= paymentBO.save(payDto);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Payment Success...!").show();
            refresh();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail Payment...!").show();
        }
    }

    @FXML
    void clikedReservation(MouseEvent event) {

    }

    @FXML
    void cmbCustCliked(MouseEvent event) throws SQLException, ClassNotFoundException {
        String selectecustId = comboCustId.getSelectionModel().getSelectedItem();
        CustomerDto CatDTO = customerBO.FindById(selectecustId);

        if (CatDTO != null) {
            txtCustomerName.setText(CatDTO.getName());
        }
    }

    @FXML
    void downloadTicket(ActionEvent event) throws IOException {
        Parent load= FXMLLoader.load(getClass().getResource("/View/Ticket.fxml"));

        Scene scene = new Scene(load);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
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
        ArrayList<AllPaymentDto> paymentDtos = paymentBO.getAllPayment();


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
            loadNextPaymentId();
            getCmbData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void refresh() throws SQLException, ClassNotFoundException {
        txtPaymentId.setText(""); // Clears the Payment ID text field
        comboReservationId.setValue(""); // Clears the selection in the combo box
        txtAmount.setText(""); // Clears the Amount text field
        datePickerPaymentDate.setValue(null); // Clears the date picker (sets it to no value)
        txtCustomerName.setText(""); // Clears the Customer Name text field
        comboPaymentMethod.setValue(""); // Clears the selection in the combo box

        loadpayTableData();
        loadNextPaymentId();
    }
    void getCmbData() throws SQLException, ClassNotFoundException {
        ArrayList<String> ids = customerBO.getAllCustIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(ids);
        comboCustId.setItems(observableList);

        ArrayList<String> idss = reservationBO.getAllIds();
        ObservableList<String> observableList2 = FXCollections.observableArrayList();
        observableList2.addAll(ids);
        comboReservationId.setItems(observableList2);
    }

    public void loadNextPaymentId() throws SQLException, ClassNotFoundException {
        String nextCustomerId = paymentBO.generateID();
        txtPaymentId.setText(nextCustomerId);
    }
}
