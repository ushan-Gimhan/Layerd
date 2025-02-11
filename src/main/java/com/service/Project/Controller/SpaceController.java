package com.service.Project.Controller;

import com.service.Project.View.Tm.FloorTm;
import com.service.Project.View.Tm.ParkingLotTm;
import com.service.Project.View.Tm.ParkingSpaceTm;
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
    private ComboBox<String> comboFloorStatus;

    @FXML
    private ComboBox<String> comboLotStatus;

    @FXML
    private ComboBox<String> comboSpaceStatus;

    @FXML
    private TableColumn<FloorTm,String> floorIdColumn;

    @FXML
    private TableColumn<FloorTm,String> floorIdSpaceColumn;

    @FXML
    private TableColumn<FloorTm,String> floorStatusColumn;

    @FXML
    private TableView<FloorTm> floorTable;

    @FXML
    private TableColumn<?, ?> locationColumn;

    @FXML
    private TableColumn<?, ?> lotIdColumn;

    @FXML
    private TableColumn<?, ?> lotIdFloorColumn;

    @FXML
    private TableColumn<?, ?> lotStatusColumn;

    @FXML
    private TableView<ParkingLotTm> parkingLotTable;

    @FXML
    private TableView<ParkingSpaceTm> parkingSpaceTable;

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
