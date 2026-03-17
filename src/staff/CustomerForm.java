
package staff;

import config.LogService;
import config.Session;
import config.config;
import javax.swing.JOptionPane;


public class CustomerForm extends javax.swing.JFrame {


    private int customerId = 0;
    private String oldName, oldPhone, oldAddress;
    private boolean updateMode = false;

    public Customers customersPanel;
    
    
public CustomerForm() {

    initComponents();

}

    
public CustomerForm(Customers customersPanel) {

    initComponents();

    this.customersPanel = customersPanel;

}

public CustomerForm(Customers customersPanel, int id, String name, String phone, String address) {

    initComponents();

    this.customersPanel = customersPanel;

    customerId = id;

    txtName.setText(name);
    txtPhone.setText(phone);
    txtAddress.setText(address);

    oldName = name;
    oldPhone = phone;
    oldAddress = address;

    updateMode = true;

    jLabel1.setText("Update Customer");

}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cname = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cphone = new javax.swing.JLabel();
        caddress = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText(" Customer Form");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        cname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cname.setText("Name :");
        jPanel1.add(cname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 149, -1, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 320, 50));

        cphone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cphone.setText("Phone :");
        jPanel1.add(cphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 239, -1, 40));

        caddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caddress.setText("Address :");
        jPanel1.add(caddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 320, 50));

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 128, 56));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 128, 56));

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 320, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    String name = txtName.getText();
    String phone = txtPhone.getText();
    String address = txtAddress.getText();

    if(name.isEmpty() || phone.isEmpty() || address.isEmpty()){

        JOptionPane.showMessageDialog(this,"Please fill all fields");

        return;

    }

    try{

        config conf = new config();

        java.sql.Connection conn = conf.connectDB();

        java.sql.PreparedStatement pst;

        if(updateMode == false){

            pst = conn.prepareStatement(
            "INSERT INTO tbl_customers (C_name,C_phone,address) VALUES (?,?,?)"
            );

            pst.setString(1,name);
            pst.setString(2,phone);
            pst.setString(3,address);

            pst.executeUpdate();

            LogService.logAction(Session.getInstance().getId(), "Added Customer: " + name);

            JOptionPane.showMessageDialog(this,"Customer Added Successfully");

        }

        else{

            if(name.equals(oldName) &&
               phone.equals(oldPhone) &&
               address.equals(oldAddress)){

                JOptionPane.showMessageDialog(this,"No changes detected");

                return;

            }

            pst = conn.prepareStatement(
            "UPDATE tbl_customers SET C_name=?,C_phone=?,address=? WHERE C_id=?"
            );

            pst.setString(1,name);
            pst.setString(2,phone);
            pst.setString(3,address);
            pst.setInt(4,customerId);

            pst.executeUpdate();

            LogService.logAction(Session.getInstance().getId(), "Updated Customer: " + name);

            JOptionPane.showMessageDialog(this,"Customer Updated Successfully");

        }

        if (customersPanel != null) {
        customersPanel.loadCustomers();
        }

        if (customersPanel != null && customersPanel.dashboard != null) {
        customersPanel.dashboard.setVisible(true);
        }

        conn.close();
        this.dispose();


    }

    catch(Exception e){

        JOptionPane.showMessageDialog(this,e);

    }
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

if(customersPanel.dashboard != null) {
    customersPanel.dashboard.setVisible(true);
}
this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel caddress;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel cname;
    private javax.swing.JLabel cphone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
