/*
 */
package red_star_autos_software.classes;

import red_star_autos_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class Log{
    // Log variables
    java.sql.Timestamp timestamp;
    String description;
    int employee;
    
    // Public constructor to take in the new log.
    public Log(java.sql.Timestamp time, String desc, int emp){
        timestamp = time;
        description = desc;
        employee = emp;
    }
    
    // Send the log to the database.
    public void send(){
        DatabaseManager.Insert("INSERT INTO `logs`(`log_timestamp`, `log_description`, `employee_id`) VALUES (?, ?, ?)", new Object[]{this.timestamp, this.description, this.employee});
        DatabaseManager.Disconnect();
    }
}
