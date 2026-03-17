
package admin;

import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Users extends javax.swing.JPanel {


    public Users() {
        initComponents();
        displayUser();
    }

    void displayUser() {
    
        config conf = new config();
        String sql = "Select * FROM tbl_accounts";
        conf.displayData(sql, table_users);
        
    }
    
       void addUser(String name, String email, String password, String type, String status) {
        try (Connection conn = config.connectDB()) {
            String sql = "INSERT INTO tbl_accounts(name,email,password,type,status,is_default) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, type);
            ps.setString(5, status);
            ps.setInt(6, 1);
            ps.executeUpdate();
            
            LogService.logAction(Session.getInstance().getId(), "Added User: " + name);
            
            JOptionPane.showMessageDialog(this, "User added!");
            displayUser();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Add Error: " + e.getMessage());
        }
    }
    
       
boolean updateUser(int id, String name, String email, String password, String type, String status) {

    if (emailExistsForOtherUser(email, id)) {
        JOptionPane.showMessageDialog(
            this,
            "Email already exists!",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );
        return false;
    }

    try (Connection conn = config.connectDB()) {

        String sql = "UPDATE tbl_accounts SET name=?, email=?, password=?, type=?, status=? WHERE U_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, type);
        ps.setString(5, status);
        ps.setInt(6, id);

        ps.executeUpdate();

        LogService.logAction(Session.getInstance().getId(), "Updated User: " + name);

        JOptionPane.showMessageDialog(this, "User updated!");
        displayUser();
        return true; 

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Update Error: " + e.getMessage());
        return false;
    }
}
     
void deleteUser(int id) {
    try (Connection conn = config.connectDB()) {
        String sql = "DELETE FROM tbl_accounts WHERE U_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        LogService.logAction(Session.getInstance().getId(), "Deleted User ID: " + id);

        JOptionPane.showMessageDialog(this, "User deleted!");
        displayUser();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Delete Error: " + e.getMessage());
    }
}
    void searchUser(String keyword) {
    String sql = "SELECT U_id, name, email, type, status FROM tbl_accounts " +
                 "WHERE U_id LIKE ? OR name LIKE ? OR email LIKE ? OR type LIKE ? OR status LIKE ?";
    
    try (Connection conn = config.connectDB();
         PreparedStatement ps = conn.prepareStatement(sql)) {


        ps.setString(1, "%" + keyword + "%"); 
        ps.setString(2, "%" + keyword + "%"); 
        ps.setString(3, "%" + keyword + "%"); 
        ps.setString(4, "%" + keyword + "%"); 
        ps.setString(5, "%" + keyword + "%");  

        ResultSet rs = ps.executeQuery();
        table_users.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Search Error: " + e.getMessage());
    }
}
    private boolean emailExistsForOtherUser(String email, int currentUserId) {
    String sql = "SELECT COUNT(*) FROM tbl_accounts WHERE email = ? AND U_id != ?";
    try (Connection conn = config.connectDB();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, email);
        ps.setInt(2, currentUserId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Validation Error: " + e.getMessage());
    }
    return false;
}
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addUser = new javax.swing.JButton();
        updateUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_users = new javax.swing.JTable();
        btnr = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        addUser.setBackground(new java.awt.Color(102, 153, 255));
        addUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addUser.setText("ADD");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        updateUser.setBackground(new java.awt.Color(102, 153, 255));
        updateUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        updateUser.setText("UPDATE");
        updateUser.setPreferredSize(new java.awt.Dimension(67, 31));
        updateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserActionPerformed(evt);
            }
        });

        deleteUser.setBackground(new java.awt.Color(102, 153, 255));
        deleteUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteUser.setText("DELETE");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(102, 153, 255));
        search.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        search.setText("SEARCH");
        search.setPreferredSize(new java.awt.Dimension(93, 32));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        table_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_users);

        btnr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        btnr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnr)
                        .addGap(22, 22, 22)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(773, 773, 773))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnr, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
       
    int selectedRow = table_users.getSelectedRow();
    if(selectedRow >= 0) {
        int id = Integer.parseInt(table_users.getValueAt(selectedRow, 0).toString()); 
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?");
        if(confirm == JOptionPane.YES_OPTION) {
            deleteUser(id); 
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.");
    }
    }//GEN-LAST:event_deleteUserActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
    
    java.awt.Window parentWindow =
            javax.swing.SwingUtilities.getWindowAncestor(this);

    UserForm form = new UserForm();

    
    parentWindow.setVisible(false);

    
form.setSaveCallback((name, email, password, type, status) -> {
    addUser(name, email, password, type, status); 

    parentWindow.setVisible(true);
    return true; 
});
    
    form.setCancelCallback(() -> {
        form.dispose();
        parentWindow.setVisible(true);
    });

    form.setLocationRelativeTo(null);
    form.setVisible(true);
    }//GEN-LAST:event_addUserActionPerformed

    private void updateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserActionPerformed
    

    int selectedRow = table_users.getSelectedRow();

    if(selectedRow >= 0) {

        int id = Integer.parseInt(table_users.getValueAt(selectedRow, 0).toString());

        java.awt.Window parentWindow =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        UserForm form = new UserForm();

        parentWindow.setVisible(false);

        form.setFields(
            table_users.getValueAt(selectedRow, 1).toString(),
            table_users.getValueAt(selectedRow, 2).toString(),
            table_users.getValueAt(selectedRow, 3).toString(),
            table_users.getValueAt(selectedRow, 4).toString(),
            table_users.getValueAt(selectedRow, 5).toString()
        );

form.setSaveCallback((name, email, password, type, status) -> {

    boolean updated = updateUser(id, name, email, password, type, status);

    if (updated) {
        parentWindow.setVisible(true);
    }

    return updated; 
});
   

        form.setCancelCallback(() -> {
            form.dispose();
            parentWindow.setVisible(true);
        });

        form.setLocationRelativeTo(null);
        form.setVisible(true);

    } else {
        JOptionPane.showMessageDialog(this, "Please select a user to update.");
    }
    }//GEN-LAST:event_updateUserActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    String keyword = jTextField1.getText().trim(); 
    if(!keyword.isEmpty()) {
        searchUser(keyword); 
    } else {
        displayUser();     }
    }//GEN-LAST:event_searchActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrMouseClicked

        displayUser();
    }//GEN-LAST:event_btnrMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JLabel btnr;
    private javax.swing.JButton deleteUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton search;
    private javax.swing.JTable table_users;
    private javax.swing.JButton updateUser;
    // End of variables declaration//GEN-END:variables
}
