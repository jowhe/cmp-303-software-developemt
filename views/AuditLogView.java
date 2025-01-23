/*
 */
package red_star_autos_software.views;

import red_star_autos_software.classes.Log;
import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class AuditLogView extends javax.swing.JPanel {
    javax.swing.table.DefaultTableModel tableModel;
    private final java.util.HashMap<Integer, String> employees = new java.util.HashMap<>();
    /**
     * Creates new view panel (Audit Log View)
     */
    public AuditLogView() {
        initComponents();
        tableModel = new javax.swing.table.DefaultTableModel();
        this.jTable1.setModel(tableModel);
        this.jTable1.setGridColor(new java.awt.Color(102,102,102));
        this.jTable1.getTableHeader().setBackground(new java.awt.Color(164,164,164));
        this.jTable1.getTableHeader().setBorder(null);
        this.jScrollPane1.getViewport().setBackground(new java.awt.Color(164,164,164));

        java.sql.ResultSet employeesRes = DatabaseManager.Query("SELECT employee_id, employee_forename, employee_surname FROM employees");
        try {
            while(employeesRes.next()){
                employees.put(employeesRes.getInt("employee_id"), "(" + employeesRes.getString("employee_forename") + " " + employeesRes.getString("employee_surname") + ")");
            }
        } catch (java.sql.SQLException e) {
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        DatabaseManager.Disconnect();
    }
    
    public void populate(){
        // Order the table by descending order, this ensures that the view displays the latest logs.
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM logs ORDER BY log_id DESC");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            for(int i = 0; i < resMd.getColumnCount(); i++){
                tableModel.addColumn(resMd.getColumnLabel(i+1));
            }
            while(res.next()){
                java.time.LocalDateTime timestamp = res.getTimestamp("log_timestamp").toLocalDateTime();
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy @ HH:mm:ss");
                String formattedTimestamp = timestamp.format(formatter);
                tableModel.addRow(new Object[]{res.getInt("log_id"), formattedTimestamp, res.getString("log_description"), res.getInt("employee_id") + " " + employees.get(res.getInt("employee_id"))});
            }
        }catch(java.sql.SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        DatabaseManager.Disconnect();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
