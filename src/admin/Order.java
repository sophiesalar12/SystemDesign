/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Order extends javax.swing.JPanel {

AdminDashboard dashboard;
private javax.swing.table.DefaultTableModel model;

public Order(AdminDashboard dashboard) {
    initComponents();
    this.dashboard = dashboard;

    model = new javax.swing.table.DefaultTableModel(
        null,
        new String[]{"ID","Customer","Service","Weight (kg)","Total","Date","Payment Status","Order Status"}
    );

    table_orders.setModel(model);

    loadOrder();
}

public void loadOrder() {
    try {
        config conf = new config();
        java.sql.Connection conn = conf.connectDB();

        java.sql.PreparedStatement pst = conn.prepareStatement(
            "SELECT o.O_id, c.C_name, s.service_name, o.weight_kg, " +
            "o.total_amount, o.order_date, o.P_status, o.O_status " +
            "FROM tbl_orders o " +
            "JOIN tbl_customers c ON o.C_id = c.C_id " +
            "JOIN tbl_services s ON o.S_id = s.S_id"
        );

        java.sql.ResultSet rs = pst.executeQuery();

        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("O_id"),
                rs.getString("C_name"),
                rs.getString("service_name"),
                rs.getDouble("weight_kg"),
                rs.getDouble("total_amount"),
                rs.getString("order_date"),
                rs.getString("P_status"),
                rs.getString("O_status")
            });
        }

        conn.close();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, e);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        oadd = new javax.swing.JButton();
        oupdate = new javax.swing.JButton();
        osearch = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        refresh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_orders = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oadd.setBackground(new java.awt.Color(102, 153, 255));
        oadd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        oadd.setText("ADD");
        oadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oaddActionPerformed(evt);
            }
        });
        jPanel1.add(oadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 40));

        oupdate.setBackground(new java.awt.Color(102, 153, 255));
        oupdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        oupdate.setText("UPDATE");
        oupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oupdateActionPerformed(evt);
            }
        });
        jPanel1.add(oupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 100, 40));

        osearch.setBackground(new java.awt.Color(102, 153, 255));
        osearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        osearch.setText("SEARCH");
        osearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osearchActionPerformed(evt);
            }
        });
        jPanel1.add(osearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 100, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 230, 40));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        jPanel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 60));

        table_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_orders);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 780, 470));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 100, 40));

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

    private void oaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oaddActionPerformed

        Orderform form = new Orderform(this, null);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        dashboard.setVisible(false);


    }//GEN-LAST:event_oaddActionPerformed

    private void oupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oupdateActionPerformed

        int row = table_orders.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select an order to update");
            return;
        }

        int orderId = (int) model.getValueAt(row, 0);
        Orderform form = new Orderform(this, orderId);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        dashboard.setVisible(false);


    }//GEN-LAST:event_oupdateActionPerformed

    private void osearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osearchActionPerformed

        String keyword = jTextField1.getText();
        try {
            config conf = new config();
            Connection conn = conf.connectDB();
            PreparedStatement pst = conn.prepareStatement(
                "SELECT o.O_id, c.C_name, s.service_name, o.weight_kg, o.total_amount, o.order_date, o.P_status, o.O_status " +
                "FROM tbl_orders o " +
                "JOIN tbl_customers c ON o.C_id = c.C_id " +
                "JOIN tbl_services s ON o.S_id = s.S_id " +
                "WHERE o.O_id LIKE ? OR c.C_name LIKE ? OR s.service_name LIKE ? OR o.P_status LIKE ? OR o.O_status LIKE ? "
                + "OR CAST(o.weight_kg AS TEXT) LIKE ? OR CAST(o.total_amount AS TEXT) LIKE ? OR CAST(o.order_date AS TEXT) LIKE ?"
            );
            String like = "%" + keyword + "%";
            for (int i = 1; i <= 8; i++) pst.setString(i, like);
            ResultSet rs = pst.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("O_id"),
                    rs.getString("C_name"),
                    rs.getString("service_name"),
                    rs.getDouble("weight_kg"),
                    rs.getDouble("total_amount"),
                    rs.getString("order_date"),
                    rs.getString("P_status"),
                    rs.getString("O_status")
                });
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_osearchActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        loadOrder();
    }//GEN-LAST:event_refreshMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int row = table_orders.getSelectedRow();
if (row < 0) {
    JOptionPane.showMessageDialog(this, "Select order to delete");
    return;
}

    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this order?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

 
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
int id = (int) model.getValueAt(row, 0);

try {
    config conf = new config();
    java.sql.Connection conn = conf.connectDB();

    java.sql.PreparedStatement pst = conn.prepareStatement(
        "DELETE FROM tbl_orders WHERE O_id=?"
    );
    pst.setInt(1, id);
    pst.executeUpdate();

    LogService.logAction(Session.getInstance().getId(), "Deleted Order ID: " + id);

    JOptionPane.showMessageDialog(this, "Order Deleted");

    conn.close();
    loadOrder();

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e);
}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton oadd;
    private javax.swing.JButton osearch;
    private javax.swing.JButton oupdate;
    private javax.swing.JLabel refresh;
    private javax.swing.JTable table_orders;
    // End of variables declaration//GEN-END:variables
}
