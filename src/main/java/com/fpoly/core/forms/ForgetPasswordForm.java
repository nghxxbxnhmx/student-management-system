package com.fpoly.core.forms;

import com.fpoly.core.LoginStudentForm;
import com.fpoly.core.dao.StudentDAO;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ForgetPasswordForm extends javax.swing.JFrame {

    LoginStudentForm loginStudentForm = new LoginStudentForm();
    StudentDAO stdao = new StudentDAO();
    int codeForgetPassword;

    public ForgetPasswordForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void checkSendMail() {
        String email = "";
        String emailForm = txtEmail.getText();
        String tenTK = txtUsername.getText();
        String tensv = stdao.selectTensv(tenTK);
        if(!stdao.checkTk(tenTK)){
            JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại","Lấy mã thất bại", JOptionPane.HEIGHT);
            return;
        }
        email = stdao.selectEmail(tenTK);
        if (emailForm.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống", "Lấy mã thất bại", JOptionPane.HEIGHT);
        }
        if (!emailForm.equals(email)) {
            JOptionPane.showMessageDialog(this, "Email Không đúng\nVui lòng nhập đúng email", "Lấy mã thất bại", JOptionPane.HEIGHT);
            return;
        }
        final String username = "cangntps36910@fpt.edu.vn";
        final String password = "rknh pozv ljoc qzdd";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cangntps36910@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(txtEmail.getText())
            );
            message.setSubject("Yêu cầu cấp mã đổi mật khẩu");
            message.setText("Dear Mail " + tensv + "\nMã đổi mật khẩu mới của bạn là: "
                    + codeForgetPassword);

            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Lấy code thành công");

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkNull() {
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống 'Username'");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống 'Email'");
            return false;
        }
        if (txtCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống 'Code'");
            return false;
        }
        if (txtNewPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống 'New password'");
            return false;
        }
        if (txtConfrimPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống 'Confirm password'");
            return false;
        }
        return true;
    }

    public boolean checkConFirmNewPassword() {
        return txtNewPassword.getText().equals(txtConfrimPassword.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnNewPassword = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        chkRemember = new javax.swing.JCheckBox();
        lblForget = new javax.swing.JLabel();
        btnResetPassword = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        txtConfrimPassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnGetCode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download-removebg-preview.png"))); // NOI18N
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELLCOME TO FPT POLYTECHNIC");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel3.setText("Username");

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel4.setText("Email");

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        chkRemember.setText("Remember me");

        lblForget.setForeground(new java.awt.Color(255, 98, 98));
        lblForget.setText("Return login");
        lblForget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetMouseClicked(evt);
            }
        });

        btnResetPassword.setBackground(new java.awt.Color(254, 147, 15));
        btnResetPassword.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnResetPassword.setText("Reset password");
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel5.setText("Code");

        txtCode.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel6.setText("New password");

        txtNewPassword.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        txtConfrimPassword.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel8.setText("Confirm password");

        btnGetCode.setBackground(new java.awt.Color(254, 147, 15));
        btnGetCode.setText("Get code");
        btnGetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnNewPasswordLayout = new javax.swing.GroupLayout(pnNewPassword);
        pnNewPassword.setLayout(pnNewPasswordLayout);
        pnNewPasswordLayout.setHorizontalGroup(
            pnNewPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNewPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNewPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnNewPasswordLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnNewPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnNewPasswordLayout.createSequentialGroup()
                                .addComponent(chkRemember, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblForget))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfrimPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNewPasswordLayout.createSequentialGroup()
                                .addComponent(txtCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addComponent(txtEmail))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnNewPasswordLayout.setVerticalGroup(
            pnNewPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNewPasswordLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnNewPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfrimPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pnNewPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRemember)
                    .addComponent(lblForget))
                .addGap(30, 30, 30)
                .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(pnNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetCodeActionPerformed
        codeForgetPassword = (int) Math.round(Math.random() * 10000);
        checkSendMail();
    }//GEN-LAST:event_btnGetCodeActionPerformed

    private void lblForgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetMouseClicked
        this.setVisible(false);
        loginStudentForm.setVisible(true);
    }//GEN-LAST:event_lblForgetMouseClicked

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        String newPassword, conFirmPassword;
        int code = Integer.parseInt(txtCode.getText());
        newPassword = txtNewPassword.getText();
        conFirmPassword = txtConfrimPassword.getText();
        if (!checkNull()) {
            return;
        }

        if (!(code == codeForgetPassword)) {
            JOptionPane.showMessageDialog(this, "'Code' bạn nhập không đúng", "Reset password thất bại", JOptionPane.HEIGHT);
            return;
        }
        if (!newPassword.equals(conFirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không giống nhau", "Reset password thất bại", JOptionPane.HEIGHT);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
        this.setVisible(false);


    }//GEN-LAST:event_btnResetPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(ForgetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPasswordForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetCode;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JCheckBox chkRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblForget;
    private javax.swing.JPanel pnNewPassword;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtConfrimPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNewPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
