/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.panel;

/**
 *
 * @author petar
 */
public interface PanelElement {
    void accept(PanelVisitor panelVisitor);
}
