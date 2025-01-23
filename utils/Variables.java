/*
 */
package red_star_autos_software.utils;

/**
 *
 * @author joe
 */
public class Variables {
    
    /**
     * The database file.
     */
    private static final String URL = "jdbc:sqlite:/C://.rs-autos/rs-database.db";
        
    /**
     * The databaseURL of the database server/file.
     * @return The databaseURL.
     */
    public static String databaseURL(){
        return URL;
    }
}
