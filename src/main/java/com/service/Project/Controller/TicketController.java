package com.service.Project.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TicketController {

    @FXML
    private ComboBox<?> comboReservationId;

    @FXML
    private DatePicker datePickerIssueDate;

    @FXML
    private TextField txtTicketId;

    @FXML
    private TextField txtVehicleId;

}
