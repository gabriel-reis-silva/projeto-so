/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ac3.sistemas.operacionais;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author gabsg
 */
public class Connection {
    
     BasicDataSource datasource;

    public Connection() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setUrl("jdbc:sqlserver://monsysclin.database.windows.net:1433;"
                + "database=Monsysclin;user=administrador@monsysclin;"
                + "password=#Gfgrupo6;encrypt=true;"
                + "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.datasource.setUsername("administrador");
        this.datasource.setPassword("#Gfgrupo6");
    }
    
    
    public BasicDataSource getDataSource(){
        return datasource;
    }
}
