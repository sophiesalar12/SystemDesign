
package admin;


import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class dashboard extends javax.swing.JPanel {

private Connection conn;

public dashboard() {
    initComponents();
    try {
        conn = config.connectDB();
        loadAllDashboardData();
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

private void loadAllDashboardData() {
    try {
        loadDashboardData(conn);
        loadServiceStats();
        loadRecentActivity();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

 public void loadServiceStats() {

    String sql =
    "SELECT s.service_name, " +
    "SUM(CASE WHEN strftime('%m', o.order_date) = strftime('%m','now') THEN 1 ELSE 0 END) AS month_orders, " +
    "SUM(CASE WHEN strftime('%Y', o.order_date) = strftime('%Y','now') THEN 1 ELSE 0 END) AS year_orders " +
    "FROM tbl_orders o " +
    "JOIN tbl_services s ON o.S_id = s.S_id " +
    "GROUP BY s.service_name " +
    "ORDER BY year_orders DESC";

    try {

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) tblServiceStats.getModel();

        model.setRowCount(0);

        while(rs.next()){

            model.addRow(new Object[]{
                rs.getString("service_name"),
                rs.getInt("month_orders"),
                rs.getInt("year_orders")
            });

        }

    } catch(Exception e){
        e.printStackTrace();
    }
}

 public void loadDashboardData(Connection con){

    try (Statement st = con.createStatement()) {


        try (ResultSet rs1 = st.executeQuery(
            "SELECT COUNT(*) AS total FROM tbl_orders " +
            "WHERE date(order_date) = date('now')"
        )) {
            if(rs1.next()){
                lblOrdersToday2.setText(rs1.getString("total"));
            }
        }


        try (ResultSet rs2 = st.executeQuery(
           "SELECT IFNULL(SUM(total_amount),0) AS revenue FROM tbl_orders " +
           "WHERE date(order_date) = date('now') AND P_status = 'Paid'"
        )) {
            if(rs2.next()){
                lblRevenueToday.setText("₱" + rs2.getString("revenue"));
            }
        }


        try (ResultSet rs3 = st.executeQuery(
            "SELECT COUNT(*) AS total FROM tbl_customers"
        )) {
            if(rs3.next()){
                lblCustomers.setText(rs3.getString("total"));
            }
        }


        try (ResultSet rs4 = st.executeQuery(
            "SELECT COUNT(*) AS total FROM tbl_orders " +
            "WHERE O_status = 'Pending'"
        )) {
            if(rs4.next()){
                lblPendingOrders.setText(rs4.getString("total"));
            }
        }

    }catch(Exception e){
        e.printStackTrace();
    }

}

public void loadRecentActivity() {

    String userType = jComboBox1.getSelectedItem().toString();

    String sql =
    "SELECT a.type AS User, l.action AS Action, l.date_time AS Time " +
    "FROM tbl_logs l " +
    "JOIN tbl_accounts a ON l.user_id = a.U_id ";

    if(!userType.equals("All")){
        sql += "WHERE a.type = ? ";
    }

    sql += "ORDER BY l.date_time DESC";

    try {

        PreparedStatement pst = conn.prepareStatement(sql);

        if(!userType.equals("All")){
            pst.setString(1, userType);
        }

        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) tbl_logs.getModel();

        model.setRowCount(0);

        SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat displayFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a");

        while(rs.next()){

            java.util.Date date = dbFormat.parse(rs.getString("Time"));

            model.addRow(new Object[]{
                rs.getString("User"),
                rs.getString("Action"),
                displayFormat.format(date)
            });

        }

    } catch(Exception e){
        e.printStackTrace();
    }
}
 
public void loadRecentActivityByDate(String dateFrom, String dateTo){

    String userType = jComboBox1.getSelectedItem().toString();

    String sql =
    "SELECT a.type AS User, l.action AS Action, l.date_time AS Time " +
    "FROM tbl_logs l " +
    "JOIN tbl_accounts a ON l.user_id = a.U_id " +
    "WHERE date(l.date_time) BETWEEN ? AND ? ";

    if(!userType.equals("All")){
        sql += "AND a.type = ? ";
    }

    sql += "ORDER BY l.date_time DESC";

    try {

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, dateFrom);
        pst.setString(2, dateTo);

        if(!userType.equals("All")){
            pst.setString(3, userType);
        }

        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) tbl_logs.getModel();

        model.setRowCount(0);

        SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat displayFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a");

        while(rs.next()){

            java.util.Date date = dbFormat.parse(rs.getString("Time"));

            model.addRow(new Object[]{
                rs.getString("User"),
                rs.getString("Action"),
                displayFormat.format(date)
            });

        }

    } catch(Exception e){
        e.printStackTrace();
    }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblOrdersToday2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblRevenueToday = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblCustomers = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblPendingOrders = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServiceStats = new javax.swing.JTable();
        recentActivityPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_logs = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        showbtn = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("TOTAL ORDERS");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("TODAY");

        lblOrdersToday2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblOrdersToday2.setText("0");
        lblOrdersToday2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrdersToday2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblOrdersToday2)
                        .addGap(52, 52, 52)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOrdersToday2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 130));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("REVENUE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText(" TODAY");

        lblRevenueToday.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRevenueToday.setText("0");
        lblRevenueToday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRevenueTodayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRevenueToday)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblRevenueToday, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 150, 130));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("TOTAL CUSTOMERS");

        lblCustomers.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCustomers.setText("0");
        lblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCustomersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblCustomers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(lblCustomers)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 150, 130));

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("PENDING ORDERS");

        lblPendingOrders.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPendingOrders.setText("0");
        lblPendingOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPendingOrdersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblPendingOrders)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(lblPendingOrders)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 150, 130));

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblServiceStats.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblServiceStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Service Type", "Orders This Month", "Orders This Year"
            }
        ));
        tblServiceStats.setGridColor(new java.awt.Color(0, 0, 0));
        tblServiceStats.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tblServiceStats);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 580, 180));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 620, 220));

        recentActivityPanel.setBackground(new java.awt.Color(255, 255, 255));
        recentActivityPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(recentActivityPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 840, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setText("System Activity Logs");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        tbl_logs.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbl_logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User", "Action", "Date / Time"
            }
        ));
        jScrollPane3.setViewportView(tbl_logs);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 690, 200));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel2.setText("Date From:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel3.setText("Date To:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, -1, 30));

        search.setBackground(new java.awt.Color(102, 153, 255));
        search.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        search.setText("Filter");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 100, 40));

        showbtn.setBackground(new java.awt.Color(102, 153, 255));
        showbtn.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        showbtn.setText("Show All");
        showbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showbtnActionPerformed(evt);
            }
        });
        jPanel2.add(showbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 100, 40));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 130, 30));
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 600, 130, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Most Ordered Services");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel5.setText("User Type:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 90, 30));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Admin", "Staff" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 80, 30));

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblOrdersToday2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrdersToday2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOrdersToday2MouseClicked

    private void lblRevenueTodayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRevenueTodayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRevenueTodayMouseClicked

    private void lblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCustomersMouseClicked

    private void lblPendingOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPendingOrdersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPendingOrdersMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if(jDateChooser1.getDate() == null || jDateChooser2.getDate() == null){
        javax.swing.JOptionPane.showMessageDialog(null,"Please select both dates.");
        return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    String dateFrom = sdf.format(jDateChooser1.getDate());
    String dateTo = sdf.format(jDateChooser2.getDate());

    loadRecentActivityByDate(dateFrom, dateTo);
    }//GEN-LAST:event_searchActionPerformed

    private void showbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showbtnActionPerformed
    jDateChooser1.setDate(null);
    jDateChooser2.setDate(null);

    jComboBox1.setSelectedItem("All"); 

    loadRecentActivity();
    }//GEN-LAST:event_showbtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        loadRecentActivity();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCustomers;
    private javax.swing.JLabel lblOrdersToday2;
    private javax.swing.JLabel lblPendingOrders;
    private javax.swing.JLabel lblRevenueToday;
    private javax.swing.JPanel recentActivityPanel;
    private javax.swing.JButton search;
    private javax.swing.JButton showbtn;
    private javax.swing.JTable tblServiceStats;
    private javax.swing.JTable tbl_logs;
    // End of variables declaration//GEN-END:variables
}
