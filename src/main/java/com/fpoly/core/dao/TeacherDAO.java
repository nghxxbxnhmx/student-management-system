/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.core.dao;

import com.fpoly.core.connection.DatabaseConnection;
import com.fpoly.core.models.TeacherModel;
import java.util.List;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public List getChuyenNganh() {
        List<String> listChuyennganh = new ArrayList<>();
        String sqlgetChuyennganh = "select tenCN from chuyennganh";
        try (Connection con = DatabaseConnection.openConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlgetChuyennganh);
            while (rs.next()) {
                listChuyennganh.add(rs.getString(1));
            }
        } catch (Exception e) {

        }
        return listChuyennganh;
    }

    public String getNameTeacherByMagv(String magv) {
        String sqlgetNamebyMagv = "select tengv from giangvien where magv = ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement st = con.prepareStatement(sqlgetNamebyMagv);
            st.setString(1, magv);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                return name;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "that bai");
        }
        return null;

    }

    public void insertTeacher(TeacherModel tc) {
        String sqlInsertTeacher = "INSERT INTO GiangVien(MAGV, TENTK, MK, TENGV,NgayVaoLam, BangCap,NgaySinh,EMAIL,SDT,QueQuan,DanToc)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        String ngayvaolam = sdate.format(tc.getNgayVaoLam());
        String ngaysinh = sdate.format(tc.getNgaySinh());
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlInsertTeacher);
            ptmt.setString(1, tc.getMaGV());
            ptmt.setString(2, tc.getTenTK());
            ptmt.setString(3, tc.getMatKhau());
            ptmt.setString(4, tc.getTenGV());
            ptmt.setString(5, ngayvaolam);
            ptmt.setString(6, tc.getBangCap());
            ptmt.setString(7, ngaysinh);
            ptmt.setString(8, tc.getEmail());
            ptmt.setString(9, tc.getSdt());
            ptmt.setString(10, tc.getQueQuan());
            ptmt.setString(11, tc.getDanToc());
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "Them giang vien thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTeacher(String maGV) {
        String sqlInsertTeacher = "delete giangvien where magv like ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlInsertTeacher);
            ptmt.setString(1, maGV);
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "Xóa giảng viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateTeacher(TeacherModel tc) {
        String sqlUpdateTeacher = "update GiangVien \n"
                + "set TenGV = ?, \n"
                + "NgayVaoLam = ?, \n"
                + "BangCap =?, \n"
                + "NgaySinh = ?, \n"
                + "Email = ?,\n"
                + "SDT = ?, \n"
                + "QueQuan =?,\n"
                + "DanToc = ?\n"
                + "where MaGV = ?";
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        String ngayvaolam = sdate.format(tc.getNgayVaoLam());
        String ngaysinh = sdate.format(tc.getNgaySinh());
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlUpdateTeacher);
            ptmt.setString(1, tc.getTenGV());
            ptmt.setString(2, ngayvaolam);
            ptmt.setString(3, tc.getBangCap());
            ptmt.setString(4, ngaysinh);
            ptmt.setString(5, tc.getEmail());
            ptmt.setString(6, tc.getSdt());
            ptmt.setString(7, tc.getQueQuan());
            ptmt.setString(8, tc.getDanToc());
            ptmt.setString(9, tc.getMaGV());
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public TeacherModel getInformationTeacherByMagv(String magv) {
        String sqlGetInformation = "SELECT MaGV, TenTK,MK, TenGV, NgayVaoLam,BangCap,ngaysinh,Email,SDT,QueQuan,DanToc FROM GiangVien WHERE MaGV = ?";
        try (Connection con = DatabaseConnection.openConnection()){
            PreparedStatement stmt = con.prepareStatement(sqlGetInformation);
            stmt.setString(1, magv);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                TeacherModel tc = new TeacherModel();
                tc.setMaGV(rs.getString(1));
                tc.setTenTK(rs.getString(2));
                tc.setMatKhau(rs.getString(3));
                tc.setTenGV(rs.getString(4));
                tc.setNgayVaoLam( rs.getDate(5));
                tc.setBangCap(rs.getString(6));
                tc.setNgaySinh(rs.getDate(7));
                tc.setEmail(rs.getString(8));
                tc.setSdt(rs.getString(9));
                tc.setQueQuan(rs.getString(10));
                tc.setDanToc(rs.getString(11));
                return tc; 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
