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
import javafx.scene.control.*;
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
    void AddSpace(ActionEvent event) throws SQLException, ClassNotFoundException {
        String spaceId = txtSpaceId.getText();
        String spaceStatus = comboSpaceStatus.getValue();
        String floorId = txtFloorId.getText();

        ParkingSpaceDto parkingSpaceDto = new ParkingSpaceDto(spaceId,floorId,spaceStatus);

        boolean isSvaed =parkingSpaceBO.save(parkingSpaceDto);

        if (isSvaed) {
//            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Space Added Successfully...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Add Space...!").show();
        }
    }

    @FXML
    void Addfloor(ActionEvent event) throws SQLException, ClassNotFoundException {
        String floorId = txtFloorId.getText();
        String lotid = txtLotId.getText();
        String status = comboFloorStatus.getValue();

        FloorDto floorDto = new FloorDto(floorId, lotid, status);

        boolean isSvaed = floorBO.save(floorDto);

        if (isSvaed) {
//            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Space Added Successfully...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Add Space...!").show();
        }
    }

    @FXML
    void ClickedLotTable(MouseEvent event) {
        FloorTm floorTm = floorTable.getSelectionModel().getSelectedItem();

        if(floorTm != null) {
            txtFloorId.setText(floorTm.getFloorId());
            txtLotIdFloor.setText(floorTm.getLotId());
            comboFloorStatus.setValue(floorTm.getStatus());
        }
    }

    @FXML
    void UpdateLot(ActionEvent event) throws SQLException, ClassNotFoundException {
        String LotId = txtLotId.getText();
        String lotStatus = comboLotStatus.getValue();
        String location = txtLocation.getText();

        ParkingLotDto parkingLotDto = new ParkingLotDto(LotId,location,lotStatus);

        boolean isSvaed = parkingLotBO.update(parkingLotDto);

        if (isSvaed) {
//            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Parking Lot Update Successfully...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Update...!").show();
        }
    }

    @FXML
    void UpdateSpace(ActionEvent event) throws SQLException, ClassNotFoundException {
        String spaceId = txtSpaceId.getText();
        String spaceStatus = comboSpaceStatus.getValue();
        String floorId = txtFloorId.getText();

        ParkingSpaceDto parkingSpaceDto = new ParkingSpaceDto(spaceId,floorId,spaceStatus);

        boolean isSvaed =parkingSpaceBO.update(parkingSpaceDto);

        if (isSvaed) {
//            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Space Added Successfully...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Add Space...!").show();
        }
    }

    @FXML
    void addLot(ActionEvent event) throws SQLException, ClassNotFoundException {
        String LotId = txtLotId.getText();
        String lotStatus = comboLotStatus.getValue();
        String location = txtLocation.getText();

        ParkingLotDto parkingLotDto = new ParkingLotDto(LotId,location,lotStatus);

        boolean isSvaed = parkingLotBO.save(parkingLotDto);

        if (isSvaed) {
//            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Parking Lot Added Successfully...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Add Lot...!").show();
        }
    }

    @FXML
    void clickedLotTable(MouseEvent event) {
        ParkingLotTm lotTm =  parkingLotTable.getSelectionModel().getSelectedItem();

        if(lotTm != null){
            txtLotId.setText(lotTm.getLotId());
            txtLocation.setText(lotTm.getLocation());
            comboLotStatus.setValue(lotTm.getStatus());
        }
    }

    @FXML
    void spaceTable(MouseEvent event) {
        ParkingSpaceTm spaceTm =  parkingSpaceTable.getSelectionModel().getSelectedItem();
        if(spaceTm != null){
            txtSpaceId.setText(spaceTm.getSpaceId());
            txtFloorIdSpace.setText(spaceTm.getFloorId());
            comboSpaceStatus.setValue(spaceTm.getStatus());
        }
    }

    @FXML
    void updateFloor(ActionEvent event) throws SQLException, ClassNotFoundException {
        String floorId = txtFloorId.getText();
        String lotid = txtLotId.getText();
        String status = comboFloorStatus.getValue();

        FloorDto floorDto = new FloorDto(floorId, lotid, status);

        boolean isSvaed = floorBO.update(floorDto);

        if (isSvaed) {
//            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Space Added Successfully...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Add Space...!").show();
        }
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
            txtLotId.setText(parkingLotBO.generateID());
//            nextSpaceId();
            txtSpaceId.setText(parkingSpaceBO.generateID());
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
