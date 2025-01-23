/*
 */
package red_star_autos_software.handlers;

import java.io.IOException;
import java.net.URISyntaxException;
import red_star_autos_software.Main;
import red_star_autos_software.forms.MessageBox;

/**
 *
 * @author joe
 */
public class FileHandler {
    
    public static boolean checkFiles(){
        // Get the resource
        java.net.URL resource = Main.class.getClassLoader().getResource("rs-database.db");
        
        // If the resource isn't packaged correctly.
        if(resource == null){
            FormHandler.openMessageBox(new MessageBox("Error!", "Resource not found: " + resource, javax.swing.JOptionPane.ERROR_MESSAGE));
            return false;
        }else{
            // Check to see if the directory exists.
            java.io.File location = new java.io.File("C://.rs-autos/");
            if(!location.exists()){
                location.mkdirs();
            }
            
            // Check to see if the file exists.
            java.io.File file = new java.io.File("C://.rs-autos/rs-database.db");
            if(!file.exists()){
                try{
                    // Copy the file from the jar.
                    java.nio.file.Files.copy(java.nio.file.Paths.get(resource.toURI()), java.nio.file.Paths.get("C://.rs-autos/rs-database.db"));
                    return true;
                }catch (URISyntaxException | IOException e) {
                    // Return the error message.
                    FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
                    return false;
                }
            }else{
                return true;
            }
        }
    }
}
