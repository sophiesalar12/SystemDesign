

package admin;

import javax.swing.JOptionPane;


public class ChangePasswordForm extends javax.swing.JFrame {


   private int userId;

    public ChangePasswordForm(int userId) {
        initComponents();
        this.userId = userId;
        defaultEchoCharNew = txtNewPass.getEchoChar();
        defaultEchoCharConfirm = txtConfirmPass.getEchoChar();
        setLocationRelativeTo(null);
    }
    
    private boolean canChangePassword(int userId) {
    String sql = "SELECT is_default FROM tbl_accounts WHERE U_id=?";

    try (java.sql.Connection conn = config.config.connectDB();
         java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, userId);
        java.sql.ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("is_default") == 1;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    return false;
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblNewPass = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        lblConfirmPass = new javax.swing.JLabel();
        txtConfirmPass = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setText("CHANGE PASSWORD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(143, 143, 143))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 528, -1));

        lblNewPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblNewPass.setText("New Password :");
        jPanel1.add(lblNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 152, -1, -1));

        txtNewPass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPassActionPerformed(evt);
            }
        });
        jPanel1.add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 223, 40));

        lblConfirmPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblConfirmPass.setText("Confirm Password :");
        jPanel1.add(lblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 50));

        txtConfirmPass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPassActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 223, 40));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 130, 50));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox2.setText("Show Password");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPassActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    

    if (!canChangePassword(userId)) {
        JOptionPane.showMessageDialog(
            this,
            "You are not required to change your password.",
            "Access Denied",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    String newPass = String.valueOf(txtNewPass.getPassword());
    String confirmPass = String.valueOf(txtConfirmPass.getPassword());

    if (newPass.isEmpty() || confirmPass.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Fill all fields");
        return;
    }

    if (!newPass.equals(confirmPass)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match");
        return;
    }

    String sql = "UPDATE tbl_accounts SET password=?, is_default=0 WHERE U_id=?";

    java.sql.Connection conn = null;
    java.sql.PreparedStatement pst = null;

    try {

        conn = config.config.connectDB();

        pst = conn.prepareStatement(sql);

        pst.setString(1, newPass);
        pst.setInt(2, userId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this,
                "Password changed successfully.\nPlease login again.");

        // ✅ OPEN LOGIN FORM
        new Main.NewJFrame().setVisible(true);

        // ✅ CLOSE CHANGE PASSWORD FORM
        this.dispose();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

    } finally {

        try {

            if (pst != null) pst.close();

            if (conn != null) conn.close();

        } catch (Exception e) {}
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private char defaultEchoCharNew;
    private char defaultEchoCharConfirm;

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
    if (jCheckBox2.isSelected()) {
        txtConfirmPass.setEchoChar((char) 0);
    } else {
        txtConfirmPass.setEchoChar(defaultEchoCharConfirm);
    }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void txtNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPassActionPerformed

    }//GEN-LAST:event_txtNewPassActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    if (jCheckBox1.isSelected()) {
        txtNewPass.setEchoChar((char) 0);
    } else {
        txtNewPass.setEchoChar(defaultEchoCharNew);
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JPasswordField txtNewPass;
    // End of variables declaration//GEN-END:variables
}
