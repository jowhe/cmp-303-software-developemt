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
import red_star_autos_software.views.AuditLogView;
import red_star_autos_software.views.CustomerView;
import red_star_autos_software.views.EmployeesView;
import red_star_autos_software.views.InvoiceView;
import red_star_autos_software.views.JobsView;

/**
 *
 * @author joe
 */
public class DashForm extends javax.swing.JFrame {
    
    private final User USER;
    private static final ViewHandler viewHandler = new ViewHandler();
    
    /**
     * Dashboard Window.
     * @param user The user that is accessing the dashboard.
     */
    public DashForm(User user) {
        initComponents();      
        this.USER = user;
        
        // Log that a user has logged in.
        new Log(Commands.getDateTime(), "Logged in. ", user.getId()).send();
        
        // Update the employees last_accessed.
        if(!DatabaseManager.Update("UPDATE employees SET last_accessed = ? WHERE employee_id = ?", new Object[]{Commands.getDateTime(), user.getId()})){
            FormHandler.openMessageBox(new MessageBox("Error!", "Failed to update last_accessed\nContact System Administrator!", javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        // Custom Form Styling
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/logo.png")).getImage());
        this.setTitle("Dashboard");
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        
        java.awt.Color btnBg = btnLogout.getBackground();
        javax.swing.border.Border btnBorder = btnLogout.getBorder();
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        
        buttons.add(btnLogout);
        buttons.add(btnJobsView);
        buttons.add(btnEmployeeView);
        buttons.add(btnViewCustomers);
        buttons.add(btnViewInvoices);
        buttons.add(btnViewAudit);
        
        StyleSetting.applyButtonStyles(buttons, btnBg, btnBorder);
        
        lblLoggedIn.setText("Logged in as: " + user.getName() + " [" + user.getRole() + "]");
        
        // Load the motivational quote of the day.
        loadMotivationalQuote(this.lblMotivationalQuote);
        
        // User permission handling.
        switch(user.getRoleID()){
            // System Administrator
            case 1 -> {
                btnViewAudit.setVisible(true);
                btnViewAudit.setEnabled(true);
            }
            // Head Mechanic
            case 2 -> {
                btnEmployeeView.setEnabled(false);
                btnViewInvoices.setEnabled(false);
                btnViewCustomers.setEnabled(false);
                lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user_green.png")));
                btnViewAudit.setVisible(false);
                btnViewAudit.setEnabled(false);
            }
            // Mechanic
            case 3 -> {
                btnEmployeeView.setEnabled(false);
                btnViewInvoices.setEnabled(false);
                btnViewCustomers.setEnabled(false);
                lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user_orange.png")));
                btnViewAudit.setVisible(false);
                btnViewAudit.setEnabled(false);
            }
            // Office Administrator
            case 4 -> {
                btnEmployeeView.setEnabled(false);
                lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user_red.png")));
                btnViewAudit.setVisible(false);
                btnViewAudit.setEnabled(false);
            }
        }
    }
    
    private void loadMotivationalQuote(javax.swing.JLabel label){
        // Get the current day of the week.
        java.time.LocalDate t = java.time.LocalDate.now();
        java.time.DayOfWeek d = t.getDayOfWeek();
        java.sql.ResultSet res = DatabaseManager.Query("SELECT quote_text FROM mv_quotes WHERE quote_id = ?", new Object[]{d.getValue()});
        try{
            while(res.next()){
                // Set the text to the provided label.
                label.setText("<html><body style=\"text-align: justify; text-justify: inter-word;\">"+ res.getString("quote_text") +"</body></html>");
            }
        }catch(java.sql.SQLException e){
            // Display an error message and Log the error.
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblMotivationalQuote = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        dashViewPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnJobsView = new javax.swing.JButton();
        btnEmployeeView = new javax.swing.JButton();
        btnViewCustomers = new javax.swing.JButton();
        btnViewInvoices = new javax.swing.JButton();
        btnViewAudit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUserIcon = new javax.swing.JLabel();
        lblLoggedIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 360));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(606, 48));
        jPanel1.setMinimumSize(new java.awt.Dimension(508, 54));
        jPanel1.setPreferredSize(new java.awt.Dimension(508, 54));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, 26));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Red Star Auto Mechanics - Dashboard");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setInheritsPopupMenu(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/logo.png"))); // NOI18N

        btnLogout.setBackground(new java.awt.Color(204, 204, 204));
        btnLogout.setForeground(new java.awt.Color(102, 102, 102));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/door_out.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblMotivationalQuote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotivationalQuote.setText("\"Some men want to watch the world burn.\"");
        lblMotivationalQuote.setForeground(new java.awt.Color(153, 153, 153));
        lblMotivationalQuote.setToolTipText("Daily Motivation");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblMotivationalQuote, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMotivationalQuote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel4.setMaximumSize(new java.awt.Dimension(606, 346));
        jPanel4.setMinimumSize(new java.awt.Dimension(606, 346));
        jPanel4.setPreferredSize(new java.awt.Dimension(508, 475));

        dashViewPanel.setBackground(new java.awt.Color(204, 204, 204));
        dashViewPanel.setMaximumSize(new java.awt.Dimension(876, 367));
        dashViewPanel.setMinimumSize(new java.awt.Dimension(876, 367));
        dashViewPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dashViewPanelComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                dashViewPanelComponentRemoved(evt);
            }
        });
        dashViewPanel.setLayout(new java.awt.CardLayout());

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Please select an option.");
        dashViewPanel.add(jLabel3, "card2");

        btnJobsView.setBackground(new java.awt.Color(204, 204, 204));
        btnJobsView.setForeground(new java.awt.Color(102, 102, 102));
        btnJobsView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/table.png"))); // NOI18N
        btnJobsView.setText("View Jobs");
        btnJobsView.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnJobsView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJobsView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJobsViewActionPerformed(evt);
            }
        });

        btnEmployeeView.setBackground(new java.awt.Color(204, 204, 204));
        btnEmployeeView.setForeground(new java.awt.Color(102, 102, 102));
        btnEmployeeView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/group.png"))); // NOI18N
        btnEmployeeView.setText("View Employees");
        btnEmployeeView.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnEmployeeView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeViewActionPerformed(evt);
            }
        });

        btnViewCustomers.setBackground(new java.awt.Color(204, 204, 204));
        btnViewCustomers.setForeground(new java.awt.Color(102, 102, 102));
        btnViewCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user.png"))); // NOI18N
        btnViewCustomers.setText("View Customers");
        btnViewCustomers.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnViewCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCustomersActionPerformed(evt);
            }
        });

        btnViewInvoices.setBackground(new java.awt.Color(204, 204, 204));
        btnViewInvoices.setForeground(new java.awt.Color(102, 102, 102));
        btnViewInvoices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/money.png"))); // NOI18N
        btnViewInvoices.setText("View Invoices");
        btnViewInvoices.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnViewInvoices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewInvoicesActionPerformed(evt);
            }
        });

        btnViewAudit.setBackground(new java.awt.Color(204, 204, 204));
        btnViewAudit.setForeground(new java.awt.Color(102, 102, 102));
        btnViewAudit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/application_view_columns.png"))); // NOI18N
        btnViewAudit.setText("View Audit Log");
        btnViewAudit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnViewAudit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAuditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnJobsView, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dashViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJobsView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(dashViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(508, 16));

        lblUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/user_suit.png"))); // NOI18N
        lblUserIcon.setForeground(new java.awt.Color(102, 102, 102));

        lblLoggedIn.setText("Logged in as:");
        lblLoggedIn.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserIcon)
                    .addComponent(lblLoggedIn))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashViewPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dashViewPanelComponentAdded
        // Debug code, can be removed.
        System.out.println("Component Added.");
    }//GEN-LAST:event_dashViewPanelComponentAdded

    private void dashViewPanelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dashViewPanelComponentRemoved
        // Debug code, can be removed.
        System.out.println("Component Removed.");
    }//GEN-LAST:event_dashViewPanelComponentRemoved

    private void btnJobsViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJobsViewActionPerformed
        // Paint the JobsView Panel
        dashViewPanel.removeAll();
        JobsView jobsView = new JobsView(USER, viewHandler);
        viewHandler.changeView(jobsView, dashViewPanel);
        jobsView.populate();
    }//GEN-LAST:event_btnJobsViewActionPerformed

    private void btnEmployeeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeViewActionPerformed
        // Paint the EmployeesView Panel
        dashViewPanel.removeAll();
        EmployeesView employeeView = new EmployeesView(USER, viewHandler);
        viewHandler.changeView(employeeView, dashViewPanel);
        employeeView.populate();
    }//GEN-LAST:event_btnEmployeeViewActionPerformed

    private void btnViewCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCustomersActionPerformed
        // Paint the CustomersView Panel
        dashViewPanel.removeAll();
        CustomerView customerView = new CustomerView(USER, viewHandler);
        viewHandler.changeView(customerView, dashViewPanel);
        customerView.populate();
    }//GEN-LAST:event_btnViewCustomersActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new Log(Commands.getDateTime(), "Logged out. ", USER.getId()).send();
        FormHandler.changeForm(new LoginForm());
        viewHandler.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewInvoicesActionPerformed
        // Paint the InvoiceView Panel
        dashViewPanel.removeAll();
        InvoiceView invoiceView = new InvoiceView(USER, viewHandler);
        viewHandler.changeView(invoiceView, dashViewPanel);
        invoiceView.populate();
    }//GEN-LAST:event_btnViewInvoicesActionPerformed

    private void btnViewAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAuditActionPerformed
        // Paint the AuditLogView Panel
        dashViewPanel.removeAll();
        AuditLogView auditView = new AuditLogView();
        viewHandler.changeView(auditView, dashViewPanel);
        auditView.populate();
    }//GEN-LAST:event_btnViewAuditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmployeeView;
    private javax.swing.JButton btnJobsView;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewAudit;
    private javax.swing.JButton btnViewCustomers;
    private javax.swing.JButton btnViewInvoices;
    private javax.swing.JPanel dashViewPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblLoggedIn;
    private javax.swing.JLabel lblMotivationalQuote;
    private javax.swing.JLabel lblUserIcon;
    // End of variables declaration//GEN-END:variables
}
