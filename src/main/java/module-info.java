module com.service.Projec{
    requires java.sql;
    requires lk.ijse.gdse.fx;
    requires static lombok;
    requires javafx.fxml;
    requires javafx.controls;
    requires mysql.connector.j;
    requires java.mail;
    requires net.sf.jasperreports.core;

    opens com.service.Project.View.Tm to javafx.base;
    opens com.service.Project.Controller to javafx.fxml;
    exports com.service.Project;

}
