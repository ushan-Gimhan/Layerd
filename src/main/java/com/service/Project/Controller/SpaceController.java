package com.service.Project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SpaceController {

    @FXML
    private Button btnAddFloor;

    @FXML
    private Button btnAddLot;

    @FXML
    private Button btnAddSpace;

    @FXML
    private Button btnUpdateFloor;

    @FXML
    private Button btnUpdateLot;

    @FXML
    private Button btnUpdateSpace;

    @FXML
    private ComboBox<?> comboFloorStatus;

    @FXML
    private ComboBox<?> comboLotStatus;

    @FXML
    private ComboBox<?> comboSpaceStatus;

    @FXML
    private TableColumn<?, ?> floorIdColumn;

    @FXML
    private TableColumn<?, ?> floorIdSpaceColumn;

    @FXML
    private TableColumn<?, ?> floorStatusColumn;

    @FXML
    private TableView<?> floorTable;

    @FXML
    private TableColumn<?, ?> locationColumn;

    @FXML
    private TableColumn<?, ?> lotIdColumn;

    @FXML
    private TableColumn<?, ?> lotIdFloorColumn;

    @FXML
    private TableColumn<?, ?> lotStatusColumn;

    @FXML
    private TableView<?> parkingLotTable;

    @FXML
    private TableView<?> parkingSpaceTable;

    @FXML
    private TableColumn<?, ?> spaceIdColumn;

    @FXML
    private TableColumn<?, ?> spaceStatusColumn;

    @FXML
    private TextField txtFloorId;

    @FXML
    private TextField txtFloorIdSpace;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtLotId;

    @FXML
    private TextField txtLotIdFloor;

    @FXML
    private TextField txtSpaceId;

    @FXML
    void AddSpace(ActionEvent event) {

    }

    @FXML
    void Addfloor(ActionEvent event) {

    }

    @FXML
    void ClickedLotTable(MouseEvent event) {

    }

    @FXML
    void UpdateLot(ActionEvent event) {

    }

    @FXML
    void UpdateSpace(ActionEvent event) {

    }

    @FXML
    void addLot(ActionEvent event) {

    }

    @FXML
    void clickedLotTable(MouseEvent event) {

    }

    @FXML
    void spaceTable(MouseEvent event) {

    }

    @FXML
    void updateFloor(ActionEvent event) {

    }

}
