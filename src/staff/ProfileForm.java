

package staff;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;



public class ProfileForm extends javax.swing.JFrame {


private int userId;
private javax.swing.JFrame parentFrame;
private String originalName;
private String originalEmail;
private String originalType;
private String originalStatus;


public ProfileForm(javax.swing.JFrame parentFrame, int userId,
                   String name, String email, String type, String status) {

    initComponents();
    this.parentFrame = parentFrame;
    this.userId = userId;

    // store originals
    this.originalName = name;
    this.originalEmail = email;
    this.originalType = type;
    this.originalStatus = status;

    // set UI values
    jTextField1.setText(name);
    jTextField2.setText(email);

    if ("Admin".equals(type)) {
        admin.setSelected(true);
    } else {
        staff.setSelected(true);
    }

    if ("Active".equals(status)) {
        Active.setSelected(true);
    } else {
        Inactive.setSelected(true);
    }
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
        utype = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        admin = new javax.swing.JRadioButton();
        staff = new javax.swing.JRadioButton();
        ustat = new javax.swing.JLabel();
        Active = new javax.swing.JRadioButton();
        Inactive = new javax.swing.JRadioButton();
        savebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Edit Profile");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        uname.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        uname.setText("Name :");
        jPanel1.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 280, 50));

        uemail.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        uemail.setText("Email :");
        jPanel1.add(uemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 70, 40));

        utype.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        utype.setText("Type :");
        jPanel1.add(utype, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 30));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 280, 50));

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminActionPerformed

    private void staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffActionPerformed

    private void ActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActiveActionPerformed

    private void InactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InactiveActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
    String name = jTextField1.getText().trim();
    String email = jTextField2.getText().trim();
    String type = admin.isSelected() ? "Admin" : staff.isSelected() ? "Staff" : "";
    String status = Active.isSelected() ? "Active" : Inactive.isSelected() ? "Inactive" : "";

 

    if (name.isEmpty() || email.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Name and Email cannot be empty.",
            "Invalid Input",
            JOptionPane.WARNING_MESSAGE);
    return;
    }


    boolean noChanges =
        name.equals(originalName) &&
        email.equals(originalEmail) &&
        type.equals(originalType) &&
        status.equals(originalStatus);

    if (noChanges) {
    JOptionPane.showMessageDialog(this,
            "No changes detected.",
            "Update Profile",
            JOptionPane.INFORMATION_MESSAGE);
    return;
}

    try {
        config con = new config();
        Connection conn = con.connectDB();

        String sql = "UPDATE tbl_accounts SET name=?, email=?, type=?, status=? WHERE U_id=?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, type);
        pst.setString(4, status);
        pst.setInt(5, userId);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Profile Updated Successfully");

        pst.close();
        conn.close();

        this.dispose(); 
        if (parentFrame != null) {
    parentFrame.setVisible(true);
}
      

    } catch(Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_savebtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed

        this.dispose();
        if(parentFrame != null) {
        parentFrame.setVisible(true); 
    }
        
    }//GEN-LAST:event_cancelbtnActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Active;
    private javax.swing.JRadioButton Inactive;
    private javax.swing.JRadioButton admin;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton savebtn;
    private javax.swing.JRadioButton staff;
    private javax.swing.JLabel uemail;
    private javax.swing.JLabel uname;
    private javax.swing.JLabel ustat;
    private javax.swing.JLabel utype;
    // End of variables declaration//GEN-END:variables
}
