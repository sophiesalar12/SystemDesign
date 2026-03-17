
package staff;


import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ProfilePanel extends javax.swing.JPanel {

    private int userId; 


public ProfilePanel(int userId) {
    this.userId = userId;
    initComponents();
    loadProfile();
}


    private void loadProfile() {
        
        try {
            config con = new config();
            Connection conn = con.connectDB();
            String sql = "SELECT U_id, name, email, type, status FROM tbl_accounts WHERE U_id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                AccountID.setText("Account ID: " + rs.getInt("U_id"));
                Name.setText("Name: " + rs.getString("name"));
                Email.setText("Email: " + rs.getString("email"));
                Type.setText("Type: " + rs.getString("type"));
                Status.setText("Status: " + rs.getString("status"));

                
                jLabel1.setText(rs.getString("name"));
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading profile: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AccountID = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblProfileIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEditProfile = new javax.swing.JButton();
        editprof = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AccountID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        AccountID.setText("ACCOUNT ID :");
        jPanel1.add(AccountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 230, 20));

        Name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name.setText("NAME :");
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 124, 350, -1));

        Email.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Email.setText("EMAIL : ");
        jPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 350, 30));

        Status.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Status.setText("STATUS :");
        jPanel1.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 310, -1));

        Type.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Type.setText("TYPE :");
        jPanel1.add(Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 270, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        lblProfileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/acc (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblProfileIcon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfileIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 300, 280));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        btnEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/prof (2).png"))); // NOI18N
        btnEditProfile.setBorderPainted(false);
        btnEditProfile.setContentAreaFilled(false);
        btnEditProfile.setFocusPainted(false);
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });

        editprof.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        editprof.setText("EDIT PROFILE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(editprof)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editprof)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 320, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        
   
    String name = Name.getText().replace("Name: ", "");
    String email = Email.getText().replace("Email: ", "");
    String type = Type.getText().replace("Type: ", "");
    String status = Status.getText().replace("Status: ", "");
    
    javax.swing.JFrame topFrame =(javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
    ProfileForm pf = new ProfileForm(topFrame, userId, name, email, type, status);
    pf.setLocationRelativeTo(null);
    pf.setVisible(true);
    topFrame.setVisible(false);
    }//GEN-LAST:event_btnEditProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountID;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Type;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JLabel editprof;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblProfileIcon;
    // End of variables declaration//GEN-END:variables
}
