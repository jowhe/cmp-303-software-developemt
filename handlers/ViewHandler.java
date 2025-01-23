/*
 */
package red_star_autos_software.handlers;

/**
 *
 * @author joe
 */
public class ViewHandler {
    
    private javax.swing.JPanel currentView;
    private javax.swing.JPanel parentPanel;
    
    /**
     * Public method to change the current view inside of the dashboard.
     * @param view The view to change to.
     * @param parent The panel inside of the dashboard.
     */
    public void changeView(javax.swing.JPanel view, javax.swing.JPanel parent){
        currentView = view;

        if(parentPanel != null)
            parentPanel.removeAll();
        else
            parentPanel = parent;
        
        parentPanel.add(currentView);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
    
    /**
     * Dispose all.
     */
    public void dispose(){
        currentView = null;
        parentPanel = null;
    }
    
}
