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
public class TeacherDAO {

    public String loginTecher(String tenTK) {
        String sqlLogin = "select MK from giangvien where tenTK = ?";
        String mkgv = "";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlLogin);
            ptmt.setString(1, tenTK);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                mkgv = rs.getString(1);
                return mkgv;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
