package com.service.Project.Controller;

import com.service.Project.Model.AccessCardDto;
import com.service.Project.View.Tm.AccessCardTm;
import com.service.Project.bo.BOFactory;
import com.service.Project.bo.custom.AccesCardBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class AccesCardContoller implements Initializable {
    AccesCardBO accesCardBO = (AccesCardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.AccesCard);
    @FXML
    private TableColumn<?, ?> accessCardIdColumn;

    @FXML
    private TableView<?> accessCardTable;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbComboBox;

    @FXML
    private TableColumn<?, ?> customerIdColumn;

    @FXML
    private TableColumn<?, ?> expiryDateColumn;

    @FXML
    private TableColumn<?, ?> issuedDateColumn;

    @FXML
    private TextField txtAccessCardId;

    @FXML
    private TextField txtExpiryDate;

    @FXML
    private TextField txtIssuedDate;

    @FXML
    void ClickedOnTable(MouseEvent event) {

    }

    @FXML
    void addAccessCard(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cardId = txtAccessCardId.getText();
        String issuedDate = txtIssuedDate.getText();
        String expiryDate = txtExpiryDate.getText();
        String custId = cmbComboBox.getValue();

        String datePattern = ""; ////// add

        boolean isValidIssueDatae= issuedDate.matches(datePattern);
        boolean isValidExpiryDate = expiryDate.matches(datePattern);

        if(!isValidIssueDatae){
            txtIssuedDate.setStyle("-fx-border-color: #Red");
        }else{
            txtIssuedDate.setStyle("-fx-border-color: #Blue");
        }
        if(!isValidExpiryDate){
            txtExpiryDate.setStyle("-fx-border-color: #Red");
        }else{
            txtExpiryDate.setStyle("-fx-border-color: #Blue");
        }

        Date issue = Date.valueOf(issuedDate);
        Date expiry = Date.valueOf(expiryDate);


        if(isValidIssueDatae && isValidExpiryDate){
            AccessCardDto accessCardDto = new AccessCardDto(
                    cardId,
                    issue,
                    expiry,
                    custId
            );
            boolean isSaved = accesCardBO.save(accessCardDto);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION, "Access Card Saved", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Access Card Error", ButtonType.OK).show();
            }
        }

    }

    @FXML
    void cmbComboBoxOnAction(ActionEvent event) {

    }

    @FXML
    void deleteAccessCard(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cardId = String.valueOf(accessCardTable.getSelectionModel().getSelectedItem());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.get() == ButtonType.YES) {
            boolean isDeleted = accesCardBO.delete(cardId);
            if (isDeleted) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Transport deleted").show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Fail to delete transport").show();
            }
        }
    }

    @FXML
    void refreshTable(ActionEvent event) {
        txtAccessCardId.setText("");
        txtIssuedDate.setText("");
        txtExpiryDate.setText("");
//        txtCustomerId.setText("");


        btnAdd.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    void updateAccessCard(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cardId = txtAccessCardId.getText();
        String issuedDate = txtIssuedDate.getText();
        String expiryDate = txtExpiryDate.getText();
        String custId = cmbComboBox.getValue();

        String datePattern = "";

        boolean isValidIssueDatae= issuedDate.matches(datePattern);
        boolean isValidExpiryDate = expiryDate.matches(datePattern);

        if(!isValidIssueDatae){
            txtIssuedDate.setStyle("-fx-border-color: #Red");
        }else{
            txtIssuedDate.setStyle("-fx-border-color: #Blue");
        }
        if(!isValidExpiryDate){
            txtExpiryDate.setStyle("-fx-border-color: #Red");
        }else{
            txtExpiryDate.setStyle("-fx-border-color: #Blue");
        }

        Date issue = Date.valueOf(issuedDate);
        Date expiry = Date.valueOf(expiryDate);


        if(isValidIssueDatae && isValidExpiryDate){
            AccessCardDto accessCardDto = new AccessCardDto(
                    cardId,
                    issue,
                    expiry,
                    custId
            );
            boolean isUpdated = accesCardBO.update(accessCardDto);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION, "Access Card Saved", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Access Card Error", ButtonType.OK).show();
            }
        }
    }
    void refreshPage(){
//        loadTableData();
//        loadNextCardID();
//        loadCustID();

        txtAccessCardId.setText("");
        txtIssuedDate.setText("");
        txtExpiryDate.setText("");
//        txtCustomerId.setText("");


        btnAdd.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accessCardIdColumn.setCellValueFactory(new PropertyValueFactory<>("cardId"));
        issuedDateColumn.setCellValueFactory(new PropertyValueFactory<>("issuedDate"));
        expiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        try{
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "can't load page").show();
        }
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
//        ArrayList<AccessCardDto> accessCardDtos = accesCardBO.getAll();
////        ObservableList<AccessCardTm> accessCardTms = FXCollections.observableArrayList();
//
//        for (AccessCardDto accessCardDto : accessCardDtos) {
//            AccessCardTm accessCardTm = new AccessCardTm(
//                    accessCardDto.getCardId(),
//                    accessCardDto.getIssuetDate(),
//                    accessCardDto.getExpiryDate(),
//                    accessCardDto.getCustId()
//            );
//            accessCardTable.getItems().add(accessCardTm);
//        }
    }
}
