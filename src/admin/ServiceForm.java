
package admin;

import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class ServiceForm extends javax.swing.JFrame {


    public ServiceForm() {
        initComponents();
    }

    public int updateId = -1;
    String originalName;
    int originalPrice;
    String originalStatus;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sname = new javax.swing.JLabel();
        sprice = new javax.swing.JLabel();
        sstat = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        savebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("SERVICES FORM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 81));

        sname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sname.setText("Service Name :");
        jPanel1.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 160, 170, -1));

        sprice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sprice.setText("Price :");
        jPanel1.add(sprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        sstat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sstat.setText("Status :");
        jPanel1.add(sstat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("Active");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 90, 30));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("Inactive");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

        savebtn.setBackground(new java.awt.Color(255, 255, 255));
        savebtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        jPanel1.add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 128, 56));

        cancelbtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelbtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 128, 56));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 310, 50));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 310, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed

 
    String name = jTextField1.getText();
    String priceText = jTextField2.getText();
    String status = jRadioButton1.isSelected() ? "Active" : "Inactive";

    if (name.isEmpty() || priceText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.");
        return;
    }

    int price;
    try {
        price = Integer.parseInt(priceText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Price must be a whole number.");
        return;
    }


    if (updateId != -1) {
        if (name.equals(originalName) && price == originalPrice && status.equals(originalStatus)) {
            JOptionPane.showMessageDialog(this, "No changes detected.");
            return; 
        }
    }

    try (Connection conn = config.connectDB()) {
        PreparedStatement ps;

        if (updateId == -1) {
            
            String sql = "INSERT INTO tbl_services(service_name, service_price, service_status) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, status);
        } else {
           
            String sql = "UPDATE tbl_services SET service_name=?, service_price=?, service_status=? WHERE S_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, status);
            ps.setInt(4, updateId);
        }

        ps.executeUpdate();

        if (updateId == -1) {
            LogService.logAction(Session.getInstance().getId(), "Added Service: " + name);
        } else {
            LogService.logAction(Session.getInstance().getId(), "Updated Service: " + name);
        }

        JOptionPane.showMessageDialog(this, "Saved Successfully!");
        this.dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    
    }//GEN-LAST:event_savebtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed

        this.dispose();
        
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ServiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JRadioButton jRadioButton2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    private javax.swing.JButton savebtn;
    private javax.swing.JLabel sname;
    private javax.swing.JLabel sprice;
    private javax.swing.JLabel sstat;
    // End of variables declaration//GEN-END:variables
}
