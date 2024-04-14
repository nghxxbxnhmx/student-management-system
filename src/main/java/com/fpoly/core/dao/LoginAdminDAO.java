/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.core.dao;

import com.fpoly.core.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class LoginAdminDAO {
    public String getMatkhauByTenTK(String tentk){
        String sqlloginAdmin = "select matkhau from LOGINADMIN where tentk = ?";
        try (Connection con = DatabaseConnection.openConnection()){
            PreparedStatement ptmt = con.prepareStatement(sqlloginAdmin);
            ptmt.setString(1, tentk);
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                String matkhau = rs.getString(1);
                return matkhau;
            }
        } catch (Exception e) {
        }
            
        return null; 
    }
}
