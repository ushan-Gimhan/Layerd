package com.service.Project.Controller;

import com.service.Project.Model.VechicleCatagoryDto;
import com.service.Project.View.Tm.VechicleCatagoryTm;
import com.service.Project.bo.BOFactory;
import com.service.Project.bo.custom.Impl.VCatagoryBOImpl;
import com.service.Project.bo.custom.VCatagoryBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CatagoryController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Label catagoryID;

    @FXML
    private Label catagoryId;

    @FXML
    private AnchorPane catagorypane;

    @FXML
    private TableColumn<VechicleCatagoryTm, String> categoryIdColumn;

    @FXML
    private TableColumn<VechicleCatagoryTm, String> categoryNameColumn;

    @FXML
    private TextField categoryNameField;

    @FXML
    private TableView<VechicleCatagoryTm> categoryTable;

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<VechicleCatagoryTm, Double> pricePerHourColumn;

    @FXML
    private TextField pricePerHourField;

    @FXML
    private Button updateButton;

    VCatagoryBO catagoryBO= (VCatagoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.vcatagory);

    @FXML
    void Onclicked(MouseEvent event) {
        VechicleCatagoryTm vechicleTM = categoryTable.getSelectionModel().getSelectedItem();
        if (vechicleTM != null) {
            catagoryID.setText(vechicleTM.getVId());
            categoryNameField.setText(vechicleTM.getVCatagoryName());
            pricePerHourField.setText(vechicleTM.getPricePerHoure().toString());

            addButton.setDisable(true);
        }
    }

    @FXML
    void handleAddCategory(ActionEvent event) throws SQLException, ClassNotFoundException {
        String categoryId = catagoryID.getText();
        String categoryName = categoryNameField.getText();
        String pricePerHour = pricePerHourField.getText();

        VechicleCatagoryDto categoryDTO = new VechicleCatagoryDto(
                categoryId,
                categoryName,
                Double.parseDouble(pricePerHour)
        );

        boolean isSaved = catagoryBO.save(categoryDTO);
        if (isSaved) {
            catId();
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Category saved...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save category...!").show();
        }
    }

    @FXML
    void handleClearFields(ActionEvent event) throws SQLException, ClassNotFoundException {
        refreshPage();
    }

    @FXML
    void handleDeleteCategory(ActionEvent event) throws SQLException, ClassNotFoundException {
        String catId = catagoryID.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = catagoryBO.delete(catId);
            if (isDeleted) {
                catId();
                refreshPage();
                loadTableData();
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void handleUpdateCategory(ActionEvent event) throws SQLException, ClassNotFoundException {
        String categoryId = catagoryID.getText();
        String categoryName = categoryNameField.getText();
        String pricePerHour = pricePerHourField.getText();
        VechicleCatagoryDto categoryDTO = new VechicleCatagoryDto(categoryId,categoryName,Double.parseDouble(pricePerHour));

        boolean isUpdate = catagoryBO.update(categoryDTO);


        if (isUpdate) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Customer update...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to update customer...!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("vId"));
        categoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("vCatagoryName"));
        pricePerHourColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerHoure"));
        try {
            catId();
            loadTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadTableData() throws ClassNotFoundException, SQLException {
        ArrayList<VechicleCatagoryDto> vehicleDTOS = catagoryBO.getAll();

        ObservableList<VechicleCatagoryTm> vehicleTMS = FXCollections.observableArrayList();


        for (VechicleCatagoryDto vechicleCatagoryDtohicleDTO : vehicleDTOS) {
            VechicleCatagoryTm V = new VechicleCatagoryTm(
                    vechicleCatagoryDtohicleDTO.getVId(),
                    vechicleCatagoryDtohicleDTO.getVCatagoryName(),
                    vechicleCatagoryDtohicleDTO.getPricePerHoure()
            );
            vehicleTMS.add(V);
        }

        categoryTable.setItems(vehicleTMS);
    }

    void catId() throws SQLException, ClassNotFoundException {
        String nextCatId = catagoryBO.generateID();
        catagoryID.setText(nextCatId);

    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        catId();
        loadTableData();

        categoryNameField.setText("");
        pricePerHourField.setText("");
        addButton.setDisable(false);
    }
}
