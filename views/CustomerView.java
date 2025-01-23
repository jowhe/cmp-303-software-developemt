/*
 */
package red_star_autos_software.views;

import red_star_autos_software.classes.Log;
import red_star_autos_software.classes.User;
import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.forms.InsertCustomer;
import red_star_autos_software.forms.UpdateCustomer;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.ViewHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.utils.StyleSetting;

/**
 *
 * @author joe
 */
public class CustomerView extends javax.swing.JPanel {
    javax.swing.table.DefaultTableModel tableModel;
    private final User USER;
    private final ViewHandler VHANDLER;
    /**
     * Creates new view panel (Customers View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public CustomerView(User user, ViewHandler viewHandler) {
        initComponents();
        this.USER = user;
        this.VHANDLER = viewHandler;
        tableModel = new javax.swing.table.DefaultTableModel();
        this.jTable1.setModel(tableModel);
        this.jTable1.setGridColor(new java.awt.Color(102,102,102));
        this.jTable1.getTableHeader().setBackground(new java.awt.Color(164,164,164));
        this.jTable1.getTableHeader().setBorder(null);
        this.jScrollPane1.getViewport().setBackground(new java.awt.Color(164,164,164));
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        
        buttons.add(btnEditCustomer);        
        buttons.add(btnDeleteCustomer);
        buttons.add(btnInsertCustomer);
        
        StyleSetting.applyButtonStyles(buttons, btnEditCustomer.getBackground(), btnEditCustomer.getBorder());
    }
    
    public void populate(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM customers");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            for(int i = 0; i < resMd.getColumnCount(); i++){
                tableModel.addColumn(resMd.getColumnLabel(i+1));
            }
            while(res.next()){
                tableModel.addRow(new Object[]{res.getInt("customer_id"), res.getString("customer_surname"), res.getString("customer_email"), res.getString("customer_tel")});
            }
            
            DatabaseManager.Disconnect();
        }catch(java.sql.SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDeleteCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnInsertCustomer = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(876, 367));
        setMinimumSize(new java.awt.Dimension(876, 367));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 621));

        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(450, 400));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnDeleteCustomer.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/group_delete.png"))); // NOI18N
        btnDeleteCustomer.setText("Delete Customer");
        btnDeleteCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnEditCustomer.setBackground(new java.awt.Color(204, 204, 204));
        btnEditCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user_edit.png"))); // NOI18N
        btnEditCustomer.setText("Edit Customer");
        btnEditCustomer.setToolTipText("");
        btnEditCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnEditCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnInsertCustomer.setBackground(new java.awt.Color(204, 204, 204));
        btnInsertCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnInsertCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user_add.png"))); // NOI18N
        btnInsertCustomer.setText("Insert Customer");
        btnInsertCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnInsertCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        if(jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            Integer id = (int) this.jTable1.getValueAt(r,0);
            
            System.out.println("Selected Employee: " + id);
            
            if(DatabaseManager.Delete("DELETE FROM customers WHERE customer_id = ?", new Object[]{id})){
                java.sql.ResultSet rows = DatabaseManager.Query("SELECT COUNT(*) FROM customers");
                try {
                    // && DatabaseManager.Execute("ALTER TABLE customers AUTO_INCREMENT = ?", new Object[]{rows.getInt(1)})
                    if(rows.next()){
                        FormHandler.openMessageBox(new MessageBox("Success!", "Customer successfully deleted!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                        CustomerView cView = new CustomerView(USER, VHANDLER);
                        VHANDLER.changeView(cView, this);
                        cView.populate();
                    }
                } catch (java.sql.SQLException e) {
                    FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
                }
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted a customer", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete a customer", USER.getId()).send();
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected any customer!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        if(jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            Integer id = (int) this.jTable1.getValueAt(r,0);
            
            System.out.println("Selected Employee: " + id);
            
            FormHandler.openPopup(new UpdateCustomer(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), id));
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected any customer!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnInsertCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCustomerActionPerformed
        FormHandler.openPopup(new InsertCustomer(USER, VHANDLER, this));
    }//GEN-LAST:event_btnInsertCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnInsertCustomer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
