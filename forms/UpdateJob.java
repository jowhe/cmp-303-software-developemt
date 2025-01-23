/*
 */
package red_star_autos_software.forms;

import red_star_autos_software.classes.Log;
import red_star_autos_software.classes.User;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.ViewHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.utils.StyleSetting;
import red_star_autos_software.views.JobsView;

/**
 *
 * @author joe
 */
public class UpdateJob extends javax.swing.JFrame {

    private final User USER;
    private final ViewHandler VHANDLER;
    private final javax.swing.JPanel PARENT;
    private int selectedJob;
    private final java.util.HashMap<String, Integer> customers = new java.util.HashMap();
    private final java.util.HashMap<String, Integer> mechanics = new java.util.HashMap();

    
    /**
     * Update Job Window.
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     * @param panel The panel that the view is contained inside.
     * @param jobID The job_id of which job to update.
     */
    public UpdateJob(User user, ViewHandler viewHandler, javax.swing.JPanel panel, int jobID) {
        this.USER = user;
        this.VHANDLER = viewHandler;
        this.PARENT = panel;
        this.selectedJob = jobID;
        
        initComponents();
        
        // Custom Form Styling
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        buttons.add(btnUpdateJob);
        StyleSetting.applyButtonStyles(buttons, btnUpdateJob.getBackground(), btnUpdateJob.getBorder());
        
        // Get the customers, Head Mechanics and jobs from the database.
        java.sql.ResultSet customerRes = DatabaseManager.Query("SELECT c.customer_surname, c.customer_email, c.customer_id FROM customers c");
        java.sql.ResultSet employeeRes = DatabaseManager.Query("SELECT e.employee_forename, e.employee_surname, e.employee_id, r.role_name FROM employees e JOIN employee_roles er ON er.employee_id = e.employee_id JOIN roles r ON er.role_id = r.role_id WHERE er.role_id = 2");
        java.sql.ResultSet jobRes = DatabaseManager.Query("SELECT c.customer_surname, c.customer_email, j.job_description, j.job_notes, j.job_status, j.job_supervisor, j.created_at, j.last_update, j.customer_id, e.employee_forename, e.employee_surname, r.role_name FROM jobs j JOIN customers c ON j.customer_id = c.customer_id JOIN employees e ON j.job_supervisor = e.employee_id JOIN employee_roles er ON er.employee_id = e.employee_id JOIN roles r ON r.role_id = er.role_id WHERE job_id = ?", new Object[]{selectedJob});
        try {
            // Put the customers inside of a HashMap and insert them into a comboBox.
            while(customerRes.next()){
                String s = customerRes.getString("customer_surname") + "(" + customerRes.getString("customer_email") + ")";
                comboCustomers.addItem(s);
                customers.put(s, customerRes.getInt("customer_id"));

            }
            // Put the Head Mechanics in their own HashMap
            while(employeeRes.next()){
                String s = employeeRes.getString("employee_forename") + " " + employeeRes.getString("employee_surname") + " ("+employeeRes.getString("role_name")+")";
                comboMechanics.addItem(s);
                mechanics.put(s, employeeRes.getInt("employee_id"));
            }
            // Set the form components.
            while(jobRes.next()){
                inputJobDescription.setText(jobRes.getString("job_description"));
                comboStatus.setSelectedItem(jobRes.getString("job_status"));
                comboMechanics.setSelectedItem(jobRes.getString("employee_forename") + " " + jobRes.getString("employee_surname") + " ("+jobRes.getString("role_name")+")");
                comboCustomers.setSelectedItem(jobRes.getString("customer_surname") + "(" + jobRes.getString("customer_email") + ")");
                inputJobNotes.setText(jobRes.getString("job_notes"));
            }
        } catch (java.sql.SQLException e) {
            // Display an error message and Log the error.
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
        }
        
        DatabaseManager.Disconnect();
        // Role permissions.
        switch(USER.getRoleID()){
            case 3 -> {
                inputJobDescription.setEnabled(false);
                comboCustomers.setEnabled(false);
                comboStatus.setEnabled(false);
                comboMechanics.setEnabled(false);
            }
            case 4 -> {
                comboStatus.setEnabled(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        inputJobDescription = new javax.swing.JTextPane();
        comboStatus = new javax.swing.JComboBox<>();
        btnUpdateJob = new javax.swing.JButton();
        comboCustomers = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputJobNotes = new javax.swing.JTextArea();
        comboMechanics = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(606, 48));
        jPanel1.setMinimumSize(new java.awt.Dimension(606, 48));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, 26));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Red Star Auto Mechanics - Update Job");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setInheritsPopupMenu(false);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        inputJobDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputJobDescription.setText("Task Description");
        inputJobDescription.setBackground(new java.awt.Color(204, 204, 204));
        inputJobDescription.setForeground(new java.awt.Color(102, 102, 102));
        inputJobDescription.setPreferredSize(new java.awt.Dimension(200, 20));
        inputJobDescription.setToolTipText("Description of task.");
        inputJobDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputJobDescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputJobDescriptionFocusLost(evt);
            }
        });
        inputJobDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputJobDescriptioninputKeyTyped(evt);
            }
        });

        comboStatus.setEditable(true);
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ongoing", "Inspection", "Completed" }));
        comboStatus.setBackground(new java.awt.Color(204, 204, 204));
        comboStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        comboStatus.setForeground(new java.awt.Color(102, 102, 102));

        btnUpdateJob.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateJob.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/accept.png"))); // NOI18N
        btnUpdateJob.setText("Update");
        btnUpdateJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnUpdateJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateJobActionPerformed(evt);
            }
        });

        comboCustomers.setBackground(new java.awt.Color(204, 204, 204));
        comboCustomers.setEditable(true);
        comboCustomers.setForeground(new java.awt.Color(102, 102, 102));
        comboCustomers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        inputJobNotes.setBackground(new java.awt.Color(204, 204, 204));
        inputJobNotes.setColumns(20);
        inputJobNotes.setForeground(new java.awt.Color(102, 102, 102));
        inputJobNotes.setRows(5);
        inputJobNotes.setText("Job Notes");
        jScrollPane1.setViewportView(inputJobNotes);

        comboMechanics.setBackground(new java.awt.Color(204, 204, 204));
        comboMechanics.setEditable(true);
        comboMechanics.setForeground(new java.awt.Color(102, 102, 102));
        comboMechanics.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        comboMechanics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMechanicsActionPerformed(evt);
            }
        });

        jLabel2.setText("Supervisor:");
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(inputJobDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdateJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(comboCustomers, 0, 300, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboMechanics, javax.swing.GroupLayout.Alignment.TRAILING, 0, 498, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputJobDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(comboMechanics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputJobDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputJobDescriptionFocusGained
        if(inputJobDescription.getText().equals("Job Description"))
            inputJobDescription.setText("");
        
        inputJobDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_inputJobDescriptionFocusGained

    private void inputJobDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputJobDescriptionFocusLost
        if(inputJobDescription.getText().isBlank() || inputJobDescription.getText().isEmpty())
            inputJobDescription.setText("Job Description");
        
        inputJobDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
    }//GEN-LAST:event_inputJobDescriptionFocusLost

    private void inputJobDescriptioninputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJobDescriptioninputKeyTyped
        
    }//GEN-LAST:event_inputJobDescriptioninputKeyTyped

    private void btnUpdateJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateJobActionPerformed
        // Get the current time in a java.sql.Timestamp
        java.sql.Timestamp date = java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
        
        // Values to update
        Object[] values = new Object[]{
            inputJobDescription.getText(),
            inputJobNotes.getText(),
            (String) comboStatus.getSelectedItem(),
            mechanics.get((String) comboMechanics.getSelectedItem()),
            date,
            customers.get((String) comboCustomers.getSelectedItem()),
            this.selectedJob
        };
        
        if(DatabaseManager.Update("UPDATE jobs SET job_description = ?, job_notes = ?, job_status = ?, job_supervisor = ?, last_update = ?, customer_id = ? WHERE job_id = ?", values)){
            // If the update is successful, repopulate the JobsView.
            JobsView j = new JobsView(USER, VHANDLER);
            VHANDLER.changeView(j, PARENT);
            j.populate();
            this.dispose();
            new Log(Commands.getDateTime(), "Successfully updated a job", USER.getId()).send();
        }else{
            new Log(Commands.getDateTime(), "Failed to update a job", USER.getId()).send();
        }        
        
    }//GEN-LAST:event_btnUpdateJobActionPerformed

    private void comboMechanicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMechanicsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMechanicsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateJob;
    private javax.swing.JComboBox<String> comboCustomers;
    private javax.swing.JComboBox<String> comboMechanics;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JTextPane inputJobDescription;
    private javax.swing.JTextArea inputJobNotes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
