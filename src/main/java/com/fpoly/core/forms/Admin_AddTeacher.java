/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fpoly.core.forms;

import com.fpoly.core.dao.Interface.Interface_Combobox_data;
import com.fpoly.core.dao.Interface.Managenment_Teacher;
import com.fpoly.core.dao.TeacherDAO;
import com.fpoly.core.models.TeacherModel;
import com.fpoly.core.services.CallApiService;
import jakarta.mail.internet.MailDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Admin_AddTeacher extends javax.swing.JFrame implements Interface_Combobox_data, Managenment_Teacher {

    DefaultTableModel tbmodelSchedule = new DefaultTableModel();
    DefaultTableModel tbmodelMark = new DefaultTableModel();
    TeacherDAO tcdao = new TeacherDAO();
    CallApiService callASV = new CallApiService();
    //bang cap
    String[] degrees = {
        "Thạc sĩ", "Tiến sĩ", "Tiến sĩ Khoa học", "Phó giáo sư", "Giáo sư"
    };
    //dan toc
    String[] ethnicities = {
        "Kinh", "Tày", "Thái", "Mường", "H'Mông", "Dao", "Khơ-me", "Nùng", "HMông",
        "Tày", "Thái", "Khơ-mú", "Dao", "HMông", "Gie Trieng", "Chăm", "M'nông",
        "Xơ-đăng", "Ra-glai", "Hoa", "Ra-glai", "La Chi", "La Ha", "Pu Péo", "Chu Ru",
        "Lào", "La Ha", "La Chi", "Chứt", "Bố Y", "Bru-Vân Kiều", "Cơ Tu", "Giáy",
        "Ngái", "Hrê", "Rơ Măm", "Co", "Brau", "Ơ Đu", "Xinh Mun", "Hoa", "Sán Chay",
        "Cống", "Pà Thẻn", "Chứt", "Xinh Mun", "Mạ", "Hà Nhì", "Cống", "Chứt",
        "Rơ Măm", "Giẻ Triêng", "Sán Chay", "Tà Ôi", "Chơ Ro", "Giẻ Triêng",
        "Mạ", "Kháng", "Xinh Mun", "Bru-Vân Kiều", "Hà Nhì", "Rơ Măm", "Tà Ôi",
        "Jơ Lơng", "Bơ Y", "Chơ Ro"
    };
    //tinh thanh
    String[] provinces = {
        "Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Cần Thơ", "Hà Giang",
        "Cao Bằng", "Lai Châu", "Lào Cai", "Tuyên Quang", "Lạng Sơn", "Bắc Kạn",
        "Thái Nguyên", "Yên Bái", "Sơn La", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang",
        "Bắc Ninh", "Quảng Ninh", "Hải Dương", "Hưng Yên", "Thái Bình", "Hà Nam",
        "Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình",
        "Quảng Trị", "Thừa Thiên Huế", "Quảng Nam", "Quảng Ngãi", "Bình Định",
        "Phú Yên", "Khánh Hòa", "Ninh Thuận", "Bình Thuận", "Kon Tum", "Gia Lai",
        "Đắk Lắk", "Đắk Nông", "Lâm Đồng", "Bình Phước", "Tây Ninh", "Bình Dương",
        "Đồng Nai", "Long An", "Tiền Giang", "Bến Tre", "Vĩnh Long", "Trà Vinh",
        "Đồng Tháp", "An Giang", "Kiên Giang", "Cà Mau", "Sóc Trăng", "Bạc Liêu",
        "Bà Rịa - Vũng Tàu", "Hậu Giang", "Bắc Liêu"
    };

    //ham tao
    public Admin_AddTeacher() {
        initComponents();
        setLocationRelativeTo(null);
        fillComboboxQueQuan();
        fillComboboxBangcap();
        fillComboboxDanToc();
        fillComboboxChuyenNganh();
    }

    @Override
    public void fillComboboxBangcap() {
        cbxBangCap.removeAllItems();
        for (String province : degrees) {
            cbxBangCap.addItem(province);
        }
    }

    @Override
    public void fillComboboxQueQuan() {
        cbxQuequan.removeAllItems();
        for (String province : provinces) {
            cbxQuequan.addItem(province);
        }
    }

    @Override
    public void fillComboboxDanToc() {
        cbxDantoc.removeAllItems();
        for (String ethnicitie : ethnicities) {
            cbxDantoc.addItem(ethnicitie);
        }
    }

    @Override
    public void fillComboboxChuyenNganh() {
        List<String> listChuyenNganh = new ArrayList<>();
        listChuyenNganh = tcdao.getChuyenNganh();
        cbxChuyenNganh.removeAllItems();
        for (String chuyennganh : listChuyenNganh) {
            cbxChuyenNganh.addItem(chuyennganh);
        }
    }

    @Override
    public boolean checkNull(String[] information) {
        if (information[0].equals("")) {
            JOptionPane.showMessageDialog(null, "tên tài khoản không được trống");
            return false;
        }
        if (information[1].equals("")) {
            JOptionPane.showMessageDialog(null, "Tên giảng viên không được trống");
            return false;
        }
        if (information[2].equals("")) {
            JOptionPane.showMessageDialog(null, "Mã giảng viên không được trống");
            return false;
        }
        if (information[3].equals("")) {
            JOptionPane.showMessageDialog(null, "Ngày vào làm không được trống");
            return false;
        }
        if (information[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Bằng cấp không được trống");
            return false;
        }
        if (information[5].equals("")) {
            JOptionPane.showMessageDialog(null, "Chuyên ngành không được trống");
            return false;
        }
        if (information[6].equals("")) {
            JOptionPane.showMessageDialog(null, "mật khẩu không được trống");
            return false;
        }
        if (information[7].equals("")) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được trống");
            return false;
        }
        if (information[8].equals("")) {
            JOptionPane.showMessageDialog(null, "Email không được trống");
            return false;
        }
        if (information[9].equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được trống");
            return false;
        }
        if (information[10].equals("")) {
            JOptionPane.showMessageDialog(null, "Quê quán không được trống");
            return false;
        }
        if (information[11].equals("")) {
            JOptionPane.showMessageDialog(null, "Dân tộc không được trống");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkInformationFormaDate(String ngayVaoLam, String ngaySinh) {
        if (ngaySinh == null || ngayVaoLam == null) {
            JOptionPane.showMessageDialog(this, "hông được để trống");
            return false;
        }
        if (!callASV.checkDateFormat(ngayVaoLam)) {
            JOptionPane.showMessageDialog(this, "Ngày vào làm không đúng định dạng năm tháng ngày");
            return false;

        }
        if (!callASV.checkDateFormat(ngaySinh)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng năm tháng ngày");
            return false;

        }
        return true;
    }
    @Override
    public TeacherModel getInformationTeacher() {
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayvaolam = null, ngaysinh = null;
        String tenTK = txtTK.getText();
        String tenGV = txtTengiangvien.getText();
        String maGV = txtMagiangvien.getText();
        String ngayVaoLam = txtNgayvaolam.getText();
        String bangCap = String.valueOf(cbxBangCap.getSelectedItem());
        String chuyenNganh = String.valueOf(cbxChuyenNganh.getSelectedItem());
        String matKhau = txtMK.getText();
        String ngaySinh = txtNgaysinh.getText();
        String email = txtEmail.getText();
        String sdt = txtSodienthoai.getText();
        String queQuan = String.valueOf(cbxQuequan.getSelectedItem());
        String danToc = String.valueOf(cbxDantoc.getSelectedItem());
        String[] information = {tenTK, tenGV, maGV, ngayVaoLam, bangCap, chuyenNganh, matKhau, ngaySinh, email, sdt, queQuan, danToc};
        if (!checkNull(information)) {
            return null;
        }

        if (!checkInformationFormaDate(ngayVaoLam, ngaySinh)) {
            return null;
        }
        try {
            ngayvaolam = sdate.parse(ngayVaoLam);
            ngaysinh = sdate.parse(ngaySinh);
        } catch (ParseException ex) {
            Logger.getLogger(Admin_AddTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        TeacherModel teacher = new TeacherModel();
        teacher.setTenTK(tenTK);
        teacher.setTenGV(tenGV);
        teacher.setMaGV(maGV);
        teacher.setNgayVaoLam(ngayvaolam);
        teacher.setBangCap(bangCap);
        teacher.setChuyenNganh(chuyenNganh);
        teacher.setMatKhau(matKhau);
        teacher.setNgaySinh(ngaysinh);
        teacher.setEmail(email);
        teacher.setSdt(sdt);
        teacher.setQueQuan(queQuan);
        teacher.setDanToc(danToc);

        return teacher;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTimSinhVien = new javax.swing.JLabel();
        lblLopCuaToi = new javax.swing.JLabel();
        lblLichHoc = new javax.swing.JLabel();
        lblLichHoc1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtteacherCode = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTengiangvien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMagiangvien = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbxBangCap = new javax.swing.JComboBox<>();
        cbxChuyenNganh = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbxDantoc = new javax.swing.JComboBox<>();
        cbxQuequan = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtSodienthoai = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnUpdateTeacher = new javax.swing.JButton();
        btnRemoveTeacher = new javax.swing.JButton();
        btnAddTeacher = new javax.swing.JButton();
        txtNgayvaolam = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        lblTimSinhVien.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTimSinhVien.setText("Sinh viên");
        lblTimSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimSinhVienMouseClicked(evt);
            }
        });

        lblLopCuaToi.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblLopCuaToi.setForeground(new java.awt.Color(254, 147, 15));
        lblLopCuaToi.setText("Giảng viên");

        lblLichHoc.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblLichHoc.setText("Lịch học");
        lblLichHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLichHocMouseClicked(evt);
            }
        });

        lblLichHoc1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblLichHoc1.setText("Dịch vụ ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLichHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLopCuaToi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLichHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimSinhVien))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(lblTimSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblLopCuaToi)
                .addGap(32, 32, 32)
                .addComponent(lblLichHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblLichHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1184, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user_icon_24px.png"))); // NOI18N

        jLabel2.setText("Admin");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Quản lý giảng viên");
        jPanel8.add(jLabel4);

        jPanel9.setBackground(new java.awt.Color(254, 147, 15));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setText("Sinh viên FPT Polytechnic");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(703, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 538, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1862, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Nhập mã giảng viên");

        txtteacherCode.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnFind.setBackground(new java.awt.Color(254, 147, 15));
        btnFind.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnFind.setText("Tìm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tên tài khoản");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Tên giảng viên");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Mã giảng viên");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Mật khẩu");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Ngày sinh");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Email");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Bằng cấp");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbxBangCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxBangCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBangCapActionPerformed(evt);
            }
        });

        cbxChuyenNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Chuyên ngành");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbxDantoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDantoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDantocActionPerformed(evt);
            }
        });

        cbxQuequan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Quê quán");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Dân tộc");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Số điện thoại");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnUpdateTeacher.setBackground(new java.awt.Color(254, 147, 15));
        btnUpdateTeacher.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnUpdateTeacher.setText("Cập nhật");
        btnUpdateTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTeacherActionPerformed(evt);
            }
        });

        btnRemoveTeacher.setBackground(new java.awt.Color(254, 147, 15));
        btnRemoveTeacher.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRemoveTeacher.setText("Xóa");
        btnRemoveTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTeacherActionPerformed(evt);
            }
        });

        btnAddTeacher.setBackground(new java.awt.Color(254, 147, 15));
        btnAddTeacher.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAddTeacher.setText("Thêm");
        btnAddTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTeacherActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Ngày vào làm");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(37, 37, 37)
                                .addComponent(txtNgayvaolam, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(cbxChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel21))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMagiangvien)
                                    .addComponent(cbxBangCap, javax.swing.GroupLayout.Alignment.TRAILING, 0, 321, Short.MAX_VALUE)))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTengiangvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel20)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxDantoc, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(btnAddTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnRemoveTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnUpdateTeacher)))
                .addContainerGap(697, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayvaolam, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxBangCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(cbxQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxDantoc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTengiangvien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMagiangvien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)))
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdateTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemoveTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtteacherCode, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtteacherCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblTimSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimSinhVienMouseClicked
        this.setVisible(false);
        new Admin_AddStudent().setVisible(true);
    }//GEN-LAST:event_lblTimSinhVienMouseClicked

    private void lblLichHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLichHocMouseClicked
        this.setVisible(false);
        new Admin_Lichhoc().setVisible(true);
    }//GEN-LAST:event_lblLichHocMouseClicked

    private void cbxDantocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDantocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDantocActionPerformed

    private void btnAddTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTeacherActionPerformed
        if (getInformationTeacher() != null) {
            TeacherModel tc = getInformationTeacher();
            tcdao.insertTeacher(tc);
        }
    }//GEN-LAST:event_btnAddTeacherActionPerformed

    private void cbxBangCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBangCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBangCapActionPerformed

    private void btnRemoveTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTeacherActionPerformed
        String magv = txtMagiangvien.getText();
        String tengv = tcdao.getNameTeacherByMagv(magv);
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa giảng viên " + tengv ,"xóa giảng viên" , JOptionPane.YES_NO_OPTION );
        if(check == JOptionPane.YES_OPTION){
            tcdao.deleteTeacher(magv);
        }
    }//GEN-LAST:event_btnRemoveTeacherActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String magv = txtteacherCode.getText();
        TeacherModel tc ;
        tc = tcdao.getInformationTeacherByMagv(magv);
        txtMagiangvien.setText(tc.getMaGV());
        txtTK.setText(tc.getTenTK());
        txtTengiangvien.setText(tc.getTenGV());
        txtNgayvaolam.setText(String.valueOf(tc.getNgayVaoLam()));
        cbxBangCap.setSelectedItem(tc.getBangCap());
        cbxChuyenNganh.setSelectedItem(tc.getChuyenNganh());
        txtMK.setText(tc.getMatKhau());
        txtNgaysinh.setText(String.valueOf(tc.getNgaySinh()));
        txtSodienthoai.setText(String.valueOf(tc.getSdt()));
        txtEmail.setText(tc.getEmail());
        cbxQuequan.setSelectedItem(tc.getQueQuan());
        cbxDantoc.setSelectedItem(tc.getDanToc());
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTeacherActionPerformed
        String magv = txtMagiangvien.getText();
        String tengv = tcdao.getNameTeacherByMagv(magv);
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật giảng viên" + tengv , "cập nhật giảng viên" , JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            TeacherModel tc = getInformationTeacher();
            tcdao.updateTeacher(tc);
        }
    }//GEN-LAST:event_btnUpdateTeacherActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_AddTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTeacher;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnRemoveTeacher;
    private javax.swing.JButton btnUpdateTeacher;
    private javax.swing.JComboBox<String> cbxBangCap;
    private javax.swing.JComboBox<String> cbxChuyenNganh;
    private javax.swing.JComboBox<String> cbxDantoc;
    private javax.swing.JComboBox<String> cbxQuequan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblLichHoc;
    private javax.swing.JLabel lblLichHoc1;
    private javax.swing.JLabel lblLopCuaToi;
    private javax.swing.JLabel lblTimSinhVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMagiangvien;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtNgayvaolam;
    private javax.swing.JTextField txtSodienthoai;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTengiangvien;
    private javax.swing.JTextField txtteacherCode;
    // End of variables declaration//GEN-END:variables

}
