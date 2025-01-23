/*
 */
package red_star_autos_software.classes;
import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.handlers.FormHandler;
import red_star_autos_software.utils.Commands;
import red_star_autos_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class User {
    // User Variables
    private final Integer id;
    private String name;
    private String role;
    private Integer roleID;
    
    /**
     * Public User constructor to sign in an employee.
     * @param id The id of the employee.
     */
    public User(Integer id){
        this.id = id;
        setName();
    }
    
    /**
     * Return the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the users name.
     */
    private void setName(){
        // Select the employee from the database.
        java.sql.ResultSet employeeRes = DatabaseManager.Query("SELECT employee_forename, employee_surname FROM employees WHERE employee_id = ?", new Object[]{this.id});
        try {
            if(employeeRes.next()){
                // Combine their first and last name into a string.
                this.name = employeeRes.getString("employee_forename") + " " + employeeRes.getString("employee_surname");
            }
        } catch (java.sql.SQLException e) {
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
        }finally{
            // Set their role.
            setRole();
        }
    }
    
    /**
     * Get the users role ID.
     * @return The role's ID.
     */
    public int getRoleID(){
        return this.roleID;
    }

        
    public int getId(){
        return this.id;
    }
    
    /**
     * Set the users role string.
     */
    private void setRole(){
        // Get the users' role ID using their employee ID.
        java.sql.ResultSet roleIdRes = DatabaseManager.Query("SELECT role_id FROM employee_roles WHERE employee_id = ?", new Object[]{this.id});
        
        try{
            // If the user has a role
            if(roleIdRes.next()){
                this.roleID = roleIdRes.getInt("role_id");
                
                java.sql.ResultSet roleName = DatabaseManager.Query("SELECT role_name FROM roles WHERE role_id = ?", new Object[]{roleIdRes.getInt("role_id")});
                if(roleName.next()){
                    this.role = roleName.getString("role_name");
                }
            }
        }catch(java.sql.SQLException e){
            // Display an error message and log the error.
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            new Log(Commands.getDateTime(), e.getMessage(), this.getId()).send();
        }

    }
    
    public String getRole(){
        return this.role;
    }

}
