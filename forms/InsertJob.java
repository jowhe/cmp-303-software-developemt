/*
 */
package red_star_autos_software.forms;

import red_star_autos_software.classes.Log;
import red_star_autos_software.classes.User;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.ViewHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.views.JobsView;


/**
 *
 * @author joe
 */
public class InsertJob extends javax.swing.JFrame {
    private final User USER;
    private final ViewHandler VHANDLER;
    private final javax.swing.JPanel PANEL;
    private final java.util.HashMap<String, Integer> customers = new java.util.HashMap();
    private final java.util.HashMap<String, Integer> mechanics = new java.util.HashMap();

    /**
     * Insert Job Window.
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     * @param panel The panel that the view is contained inside.
     */
    public InsertJob(User user, ViewHandler viewHandler, javax.swing.JPanel panel) {
        // Variable declaration
        this.USER = user;
        this.VHANDLER = viewHandler;
        this.PANEL = panel;
        
        initComponents();
        
        // Center the form.
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        
        // ResutltSet for cusomters
        java.sql.ResultSet customersRes = DatabaseManager.Query("SELECT * FROM customers WHERE customer_id");
        // ResultSet for head mechanics
        java.sql.ResultSet supervisorsRes = DatabaseManager.Query("SELECT e.employee_id, e.employee_forename, e.employee_surname, r.role_name FROM employees e "
                + "JOIN employee_roles er ON er.employee_id = e.employee_id "
                + "JOIN roles r ON er.role_id = r.role_id "
                + "WHERE r.role_id = 2");
        try {
            while(customersRes.next()){
                // Populate the customers combo box.
                comboCustomers.addItem(customersRes.getString("customer_email"));
                // Store the customers and their customer_id into the HashMap
                customers.put(customersRes.getString("customer_email"), customersRes.getInt("customer_id"));
            }
            while(supervisorsRes.next()){
                // Populate the supervisor combo box.
                comboMechanics.addItem(supervisorsRes.getString("employee_forename") 
                        + " " 
                        + supervisorsRes.getString("employee_surname") + " ("+supervisorsRes.getString("role_name")+")");
                // Store the supervisors and their employee_id into the HashMap.
                mechanics.put(supervisorsRes.getString("employee_forename") 
                        + " " 
                        + supervisorsRes.getString("employee_surname") 
                        + " ("+supervisorsRes.getString("role_name")+")", supervisorsRes.getInt("employee_id"));
            }
        } catch (java.sql.SQLException e) {
            // Should there be an SQL error, display a messaage and send a Log.
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
        }
        
        // User Permissions
        if(comboCustomers.getSelectedIndex() == -1){        
            inputJobDescription.setEnabled(false);
            inputNotes.setEnabled(false);
            comboStatus.setEnabled(false);
        }else{
            inputJobDescription.setEnabled(true);
            inputNotes.setEnabled(true);
            comboStatus.setEnabled(true);
        }
        
        comboStatus.setSelectedIndex(0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputJobDescription = new javax.swing.JTextPane();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputNotes = new javax.swing.JTextArea();
        comboCustomers = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboMechanics = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(606, 48));
        jPanel1.setMinimumSize(new java.awt.Dimension(606, 48));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, 26));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Red Star Auto Mechanics - New Job");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnInsert.setBackground(new java.awt.Color(204, 204, 204));
        btnInsert.setForeground(new java.awt.Color(102, 102, 102));
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/accept.png"))); // NOI18N
        btnInsert.setText("Confirm");
        btnInsert.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Job Description:");

        inputJobDescription.setBackground(new java.awt.Color(204, 204, 204));
        inputJobDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputJobDescription.setForeground(new java.awt.Color(102, 102, 102));
        inputJobDescription.setToolTipText("Description of new job.");
        inputJobDescription.setPreferredSize(new java.awt.Dimension(200, 20));

        comboStatus.setBackground(new java.awt.Color(204, 204, 204));
        comboStatus.setForeground(new java.awt.Color(102, 102, 102));
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ongoing" }));
        comboStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Job Status:");

        jScrollPane1.setBorder(null);

        inputNotes.setBackground(new java.awt.Color(204, 204, 204));
        inputNotes.setColumns(20);
        inputNotes.setForeground(new java.awt.Color(102, 102, 102));
        inputNotes.setRows(5);
        inputNotes.setText("Job Notes");
        inputNotes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(inputNotes);

        comboCustomers.setBackground(new java.awt.Color(204, 204, 204));
        comboCustomers.setForeground(new java.awt.Color(102, 102, 102));
        comboCustomers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Customer:");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Supervisor:");

        comboMechanics.setBackground(new java.awt.Color(204, 204, 204));
        comboMechanics.setForeground(new java.awt.Color(102, 102, 102));
        comboMechanics.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(inputJobDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(comboMechanics, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputJobDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMechanics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // The values to be inserted.
        Object[] values = new Object[]{
            inputJobDescription.getText(),
            inputNotes.getText(),
            (String) comboStatus.getSelectedItem(),
            mechanics.get((String) comboMechanics.getSelectedItem()),
            Commands.getDateTime(),
            Commands.getDateTime(),
            customers.get((String) comboCustomers.getSelectedItem())
        };
        
        // If the insertion is successful.
        if(DatabaseManager.Insert("INSERT INTO jobs (job_description, job_notes, job_status, job_supervisor, created_at, last_update, customer_id) VALUES (?,?,?,?,?,?,?)", values)){
            FormHandler.openMessageBox(new MessageBox("Success!", "Successfully created new job!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
            JobsView jobView = new JobsView(USER, VHANDLER);
            VHANDLER.changeView(jobView, PANEL);
            jobView.populate();
            new Log(Commands.getDateTime(), "Successfully inserted a new job", USER.getId()).send();
        }else{
            new Log(Commands.getDateTime(), "Failed to insert a new job", USER.getId()).send();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> comboCustomers;
    private javax.swing.JComboBox<String> comboMechanics;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JTextPane inputJobDescription;
    private javax.swing.JTextArea inputNotes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
