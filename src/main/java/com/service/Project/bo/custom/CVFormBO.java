package com.service.Project.bo.custom;

import com.service.Project.Model.CustomerDto;
import com.service.Project.Model.CvFormDto;
import com.service.Project.Model.VechicleDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.bo.SuperBO;
import com.service.Project.entity.CVForm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CVFormBO extends SuperBO {
    public ArrayList<CvFormDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(CvFormDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(CvFormDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    void delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    public CvFromTm search(String id) throws SQLException, ClassNotFoundException;
    public boolean AllSave(CustomerDto customerDto, VechicleDto vechicleDto) throws SQLException, ClassNotFoundException;
    public boolean AllUpdate(CustomerDto customerDto, VechicleDto vechicleDto) throws SQLException, ClassNotFoundException;
}
