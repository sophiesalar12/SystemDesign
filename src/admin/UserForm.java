
package admin;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class UserForm extends javax.swing.JFrame {

private String originalName;
private String originalEmail;
private String originalPassword;
private String originalType;
private String originalStatus;


    public UserForm() {
        initComponents();
        
    ButtonGroup typeGroup = new ButtonGroup();
    typeGroup.add(admin);
    typeGroup.add(staff);

    ButtonGroup statusGroup = new ButtonGroup();
    statusGroup.add(Active);
    statusGroup.add(Inactive);
    }

    public interface SaveCallback {
    boolean onSave(String name, String email, String password, String type, String status);
}

    private SaveCallback saveCallback;

    public void setSaveCallback(SaveCallback callback) {
    this.saveCallback = callback;
}

    public void setFields(String name, String email, String password, String type, String status) {
    jTextField1.setText(name);
    jTextField2.setText(email);
    jPasswordField1.setText(password);

    if(type.equalsIgnoreCase("Admin")) {
        admin.setSelected(true);
    } else {
        staff.setSelected(true);
    }

    if(status.equalsIgnoreCase("Active")) {
        Active.setSelected(true);
    } else {
        Inactive.setSelected(true);
    }

 
    originalName = name;
    originalEmail = email;
    originalPassword = password;
    originalType = type;
    originalStatus = status;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        uemail = new javax.swing.JLabel();
        upass = new javax.swing.JLabel();
        utype = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        admin = new javax.swing.JRadioButton();
        staff = new javax.swing.JRadioButton();
        ustat = new javax.swing.JLabel();
        Active = new javax.swing.JRadioButton();
        Inactive = new javax.swing.JRadioButton();
        savebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(32767, 32767));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Add User Form");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        uname.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        uname.setText("Name :");
        jPanel1.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 82, 280, 50));

        uemail.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        uemail.setText("Email :");
        jPanel1.add(uemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        upass.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        upass.setText("Password :");
        jPanel1.add(upass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        utype.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        utype.setText("Type :");
        jPanel1.add(utype, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 30));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 280, 50));

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 280, 50));

        admin.setBackground(new java.awt.Color(255, 255, 255));
        admin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        admin.setText("Admin");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        staff.setBackground(new java.awt.Color(255, 255, 255));
        staff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        staff.setText("Staff");
        staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffActionPerformed(evt);
            }
        });
        jPanel1.add(staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 90, -1));

        ustat.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        ustat.setText("Status :");
        jPanel1.add(ustat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 40));

        Active.setBackground(new java.awt.Color(255, 255, 255));
        Active.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Active.setText("Active");
        Active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActiveActionPerformed(evt);
            }
        });
        jPanel1.add(Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 80, -1));

        Inactive.setBackground(new java.awt.Color(255, 255, 255));
        Inactive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Inactive.setText("Inactive");
        Inactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactiveActionPerformed(evt);
            }
        });
        jPanel1.add(Inactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        savebtn.setBackground(new java.awt.Color(255, 255, 255));
        savebtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        jPanel1.add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 128, 56));

        cancelbtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelbtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 128, 56));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
    String name = jTextField1.getText();
    String email = jTextField2.getText();
    String password = new String(jPasswordField1.getPassword());
    String type = admin.isSelected() ? "Admin" : "Staff";
    String status = Active.isSelected() ? "Active" : "Inactive";
    

    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.");
        return; 
    }


    if(originalName != null) { 

        if(name.equals(originalName) &&
           email.equals(originalEmail) &&
           password.equals(originalPassword) &&
           type.equals(originalType) &&
           status.equals(originalStatus)) {

            JOptionPane.showMessageDialog(this, "No changes detected.");
            return; 
        }
    }


if (saveCallback != null) {
    boolean success = saveCallback.onSave(name, email, password, type, status);

    if (success) {
        this.dispose(); 
    }
}

    }//GEN-LAST:event_savebtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        
        if(cancelCallback != null) {
        cancelCallback.run();
        } 
        this.dispose();
    }//GEN-LAST:event_cancelbtnActionPerformed
    
    private void addUser(String name, String email, String password, String type, String status) {
    try {
        Connection conn = new config().connectDB(); // your DB connection
        String sql = "INSERT INTO tbl_users(name, email, password, type, status) VALUES(?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, password);
        pst.setString(4, type);
        pst.setString(5, status);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "User added successfully!");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
    
    private void updateUser(int id, String name, String email, String password, String type, String status) {
    try {
        Connection conn = new config().connectDB();
        String sql = "UPDATE tbl_users SET name=?, email=?, password=?, type=?, status=? WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, password);
        pst.setString(4, type);
        pst.setString(5, status);
        pst.setInt(6, id);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "User updated successfully!");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
    
    private Runnable cancelCallback;

    public void setCancelCallback(Runnable callback) {
    this.cancelCallback = callback;
}

    
    private void staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffActionPerformed

    private void ActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActiveActionPerformed

    private void InactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InactiveActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Active;
    private javax.swing.JRadioButton Inactive;
    private javax.swing.JRadioButton admin;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton savebtn;
    private javax.swing.JRadioButton staff;
    private javax.swing.JLabel uemail;
    private javax.swing.JLabel uname;
    private javax.swing.JLabel upass;
    private javax.swing.JLabel ustat;
    private javax.swing.JLabel utype;
    // End of variables declaration//GEN-END:variables
}
