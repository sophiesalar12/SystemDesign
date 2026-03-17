
package admin;

import javax.swing.JOptionPane;
import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Customer extends javax.swing.JPanel {

public javax.swing.JFrame dashboard;

    public Customer() {
        initComponents();
    }


    public Customer(javax.swing.JFrame dashboard) {
    initComponents();
    this.dashboard = dashboard;
    loadCustomers();
}
    
    public void loadCustomers() {

        config conf = new config();
        String sql = "Select * FROM tbl_customers";
        conf.displayData(sql, table_customers);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addb = new javax.swing.JButton();
        updateb = new javax.swing.JButton();
        deleteb = new javax.swing.JButton();
        searchb = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnr = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_customers = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addb.setBackground(new java.awt.Color(102, 153, 255));
        addb.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addb.setText("ADD");
        addb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbActionPerformed(evt);
            }
        });
        jPanel1.add(addb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 40));

        updateb.setBackground(new java.awt.Color(102, 153, 255));
        updateb.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updateb.setText("UPDATE");
        updateb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebActionPerformed(evt);
            }
        });
        jPanel1.add(updateb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 100, 40));

        deleteb.setBackground(new java.awt.Color(102, 153, 255));
        deleteb.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        deleteb.setText("DELETE");
        deleteb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebActionPerformed(evt);
            }
        });
        jPanel1.add(deleteb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 100, 40));

        searchb.setBackground(new java.awt.Color(102, 153, 255));
        searchb.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchb.setText("SEARCH");
        searchb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbActionPerformed(evt);
            }
        });
        jPanel1.add(searchb, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 100, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 230, 40));

        btnr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        btnr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrMouseClicked(evt);
            }
        });
        jPanel1.add(btnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 60));

        table_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_customers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 110, 720, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbActionPerformed

        Customerform form = new Customerform(this);
        form.setLocationRelativeTo(null); 
        form.setVisible(true);

        if (dashboard != null) {
            dashboard.setVisible(false);  
        }

    }//GEN-LAST:event_addbActionPerformed

    private void updatebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebActionPerformed

        int row = table_customers.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(this,"Select customer first");

            return;

        }

        int id = Integer.parseInt(table_customers.getValueAt(row,0).toString());

        String name = table_customers.getValueAt(row,1).toString();

        String phone = table_customers.getValueAt(row,2).toString();

        String address = table_customers.getValueAt(row,3).toString();

        Customerform form = new Customerform(this, id, name, phone, address);
        form.setLocationRelativeTo(null); 
        form.setVisible(true);

        if (dashboard != null) {
            dashboard.setVisible(false);
        }

    }//GEN-LAST:event_updatebActionPerformed

    private void deletebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebActionPerformed

     int row = table_customers.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Select Customer First");
        return;
    }


    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this customer?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

 
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    int id = (int) table_customers.getValueAt(row, 0);

    try {
        config conf = new config();
        Connection conn = conf.connectDB();

        String sql = "DELETE FROM tbl_customers WHERE C_id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);

        pst.executeUpdate();

        LogService.logAction(Session.getInstance().getId(), "Deleted Customer ID: " + id);

        JOptionPane.showMessageDialog(this, "Customer Deleted Successfully");

        loadCustomers();

        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_deletebActionPerformed

    private void searchbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbActionPerformed

        String search = jTextField1.getText();

        DefaultTableModel model = (DefaultTableModel) table_customers.getModel();

        model.setRowCount(0);

        try{

            config conf = new config();
            Connection conn = conf.connectDB();

            String sql = "SELECT * FROM tbl_customers WHERE "
            + "C_id LIKE ? OR "
            + "C_name LIKE ? OR "
            + "C_phone LIKE ? OR "
            + "address LIKE ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%"+search+"%");
            pst.setString(2, "%"+search+"%");
            pst.setString(3, "%"+search+"%");
            pst.setString(4, "%"+search+"%");

            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                model.addRow(new Object[]{

                    rs.getInt("C_id"),
                    rs.getString("C_name"),
                    rs.getString("C_phone"),
                    rs.getString("address")

                });

            }

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_searchbActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrMouseClicked

        loadCustomers();

    }//GEN-LAST:event_btnrMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addb;
    private javax.swing.JLabel btnr;
    private javax.swing.JButton deleteb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchb;
    private javax.swing.JTable table_customers;
    private javax.swing.JButton updateb;
    // End of variables declaration//GEN-END:variables
}
