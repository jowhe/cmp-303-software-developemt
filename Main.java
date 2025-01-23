/*
 */
package red_star_autos_software;

import red_star_autos_software.forms.LoginForm;
import red_star_autos_software.handlers.FileHandler;
import red_star_autos_software.handlers.FormHandler;


/**
 *
 * @author joe
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        if(FileHandler.checkFiles()){
            // Set the current form to a new login form and show it.
            FormHandler.setForm(new LoginForm());
            FormHandler.showForm();
        }        
    }
    
}
