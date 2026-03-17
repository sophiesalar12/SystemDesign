
package admin;

import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Services extends javax.swing.JPanel {


    public Services() {
        initComponents();
        displayServices();
    }

    void displayServices() {
        
    config conf = new config();

    String sql = "SELECT "
            + "S_id, "
            + "service_name, "
            + "'₱' || service_price || ' per kg' AS service_price, "
            + "service_status "
            + "FROM tbl_services";

    conf.displayData(sql, table_services);
}
    
    void addService(String name, int price, String status) {
    try (Connection conn = config.connectDB()) {
        String sql = "INSERT INTO tbl_services(service_name, service_price, service_status) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, price); 
        ps.setString(3, status);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Service Added!");
        displayServices();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Add Error: " + e.getMessage());
    }
}

    void updateService(int id, String name, int price, String status) {
    try (Connection conn = config.connectDB()) {
        String sql = "UPDATE tbl_services SET service_name=?, service_price=?, service_status=? WHERE S_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, price); 
        ps.setString(3, status);
        ps.setInt(4, id);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Service Updated!");
        displayServices();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Update Error: " + e.getMessage());
    }
}


    void deleteService(int id) {
    try (Connection conn = config.connectDB()) {

        String sql = "DELETE FROM tbl_services WHERE S_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();

        LogService.logAction(Session.getInstance().getId(), "Deleted Service ID: " + id);

        JOptionPane.showMessageDialog(this, "Service Deleted!");
        displayServices();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Delete Error: " + e.getMessage());
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        seadd = new javax.swing.JButton();
        supdate = new javax.swing.JButton();
        sdelete = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        ssearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_services = new javax.swing.JTable();
        cbtn = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seadd.setBackground(new java.awt.Color(102, 153, 255));
        seadd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        seadd.setText("ADD");
        seadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seaddActionPerformed(evt);
            }
        });
        jPanel1.add(seadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 40));

        supdate.setBackground(new java.awt.Color(102, 153, 255));
        supdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        supdate.setText("UPDATE");
        supdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supdateActionPerformed(evt);
            }
        });
        jPanel1.add(supdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 100, 40));

        sdelete.setBackground(new java.awt.Color(102, 153, 255));
        sdelete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sdelete.setText("DELETE");
        sdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(sdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 100, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 240, 41));

        ssearch.setBackground(new java.awt.Color(102, 153, 255));
        ssearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ssearch.setText("SEARCH");
        ssearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssearchActionPerformed(evt);
            }
        });
        jPanel1.add(ssearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 100, 40));

        table_services.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_services);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 122, 697, 410));

        cbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        cbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbtnMouseClicked(evt);
            }
        });
        jPanel1.add(cbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdeleteActionPerformed
    int row = table_services.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Select a service first.");
        return;
    }

    int id = Integer.parseInt(table_services.getValueAt(row, 0).toString());

    int confirm = JOptionPane.showConfirmDialog(this, "Delete this service?", "Confirm", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        deleteService(id);
    }
    }//GEN-LAST:event_sdeleteActionPerformed

    private void seaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seaddActionPerformed
    ServiceForm form = new ServiceForm();


    this.setVisible(false);

    form.setLocationRelativeTo(null);
    form.setVisible(true);

    
    form.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            displayServices();  
            setVisible(true);  
            
        }
    });
    }//GEN-LAST:event_seaddActionPerformed

    private void supdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supdateActionPerformed
    int row = table_services.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Select a service first.");
        return;
    }

    int id = Integer.parseInt(table_services.getValueAt(row, 0).toString());
    String name = table_services.getValueAt(row, 1).toString();
    String priceText = table_services.getValueAt(row, 2).toString();

    priceText = priceText.replace("₱", "")
                     .replace(" per kg", "")
                     .trim();

    int price = Integer.parseInt(priceText);
    String status = table_services.getValueAt(row, 3).toString();

    ServiceForm form = new ServiceForm();

    form.updateId = id;
    form.jTextField1.setText(name);
    form.jTextField2.setText(String.valueOf(price));

    if (status.equalsIgnoreCase("Active")) {
        form.jRadioButton1.setSelected(true);
    } else {
        form.jRadioButton2.setSelected(true);
        
    }

    form.originalName = name;
    form.originalPrice = price;
    form.originalStatus = status;
    form.setLocationRelativeTo(null);
    form.setVisible(true);

    this.setVisible(false);

    form.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        displayServices();
        setVisible(true);
    }
});
    }//GEN-LAST:event_supdateActionPerformed

    private void ssearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssearchActionPerformed
        
    String searchText = jTextField1.getText();

    config conf = new config();

    String sql = "SELECT * FROM tbl_services WHERE "
            + "S_id LIKE '%" + searchText + "%' OR " 
            + "service_name LIKE '%" + searchText + "%' OR "
            + "service_price LIKE '%" + searchText + "%' OR "
            + "service_status LIKE '%" + searchText + "%'";

    conf.displayData(sql, table_services);
    }//GEN-LAST:event_ssearchActionPerformed

    private void cbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbtnMouseClicked

        displayServices();

    }//GEN-LAST:event_cbtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cbtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton sdelete;
    private javax.swing.JButton seadd;
    private javax.swing.JButton ssearch;
    private javax.swing.JButton supdate;
    private javax.swing.JTable table_services;
    // End of variables declaration//GEN-END:variables
}
