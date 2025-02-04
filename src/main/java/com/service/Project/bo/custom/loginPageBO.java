package com.service.Project.bo.custom;

import com.service.Project.bo.SuperBO;

public interface loginPageBO  extends SuperBO {
    public boolean checkUserName(String userName,String password);


}
