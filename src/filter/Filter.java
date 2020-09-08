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
public abstract class Filter {
    
    protected Filter next;
    
    public void handle() throws Exception{
     
        doFilter();
        
        if(next != null){
            next.handle();
        }
    }

    public void setNext(Filter next) {
        this.next = next;
    }
    
    

    protected abstract void doFilter() throws Exception;
}
