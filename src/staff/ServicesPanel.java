
package staff;

import config.config;


public class ServicesPanel extends javax.swing.JPanel {


    public ServicesPanel() {
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_services = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbtn = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 240, 41));

        searchbtn.setBackground(new java.awt.Color(102, 153, 255));
        searchbtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        searchbtn.setText("SEARCH");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 101, 43));

        table_services.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_services);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 697, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("AVAILABLE SERVICES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 270, 30));

        cbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        cbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbtnMouseClicked(evt);
            }
        });
        jPanel1.add(cbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed

        String searchText = jTextField1.getText();

        config conf = new config();

        String sql = "SELECT * FROM tbl_services WHERE "
        + "S_id LIKE '%" + searchText + "%' OR "      
        + "service_name LIKE '%" + searchText + "%' OR "
        + "service_price LIKE '%" + searchText + "%' OR "
        + "service_status LIKE '%" + searchText + "%'";

        conf.displayData(sql, table_services);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void cbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbtnMouseClicked

        displayServices();

    }//GEN-LAST:event_cbtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTable table_services;
    // End of variables declaration//GEN-END:variables
}
