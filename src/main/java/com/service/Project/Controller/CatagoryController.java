package com.service.Project.Controller;

import com.service.Project.Model.VechicleCatagoryDto;
import com.service.Project.View.Tm.VechicleCatagoryTm;
import com.service.Project.bo.custom.Impl.VCatagoryBOImpl;
import com.service.Project.bo.custom.VCatagoryBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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

    VCatagoryBO catagoryBO= new VCatagoryBOImpl();

    @FXML
    void Onclicked(MouseEvent event) {

    }

    @FXML
    void handleAddCategory(ActionEvent event) {

    }

    @FXML
    void handleClearFields(ActionEvent event) {

    }

    @FXML
    void handleDeleteCategory(ActionEvent event) {

    }

    @FXML
    void handleUpdateCategory(ActionEvent event) {

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
}
