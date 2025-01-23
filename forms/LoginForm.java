/*
 */
package red_star_autos_software.forms;

import red_star_autos_software.classes.User;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.handlers.LoginHandler;
import red_star_autos_software.utils.DatabaseManager;
import red_star_autos_software.utils.StyleSetting;

/**
 *
 * @author joe
 */
public class LoginForm extends javax.swing.JFrame {
    private static final String[] defaultTxt = new String[2];

    /**
     * Login Window.
     */
    public LoginForm() {
        initComponents();
        
        defaultTxt[0] = inputUsername.getText();
        defaultTxt[1] = new String(inputPassword.getPassword());
        
        // Custom Form Styling
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/logo.png")).getImage());
        this.setTitle("Login Form");
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        
        java.awt.Color btnBg = btnLogin.getBackground();
        javax.swing.border.Border btnBorder = btnLogin.getBorder();
        java.util.ArrayList<javax.swing.JButton> buttons = new java.util.ArrayList();
        buttons.add(btnLogin);
        buttons.add(btnExit);
        
        StyleSetting.applyButtonStyles(buttons, btnBg, btnBorder);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblLoginError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(600, 350));
        setName("frameLogin"); // NOI18N
        setPreferredSize(new java.awt.Dimension(576, 325));
        setResizable(false);
        setSize(new java.awt.Dimension(576, 325));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(606, 48));
        jPanel1.setMinimumSize(new java.awt.Dimension(606, 48));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, 26));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Red Star Auto Mechanics - Login");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 606, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setMaximumSize(new java.awt.Dimension(606, 346));
        jPanel4.setMinimumSize(new java.awt.Dimension(606, 346));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 25);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Username:");
        jPanel2.add(jLabel4);

        inputUsername.setBackground(new java.awt.Color(204, 204, 204));
        inputUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputUsername.setForeground(new java.awt.Color(102, 102, 102));
        inputUsername.setText("Your email address.");
        inputUsername.setToolTipText("Account email address.");
        inputUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        inputUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputUsernameFocusLost(evt);
            }
        });
        inputUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputKeyTyped(evt);
            }
        });
        jPanel2.add(inputUsername);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 25);
        flowLayout3.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout3);

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Password:");
        jPanel3.add(jLabel5);

        inputPassword.setBackground(new java.awt.Color(204, 204, 204));
        inputPassword.setForeground(new java.awt.Color(102, 102, 102));
        inputPassword.setText("Your password.");
        inputPassword.setToolTipText("Account password.");
        inputPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        inputPassword.setEchoChar('\u0000');
        inputPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        inputPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputPasswordFocusLost(evt);
            }
        });
        inputPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputKeyTyped(evt);
            }
        });
        jPanel3.add(inputPassword);

        btnLogin.setBackground(new java.awt.Color(204, 204, 204));
        btnLogin.setForeground(new java.awt.Color(102, 102, 102));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/door_in.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(204, 204, 204));
        btnExit.setForeground(new java.awt.Color(102, 102, 102));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/cross.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblLoginError.setForeground(new java.awt.Color(255, 51, 51));
        lblLoginError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoginError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoginError)
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, -1, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if(!inputUsername.getText().equals(defaultTxt[0]) && !new String(inputPassword.getPassword()).equals(defaultTxt[1])){
            if(LoginHandler.matchLogin(inputUsername.getText(), inputPassword.getPassword())){
                // Match the credentials agains the database.
                java.sql.ResultSet matchCredentials = DatabaseManager.Query("SELECT employee_id, employee_forename, employee_surname FROM employees WHERE employee_email = ?", new String[] {inputUsername.getText()});
                try{
                    if(matchCredentials.next()){
                        // Create a new user and open the dashboard form.
                        User user = new User(matchCredentials.getInt("employee_id"));
                        FormHandler.changeForm(new DashForm(user));
                    }
                }catch(java.sql.SQLException e){
                    FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
                }
            }else{
                lblLoginError.setText("You have not entered valid any credentials!");
            }
        }else{
            lblLoginError.setText("You have not entered any credentials!");
        }
        
        DatabaseManager.Disconnect();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        FormHandler.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginMouseEntered

    private void inputUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUsernameFocusGained
        inputUsername.setText("");
    }//GEN-LAST:event_inputUsernameFocusGained

    private void inputUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUsernameFocusLost
        if(inputUsername.getText().isBlank() || inputUsername.getText().isEmpty())
            inputUsername.setText("Your email address.");
    }//GEN-LAST:event_inputUsernameFocusLost

    private void inputPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordFocusGained
        inputPassword.setEchoChar('\u2022');
        inputPassword.setText("");
    }//GEN-LAST:event_inputPasswordFocusGained

    private void inputPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordFocusLost
        if(new String(inputPassword.getPassword()).isBlank() || new String(inputPassword.getPassword()).isEmpty()){
            inputPassword.setEchoChar('\u0000');
        inputPassword.setText("Your password.");
        }
    }//GEN-LAST:event_inputPasswordFocusLost

    private void inputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputKeyTyped
        // TODO add your handling code here:
        if(!lblLoginError.getText().isEmpty())
            lblLoginError.setText("");
    }//GEN-LAST:event_inputKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextPane inputUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblLoginError;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
