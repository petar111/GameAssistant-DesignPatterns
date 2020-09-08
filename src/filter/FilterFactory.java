/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

/**
 *
 * @author petar
 */
public class FilterFactory {
    public static Filter makeFilterChain(){
        
        Filter head = new ViewConfigFilter();
        Filter next1 = new LicenceFilter();
        
        head.setNext(next1);
        
        return head;
    }
}
