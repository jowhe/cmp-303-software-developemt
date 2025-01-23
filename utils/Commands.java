package red_star_autos_software.utils;

import java.time.LocalDateTime;

/**
 *
 * @author joe
 */
public class Commands {
    /**
     * The java.sql.Timestamp value of the current java.time.LocalDateTime.now().
     * @return The java.sql.Timestamp value.
     */
    public static java.sql.Timestamp getDateTime(){
        System.out.println(LocalDateTime.now());
        return java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
    }
    
}
