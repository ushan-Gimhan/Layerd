package com.service.Project.bo.custom;

import com.service.Project.Model.CvFormDto;
import com.service.Project.Model.FloorDto;
import com.service.Project.View.Tm.CvFromTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FloorBO {
    public ArrayList<FloorDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(FloorDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(FloorDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    void delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    public CvFromTm search(String id) throws SQLException, ClassNotFoundException;
}
