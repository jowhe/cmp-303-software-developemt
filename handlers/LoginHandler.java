/*
 */
package red_star_autos_software.handlers;

import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class LoginHandler{    
    public LoginHandler(){
        super();
    }
    
    public static boolean matchLogin(String user, char[] pass){
        // Get the credentials from the database.
        java.sql.ResultSet credentials = DatabaseManager.Query("SELECT employee_forename, employee_surname, employee_email, employee_password FROM employees WHERE employee_email = ? AND employee_password = ?", 
                new Object[]{user, new String(pass)});
        
        try{
            while(credentials.next()){
                if(credentials.getString("employee_email").equals(user) && credentials.getString("employee_password").equals(new String(pass))){
                    // Display a welcome message.
                    FormHandler.openMessageBox(new MessageBox("Success!", "Welcome back, " + credentials.getString("employee_forename").concat(" " + credentials.getString("employee_surname")), javax.swing.JOptionPane.INFORMATION_MESSAGE));
                    DatabaseManager.Disconnect();
                    return true;
                }else{
                    DatabaseManager.Disconnect();
                    return false;
                }
            }
        }catch(java.sql.SQLException e) {
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        return false;
    }
}
