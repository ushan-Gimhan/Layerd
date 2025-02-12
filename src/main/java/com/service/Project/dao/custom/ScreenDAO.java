package com.service.Project.dao.custom;

import com.service.Project.Model.ChartDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScreenDAO {
    public ArrayList<ChartDto> getAllViolationMonth() throws SQLException, ClassNotFoundException;
}
