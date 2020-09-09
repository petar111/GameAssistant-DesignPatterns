/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.commands.mandatory;

import constants.GameCommandsConstant;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediator.panel.PanelGameCommandsMediator;
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
        btnStartGame.setEnabled(false);
        btnMove.setEnabled(false);
        btnAdvice.setEnabled(false);
        btnChangeBehavior.setEnabled(false);
        
        PanelGameCommandsMediator.INSTANCE.setPanelBasicCommandsMandatory(this);
    }
    
    public void refreshView(){
        if(session.Session.INSTANCE.getGameSession().getGameState() == GameSession.GameState.ACTIVE){
            btnStartGame.setEnabled(false);
            btnMove.setEnabled(true);
            btnAdvice.setEnabled(true);
            btnChangeBehavior.setEnabled(true);
        }else{
            btnStartGame.setEnabled(true);
            btnMove.setEnabled(false);
            btnAdvice.setEnabled(false);
            btnChangeBehavior.setEnabled(false);
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

        btnStartGame1 = new javax.swing.JButton();
        btnStartGame = new javax.swing.JButton();
        btnAdvice = new javax.swing.JButton();
        btnMove = new javax.swing.JButton();
        btnChangeBehavior = new javax.swing.JButton();

        btnStartGame1.setText("Start game");
        btnStartGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGame1ActionPerformed(evt);
            }
        });

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

        btnChangeBehavior.setText("Change Behavior");
        btnChangeBehavior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeBehaviorActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMove, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeBehavior))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartGame)
                    .addComponent(btnMove))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdvice)
                    .addComponent(btnChangeBehavior))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        
       PanelGameCommandsMediator.INSTANCE.makeAndInvokeCommand(GameCommandsConstant.START_GAME);
//        panelCommands.makeCommand(GameCommandsConstant.START_GAME);
//        try {
//            panelCommands.invokeCommand();
//        } catch (Exception ex) {
//            Logger.getLogger(PanelBasicCommandsMandatory.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveActionPerformed
        if(session.Session.INSTANCE.getGameSession().getClientPlayer().getSelectedStrategy() == null){
            return;
        }
        PanelGameCommandsMediator.INSTANCE.makeAndInvokeCommand(GameCommandsConstant.MOVE);
//        panelCommands.makeCommand(GameCommandsConstant.MOVE);
//        try {
//            panelCommands.invokeCommand();
//        } catch (Exception ex) {
//            Logger.getLogger(PanelBasicCommandsMandatory.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnMoveActionPerformed

    private void btnStartGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGame1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartGame1ActionPerformed

    private void btnChangeBehaviorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeBehaviorActionPerformed
        PanelGameCommandsMediator.INSTANCE.makeAndInvokeCommand(GameCommandsConstant.CHANGE_BEHAVIOR);
//       panelCommands.makeCommand(GameCommandsConstant.CHANGE_BEHAVIOR);
//        try {
//            panelCommands.invokeCommand();
//        } catch (Exception ex) {
//            Logger.getLogger(PanelBasicCommandsMandatory.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnChangeBehaviorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdvice;
    private javax.swing.JButton btnChangeBehavior;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JButton btnStartGame1;
    // End of variables declaration//GEN-END:variables
}
