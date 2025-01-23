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
import red_star_autos_software.views.CustomerView;

/**
 *
 * @author joe
 */
public class UpdateCustomer extends javax.swing.JFrame {
    private final User USER;
    private final ViewHandler VHANDLER;
    private final javax.swing.JPanel PANEL;
    private final int CUSTOMERID;

    /**
     * Update Customer Window.
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     * @param panel The panel that the view is contained inside.
     * @param customerID The customer to update.
     */
    public UpdateCustomer(User user, ViewHandler viewHandler, javax.swing.JPanel panel, int customerID) {
        this.USER = user;
        this.VHANDLER = viewHandler;
        this.PANEL = panel;
        this.CUSTOMERID = customerID;
        initComponents();
        // Custom Form Styling
        java.util.ArrayList<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        buttons.add(btnUpdate);
        StyleSetting.applyButtonStyles(buttons, btnUpdate.getBackground(), btnUpdate.getBorder());
        
        // Get the customer from the customers database with the corresponding ID.
        java.sql.ResultSet customerRes = DatabaseManager.Query("SELECT * FROM customers WHERE customer_id = ?", new Object[]{CUSTOMERID});
        try {
            if(customerRes.next()){
                // Set the form's components to the data values.
                inputCustomerSurname.setText(customerRes.getString("customer_surname"));
                inputCustomerEmail.setText(customerRes.getString("customer_email"));
                inputTelephone.setText(customerRes.getString("customer_tel"));
            }
        } catch (java.sql.SQLException e) {
            // Display an error message and Log the error.
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), USER.getId()).send();
        }
        
        DatabaseManager.Disconnect();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputCustomerSurname = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        inputCustomerEmail = new javax.swing.JTextPane();
        inputTelephone = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        lblValidationError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Customer");
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
        jLabel1.setText("Red Star Auto Mechanics - Update Customer");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/accept.png"))); // NOI18N
        btnUpdate.setText("Confirm");
        btnUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer Surname:");

        inputCustomerSurname.setBackground(new java.awt.Color(204, 204, 204));
        inputCustomerSurname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputCustomerSurname.setForeground(new java.awt.Color(102, 102, 102));
        inputCustomerSurname.setToolTipText("The surname of the customer.");
        inputCustomerSurname.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Customer Email:");

        inputCustomerEmail.setBackground(new java.awt.Color(204, 204, 204));
        inputCustomerEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputCustomerEmail.setForeground(new java.awt.Color(102, 102, 102));
        inputCustomerEmail.setToolTipText("The email of the customer.");
        inputCustomerEmail.setPreferredSize(new java.awt.Dimension(200, 20));

        inputTelephone.setBackground(new java.awt.Color(204, 204, 204));
        inputTelephone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputTelephone.setContentType("numeric"); // NOI18N
        inputTelephone.setForeground(new java.awt.Color(102, 102, 102));
        inputTelephone.setToolTipText("The telephone number of the customer.");
        inputTelephone.setPreferredSize(new java.awt.Dimension(200, 20));
        inputTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputTelephoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTelephoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTelephoneKeyTyped(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Customer Telephone:");

        lblValidationError.setBackground(new java.awt.Color(204, 204, 204));
        lblValidationError.setForeground(new java.awt.Color(255, 51, 51));
        lblValidationError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValidationError.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputCustomerSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(lblValidationError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputCustomerSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValidationError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Check input validation.
        if(!inputCustomerSurname.getText().equals("Customer Surname") &&
                !inputCustomerEmail.getText().isEmpty() || !inputCustomerEmail.getText().equals("Customer Email") &&
                !inputTelephone.getText().isEmpty() || !inputTelephone.getText().equals("Customer Telephone")) {
            // Update the customer
            if(DatabaseManager.Update("UPDATE customers SET customer_surname = ?, customer_email = ?, customer_tel = ? WHERE customer_id = ?", new Object[]{
                inputCustomerSurname.getText(),
                inputCustomerEmail.getText(),
                inputTelephone.getText(),
                CUSTOMERID
            })){
                // Display a success message and repopulate the CustomerView table.
                FormHandler.openMessageBox(new MessageBox("Success!", "Successfully edited customer!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                this.dispose();
                CustomerView c = new CustomerView(USER, VHANDLER);
                VHANDLER.changeView(c, PANEL);
                c.populate();
                new Log(Commands.getDateTime(), "Successfully updated a customer", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to update a customer, ID: " + CUSTOMERID, USER.getId()).send();
            }
        }
        
        DatabaseManager.Disconnect();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void validateTelephone(){
        // Validation for telephone.
        try{
            if(Integer.parseInt(inputTelephone.getText()) > -1){
                if(!lblValidationError.getText().isEmpty())
                lblValidationError.setText("");
            }
        }catch(NumberFormatException e){
            String text = inputTelephone.getText().replaceAll("[^0-9]", "");
            inputTelephone.setText(text);
        }
    }
    
    private void inputTelephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelephoneKeyPressed
        validateTelephone();
    }//GEN-LAST:event_inputTelephoneKeyPressed

    private void inputTelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelephoneKeyTyped
        validateTelephone();
    }//GEN-LAST:event_inputTelephoneKeyTyped

    private void inputTelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelephoneKeyReleased
       validateTelephone();
    }//GEN-LAST:event_inputTelephoneKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextPane inputCustomerEmail;
    private javax.swing.JTextPane inputCustomerSurname;
    private javax.swing.JTextPane inputTelephone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblValidationError;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
