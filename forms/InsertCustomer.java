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
public class InsertCustomer extends javax.swing.JFrame {
    private final User USER;
    private final ViewHandler VHANDLER;
    private final javax.swing.JPanel PANEL;

    /**
     * Insert Customer Window.
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     * @param panel The panel that the view is contained inside.
     */
    public InsertCustomer(User user, ViewHandler viewHandler, javax.swing.JPanel panel) {
        this.USER = user;
        this.VHANDLER = viewHandler;
        this.PANEL = panel;
        initComponents();
        
        // Custom Form Styling
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        java.util.ArrayList<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        buttons.add(btnInsert);
        StyleSetting.applyButtonStyles(buttons, btnInsert.getBackground(), btnInsert.getBorder());
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inputSurname = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        inputTelephone = new javax.swing.JTextPane();
        btnInsert = new javax.swing.JButton();
        lblValidationError = new javax.swing.JLabel();

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
        jLabel1.setText("Red Star Auto Mechanics - New Customer");
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

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 25);
        flowLayout1.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout1);

        jLabel4.setText("Customer Surname:");
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(jLabel4);

        inputSurname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputSurname.setBackground(new java.awt.Color(204, 204, 204));
        inputSurname.setForeground(new java.awt.Color(102, 102, 102));
        inputSurname.setPreferredSize(new java.awt.Dimension(200, 20));
        inputSurname.setToolTipText("Customer surname.");
        jPanel3.add(inputSurname);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 115, 25);
        flowLayout2.setAlignOnBaseline(true);
        jPanel4.setLayout(flowLayout2);

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Customer Email:");
        jPanel4.add(jLabel5);

        inputEmail.setBackground(new java.awt.Color(204, 204, 204));
        inputEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputEmail.setForeground(new java.awt.Color(102, 102, 102));
        inputEmail.setToolTipText("Customer surname.");
        inputEmail.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel4.add(inputEmail);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 25);
        flowLayout3.setAlignOnBaseline(true);
        jPanel5.setLayout(flowLayout3);

        jLabel6.setText("Customer Number:");
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.add(jLabel6);

        inputTelephone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputTelephone.setContentType("numeric"); // NOI18N
        inputTelephone.setBackground(new java.awt.Color(204, 204, 204));
        inputTelephone.setForeground(new java.awt.Color(102, 102, 102));
        inputTelephone.setPreferredSize(new java.awt.Dimension(200, 20));
        inputTelephone.setToolTipText("Customer surname.");
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
        jPanel5.add(inputTelephone);

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

        lblValidationError.setBackground(new java.awt.Color(204, 204, 204));
        lblValidationError.setForeground(new java.awt.Color(255, 51, 51));
        lblValidationError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblValidationError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValidationError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
        // Check the inputs for empty text and ensure the user is either a system admin or an office admin.
        if(!inputSurname.getText().isEmpty() && !inputEmail.getText().isEmpty() && !inputTelephone.getText().isEmpty()){
            if(USER.getRoleID() == 1 || USER.getRoleID() == 4){
                // If the data gets inserted successfully
                if(DatabaseManager.Insert("INSERT INTO customers (customer_surname, customer_email, customer_tel) VALUES (?, ?, ?)", new String[]{
                    inputSurname.getText(),
                    inputEmail.getText(),
                    inputTelephone.getText()
                })){
                    // Display a success message and repopulate the Customer View table.
                    FormHandler.openMessageBox(new MessageBox("Success!", "Customer successfully inserted!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                    CustomerView cView = new CustomerView(USER, VHANDLER);
                    VHANDLER.changeView(cView, PANEL);
                    cView.populate();
                    this.dispose();
                    new Log(Commands.getDateTime(), "Successfully inserted a new customer", USER.getId()).send();
                }else{
                    new Log(Commands.getDateTime(), "Failed to insert a new customer", USER.getId()).send();
                }
            }
        }else
            FormHandler.openMessageBox(new MessageBox("Error!", "You have not entered all of the required information!", javax.swing.JOptionPane.ERROR_MESSAGE));
    }//GEN-LAST:event_btnInsertActionPerformed
    
    /**
     * Validation for telephone.
     */
    private void validateTelephone(){
        try{
            int x = Integer.parseInt(inputTelephone.getText());
            if(!lblValidationError.getText().isEmpty())
                lblValidationError.setText("");
        }catch(NumberFormatException e){
            lblValidationError.setText("You can only enter numbers into the telephone input.");
            String text = inputTelephone.getText().replaceAll("[^0-9]", "");
            inputTelephone.setText(text);
        }
    }
    
    private void inputTelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelephoneKeyTyped
        validateTelephone();        
    }//GEN-LAST:event_inputTelephoneKeyTyped

    private void inputTelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelephoneKeyReleased
        validateTelephone();
    }//GEN-LAST:event_inputTelephoneKeyReleased

    private void inputTelephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelephoneKeyPressed
        validateTelephone();
    }//GEN-LAST:event_inputTelephoneKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JTextPane inputEmail;
    private javax.swing.JTextPane inputSurname;
    private javax.swing.JTextPane inputTelephone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblValidationError;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
