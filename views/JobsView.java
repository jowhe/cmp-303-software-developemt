/*
 */
package red_star_autos_software.views;

import red_star_autos_software.classes.Log;
import red_star_autos_software.classes.User;
import red_star_autos_software.forms.InsertJob;
import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.forms.UpdateJob;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.ViewHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.utils.StyleSetting;

/**
 *
 * @author joe
 */
public class JobsView extends javax.swing.JPanel {
    javax.swing.table.DefaultTableModel tableModel;
    private final User USER;
    private final ViewHandler VHANDLER;
    /**
     * Creates new view panel (Jobs View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public JobsView(User user, ViewHandler viewHandler) {
        initComponents();
        this.USER = user;
        this.VHANDLER = viewHandler;
        tableModel = new javax.swing.table.DefaultTableModel();
        this.jTable1.setModel(tableModel);
        this.jTable1.setGridColor(new java.awt.Color(102,102,102));
        this.jTable1.getTableHeader().setBackground(new java.awt.Color(164,164,164));
        this.jTable1.getTableHeader().setBorder(null);
        this.jTable1.setSelectionBackground(new java.awt.Color(179, 200, 207));
        this.jScrollPane1.getViewport().setBackground(new java.awt.Color(164,164,164));
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        
        java.awt.Color btnBg = btnEditJob.getBackground();
        javax.swing.border.Border btnBorder = btnEditJob.getBorder();
        
        buttons.add(btnDeleteJob);
        buttons.add(btnEditJob);
        buttons.add(btnNewJob);
        buttons.add(btnViewTasks);
        
        StyleSetting.applyButtonStyles(buttons, btnBg, btnBorder);
        
        switch(USER.getRoleID()){
            case 3 -> {
                btnNewJob.setEnabled(false);
                btnDeleteJob.setEnabled(false);
            }
            case 4 -> {
                btnDeleteJob.setEnabled(false);
            }
        }
    }
    
    public void populate(){
        if(USER.getRoleID() != 3){
            java.sql.ResultSet res = DatabaseManager.Query("SELECT j.*, e.employee_forename AS supervisor_forename, e.employee_surname AS supervisor_surname, c.customer_surname, c.customer_email FROM jobs j JOIN employees e ON j.job_supervisor = e.employee_id JOIN customers c ON c.customer_id = j.customer_id");
            try{
                java.sql.ResultSetMetaData resMd = res.getMetaData();
                for(int i = 0; i < resMd.getColumnCount(); i++){
                    if(!resMd.getColumnLabel(i+1).equals("supervisor_forename") && 
                            !resMd.getColumnLabel(i+1).equals("supervisor_surname") &&
                            !resMd.getColumnLabel(i+1).equals("customer_surname") &&
                            !resMd.getColumnLabel(i+1).equals("customer_email")){
                        tableModel.addColumn(resMd.getColumnLabel(i+1));
                    }
                }
                while(res.next()){
                    java.time.LocalDateTime created_timestamp = res.getTimestamp("created_at").toLocalDateTime();
                    java.time.LocalDateTime updated_timestamp = res.getTimestamp("last_update").toLocalDateTime();
                    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy @ HH:mm:ss");
                    String formattedCreateTimestamp = created_timestamp.format(formatter);
                    String formattedUpdateTimestamp = updated_timestamp.format(formatter);
                    tableModel.addRow(new Object[]{res.getInt("job_id"), res.getString("job_description"), res.getString("job_notes"), res.getString("job_status"), res.getInt("job_supervisor") + " ("+res.getString("supervisor_forename")+ " " + res.getString("supervisor_surname") + ")", formattedCreateTimestamp, formattedUpdateTimestamp, res.getInt("customer_id") + " ("+ res.getString("customer_email")+")"});
                }
                DatabaseManager.Disconnect();
            }catch(java.sql.SQLException e){
                FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
            }
        }else{
            java.sql.ResultSet res = DatabaseManager.Query("SELECT j.*, s.employee_forename AS supervisor_forename, s.employee_surname AS supervisor_surname, c.customer_surname, c.customer_email FROM jobs j JOIN tasks t ON t.job_id = j.job_id JOIN employees e ON t.employee_id = e.employee_id JOIN employees s ON j.job_supervisor = s.employee_id JOIN customers c ON c.customer_id = j.customer_id WHERE e.employee_id = ?", new Object[]{USER.getId()});
            try{
                java.sql.ResultSetMetaData resMd = res.getMetaData();
                for(int i = 0; i < resMd.getColumnCount(); i++){
                    if(!resMd.getColumnLabel(i+1).equals("supervisor_forename") && 
                            !resMd.getColumnLabel(i+1).equals("supervisor_surname") &&
                            !resMd.getColumnLabel(i+1).equals("customer_surname") &&
                            !resMd.getColumnLabel(i+1).equals("customer_email") &&
                            !resMd.getColumnLabel(i+1).equals("customer_id")){
                        tableModel.addColumn(resMd.getColumnLabel(i+1));
                    }
                }
                while(res.next()){
                    java.time.LocalDateTime created_timestamp = res.getTimestamp("created_at").toLocalDateTime();
                    java.time.LocalDateTime updated_timestamp = res.getTimestamp("last_update").toLocalDateTime();
                    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy @ HH:mm:ss");
                    String formattedCreateTimestamp = created_timestamp.format(formatter);
                    String formattedUpdateTimestamp = updated_timestamp.format(formatter);
                    tableModel.addRow(new Object[]{res.getInt("job_id"), res.getString("job_description"), res.getString("job_notes"), res.getString("job_status"), res.getInt("job_supervisor") + " ("+res.getString("supervisor_forename")+ " " + res.getString("supervisor_surname") + ")", formattedCreateTimestamp, formattedUpdateTimestamp, res.getInt("customer_id") + " ("+ res.getString("customer_email")+")"});
                }

                DatabaseManager.Disconnect();
            }catch(java.sql.SQLException e){
                FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
            }
        }
    }
    
    public void populateComplete(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT j.*, e.employee_forename AS supervisor_forename, e.employee_surname AS supervisor_surname, c.customer_surname, c.customer_email FROM jobs j JOIN employees e ON j.job_supervisor = e.employee_id JOIN customers c ON c.customer_id = j.customer_id WHERE j.job_status = 'Completed'");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            
            for(int i = 0; i < resMd.getColumnCount(); i++){
                if(!resMd.getColumnLabel(i+1).equals("supervisor_forename") && 
                        !resMd.getColumnLabel(i+1).equals("supervisor_surname") &&
                        !resMd.getColumnLabel(i+1).equals("customer_surname") &&
                        !resMd.getColumnLabel(i+1).equals("customer_email") &&
                        !resMd.getColumnLabel(i+1).equals("customer_id")){
                    tableModel.addColumn(resMd.getColumnLabel(i+1));
                }
            }
            while(res.next()){
                java.time.LocalDateTime created_timestamp = res.getTimestamp("created_at").toLocalDateTime();
                java.time.LocalDateTime updated_timestamp = res.getTimestamp("last_update").toLocalDateTime();
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy @ HH:mm:ss");
                String formattedCreateTimestamp = created_timestamp.format(formatter);
                String formattedUpdateTimestamp = updated_timestamp.format(formatter);
                tableModel.addRow(new Object[]{res.getInt("job_id"), res.getString("job_description"), res.getString("job_notes"), res.getString("job_status"), res.getInt("job_supervisor") + " ("+res.getString("supervisor_forename")+ " " + res.getString("supervisor_surname") + ")", formattedCreateTimestamp, formattedUpdateTimestamp, res.getInt("customer_id") + " ("+ res.getString("customer_email")+")"});
            }

            DatabaseManager.Disconnect();
        }catch(java.sql.SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
        }
        checkboxCompleted.setSelected(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditJob = new javax.swing.JButton();
        btnViewTasks = new javax.swing.JButton();
        btnNewJob = new javax.swing.JButton();
        btnDeleteJob = new javax.swing.JButton();
        checkboxCompleted = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(876, 367));
        setMinimumSize(new java.awt.Dimension(876, 367));
        setName(""); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(null);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEditJob.setBackground(new java.awt.Color(204, 204, 204));
        btnEditJob.setForeground(new java.awt.Color(102, 102, 102));
        btnEditJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/table_edit.png"))); // NOI18N
        btnEditJob.setText("Edit Job");
        btnEditJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnEditJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditJobActionPerformed(evt);
            }
        });

        btnViewTasks.setBackground(new java.awt.Color(204, 204, 204));
        btnViewTasks.setForeground(new java.awt.Color(102, 102, 102));
        btnViewTasks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/table_go.png"))); // NOI18N
        btnViewTasks.setText("View Tasks");
        btnViewTasks.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnViewTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTasksActionPerformed(evt);
            }
        });

        btnNewJob.setBackground(new java.awt.Color(204, 204, 204));
        btnNewJob.setForeground(new java.awt.Color(102, 102, 102));
        btnNewJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/table_add.png"))); // NOI18N
        btnNewJob.setText("Insert Job");
        btnNewJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnNewJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewJobActionPerformed(evt);
            }
        });

        btnDeleteJob.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteJob.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/table_delete.png"))); // NOI18N
        btnDeleteJob.setText("Delete Job");
        btnDeleteJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJobActionPerformed(evt);
            }
        });

        checkboxCompleted.setBackground(new java.awt.Color(204, 204, 204));
        checkboxCompleted.setForeground(new java.awt.Color(102, 102, 102));
        checkboxCompleted.setText("Show Only Completed");
        checkboxCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxCompletedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnEditJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkboxCompleted)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxCompleted))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditJobActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1){
            int r = jTable1.getSelectedRow();
            int id = (int) jTable1.getValueAt(r, 0);
            FormHandler.openPopup(new UpdateJob(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), id));
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a job!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnEditJobActionPerformed

    private void btnViewTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTasksActionPerformed
        // TODO add your handling code here:
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r,0);
        
            TasksView tv = new TasksView(USER, VHANDLER);
            VHANDLER.changeView(tv, (javax.swing.JPanel) this.getParent());
            tv.populate(id);
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a job!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnViewTasksActionPerformed

    private void btnNewJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewJobActionPerformed
        FormHandler.openPopup(new InsertJob(USER, VHANDLER, (javax.swing.JPanel) this.getParent()));
    }//GEN-LAST:event_btnNewJobActionPerformed

    private void btnDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJobActionPerformed
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r,0);
            if(DatabaseManager.Delete("DELETE FROM jobs WHERE job_id = ?", new Object[]{id})){
                java.sql.ResultSet rows = DatabaseManager.Query("SELECT COUNT(*) FROM jobs");
                try {
                    // && DatabaseManager.Execute("ALTER TABLE customers AUTO_INCREMENT = ?", new Object[]{rows.getInt(1)})
                    if(rows.next()){
                        FormHandler.openMessageBox(new MessageBox("Success!", "Successfully deleted job!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                        JobsView j = new JobsView(USER,VHANDLER);
                        VHANDLER.changeView(j, (javax.swing.JPanel) this.getParent());
                        j.populate();
                    }
                } catch (java.sql.SQLException ex) {
                    FormHandler.openMessageBox(new MessageBox("Error!", ex.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
                }
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted a job", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete a job", USER.getId()).send();
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a job!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnDeleteJobActionPerformed

    private void checkboxCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxCompletedActionPerformed
        // TODO add your handling code here:
        if(checkboxCompleted.isSelected()){
            JobsView j = new JobsView(USER,VHANDLER);
            VHANDLER.changeView(j, (javax.swing.JPanel) this.getParent());
            j.populateComplete();
        }else{
            JobsView j = new JobsView(USER,VHANDLER);
            VHANDLER.changeView(j, (javax.swing.JPanel) this.getParent());
            j.populate();
        }
    }//GEN-LAST:event_checkboxCompletedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteJob;
    private javax.swing.JButton btnEditJob;
    private javax.swing.JButton btnNewJob;
    private javax.swing.JButton btnViewTasks;
    private javax.swing.JCheckBox checkboxCompleted;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
