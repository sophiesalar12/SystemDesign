
package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import config.config;


public class Customers extends javax.swing.JPanel {

    public javax.swing.JFrame dashboard;


    public Customers() {
        initComponents();
        loadCustomers();
    }

public Customers(javax.swing.JFrame dashboard) {

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
        cadd = new javax.swing.JButton();
        cupdate = new javax.swing.JButton();
        csearch = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        cbtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_customers = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cadd.setBackground(new java.awt.Color(102, 153, 255));
        cadd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cadd.setText("ADD");
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });
        jPanel1.add(cadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 90, 40));

        cupdate.setBackground(new java.awt.Color(102, 153, 255));
        cupdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cupdate.setText("UPDATE");
        cupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdateActionPerformed(evt);
            }
        });
        jPanel1.add(cupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 100, 40));

        csearch.setBackground(new java.awt.Color(102, 153, 255));
        csearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        csearch.setText("SEARCH");
        csearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csearchActionPerformed(evt);
            }
        });
        jPanel1.add(csearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 100, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 230, 40));

        cbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        cbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbtnMouseClicked(evt);
            }
        });
        jPanel1.add(cbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 60));

        table_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed

    CustomerForm form = new CustomerForm(this);
    form.setLocationRelativeTo(null); 
    form.setVisible(true);
    
    if (dashboard != null) {
        dashboard.setVisible(false);  
    }


    }//GEN-LAST:event_caddActionPerformed

    private void cupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdateActionPerformed
        
     int row = table_customers.getSelectedRow();

    if(row == -1){

        JOptionPane.showMessageDialog(this,"Select customer first");

        return;

    }

    int id = Integer.parseInt(table_customers.getValueAt(row,0).toString());

    String name = table_customers.getValueAt(row,1).toString();

    String phone = table_customers.getValueAt(row,2).toString();

    String address = table_customers.getValueAt(row,3).toString();

    CustomerForm form = new CustomerForm(this, id, name, phone, address);
    form.setLocationRelativeTo(null); 
    form.setVisible(true);

    if (dashboard != null) {
      dashboard.setVisible(false);
    }

    
    }//GEN-LAST:event_cupdateActionPerformed

    private void csearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csearchActionPerformed
          
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

    }//GEN-LAST:event_csearchActionPerformed

    private void cbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbtnMouseClicked
       
        loadCustomers();
        
    }//GEN-LAST:event_cbtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadd;
    private javax.swing.JLabel cbtn;
    private javax.swing.JButton csearch;
    private javax.swing.JButton cupdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table_customers;
    // End of variables declaration//GEN-END:variables
}
