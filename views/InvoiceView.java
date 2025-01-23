/*
 */
package red_star_autos_software.views;

import red_star_autos_software.classes.Log;
import red_star_autos_software.classes.User;
import red_star_autos_software.forms.GenerateInvoice;
import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.forms.UpdateInvoice;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.ViewHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.utils.StyleSetting;

/**
 *
 * @author joe
 */
public class InvoiceView extends javax.swing.JPanel {
    javax.swing.table.DefaultTableModel tableModel;
    private final User USER;
    private final ViewHandler VHANDLER;
    /**
     * Creates new view panel (Customers View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public InvoiceView(User user, ViewHandler viewHandler) {
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
        
        buttons.add(btnGenerateInvoice);        
        buttons.add(btnUpdateInvoice);
        buttons.add(btnDeleteInvoice);
        
        StyleSetting.applyButtonStyles(buttons, btnGenerateInvoice.getBackground(), btnGenerateInvoice.getBorder());
        
    }
    
    public void populate(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM invoices");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            for(int i = 0; i < resMd.getColumnCount(); i++){
                tableModel.addColumn(resMd.getColumnLabel(i+1));
            }
            while(res.next()){
                java.time.LocalDateTime payTimestamp = res.getTimestamp("invoice_pay_date").toLocalDateTime();
                java.time.LocalDateTime nextPayTimestamp = res.getTimestamp("invoice_next_pay_date").toLocalDateTime();
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy @ HH:mm:ss");
                String formattedPay = payTimestamp.format(formatter);
                String formattedNext = nextPayTimestamp.format(formatter);
                tableModel.addRow(new Object[]{res.getInt("invoice_id"), res.getInt("job_id"), res.getInt("customer_id"), res.getFloat("invoice_owed"), res.getFloat("invoice_paid"), res.getString("invoice_freq"), res.getInt("invoice_method"), formattedPay, formattedNext, res.getString("invoice_status")});
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
        btnGenerateInvoice = new javax.swing.JButton();
        btnUpdateInvoice = new javax.swing.JButton();
        btnDeleteInvoice = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(876, 367));
        setMinimumSize(new java.awt.Dimension(876, 367));
        setName(""); // NOI18N

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

        btnGenerateInvoice.setBackground(new java.awt.Color(204, 204, 204));
        btnGenerateInvoice.setForeground(new java.awt.Color(102, 102, 102));
        btnGenerateInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/money_add.png"))); // NOI18N
        btnGenerateInvoice.setText("Generate Invoice");
        btnGenerateInvoice.setToolTipText("");
        btnGenerateInvoice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnGenerateInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateInvoiceActionPerformed(evt);
            }
        });

        btnUpdateInvoice.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateInvoice.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/pencil.png"))); // NOI18N
        btnUpdateInvoice.setText("Update Invoice");
        btnUpdateInvoice.setToolTipText("");
        btnUpdateInvoice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnUpdateInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateInvoiceActionPerformed(evt);
            }
        });

        btnDeleteInvoice.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteInvoice.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/delete.png"))); // NOI18N
        btnDeleteInvoice.setText("Delete Invoice");
        btnDeleteInvoice.setToolTipText("");
        btnDeleteInvoice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnUpdateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateInvoiceActionPerformed
        FormHandler.openPopup(new GenerateInvoice(USER, VHANDLER, this));
    }//GEN-LAST:event_btnGenerateInvoiceActionPerformed

    private void btnUpdateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateInvoiceActionPerformed
        FormHandler.openPopup(new UpdateInvoice(USER, VHANDLER, this));
    }//GEN-LAST:event_btnUpdateInvoiceActionPerformed

    private void btnDeleteInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteInvoiceActionPerformed
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r,0);
            if(DatabaseManager.Delete("DELETE FROM invoices WHERE invoice_id = ?", new Object[]{id})){
                FormHandler.openMessageBox(new MessageBox("Success!", "Successfully deleted invocie!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                InvoiceView i = new InvoiceView(USER,VHANDLER);
                VHANDLER.changeView(i, (javax.swing.JPanel) this.getParent());
                i.populate();
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted an invoice", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete an invoice", USER.getId()).send();
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected an invoice!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnDeleteInvoiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteInvoice;
    private javax.swing.JButton btnGenerateInvoice;
    private javax.swing.JButton btnUpdateInvoice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
