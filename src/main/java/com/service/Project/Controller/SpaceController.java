package com.service.Project.Controller;


import com.service.Project.Model.FloorDto;
import com.service.Project.Model.ParkingLotDto;
import com.service.Project.Model.ParkingSpaceDto;
import com.service.Project.View.Tm.FloorTm;
import com.service.Project.View.Tm.ParkingLotTm;
import com.service.Project.View.Tm.ParkingSpaceTm;
import com.service.Project.bo.custom.FloorBO;
import com.service.Project.bo.custom.Impl.FloorBOImpl;
import com.service.Project.bo.custom.Impl.ParkingLotBOImpl;
import com.service.Project.bo.custom.Impl.ParkingSpaceBOImpl;
import com.service.Project.bo.custom.ParkingLotBO;
import com.service.Project.bo.custom.ParkingSpaceBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SpaceController implements Initializable {

    ParkingLotBO parkingLotBO = new ParkingLotBOImpl();
    FloorBO floorBO = new FloorBOImpl();
    ParkingSpaceBO parkingSpaceBO=new ParkingSpaceBOImpl();

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
    private TableColumn<ParkingLotTm,String> locationColumn;

    @FXML
    private TableColumn<ParkingLotTm,String> lotIdColumn;

    @FXML
    private TableColumn<ParkingLotTm,String> lotIdFloorColumn;

    @FXML
    private TableColumn<ParkingLotTm,String> lotStatusColumn;

    @FXML
    private TableView<ParkingLotTm> parkingLotTable;

    @FXML
    private TableView<ParkingSpaceTm> parkingSpaceTable;

    @FXML
    private TableColumn<ParkingSpaceTm, String> spaceIdColumn;

    @FXML
    private TableColumn<ParkingSpaceTm, String> spaceStatusColumn;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lotIdColumn.setCellValueFactory(new PropertyValueFactory<>("lotId"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        lotStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        floorIdColumn.setCellValueFactory(new PropertyValueFactory<>("floorId"));
        lotIdFloorColumn.setCellValueFactory(new PropertyValueFactory<>("lotId"));
        floorStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        spaceIdColumn.setCellValueFactory(new PropertyValueFactory<>("spaceId"));
        floorIdSpaceColumn.setCellValueFactory(new PropertyValueFactory<>("floorId"));
        spaceStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        try {
//            nextFloorId();
            txtFloorId.setText(floorBO.generateID());
//            nextLotId();
            parkingLotBO.generateID();
//            nextSpaceId();
            parkingSpaceBO.generateID();
            loadTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void loadTableData() throws SQLException, ClassNotFoundException {
        ArrayList<ParkingLotDto> parkingLotDtos = parkingLotBO.getAll();


        ObservableList<ParkingLotTm> parkingLotTms = FXCollections.observableArrayList();

        for (ParkingLotDto customerDTO : parkingLotDtos) {
            ParkingLotTm parkingLotTm = new ParkingLotTm(
                    customerDTO.getLotId(),
                    customerDTO.getLocation(),
                    customerDTO.getStatus()
            );
            parkingLotTms.add(parkingLotTm);
        }

        parkingLotTable.setItems(parkingLotTms);

        ArrayList<FloorDto> floorDtos = floorBO.getAll();


        ObservableList<FloorTm> floorTms = FXCollections.observableArrayList();

        for (FloorDto floorDto : floorDtos) {
            FloorTm floorTm = new FloorTm(
                    floorDto.getFloorId(),
                    floorDto.getLotId(),
                    floorDto.getStatus()
            );
            floorTms.add(floorTm);
        }

        floorTable.setItems(floorTms);

        ArrayList<ParkingSpaceDto> spaceDtos = parkingSpaceBO.getAll();


        ObservableList<ParkingSpaceTm> spaceTms = FXCollections.observableArrayList();

        for (ParkingSpaceDto spaceDto : spaceDtos) {
            ParkingSpaceTm spaceTm = new ParkingSpaceTm(
                    spaceDto.getSpaceId(),
                    spaceDto.getFloorId(),
                    spaceDto.getStatus()
            );
            spaceTms.add(spaceTm);
        }

        parkingSpaceTable.setItems(spaceTms);
    }

}
