
package admin;

import config.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class ReportsPanel extends javax.swing.JPanel {


    public ReportsPanel() {
        initComponents();
        loadAllReports(); 
    }

public void generateReport(String dateFrom, String dateTo){

    try (Connection con = config.connectDB();
         Statement st = con.createStatement()) {

String sql =
"SELECT o.O_id, c.C_name, s.service_name, o.total_amount, o.order_date " +
"FROM tbl_orders o " +
"JOIN tbl_customers c ON o.C_id = c.C_id " +
"JOIN tbl_services s ON o.S_id = s.S_id " +
"WHERE o.order_date BETWEEN '"+dateFrom+"' AND '"+dateTo+"' " +
"AND o.P_status = 'Paid'";

        try (ResultSet rs = st.executeQuery(sql)) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            int totalOrders = 0;
            double totalRevenue = 0;

            while(rs.next()){

    int orderId = rs.getInt("O_id");
    String customer = rs.getString("C_name");
    String service = rs.getString("service_name");
    double amount = rs.getDouble("total_amount");
    String date = rs.getString("order_date");

                model.addRow(new Object[]{
                    orderId,
                    customer,
                    service,
                    amount,
                    date
                });

                totalOrders++;
                totalRevenue += amount;
            }

            lblTotalOrders.setText("Total Orders: " + totalOrders);
            lblTotalRevenue.setText("Total Revenue: ₱" + String.format("%,.2f", totalRevenue));
        }

    }catch(Exception e){
        e.printStackTrace();
    }

}

public void loadAllReports(){

    try (Connection con = config.connectDB();
         Statement st = con.createStatement()) {

        String sql =
        "SELECT o.O_id, c.C_name, s.service_name, o.total_amount, o.order_date " +
        "FROM tbl_orders o " +
        "JOIN tbl_customers c ON o.C_id = c.C_id " +
        "JOIN tbl_services s ON o.S_id = s.S_id " +
        "WHERE o.P_status = 'Paid'";

        try (ResultSet rs = st.executeQuery(sql)) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            int totalOrders = 0;
            double totalRevenue = 0;

            while(rs.next()){

                int orderId = rs.getInt("O_id");
                String customer = rs.getString("C_name");
                String service = rs.getString("service_name");
                double amount = rs.getDouble("total_amount");
                String date = rs.getString("order_date");

                model.addRow(new Object[]{
                    orderId,
                    customer,
                    service,
                    amount,
                    date
                });

                totalOrders++;
                totalRevenue += amount;
            }

            lblTotalOrders.setText("Total Orders: " + totalOrders);
            lblTotalRevenue.setText("Total Revenue: ₱" + String.format("%,.2f", totalRevenue));
        }

    }catch(Exception e){
        e.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        generatebtn = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTotalOrders = new javax.swing.JLabel();
        lblTotalRevenue = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        refresh = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("SALES REPORT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Date From:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Date To:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 80, -1));

        generatebtn.setBackground(new java.awt.Color(102, 153, 255));
        generatebtn.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        generatebtn.setText("Generate Report");
        generatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatebtnActionPerformed(evt);
            }
        });
        jPanel1.add(generatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 170, 40));

        printbtn.setBackground(new java.awt.Color(102, 153, 255));
        printbtn.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        printbtn.setText("Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });
        jPanel1.add(printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 100, 40));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Service", "Amount", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 720, 190));

        lblTotalOrders.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTotalOrders.setText("Total Orders: 0");
        jPanel1.add(lblTotalOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        lblTotalRevenue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTotalRevenue.setText("Total Revenue: ₱0");
        jPanel1.add(lblTotalRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, -1, 40));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 140, 30));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 140, 30));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        jPanel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatebtnActionPerformed
        if(jDateChooser1.getDate() == null || jDateChooser2.getDate() == null){
        JOptionPane.showMessageDialog(null,"Please select both dates.");
        return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    String dateFrom = sdf.format(jDateChooser1.getDate());
    String dateTo = sdf.format(jDateChooser2.getDate());

    generateReport(dateFrom, dateTo);
    }//GEN-LAST:event_generatebtnActionPerformed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        try{

        boolean complete = jTable1.print();

        if(complete){
            JOptionPane.showMessageDialog(null,"Printing Complete");
        }else{
            JOptionPane.showMessageDialog(null,"Printing Cancelled");
        }

    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_printbtnActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        loadAllReports(); 
    }//GEN-LAST:event_refreshMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generatebtn;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTotalOrders;
    private javax.swing.JLabel lblTotalRevenue;
    private javax.swing.JButton printbtn;
    private javax.swing.JLabel refresh;
    // End of variables declaration//GEN-END:variables
}
