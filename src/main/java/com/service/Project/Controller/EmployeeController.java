package com.service.Project.Controller;

import com.service.Project.DBConnection.DbConnection;
import com.service.Project.Model.EmployeeDto;
import com.service.Project.View.Tm.EmployeeTm;
import com.service.Project.bo.BOFactory;
import com.service.Project.bo.custom.AdminBO;
import com.service.Project.bo.custom.EmployeeBO;
import com.service.Project.bo.custom.Impl.AdminBOImpl;
import com.service.Project.bo.custom.Impl.EmployeeBOImpl;
import com.service.Project.dao.custom.EmployeeDAO;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeController  implements Initializable {

    public Label txtempid;
    @FXML
    private TableColumn<EmployeeTm,String> addminId;

    @FXML
    private ComboBox<String> adminIDCombo;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnreport;

    @FXML
    private Button btnsendMail;

    @FXML
    private TableColumn<EmployeeTm, String> colDesignation;

    @FXML
    private TableColumn<EmployeeTm, String> colEmail;

    @FXML
    private TableColumn<EmployeeTm, String> colEmpId;

    @FXML
    private TableColumn<EmployeeTm, String> colMobileNumber;

    @FXML
    private TableColumn<EmployeeTm, String> colName;

    @FXML
    private TableView<EmployeeTm> employeeTable;

    @FXML
    private TextField txtDesignation;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtMobileNumber;

    @FXML
    private TextField txtName;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.employee);
    AdminBO adminBO= (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.admin);


    @FXML
    void addEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        String designation = txtDesignation.getText();
        String email = txtEmail.getText();
        String empId = txtempid.getText();
        String mobileNumber = txtMobileNumber.getText();
        String name = txtName.getText();
        String adminID = adminIDCombo.getValue();

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";

        boolean isValidName = name.matches(namePattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = mobileNumber.matches(phonePattern);

        if (!isValidName) {
            txtName.setStyle(txtName.getStyle() + "-fx-text-fill: red;");
        }

        if (!isValidEmail) {
            txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidPhone) {
            txtMobileNumber.setStyle(txtMobileNumber.getStyle() + "-fx-text-fill: red;");
        }


        EmployeeDto customerDTO = new EmployeeDto(empId,name,designation,email,mobileNumber,adminID);
        if(isValidEmail && isValidName && isValidPhone){

            boolean isSaved = employeeBO.save(customerDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Employee saved...!").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save employee...!").show();
            }
            btnDelete.setDisable(true);
            btnUpdate.setDisable(true);}
    }

    @FXML
    void adminonAction(ActionEvent event) {
        String selectedCatId = adminIDCombo.getSelectionModel().getSelectedItem();

    }

    @FXML
    void clicked(MouseEvent event) {
        EmployeeTm employeeTm = employeeTable.getSelectionModel().getSelectedItem();
        if (employeeTm != null) {
            txtempid.setText(employeeTm.getEmployeeId());
            txtName.setText(employeeTm.getEmployeeName());
            txtDesignation.setText(employeeTm.getDesignation());
            txtEmail.setText(employeeTm.getEmail());
            txtMobileNumber.setText(employeeTm.getPhoneNumber());
            adminIDCombo.setValue(employeeTm.getAdminId());

            btnAdd.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            btnReset.setDisable(false);

        }

    }

    @FXML
    void deleteEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        String empId = txtempid.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted=employeeBO.delete(empId);
            if (isDeleted) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void genarateReport(ActionEvent event) {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass().getResourceAsStream("/Reports/U_Customer.jrxml")
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
    void resetFields(ActionEvent event) throws SQLException, ClassNotFoundException {
        refreshPage();
    }

    @FXML
    void sendMail(ActionEvent event) {
        EmployeeTm selectdedTm = employeeTable.getSelectionModel().getSelectedItem();

        if (selectdedTm == null) {
            new Alert(Alert.AlertType.WARNING, "Please select customer..!");
            return;
        }

        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/View/MailView.fxml"));
            Parent root = load.load();

            MailController sendMainController = load.getController();

            String mail = selectdedTm.getEmail();
            sendMainController.setCustomerEmail(mail);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Send email");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/mail_icon.png")));

            // Set window as modal
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
    void updateEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        String customerId = txtempid.getText();
        String name = txtName.getText();
        String nic = txtDesignation.getText();
        String email = txtEmail.getText();
        String phone = txtMobileNumber.getText();
        String adminID = adminIDCombo.getValue();

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";

        boolean isValidName = name.matches(namePattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = phone.matches(phonePattern);

        if (!isValidName) {
            txtName.setStyle(txtName.getStyle() + "-fx-text-fill: red;");
        }

        if (!isValidEmail) {
            txtEmail.setStyle(txtEmail.getStyle() + "-fx-text-fill: red;");
        }
        if (!isValidPhone) {
            txtMobileNumber.setStyle(txtMobileNumber.getStyle() + "-fx-text-fill: red;");
        }

        EmployeeDto employeeDto = new EmployeeDto(
                customerId,
                name,
                nic,
                email,
                phone,
                adminID

        );
        if(isValidEmail && isValidName && isValidPhone){

            boolean isUpdate = employeeBO.update(employeeDto);
            if (isUpdate) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "EmplyeeUpdated update...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update Employee...!").show();
            }
        }
    }

    void loadTableDeatails() throws SQLException, ClassNotFoundException {
//        ArrayList<EmployeeDto> employeeDTOS = employeeModel.getAllData();
        ArrayList<EmployeeDto> employeeDtos = employeeBO.getAll();

//        ObservableList<EmployeeTm> employeeTms = FXCollections.observableArrayList();

        for (EmployeeDto employeeDTO : employeeDtos) {
            EmployeeTm employeeTm = new EmployeeTm(
                    employeeDTO.getEmployeeId(),
                    employeeDTO.getEmployeeName(),
                    employeeDTO.getDesignation(),
                    employeeDTO.getEmail(),
                    employeeDTO.getPhoneNumber(),
                    employeeDTO.getAdminId()
            );
            employeeTable.getItems().add(employeeTm);
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMobileNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addminId.setCellValueFactory(new PropertyValueFactory<>("adminId"));

        try {
            loadTableDeatails();
            nextEmployeeID();
            loadIdminIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void refreshPage() throws SQLException, ClassNotFoundException {

        btnAdd.setDisable(false);
//
//        btnUpdate.setDisable(true);
//        btnDelete.setDisable(true);

        txtDesignation.setText("");
        txtEmail.setText("");
        txtEmpId.setText("");
        txtMobileNumber.setText("");
        txtName.setText("");
//        txtaddmin.setText("");
        adminIDCombo.setValue("");
        nextEmployeeID();
        loadTableDeatails();
    }
    void nextEmployeeID() throws SQLException, ClassNotFoundException {
        String nextCustomerId = employeeBO.generateID();
        txtempid.setText(nextCustomerId);
    }
    void loadIdminIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> adminIds = adminBO.getAllAdminIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(adminIds);
        adminIDCombo.setItems(observableList);
    }

}
