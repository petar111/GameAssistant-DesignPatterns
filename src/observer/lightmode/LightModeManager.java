/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.lightmode;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author siux
 */

public class LightModeManager {
    private List<LightModeListener> listeners;
    
    private LightModeColors colors;

    public LightModeManager() {
        listeners = new LinkedList<>();
        
        //setting default light mode
        colors = new LightModeColors();
        colors.setBackgroundColor(null);
        colors.setTextColor(Color.BLACK);
        
    }

    public LightModeColors getColors() {
        return colors;
    }
    
    
    
    public void setLightMode(LightModeColors lightModeColors){
        this.colors = lightModeColors;
        updateObservers();
    }
    
    public void attach(LightModeListener lightModeListener){
        listeners.add(lightModeListener);
    }
    
    public void detach(LightModeListener lightModeListener){
        listeners.remove(lightModeListener);
    }

    private void updateObservers() {
        for (LightModeListener listener : listeners) {
            listener.update(this);
        }
    }
    
    
    
}
