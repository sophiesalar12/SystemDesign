
package admin;

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
            String sql = "INSERT INTO tbl_accounts(name,email,password,type,status) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, type);
            ps.setString(5, status);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "User added!");
            displayUser();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Add Error: " + e.getMessage());
        }
    }
    
       
        void updateUser(int id, String name, String email, String password, String type, String status) {
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
            JOptionPane.showMessageDialog(this, "User updated!");
            displayUser();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update Error: " + e.getMessage());
        }
    }   
       
       
         void deleteUser(int id) {
        try (Connection conn = config.connectDB()) {
            String sql = "DELETE FROM tbl_accounts WHERE U_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "User deleted!");
            displayUser();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Delete Error: " + e.getMessage());
        }
    }
         
    void searchUser(String keyword) {
    String sql = "SELECT U_id, name, email, type, status FROM tbl_accounts " +
                 "WHERE name LIKE ? OR email LIKE ? OR type LIKE ?";
    try (java.sql.Connection conn = config.connectDB();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");
        ps.setString(3, "%" + keyword + "%");

        java.sql.ResultSet rs = ps.executeQuery();
        table_users.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Search Error: " + e.getMessage());
    }
}
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addUser = new javax.swing.JButton();
        updateUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_users = new javax.swing.JTable();

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

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setText("SEARCH");
        jButton4.setPreferredSize(new java.awt.Dimension(93, 32));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        table_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_users);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
       
    int selectedRow = table_users.getSelectedRow();
    if(selectedRow >= 0) {
        int id = Integer.parseInt(table_users.getValueAt(selectedRow, 0).toString()); // U_id
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?");
        if(confirm == JOptionPane.YES_OPTION) {
            deleteUser(id); // this is your method from earlier
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.");
    }
    }//GEN-LAST:event_deleteUserActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
    
    String name = JOptionPane.showInputDialog(this, "Enter Name:");
    String email = JOptionPane.showInputDialog(this, "Enter Email:");
    String password = JOptionPane.showInputDialog(this, "Enter Password:");
    String type = JOptionPane.showInputDialog(this, "Enter Type (Admin/Staff):");
    String status = JOptionPane.showInputDialog(this, "Enter Status (Active/Inactive):");

    if(name != null && email != null) {
        addUser(name, email, password, type, status); // this is your method from earlier
    }
    }//GEN-LAST:event_addUserActionPerformed

    private void updateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserActionPerformed
    
        int selectedRow = table_users.getSelectedRow();
    if(selectedRow >= 0) {
        int id = Integer.parseInt(table_users.getValueAt(selectedRow, 0).toString()); // U_id
        String name = JOptionPane.showInputDialog(this, "Enter Name:", table_users.getValueAt(selectedRow, 1));
        String email = JOptionPane.showInputDialog(this, "Enter Email:", table_users.getValueAt(selectedRow, 2));
        String password = JOptionPane.showInputDialog(this, "Enter Password:", table_users.getValueAt(selectedRow, 3));
        String type = JOptionPane.showInputDialog(this, "Enter Type:", table_users.getValueAt(selectedRow, 4));
        String status = JOptionPane.showInputDialog(this, "Enter Status:", table_users.getValueAt(selectedRow, 5));

        updateUser(id, name, email, password, type, status);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a user to update.");
    }
    }//GEN-LAST:event_updateUserActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String keyword = jTextField1.getText().trim(); // get text from your search field
    if(!keyword.isEmpty()) {
        searchUser(keyword); // call the method above
    } else {
        displayUser(); // if search box is empty, show all users
    }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JButton deleteUser;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table_users;
    private javax.swing.JButton updateUser;
    // End of variables declaration//GEN-END:variables
}
