/*
 */
package red_star_autos_software.utils;

import red_star_autos_software.forms.MessageBox;
import red_star_autos_software.handlers.FormHandler;
import java.sql.*;

/**
 *
 * @author joe
 */
public class DatabaseManager {
    
    // The databaseURL of the Database Server/File.
    private static final String URL = Variables.databaseURL();
    
    // An active connection to ensure that the connection doesn't overflow.
    public static Connection activeConnection;
        
    /**
     * Disconnect from the database.
     */
    public static final void Disconnect(){
        System.out.println("Disconnecting from DB!");
        try{
            if(activeConnection != null){
                activeConnection.close();
                activeConnection = null;
            }
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
        }
    }
    
    /**
     * Get the active connection.
     * @return The active connection.
     */
    public static final Connection getConnection(){
        return activeConnection;
    }
    
    /**
     * Execute method with string options.
     * @param sql The SQL string to execute.
     * @param opts The options to pair with each ? in the SQL string.
     * @return The results.
     */
    public static boolean Execute(String sql, Object[] opts){
        System.out.println("Execute: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
                if(opts[i] instanceof java.lang.Float f)
                    query.setFloat(i+1, f);
                if(opts[i] instanceof java.sql.Date dt)
                    query.setDate(i+1, dt);
                if(opts[i] instanceof java.sql.Timestamp ts)
                    query.setTimestamp(i+1, ts);
            }
            boolean rs = query.execute();
            
            if(!rs)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
        }
        
        return false;
    }
    
    /**
     * Simple query method.
     * @param sql The SQL string to query.
     * @return The results.
     */
    public static ResultSet Query(String sql){
        System.out.println("Query: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement ps = activeConnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
            return null;
        }
    }
    
    /**
     * Query method with string options.
     * @param sql The SQL string to query.
     * @param opts The options to pair with each ? in the SQL string.
     * @return The results.
     */
    public static ResultSet Query(String sql, Object[] opts){
        System.out.println("Query: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
                if(opts[i] instanceof java.lang.Float f)
                    query.setFloat(i+1, f);
                if(opts[i] instanceof java.sql.Date dt)
                    query.setDate(i+1, dt);
                if(opts[i] instanceof java.sql.Timestamp ts)
                    query.setTimestamp(i+1, ts);
            }
            ResultSet rs = query.executeQuery();
            return rs;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
            return null;
        }
    }
    
    /**
    * Update method with string options.
    * @param sql The update query.
    * @param opts The option to pair with each ? in the SQL string.
    * @return Whether the update is successful or not.
    */ 
    public static boolean Update(String sql, Object[] opts){
        System.out.println("Update: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
            
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
                if(opts[i] instanceof java.lang.Float f)
                    query.setFloat(i+1, f);
                if(opts[i] instanceof java.sql.Date dt)
                    query.setDate(i+1, dt);
                if(opts[i] instanceof java.sql.Timestamp ts)
                    query.setTimestamp(i+1, ts);
            }
            
            int res = query.executeUpdate();
            
            if(res == 1)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
        }
        
        return false;
    }
    
    /**
    * Update method with string options.
    * @param sql The update query.
    * @param opts The option to pair with each ? in the SQL string.
    * @return Whether the update is successful or not.
    */ 
    public static boolean Insert(String sql, Object[] opts){
        System.out.println("Insert: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
            
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
                if(opts[i] instanceof java.lang.Float f)
                    query.setFloat(i+1, f);
                if(opts[i] instanceof java.sql.Date dt)
                    query.setDate(i+1, dt);
                if(opts[i] instanceof java.sql.Timestamp ts)
                    query.setTimestamp(i+1, ts);
            }
            
            boolean res = query.execute();
            
            if(!res)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
        }
        
        return false;
    }
    
    /**
    * Delete method with options.
    * @param sql The update query.
    * @param opts The option to pair with each ? in the SQL string.
    * @return Whether the update is successful or not.
    */ 
    public static boolean Delete(String sql, Object[] opts){
        System.out.println("Delete: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
                if(opts[i] instanceof java.lang.Float f)
                    query.setFloat(i+1, f);
                if(opts[i] instanceof java.sql.Date dt)
                    query.setDate(i+1, dt);
                if(opts[i] instanceof java.sql.Timestamp ts)
                    query.setTimestamp(i+1, ts);
            }
            
            boolean res = query.execute();
            
            if(!res)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
            return false;
        }
        
        return false;
    }
    
    /**
     * Method to initialize a connection to the database.
     * @return The connection.
     */
    private static Connection initCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL);
            con.setAutoCommit(true);
            return con;
        }catch(ClassNotFoundException | SQLException e){
            //JOptionPane.showConfirmDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage() + "\n\nContact System Administrator", javax.swing.JOptionPane.ERROR_MESSAGE));
            
            return null;
        }
    }
}
