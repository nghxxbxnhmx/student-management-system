package com.fpoly.core.dao;

import com.fpoly.core.connection.DatabaseConnection;
import com.fpoly.core.models.StudentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

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

    public String getNameStudentBytenTK(String tenTK) {
        String sqlemail = "select tensv from sinhvien where tenTK = ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, tenTK);

            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean existsTenTk(String tenTK) {
        String sqlemail = "select tenTK from sinhvien where tenTK = ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, tenTK);

            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public String getEmailByTenTk(String tenTk) {
        String sqlemail = "select email from sinhvien where tenTK = ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlemail);
            ptmt.setString(1, tenTk);

            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public void updateMK(String tenTK, String newPass) {
        String sqlUpdate = "update sinhvien set mk = ? where tenTK = ?";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlUpdate);
            ptmt.setString(1, newPass);
            ptmt.setString(2, tenTK);
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }

    //form admin 
    public StudentModel getStudetnByMasv(String masv) {
        String sqlGetInformationStudent = """
                           select TenTK,TenSV,MaSV,Khoa,HocKy,TenCN, NgaySinh,email,MK,NgayNhapHoc,SDT,QueQuan,DanToc  
                           from SinhVien join ChuyenNganh on sinhvien.MaCN = ChuyenNganh.MaCN where masv = ?""";
        try (Connection con = DatabaseConnection.openConnection()) {
            PreparedStatement ptmt = con.prepareStatement(sqlGetInformationStudent);
            ptmt.setString(1, masv);
            ResultSet rs = ptmt.executeQuery();
            if(rs.next()){
                SimpleDateFormat sdat  = new SimpleDateFormat("yyyy-MM-dd");
              Date ngaysinh = sdat.parse(rs.getString(7));
              Date ngaynhaphoc = sdat.parse(rs.getString(10));
                StudentModel st = new StudentModel();
                st.setTenTK(rs.getString(1));
                st.setTenSV(rs.getString(2));
                st.setMaSV(rs.getString(3));
                st.setKhoa(rs.getString(4));
                st.setHocKy(rs.getString(5));
                st.setNganhHoc(rs.getString(6));
                st.setNgaySinh(ngaysinh);
                st.setEmail(rs.getString(8));
                st.setMK(rs.getString(9));
                st.setNgayNhapHoc(ngaynhaphoc);
                st.setSoDienThoai(rs.getString(11));
                st.setQueQuan(rs.getString(12));
                st.setDanToc(rs.getString(13));
                return st; 
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tìm kiếm thất bại");
        }
        return null;
    }
    
    public List getKhoaStudent(){
        List<String> listKhoa = new ArrayList();
        String sqlGetKhoa = "select khoa from sinhvien";
        try (Connection con = DatabaseConnection.openConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlGetKhoa);
            while (rs.next()) {
                listKhoa.add(rs.getString(1));
            }
            return listKhoa;
        } catch (Exception e) {
        }
        return null; 
    }
     public List getHockyStudent(){
        List<String> listHocky = new ArrayList();
        String sqlGetKhoa = "select hocky from sinhvien";
        try (Connection con = DatabaseConnection.openConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlGetKhoa);
            while (rs.next()) {
                listHocky.add(rs.getString(1));
            }
            return listHocky;
        } catch (Exception e) {
        }
        return null; 
    }
      public List getChuyennganh(){
        List<String> listChuyennganh = new ArrayList();
        String sqlGetKhoa = "select tenCN from chuyennganh";
        try (Connection con = DatabaseConnection.openConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlGetKhoa);
            while (rs.next()) {
                listChuyennganh.add(rs.getString(1));
            }
            return listChuyennganh;
        } catch (Exception e) {
        }
        return null; 
    }
}
