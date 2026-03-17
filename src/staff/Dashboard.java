

package staff;


import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class Dashboard extends javax.swing.JPanel {

private int userId;

public Dashboard(int userId) {
    initComponents();
    this.userId = userId;

    try (Connection conn = new config().connectDB()) {
        loadCounts(conn);
        loadPendingOrders(conn);
    } catch (Exception e) {
        e.printStackTrace();
    }

    startClock();
}
public Dashboard(int uid, String name) {
    initComponents();

    this.userId = uid;

    lblWelcome.setText("Welcome, " + name + "!");

    loadAllDashboardData();

    startClock();
}

private void startClock() {
    Date d = new Date();
    SimpleDateFormat sdfDate = new SimpleDateFormat("MMMM dd, yyyy");
    SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss a");

    lblDate.setText(sdfDate.format(d));
    lblTime.setText(sdfTime.format(d));

    Timer t = new Timer(1000, e -> {
        Date now = new Date();
        lblDate.setText(sdfDate.format(now));
        lblTime.setText(sdfTime.format(now));
    });

    t.start();
}

private void loadAllDashboardData() {
    try (Connection conn = new config().connectDB()) {
        loadCounts(conn);
        loadPendingOrders(conn);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadCounts(Connection conn) {
    try {
        String sqlTotal = "SELECT COUNT(*) FROM tbl_orders";
        String sqlCompleted = "SELECT COUNT(*) FROM tbl_orders WHERE O_status='Completed'";
        String sqlPending = "SELECT COUNT(*) FROM tbl_orders WHERE O_status='Pending'";

        try (PreparedStatement pst = conn.prepareStatement(sqlTotal);
             ResultSet rs = pst.executeQuery()) {
            if(rs.next()) lblTotal.setText(rs.getString(1));
        }

        try (PreparedStatement pst = conn.prepareStatement(sqlCompleted);
             ResultSet rs = pst.executeQuery()) {
            if(rs.next()) lblCompleted.setText(rs.getString(1));
        }

        try (PreparedStatement pst = conn.prepareStatement(sqlPending);
             ResultSet rs = pst.executeQuery()) {
            if(rs.next()) lblPending.setText(rs.getString(1));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadPendingOrders(Connection conn) {
    lblTableTitle.setText("Pending Orders - Action Required");

    String sql = 
        "SELECT o.O_id, c.C_name, s.service_name, o.O_status " +
        "FROM tbl_orders o " +
        "JOIN tbl_customers c ON o.C_id = c.C_id " +
        "JOIN tbl_services s ON o.S_id = s.S_id " +
        "WHERE o.O_status = 'Pending'";

    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new String[]{
        "Order ID", "Customer", "Service", "Status"
    });

    try (PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while(rs.next()){
            model.addRow(new Object[]{
                rs.getInt("O_id"),
                rs.getString("C_name"),
                rs.getString("service_name"),
                rs.getString("O_status")
            });
        }
        tblOrders.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadAllOrders(){

    lblTableTitle.setText("Total Orders Today");

    loadTable("SELECT * FROM tbl_orders");

}

private void loadCompletedOrders(){

    lblTableTitle.setText("Completed Orders Today");

    loadTable("SELECT * FROM tbl_orders WHERE O_status='Completed'");

}

private void loadTable(String sql){

    DefaultTableModel model = new DefaultTableModel();

    model.setColumnIdentifiers(new String[]{
        "Order ID",
        "Customer",
        "Service",
        "Status"
    });

    try{

        config conf = new config();
        Connection conn = conf.connectDB();

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while(rs.next()){

            model.addRow(new Object[]{

                rs.getInt("O_id"),
                rs.getString("C_id"),
                rs.getString("S_id"),
                rs.getString("O_status")

            });

        }

        tblOrders.setModel(model);

        conn.close();

    }
    catch(Exception e){

        System.out.println(e);

    }

}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCompleted = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPending = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblTableTitle = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblWelcome.setText("Welcome");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 36, -1, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDate.setText("DATE");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTime.setText("TIME");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("My Orders Today");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Active");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblTotal.setText("10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 140, 110));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Completed");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Today");

        lblCompleted.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblCompleted.setText("10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(lblCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(lblCompleted)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 140, 110));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Pending");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("In Queue");

        lblPending.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPending.setText("10");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(lblPending, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(lblPending)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 140, 110));

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOrders);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 670, 280));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        lblTableTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTableTitle.setText("Pending Orders - Action Required");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTableTitle)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTableTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 810, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        loadAllOrders();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
       loadCompletedOrders();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
    try (Connection conn = new config().connectDB()) {
        loadPendingOrders(conn);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jPanel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCompleted;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPending;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblOrders;
    // End of variables declaration//GEN-END:variables
}
