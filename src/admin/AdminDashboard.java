

package admin;

import Main.NewJFrame;
import config.LogService;
import config.Session;
import config.config;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import admin.Customer;
import staff.Orders;
import staff.ProfilePanel;



public class AdminDashboard extends javax.swing.JFrame {
    

private int loggedInUserId;


public AdminDashboard(int userId) {
    if (!Session.isLoggedIn()) {
        JOptionPane.showMessageDialog(null, "Login First!");

        new NewJFrame().setVisible(true);

        dispose();   
        return;
    }

    this.loggedInUserId = userId;
    initComponents();
    
    dashboard dash = new dashboard();

    jPanel2.removeAll();
    jPanel2.setLayout(new BorderLayout());
    jPanel2.add(dash, BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
    }


private void showPanel(javax.swing.JPanel panel) {
    jPanel2.removeAll();
    jPanel2.setLayout(new BorderLayout());
    jPanel2.add(panel, BorderLayout.CENTER);
    jPanel2.revalidate();
    jPanel2.repaint();
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
        dashboard = new javax.swing.JButton();
        orders = new javax.swing.JButton();
        customers = new javax.swing.JButton();
        services = new javax.swing.JButton();
        users = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        reports = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(960, 650));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Laundry Shop Management System");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin Dashboard");

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

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 800, 590));

        dashboard.setBackground(new java.awt.Color(153, 204, 255));
        dashboard.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dashboard icon (2).png"))); // NOI18N
        dashboard.setText(" Dashboard");
        dashboard.setBorderPainted(false);
        dashboard.setContentAreaFilled(false);
        dashboard.setPreferredSize(new java.awt.Dimension(99, 30));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardMouseExited(evt);
            }
        });
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });
        jPanel3.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, 60));

        orders.setBackground(new java.awt.Color(153, 204, 255));
        orders.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        orders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orders icon (1).png"))); // NOI18N
        orders.setText(" Orders");
        orders.setBorderPainted(false);
        orders.setContentAreaFilled(false);
        orders.setPreferredSize(new java.awt.Dimension(99, 30));
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });
        jPanel3.add(orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 160, 180, 50));

        customers.setBackground(new java.awt.Color(153, 204, 255));
        customers.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customers icon (1).png"))); // NOI18N
        customers.setText(" Customers");
        customers.setBorderPainted(false);
        customers.setContentAreaFilled(false);
        customers.setPreferredSize(new java.awt.Dimension(99, 30));
        customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersActionPerformed(evt);
            }
        });
        jPanel3.add(customers, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 200, 190, 100));

        services.setBackground(new java.awt.Color(153, 204, 255));
        services.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/services icon (2).png"))); // NOI18N
        services.setText("  Services");
        services.setBorderPainted(false);
        services.setContentAreaFilled(false);
        services.setPreferredSize(new java.awt.Dimension(99, 30));
        services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesActionPerformed(evt);
            }
        });
        jPanel3.add(services, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 340, 170, 70));

        users.setBackground(new java.awt.Color(153, 204, 255));
        users.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/staff icon (1).png"))); // NOI18N
        users.setText("Users");
        users.setBorderPainted(false);
        users.setContentAreaFilled(false);
        users.setPreferredSize(new java.awt.Dimension(99, 30));
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });
        jPanel3.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 440, 200, 110));

        payment.setBackground(new java.awt.Color(153, 204, 255));
        payment.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/download (3) (1) (1).png"))); // NOI18N
        payment.setText(" Payment");
        payment.setBorderPainted(false);
        payment.setContentAreaFilled(false);
        payment.setPreferredSize(new java.awt.Dimension(99, 30));
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });
        jPanel3.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 260, 190, 100));

        logout.setBackground(new java.awt.Color(153, 204, 255));
        logout.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout icon (1).png"))); // NOI18N
        logout.setText(" LogOut");
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setPreferredSize(new java.awt.Dimension(99, 30));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 580, 180, 80));

        Account.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/acc (4).png"))); // NOI18N
        Account.setText(" Account");
        Account.setContentAreaFilled(false);
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });
        jPanel3.add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 520, 160, 70));

        reports.setBackground(new java.awt.Color(153, 204, 255));
        reports.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reports icon (1).png"))); // NOI18N
        reports.setText(" Reports");
        reports.setBorderPainted(false);
        reports.setContentAreaFilled(false);
        reports.setPreferredSize(new java.awt.Dimension(99, 30));
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsMouseExited(evt);
            }
        });
        reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsActionPerformed(evt);
            }
        });
        jPanel3.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 410, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
    jLabel3.setText("Order Management");

    Order ordersPanel = new Order(this);

    jPanel2.removeAll();
    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(ordersPanel, java.awt.BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_ordersActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
    jLabel3.setText("Admin Dashboard");

    dashboard dashboardPanel = new dashboard();

    jPanel2.removeAll();
    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(dashboardPanel, java.awt.BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_dashboardActionPerformed

    private void servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesActionPerformed
    jLabel3.setText("Service Management");
    jLabel3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));

    jPanel2.removeAll();

    Services servicesPanel = new Services();

    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(servicesPanel, java.awt.BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_servicesActionPerformed

    private void customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersActionPerformed
     Customer c = new Customer(this);

    
    jLabel3.setText("Customer Management");
    jPanel2.removeAll();
    jPanel2.add(c);
    c.setSize(jPanel2.getSize());
    c.setVisible(true);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_customersActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
    jLabel3.setText("Payment Management");

    Payment panel = new Payment();

    showPanel(panel);        
    }//GEN-LAST:event_paymentActionPerformed

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
       
    
    jLabel3.setText("User Management");
    jLabel3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));

    
    jPanel2.removeAll();

    Users users = new Users();

    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.add(users, java.awt.BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
        
    }//GEN-LAST:event_usersActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
   int choice = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Logout Confirmation",
        JOptionPane.YES_NO_OPTION
    );

    if (choice == JOptionPane.YES_OPTION) {
        LogService.logAction(loggedInUserId, "Logged Out");
        Session.destroySession(); 
        new NewJFrame().setVisible(true); 
        this.dispose(); 
        
    }
    }//GEN-LAST:event_logoutActionPerformed

    private void dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseEntered

    }//GEN-LAST:event_dashboardMouseEntered

    private void dashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseExited
       
    }//GEN-LAST:event_dashboardMouseExited

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
    jLabel3.setText("Account Settings");

    jPanel2.removeAll();

    ProfilePanel profilePanel = new ProfilePanel(loggedInUserId);

    jPanel2.setLayout(new BorderLayout());
    jPanel2.add(profilePanel, BorderLayout.CENTER);

    jPanel2.revalidate();
    jPanel2.repaint();
    }//GEN-LAST:event_AccountActionPerformed

    private void reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reportsMouseEntered

    private void reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_reportsMouseExited

    private void reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsActionPerformed
        jLabel3.setText("");
        
        ReportsPanel reportsPanel = new ReportsPanel();
        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(reportsPanel, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_reportsActionPerformed

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardMouseClicked

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AdminDashboard(0).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton customers;
    private javax.swing.JButton dashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logout;
    private javax.swing.JButton orders;
    private javax.swing.JButton payment;
    private javax.swing.JButton reports;
    private javax.swing.JButton services;
    private javax.swing.JButton users;
    // End of variables declaration//GEN-END:variables
}
