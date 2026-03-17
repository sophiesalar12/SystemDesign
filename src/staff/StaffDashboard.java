
package staff;


import Main.NewJFrame;
import admin.Services;
import config.LogService;
import config.Session;
import config.config;
import javax.swing.JOptionPane;


public class StaffDashboard extends javax.swing.JFrame {

private int userId;
private javax.swing.JPanel currentPanel;


public StaffDashboard(int userId) {

    if (!Session.isLoggedIn()) {
        JOptionPane.showMessageDialog(null, "Login Required!");
        new NewJFrame().setVisible(true);
        this.dispose();
        return;
    }

    this.userId = userId;

    initComponents();

    String name = Session.getInstance().getname();
    showPanel(new Dashboard(userId, name));

}

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sdashboard = new javax.swing.JButton();
        sorders = new javax.swing.JButton();
        customerinfo = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        slogout = new javax.swing.JButton();
        services2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(960, 650));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Laundry Shop Management System");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setText("Staff Dashboard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(88, 88, 88)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 800, 580));

        sdashboard.setBackground(new java.awt.Color(153, 204, 255));
        sdashboard.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sdashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dashboard icon (2).png"))); // NOI18N
        sdashboard.setText("  Dashboard");
        sdashboard.setBorderPainted(false);
        sdashboard.setContentAreaFilled(false);
        sdashboard.setPreferredSize(new java.awt.Dimension(99, 30));
        sdashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdashboardActionPerformed(evt);
            }
        });
        jPanel3.add(sdashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 100, 190, 50));

        sorders.setBackground(new java.awt.Color(153, 204, 255));
        sorders.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sorders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orders icon (1).png"))); // NOI18N
        sorders.setText(" Orders");
        sorders.setBorderPainted(false);
        sorders.setContentAreaFilled(false);
        sorders.setPreferredSize(new java.awt.Dimension(99, 30));
        sorders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sordersActionPerformed(evt);
            }
        });
        jPanel3.add(sorders, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 170, 160, 50));

        customerinfo.setBackground(new java.awt.Color(153, 204, 255));
        customerinfo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        customerinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customers icon (1).png"))); // NOI18N
        customerinfo.setText(" Customers");
        customerinfo.setBorderPainted(false);
        customerinfo.setContentAreaFilled(false);
        customerinfo.setPreferredSize(new java.awt.Dimension(99, 30));
        customerinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerinfoActionPerformed(evt);
            }
        });
        jPanel3.add(customerinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 370, 230, 70));

        payment.setBackground(new java.awt.Color(153, 204, 255));
        payment.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/download (3) (1) (1).png"))); // NOI18N
        payment.setText("  Payment");
        payment.setBorderPainted(false);
        payment.setContentAreaFilled(false);
        payment.setPreferredSize(new java.awt.Dimension(99, 30));
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });
        jPanel3.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 240, 260, 50));

        profile.setBackground(new java.awt.Color(153, 204, 255));
        profile.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/staff icon (1).png"))); // NOI18N
        profile.setText("Profile");
        profile.setBorderPainted(false);
        profile.setContentAreaFilled(false);
        profile.setPreferredSize(new java.awt.Dimension(99, 30));
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel3.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 420, 170, 100));

        slogout.setBackground(new java.awt.Color(153, 204, 255));
        slogout.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        slogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout icon (1).png"))); // NOI18N
        slogout.setText(" LogOut");
        slogout.setBorderPainted(false);
        slogout.setContentAreaFilled(false);
        slogout.setPreferredSize(new java.awt.Dimension(99, 30));
        slogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slogoutActionPerformed(evt);
            }
        });
        jPanel3.add(slogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 140, 100));

        services2.setBackground(new java.awt.Color(153, 204, 255));
        services2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        services2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/services icon (2).png"))); // NOI18N
        services2.setText("  Services");
        services2.setBorderPainted(false);
        services2.setContentAreaFilled(false);
        services2.setPreferredSize(new java.awt.Dimension(99, 30));
        services2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                services2ActionPerformed(evt);
            }
        });
        jPanel3.add(services2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void sdashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdashboardActionPerformed
    String name = Session.getInstance().getname();
    Dashboard dash = new Dashboard(userId, name);

    jPanel2.removeAll();
    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(dash, java.awt.BorderLayout.CENTER);
    jPanel2.revalidate();
    jPanel2.repaint();

    }//GEN-LAST:event_sdashboardActionPerformed

    private void sordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sordersActionPerformed
    jLabel3.setText("Orders");

    Orders ordersPanel = new Orders(this);

    jPanel2.removeAll();
    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(ordersPanel, java.awt.BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_sordersActionPerformed

    private void customerinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerinfoActionPerformed
        
    Customers c = new Customers(this);

    
    jLabel3.setText("Customer Management");
    jPanel2.removeAll();
    jPanel2.add(c);
    c.setSize(jPanel2.getSize());
    c.setVisible(true);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_customerinfoActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
    jLabel3.setText("Payment Management");

    PaymentPanel panel = new PaymentPanel();

    showPanel(panel);
    }//GEN-LAST:event_paymentActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
            ProfilePanel profilePanel = new ProfilePanel(userId);  
            jLabel3.setText("My Profile");
            showPanel(profilePanel);  
    }//GEN-LAST:event_profileActionPerformed

    private void showPanel(javax.swing.JPanel panel) {
    currentPanel = panel;        
    jPanel2.removeAll();
    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(panel, java.awt.BorderLayout.CENTER);
    jPanel2.revalidate();
    jPanel2.repaint();
    }

    private void slogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Logout Confirmation",
        JOptionPane.YES_NO_OPTION
    );

    if (choice == JOptionPane.YES_OPTION) {
        LogService.logAction(userId, "Logged Out");
        Session.destroySession(); 
        NewJFrame login = new NewJFrame();
        login.setVisible(true);

        
        this.dispose();
    }
    
    
    }//GEN-LAST:event_slogoutActionPerformed

    private void services2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_services2ActionPerformed
        jLabel3.setText("");

        jPanel2.removeAll();

        ServicesPanel services = new ServicesPanel();

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(services, java.awt.BorderLayout.CENTER);

        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_services2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffDashboard(0).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customerinfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton payment;
    private javax.swing.JButton profile;
    private javax.swing.JButton sdashboard;
    private javax.swing.JButton services2;
    private javax.swing.JButton slogout;
    private javax.swing.JButton sorders;
    // End of variables declaration//GEN-END:variables
}
