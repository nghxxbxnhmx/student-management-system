package com.fpoly.core.dao;

import com.fpoly.core.connection.DatabaseConnection;
import com.fpoly.core.models.StudentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public static final String URI = "";
    public String loginStudent(String tenTK) {
        String mkst = "";
        String sqlLogin = "select MK from sinhvien where tenTK = ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlLogin);
            ptmt.setString(1, tenTK);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                mkst = rs.getString(1);
                return mkst;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    
    public String checkEmail (String email){
        String sqlemail = "select email from sinhvien where email = ?"; 
        try (Connection con = DatabaseConnection.openConnection()){
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, email);
            
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return ""; 
    }
    
    public String selectTensv(String tenTK){
         String sqlemail = "select tensv from sinhvien where tenTK = ?"; 
        try (Connection con = DatabaseConnection.openConnection()){
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, tenTK);
            
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
            return "";
    }
    
    public boolean checkTk(String tenTK){
         String sqlemail = "select tenTK from sinhvien where tenTK = ?"; 
        try (Connection con = DatabaseConnection.openConnection()){
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, tenTK);
            
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
        }
            return false;
    }
    
    public String selectEmail(String tenTk){
        String sqlemail = "select email from sinhvien where tenTK = ?"; 
        try (Connection con = DatabaseConnection.openConnection()){
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, tenTk);
            
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    
    
}
