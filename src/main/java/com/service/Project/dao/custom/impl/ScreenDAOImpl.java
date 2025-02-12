package com.service.Project.dao.custom.impl;

import com.service.Project.Model.ChartDto;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.ScreenDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScreenDAOImpl implements ScreenDAO {
    public ArrayList<ChartDto> getAllViolationMonth() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= CrudUtil.execute("SELECT DATE_FORMAT(reservation_date, '%Y-%m') AS reservation_month, COUNT(res_id) AS id_count FROM reservation GROUP BY reservation_month ORDER BY reservation_month");

        ArrayList<ChartDto> data=new ArrayList<>();
        while(resultSet.next()){
            ChartDto chartDto=new ChartDto(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            );
            data.add(chartDto);
        }
        return data;

    }
}
