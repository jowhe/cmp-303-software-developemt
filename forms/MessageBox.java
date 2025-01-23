/*
 */
package red_star_autos_software.forms;

import red_star_autos_software.utils.StyleSetting;

/**
 *
 * @author joe
 */
public class MessageBox extends javax.swing.JFrame {
    private final String TITLE;
    private final String MESSAGE;
    private final Integer TYPE;
    private javax.swing.Icon ICON;

    /**
     * Custom MessageBox Window.
     * @param title The title of the message.
     * @param message The content of the message.
     * @param messageType The type of message.
     */
    public MessageBox(String title, String message, int messageType) {
        this.TITLE = title;
        this.MESSAGE = message;
        this.TYPE = messageType;
        
        // Switch the type of messagebox to display different icons.
        switch(TYPE){
            case javax.swing.JOptionPane.ERROR_MESSAGE -> this.ICON = javax.swing.UIManager.getIcon("OptionPane.errorIcon");
            case javax.swing.JOptionPane.WARNING_MESSAGE -> this.ICON = javax.swing.UIManager.getIcon("OptionPane.warningIcon");
            case javax.swing.JOptionPane.INFORMATION_MESSAGE -> this.ICON = javax.swing.UIManager.getIcon("OptionPane.informationIcon");
        }
        
        initComponents();
        
        // Custom Form Styling       
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        this.lblTitle.setText(TITLE);
        this.txtMessage.setText(MESSAGE);
        addIcon();
        this.setAlwaysOnTop(true);
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        buttons.add(btnConfirm);
        StyleSetting.applyButtonStyles(buttons, btnConfirm.getBackground(), btnConfirm.getBorder());
    }
    
    /**
     * Add the icon to the form.
     */
    private void addIcon(){
        this.logo.setIcon(ICON);
        this.revalidate();
        this.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(255, 102, 102));
        jPanel2.setMaximumSize(new java.awt.Dimension(606, 48));
        jPanel2.setMinimumSize(new java.awt.Dimension(606, 48));

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("TITLE");
        lblTitle.setBackground(new java.awt.Color(255, 153, 153));
        lblTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblTitle.setFocusable(false);
        lblTitle.setFont(lblTitle.getFont().deriveFont(lblTitle.getFont().getStyle() & ~java.awt.Font.BOLD, 26));
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setInheritsPopupMenu(false);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setBorder(null);

        txtMessage.setEditable(false);
        txtMessage.setBackground(new java.awt.Color(204, 204, 204));
        txtMessage.setColumns(20);
        txtMessage.setForeground(new java.awt.Color(102, 102, 102));
        txtMessage.setLineWrap(true);
        txtMessage.setRows(5);
        txtMessage.setText("MESSAGE");
        txtMessage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(txtMessage);

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_star_autos_software/assets/icons/accept.png"))); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirm.setForeground(new java.awt.Color(102, 102, 102));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel logo;
    private javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables
}
