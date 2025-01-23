/*
 */
package red_star_autos_software.forms;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import red_star_autos_software.classes.Log;
import red_star_autos_software.classes.User;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.ViewHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.views.EmployeesView;

/**
 *
 * @author joe
 */
public class InsertEmployee extends javax.swing.JFrame {
    private final User USER;
    private final ViewHandler VHANDLER;
    private final javax.swing.JPanel PANEL;

    /**
     * Insert Employee Window.
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     * @param panel The panel that the view is contained inside.
     */
    public InsertEmployee(User user, ViewHandler viewHandler, javax.swing.JPanel panel) {
        this.USER = user;
        this.VHANDLER = viewHandler;
        this.PANEL = panel;
        initComponents();
        btnInsert.setEnabled(false);
        
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputEmployeeForename = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        inputEmployeeSurname = new javax.swing.JTextPane();
        inputEmployeeEmail = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputEmployeePassword = new javax.swing.JTextPane();
        comboEmployeeRole = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

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
        jLabel1.setText("Red Star Auto Mechanics - New Employee");
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
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee Forename:");

        inputEmployeeForename.setBackground(new java.awt.Color(204, 204, 204));
        inputEmployeeForename.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputEmployeeForename.setForeground(new java.awt.Color(102, 102, 102));
        inputEmployeeForename.setText("Employee Forename");
        inputEmployeeForename.setToolTipText("The forename of the employee (e.g. John)");
        inputEmployeeForename.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Employee Surname:");

        inputEmployeeSurname.setBackground(new java.awt.Color(204, 204, 204));
        inputEmployeeSurname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputEmployeeSurname.setForeground(new java.awt.Color(102, 102, 102));
        inputEmployeeSurname.setText("Employee Surname");
        inputEmployeeSurname.setToolTipText("The surname of the employee (e.g. Baker)");
        inputEmployeeSurname.setPreferredSize(new java.awt.Dimension(200, 20));

        inputEmployeeEmail.setBackground(new java.awt.Color(204, 204, 204));
        inputEmployeeEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputEmployeeEmail.setForeground(new java.awt.Color(102, 102, 102));
        inputEmployeeEmail.setText("Employee Email Address");
        inputEmployeeEmail.setToolTipText("The email address of the employee (usually their forename.surname@rs-autos.biz)");
        inputEmployeeEmail.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Employee Email:");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Employee Password:");

        inputEmployeePassword.setBackground(new java.awt.Color(204, 204, 204));
        inputEmployeePassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputEmployeePassword.setForeground(new java.awt.Color(102, 102, 102));
        inputEmployeePassword.setText("Employee Password");
        inputEmployeePassword.setToolTipText("The password for the employee");
        inputEmployeePassword.setPreferredSize(new java.awt.Dimension(200, 20));

        comboEmployeeRole.setBackground(new java.awt.Color(204, 204, 204));
        comboEmployeeRole.setForeground(new java.awt.Color(102, 102, 102));
        comboEmployeeRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Head Mechanic", "Mechanic", "Office Administrator" }));
        comboEmployeeRole.setToolTipText("The role of the employee.");
        comboEmployeeRole.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        comboEmployeeRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEmployeeRoleActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Employee Role:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputEmployeeEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputEmployeeSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputEmployeeForename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEmployeeRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputEmployeePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputEmployeeForename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputEmployeeSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputEmployeeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEmployeeRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        // Current timestamp
        java.sql.Timestamp date = java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
        
        // Input validation
        if(!inputEmployeeForename.getText().isEmpty() && !inputEmployeeForename.getText().equals("Employee Forename") &&
                !inputEmployeeSurname.getText().isEmpty() && !inputEmployeeSurname.getText().equals("Employee Surname") &&
                !inputEmployeeEmail.getText().isEmpty() && !inputEmployeeEmail.getText().equals("Employee Email") &&
                !inputEmployeePassword.getText().isEmpty() && !inputEmployeePassword.getText().equals("Employee Password") &&
                comboEmployeeRole.getSelectedItem() != "Please Select") {
            if(DatabaseManager.Insert("INSERT INTO employees (employee_forename, employee_surname, employee_email, employee_password, created_at, last_accessed) VALUES (?, ?, ?, ?, ?, ?)", new Object[]{
                inputEmployeeForename.getText(),
                inputEmployeeSurname.getText(),
                inputEmployeeEmail.getText(),
                inputEmployeePassword.getText().replaceAll("[ ]", ""),
                date,
                date
            })){
                // Select the name of the role from comboEmployeeRole.
                java.sql.ResultSet existingRole = DatabaseManager.Query("SELECT e.employee_id, r.role_id FROM employees e JOIN roles r ON r.role_name = ? WHERE employee_email = ?", new String[]{
                    (String) comboEmployeeRole.getSelectedItem(),
                    inputEmployeeEmail.getText()
                });
                try {
                    // If the role exists.
                    if(existingRole.next()){
                        if(DatabaseManager.Insert("INSERT INTO employee_roles (employee_id, role_id) VALUES (?,?)", new Object[]{
                            existingRole.getInt("employee_id"),
                            existingRole.getInt("role_id")
                        })){
                            // If the new employee was successfully added.
                            this.dispose();
                            FormHandler.openMessageBox(new MessageBox("Success!", "Successfully inserted new employee!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                            EmployeesView e = new EmployeesView(USER, VHANDLER);
                            VHANDLER.changeView(e, PANEL);
                            e.populate();
                            new Log(Commands.getDateTime(), "Successfully inserted a new employee", USER.getId()).send();
                        }else{
                            new Log(Commands.getDateTime(), "Failed to insert a new employee", USER.getId()).send();
                        }
                    }
                } catch (java.sql.SQLException e) {
                    // Display an error message and Log the error.
                    FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
                    new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
                }
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Error!", "Invalid input, please make sure all fields are correct!", javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        DatabaseManager.Disconnect();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void comboEmployeeRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEmployeeRoleActionPerformed
        // Disable the insert button if a role is not selected.
        if(comboEmployeeRole.getSelectedItem() == "Please Select"){
            btnInsert.setEnabled(false);
        }else{
            btnInsert.setEnabled(true);
        }
    }//GEN-LAST:event_comboEmployeeRoleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> comboEmployeeRole;
    private javax.swing.JTextPane inputEmployeeEmail;
    private javax.swing.JTextPane inputEmployeeForename;
    private javax.swing.JTextPane inputEmployeePassword;
    private javax.swing.JTextPane inputEmployeeSurname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
