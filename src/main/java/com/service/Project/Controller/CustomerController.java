package com.service.Project.Controller;

import com.service.Project.DBConnection.DbConnection;
import com.service.Project.Model.CustomerDto;
import com.service.Project.Model.CvFormDto;
import com.service.Project.Model.VechicleCatagoryDto;
import com.service.Project.Model.VechicleDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.bo.custom.CVFormBO;
import com.service.Project.bo.custom.CustomerBO;
import com.service.Project.bo.custom.Impl.CVFormBOImpl;
import com.service.Project.bo.custom.Impl.CustomerBOImpl;
import com.service.Project.bo.custom.Impl.VCatagoryBOImpl;
import com.service.Project.bo.custom.Impl.VehicleBOImpl;
import com.service.Project.bo.custom.VCatagoryBO;
import com.service.Project.bo.custom.VehicleBO;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    CVFormBO cvFormBO = new CVFormBOImpl();
    CustomerBO customerBO = new CustomerBOImpl();
    VehicleBO vehicleBO = new VehicleBOImpl();
    VCatagoryBO vCatagoryBO = new VCatagoryBOImpl();

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

    @FXML
    private ComboBox<String> comboVehicleCategory;

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
    void clickedToadd(ActionEvent event) throws IOException {

        Parent load= FXMLLoader.load(getClass().getResource("/View/VechicleCatagory.fxml"));

        Scene scene = new Scene(load);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clikedTable(MouseEvent event) {
        CvFromTm cvFromTm =  customerTable.getSelectionModel().getSelectedItem();
        if (cvFromTm != null) {
            custid.setText(cvFromTm.getCustomerId());
            txtName.setText(cvFromTm.getName());
            txtNic.setText(cvFromTm.getNIC());
            txtEmail.setText(cvFromTm.getEmail());
            txtNumber.setText(cvFromTm.getPhone());
            txtvNumber.setText(cvFromTm.getVehicleNumber());
            comboVehicleCategory.setValue(cvFromTm.getVehicleCategory());

            btnSave.setDisable(true);

            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
        }
    }

    @FXML
    void cmbCat(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectedCatId = comboVehicleCategory.getSelectionModel().getSelectedItem();
        VechicleCatagoryDto CatDTO = vCatagoryBO.FindById(selectedCatId);

        if (CatDTO != null) {
            catagoryName.setText(CatDTO.getVCatagoryName());
            priceLable.setText(String.valueOf(CatDTO.getPricePerHoure()));
        }
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
    void saveClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = custid.getText();
        String name = txtName.getText();
        String nic = txtNic.getText();
        String email = txtEmail.getText();
        String phone = txtNumber.getText();
        String vNmber = txtvNumber.getText();

        String vechicleId = vehicleID.getText();
        String selectedcatId = comboVehicleCategory.getValue();
        String selectCatName = catagoryName.getText();
//        Double pricePerHourse = Double.parseDouble(pricePerH.getText());

//        if (selectedcatId == null) {
//            new Alert(Alert.AlertType.ERROR, "Please select Vehicle Catagory..!").show();
//            return false;
//        }

        txtName.setStyle(txtName.getStyle() + "-fx-text-fill: blue;");
        txtNic.setStyle(txtNic.getStyle() + "-fx-text-fill: blue;");
        txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: blue;");
        txtNumber.setStyle(txtNumber.getStyle() + "-fx-text-fill: blue;");
        txtvNumber.setStyle(txtvNumber.getStyle() + "-fx-text-fill: blue;");

        String namePattern = "^[A-Za-z ]+$";
        String nicPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
        String vechicleNum ="^((?!0000)([a-zA-Z]{1,3}|([0-9]{1,3}))-[0-9])|(([a-zA-Z]{1,3}|([0-9]{1,3}))-[0-9])(?!000)";

        boolean isValidName = name.matches(namePattern);
        boolean isValidNic = nic.matches(nicPattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = phone.matches(phonePattern);
        boolean isVechiclenum = vechicleNum.matches(vechicleNum);

        if (!isValidName) {
            txtName.setStyle(txtName.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidNic) {
            txtNic.setStyle(txtNic.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidEmail) {
            txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidPhone) {
            txtNumber.setStyle(txtNumber.getStyle() + "-fx-text-fill: red;");
        }


        if (isValidName && isValidNic && isValidEmail && isValidPhone) {
            CustomerDto customerDto = new CustomerDto(id, name, nic, email, phone);
            VechicleDto vechicleDto = new VechicleDto(vechicleId,vNmber,id,selectedcatId);

            boolean isSved=cvFormBO.AllSave(customerDto,vechicleDto);

            if(isSved){
                new Alert(Alert.AlertType.INFORMATION, "Customer and Vehicle Added Successfully!").show();
                    refreshPage();
            }
            else {
                new Alert(Alert.AlertType.ERROR, "Failed to Add Vehicle. Transaction Rolled Back!").show();
            }
        }

    }

    @FXML
    void sendMail(ActionEvent event) {
        CvFromTm selectdedTm = customerTable.getSelectionModel().getSelectedItem();

        if (selectdedTm == null) {
            new Alert(Alert.AlertType.WARNING, "Please select customer..!");
            return;
        }

        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/View/MailView.fxml"));
            Parent root = load.load();

            MailController sendMainController = load.getController(); //

            String mail = selectdedTm.getEmail();
            sendMainController.setCustomerEmail(mail);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Send email");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/mail_icon.png")));

            stage.initModality(Modality.APPLICATION_MODAL);

            Window underWindow = btnUpdate.getScene().getWindow();
            stage.initOwner(underWindow);

            stage.showAndWait();

        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Fail to load ui..!");
            e.printStackTrace();
        }
    }

    @FXML
    void updateClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = custid.getText();
        String name = txtName.getText();
        String nic = txtNic.getText();
        String email = txtEmail.getText();
        String phone = txtNumber.getText();
        String vNmber = txtvNumber.getText();

        String vechicleId = vehicleID.getText();
        String selectedcatId = comboVehicleCategory.getValue();
        String selectCatName = catagoryName.getText();

        txtName.setStyle(txtName.getStyle() + "-fx-text-fill: blue;");
        txtNic.setStyle(txtNic.getStyle() + "-fx-text-fill: blue;");
        txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: blue;");
        txtNumber.setStyle(txtNumber.getStyle() + "-fx-text-fill: blue;");
        txtvNumber.setStyle(txtvNumber.getStyle() + "-fx-text-fill: blue;");

        String namePattern = "^[A-Za-z ]+$";
        String nicPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
        String vechicleNum ="^((?!0000)([a-zA-Z]{1,3}|([0-9]{1,3}))-[0-9])|(([a-zA-Z]{1,3}|([0-9]{1,3}))-[0-9])(?!000)";

        boolean isValidName = name.matches(namePattern);
        boolean isValidNic = nic.matches(nicPattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = phone.matches(phonePattern);
        boolean isVechiclenum = vechicleNum.matches(vechicleNum);

        if (!isValidName) {
            txtName.setStyle(txtName.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidNic) {
            txtNic.setStyle(txtNic.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidEmail) {
            txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidPhone) {
            txtNumber.setStyle(txtNumber.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidName) {
            txtName.setStyle(txtName.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidNic) {
            txtNic.setStyle(txtNic.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidEmail) {
            txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidPhone) {
            txtNumber.setStyle(txtNumber.getStyle() + "-fx-text-fill: red;");
        }

        if (isValidName && isValidNic && isValidEmail && isValidPhone){
            CustomerDto customerDto = new CustomerDto(id,name,nic,email,phone);
            VechicleDto vechicleDto = new VechicleDto(vechicleId,vNmber,id,selectedcatId);

            boolean isUpdate = cvFormBO.AllUpdate(customerDto,vechicleDto);

            if (isUpdate) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Updated...!").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update customer...!").show();
            }
        }
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



//        Add data to combobox
        ArrayList<String> Vehilce= null;
        try {
            Vehilce = vCatagoryBO.getAllCatagoryIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObservableList<String> observable = FXCollections.observableArrayList();
        observable.addAll(Vehilce);
        comboVehicleCategory.setItems(observable);


        try {
            loadNextCustomerId();
            loadVId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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

    public void refreshPage() throws SQLException, ClassNotFoundException {
        loadNextCustomerId();
        loadVId();
        loadTableData();

        txtName.setStyle(txtName.getStyle() + "-fx-text-fill: blue;");
        txtNic.setStyle(txtNic.getStyle() + "-fx-text-fill: blue;");
        txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: blue;");
        txtNumber.setStyle(txtNumber.getStyle() + "-fx-text-fill: blue;");
        txtvNumber.setStyle(txtvNumber.getStyle() + "-fx-text-fill: blue;");

        txtName.setText("");
        txtNic.setText("");
        txtEmail.setText("");
        txtNumber.setText("");
        txtvNumber.setText("");
        comboVehicleCategory.setValue("");
        catagoryName.setText("");
        pricePerH.setText("");

        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    public void  loadNextCustomerId() throws SQLException, ClassNotFoundException {
        String nextCustomerId = customerBO.generateID();
        custid.setText(nextCustomerId);
    }

    public void loadVId() throws SQLException, ClassNotFoundException {
        String nextVehicleId = vehicleBO.generateID();
        vehicleID.setText(nextVehicleId);

    }

}
