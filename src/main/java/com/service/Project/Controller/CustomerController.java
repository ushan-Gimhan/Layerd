package com.service.Project.Controller;

import com.service.Project.Model.CvFormDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.bo.custom.CVFormBO;
import com.service.Project.bo.custom.Impl.CVFormBOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    CVFormBO cvFormBO = new CVFormBOImpl();

    @FXML

    private Button AddAccesCard;

    @FXML
    private Button btbadd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label catagoryName;

//    @FXML
//    private ComboBox<?> comboVehicleCategory;

    @FXML
    private TableColumn<CvFromTm, String> custEmail;

    @FXML
    private TableColumn<CvFromTm, String> custId;

    @FXML
    private TableColumn<CvFromTm, String> custName;

    @FXML
    private TableColumn<CvFromTm, String> custNic;

    @FXML
    private TableColumn<CvFromTm, String> custNumber;

    @FXML
    private Label custid;

    @FXML
    private TableView<CvFromTm> customerTable;

    @FXML
    private HBox name;

    @FXML
    private Button openMailSend;

    @FXML
    private HBox price;

    @FXML
    private Label priceLable;

    @FXML
    private TableColumn<CvFromTm, Double> pricePerH;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtNumber;

    @FXML
    private Button txtreport;

    @FXML
    private TextField txtvNumber;

    @FXML
    private HBox vId;

    @FXML
    private Label vehicleID;

    @FXML
    private TableColumn<CvFromTm, String> vehicleNum;

    @FXML
    private TableColumn<CvFromTm, String> vehiclecata;

    @FXML
    void ClickedAccesCard(ActionEvent event) {

    }

    @FXML
    void clickedToadd(ActionEvent event) {

    }

    @FXML
    void clikedTable(MouseEvent event) {

    }

    @FXML
    void cmbCat(ActionEvent event) {

    }

    @FXML
    void deleteClicked(ActionEvent event) {

    }

    @FXML
    void genarateReport(ActionEvent event) {

    }

    @FXML
    void resetClicked(ActionEvent event) {

    }

    @FXML
    void saveClicked(ActionEvent event) {

    }

    @FXML
    void sendMail(ActionEvent event) {

    }

    @FXML
    void updateClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        custName.setCellValueFactory(new PropertyValueFactory<>("name"));
        custNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        custEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        custNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        vehicleNum.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        vehiclecata.setCellValueFactory(new PropertyValueFactory<>("vehicleCategory"));
        pricePerH.setCellValueFactory(new PropertyValueFactory<>("pricePerHourse"));

        //Add data to combobox
//        ArrayList<String> Vehilce= vehicleCatagoryModel.getAllCataoryid();
//
//        ObservableList<String> observable = FXCollections.observableArrayList();
//        observable.addAll(Vehilce);
//        comboVehicleCategory.setItems(observable);
//
//
//
//        loadNextCustomerId();
////        loadVId();
        try {
            loadTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public void loadTableData() throws SQLException, ClassNotFoundException {
        ArrayList<CvFormDto> cvFromTms = cvFormBO.getAll();


        for (CvFormDto customerDTO : cvFromTms) {
//            CvFromTm customerTM = new CvFromTm(
//                    customerDTO.getCustomerId(),
//                    customerDTO.getName(),
//                    customerDTO.getNIC(),
//                    customerDTO.getEmail(),
//                    customerDTO.getPhone(),
//                    customerDTO.getVehicleNumber(),
//                    customerDTO.getVehicleCategory(),
//                    customerDTO.getPricePerHourse()
//            );
//            customerTable.setItems(customerTM);
            customerTable.getItems().add(new CvFromTm(
                    customerDTO.getCustomerId(),
                    customerDTO.getName(),
                    customerDTO.getNIC(),
                    customerDTO.getEmail(),
                    customerDTO.getPhone(),
                    customerDTO.getVehicleNumber(),
                    customerDTO.getVehicleCategory(),
                    customerDTO.getPricePerHourse()));
        }
    }

}
