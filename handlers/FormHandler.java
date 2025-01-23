/*
 */
package red_star_autos_software.handlers;

import red_star_autos_software.forms.MessageBox;

/**
 *
 * @author joe
 */
public class FormHandler {
    private static javax.swing.JFrame currentForm;
    private static javax.swing.JFrame lastForm;
    
    private static javax.swing.JFrame currentPopup;
    
    /**
     * Public constructor for the form handler.
     * 
     */
    public FormHandler(){
        super();
    }
    
    /**
    * Public method to set the current form.
    * @param form The form to set to.
     */    
    public static void setForm(javax.swing.JFrame form){
        currentForm = form;
    }
    
    /**
    * Public method to show the currentForm.
    * 
     */    
    public static void showForm(){
        if(currentForm != null){
            currentForm.setVisible(true);
        }
    }
    /**
     * Public method to change the form.
     * @param form The form to change to.
     */
    public static void changeForm(javax.swing.JFrame form){
        if(currentForm != null){
            lastForm = currentForm;
            currentForm.dispose();
            setForm(form);
            showForm();
        }
    }
    
    /**
     * Return to the previous form.
     */
    public static void returnForm(){
        if(lastForm != null){
            changeForm(lastForm);
            lastForm = null;
        }
    }
    
    /**
     * Dispose all forms.
     */
    public static void dispose(){
        if(currentForm != null){
            currentForm.dispose();
            lastForm = null;
        }
    }
    
    /**
     * Open a new popup, to conserve memory popups are limited to 1 instance.
     * @param frame The frame to popup.
     */
    public static void openPopup(javax.swing.JFrame frame){
        if(currentPopup != null)
            currentPopup.dispose();
        
        currentPopup = frame;
        currentPopup.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        currentPopup.setVisible(true);
        currentPopup.setAlwaysOnTop(true);
    }
    
    /**
     * Open a new message box
     * @param msgbx The new MessageBox to show.
     */
    public static void openMessageBox(MessageBox msgbx){
        msgbx.setVisible(true);
    }
    
}
