package com.fpoly.core;

import com.fpoly.core.dao.StudentDAO;
import com.fpoly.core.forms.ForgetPasswordForm;
import com.fpoly.core.forms.LoginAdminForm;
import com.fpoly.core.forms.LoginTeacherForm;
import com.fpoly.core.models.StudentModel;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class LoginStudentForm extends javax.swing.JFrame {

    final static LoginStudentForm loginStudentForm = new LoginStudentForm();
    final static LoginTeacherForm loginTeacherFrom = new LoginTeacherForm();
    final static LoginAdminForm loginAdminForm = new LoginAdminForm();
    final static ForgetPasswordForm forgetPasswordForm = new ForgetPasswordForm();
    final StudentDAO stdao = new StudentDAO();

    public LoginStudentForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public boolean checkNullUsername(String username) {
        return !(username.equals(""));
    }

    public boolean checkNullPassword(String password) {
        return !(password.equals(""));
    }

    public void login(String tenTK, String passWordForm) {
        if (!checkNullUsername(tenTK)) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản không được trống");
            return;
        }
        if (!checkNullPassword(passWordForm)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được trống");
            return;
        }
        //lay password tu database
        String passWordStudent;
        passWordStudent = stdao.loginStudent(tenTK);
        //tim matkhau tu ten tenTK, neu mk=="" thi tenTK khong ton tai
        if (passWordStudent.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản không tồn tại");
            return;
        }
        if (passWordForm.equals(passWordStudent)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
            this.setVisible(false);
            //goi form sinh viên 

        } else {
            JOptionPane.showMessageDialog(this, "Mật khẩu không chính xác");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnLoginStudent = new javax.swing.JPanel();
        btnStudent = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkRemember = new javax.swing.JCheckBox();
        lblForget = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download-removebg-preview.png"))); // NOI18N
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        btnStudent.setBackground(new java.awt.Color(254, 147, 15));
        btnStudent.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnStudent.setText("Sinh viên");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        btnTeacher.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnTeacher.setText("Giảng viên");
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });

        btnAdmin.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELLCOME TO FPT POLYTECHNIC");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel3.setText("Username");

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel4.setText("Password");

        chkRemember.setText("Remember me");

        lblForget.setForeground(new java.awt.Color(255, 98, 98));
        lblForget.setText("Forger password");
        lblForget.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblForgetAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblForget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetMouseClicked(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(254, 147, 15));
        btnLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnLoginKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnLoginStudentLayout = new javax.swing.GroupLayout(pnLoginStudent);
        pnLoginStudent.setLayout(pnLoginStudentLayout);
        pnLoginStudentLayout.setHorizontalGroup(
            pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoginStudentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(pnLoginStudentLayout.createSequentialGroup()
                        .addGroup(pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnLoginStudentLayout.createSequentialGroup()
                                        .addComponent(chkRemember, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(258, 258, 258)
                                        .addComponent(lblForget)))))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(pnLoginStudentLayout.createSequentialGroup()
                        .addComponent(txtPassword)
                        .addGap(38, 38, 38))))
        );
        pnLoginStudentLayout.setVerticalGroup(
            pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginStudentLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStudent)
                    .addComponent(btnAdmin)
                    .addComponent(btnTeacher))
                .addGap(64, 64, 64)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnLoginStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRemember)
                    .addComponent(lblForget))
                .addGap(87, 87, 87)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );

        jPanel1.add(pnLoginStudent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        this.setVisible(false);
        new LoginTeacherForm().setVisible(true);

    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        this.setVisible(false);
        new LoginAdminForm().setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void lblForgetAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblForgetAncestorAdded
    }//GEN-LAST:event_lblForgetAncestorAdded

    private void lblForgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetMouseClicked
        this.setVisible(false);
        new ForgetPasswordForm().setVisible(true);
    }//GEN-LAST:event_lblForgetMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String tenTK = txtUsername.getText();
        char[] arrpass = txtPassword.getPassword();
        String passWordForm = new String(arrpass);
        login(tenTK, passWordForm);

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginStudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JCheckBox chkRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblForget;
    private javax.swing.JPanel pnLoginStudent;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
