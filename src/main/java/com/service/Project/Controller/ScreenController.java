package com.service.Project.Controller;

import com.service.Project.Model.ChartDto;
import com.service.Project.dao.custom.impl.ScreenDAOImpl;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScreenController implements Initializable {
    public LineChart<String, Number> lineChart; // Specify type parameters for the LineChart
    ScreenDAOImpl screenDAO = new ScreenDAOImpl();

    // Method to add data to the LineChart
    private void addDataToLineChart() throws SQLException, ClassNotFoundException {

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Monthly Reservations");

        ArrayList<ChartDto> allMonth = screenDAO.getAllViolationMonth();

        // Loop through each month and add to chart, checking for null values
        for (ChartDto dateDto : allMonth) {
            String month = dateDto.getMonth();
            if (month != null && !month.isEmpty()) {  // Check for null or empty values
                int count = dateDto.getCount();
                series.getData().add(new XYChart.Data<>(month, count));
            } else {
                // Handle the case where month is null or empty, for example, logging or skipping
                System.out.println("Warning: Month is null or empty for entry: " + dateDto);
            }
        }
        lineChart.getData().add(series);  // Add series to the chart
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addDataToLineChart();  // Add data to the chart when the controller is initialized
        } catch (SQLException e) {
            e.printStackTrace();  // Handle SQL exception
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Handle ClassNotFoundException
        }
    }
}
