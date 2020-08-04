/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.commands.mandatory;

import constants.GameCommandsConstant;
import java.util.logging.Level;
import java.util.logging.Logger;
import panel.commands.AbstractPanelCommands;
import session.game.GameSession;

/**
 *
 * @author siux
 */
public class PanelBasicCommandsMandatory extends javax.swing.JPanel {

    private final AbstractPanelCommands panelCommands;
    /**
     * Creates new form PanelBasicCommandsMandatory
     * @param panelCommands
     */
    public PanelBasicCommandsMandatory(AbstractPanelCommands panelCommands) {
        initComponents();
        this.panelCommands = panelCommands;
    }
    
    public void refreshView(){
        if(session.Session.INSTANCE.getGameSession().getGameState() == GameSession.GameState.ACTIVE){
            btnStartGame.setEnabled(false);
            btnMove.setEnabled(true);
            btnAdvice.setEnabled(true);
        }else{
            btnStartGame.setEnabled(true);
            btnMove.setEnabled(false);
            btnAdvice.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStartGame = new javax.swing.JButton();
        btnAdvice = new javax.swing.JButton();
        btnMove = new javax.swing.JButton();

        btnStartGame.setText("Start game");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        btnAdvice.setText("Advice");

        btnMove.setText("Move");
        btnMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAdvice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStartGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMove, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartGame)
                    .addComponent(btnMove))
                .addGap(18, 18, 18)
                .addComponent(btnAdvice))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
       panelCommands.makeCommand(GameCommandsConstant.START_GAME);
        try {
            panelCommands.invokeCommand();
        } catch (Exception ex) {
            Logger.getLogger(PanelBasicCommandsMandatory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveActionPerformed
        panelCommands.makeCommand(GameCommandsConstant.MOVE);
        try {
            panelCommands.invokeCommand();
        } catch (Exception ex) {
            Logger.getLogger(PanelBasicCommandsMandatory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdvice;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnStartGame;
    // End of variables declaration//GEN-END:variables
}
