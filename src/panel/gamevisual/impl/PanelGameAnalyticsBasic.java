
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel.gamevisual.impl;

import session.game.player.Player;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import observer.lightmode.LightMode;
import observer.lightmode.LightModeListener;
import observer.lightmode.LightModeManager;
import panel.gamevisual.AbstractPanelGameAnalytics;
import panel.util.PanelLblTxtPair;
import session.Session;
import session.game.GameSession;

/**
 *
 * @author siux
 */
public class PanelGameAnalyticsBasic extends AbstractPanelGameAnalytics implements LightModeListener{

    /** Creates new form PanelGameAnalyticsBasic */
    public PanelGameAnalyticsBasic() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNameP1 = new javax.swing.JLabel();
        lblNameP2 = new javax.swing.JLabel();
        lblPayoffP1 = new javax.swing.JLabel();
        lblPayoffP2 = new javax.swing.JLabel();
        lblTotalRounds = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGameFlow = new javax.swing.JTextArea();
        txtPayoffP1 = new javax.swing.JTextField();
        txtPayoffP2 = new javax.swing.JTextField();
        txtTotalRounds = new javax.swing.JTextField();
        pnlStrategiesP1 = new javax.swing.JPanel();
        pnlStrategiesP2 = new javax.swing.JPanel();

        lblNameP1.setText("jLabel1");

        lblNameP2.setText("jLabel2");

        lblPayoffP1.setText("Total payoff");

        lblPayoffP2.setText("Total payoff");

        lblTotalRounds.setText("Total rounds:");

        txtGameFlow.setColumns(20);
        txtGameFlow.setRows(5);
        jScrollPane1.setViewportView(txtGameFlow);

        txtPayoffP1.setEditable(false);

        txtPayoffP2.setEditable(false);

        txtTotalRounds.setEditable(false);

        pnlStrategiesP1.setLayout(new javax.swing.BoxLayout(pnlStrategiesP1, javax.swing.BoxLayout.Y_AXIS));

        pnlStrategiesP2.setLayout(new javax.swing.BoxLayout(pnlStrategiesP2, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblNameP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNameP2)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblTotalRounds)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalRounds))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPayoffP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPayoffP1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlStrategiesP1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPayoffP2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPayoffP2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlStrategiesP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameP1)
                    .addComponent(lblNameP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlStrategiesP2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(pnlStrategiesP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPayoffP1)
                    .addComponent(lblPayoffP2)
                    .addComponent(txtPayoffP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPayoffP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRounds)
                    .addComponent(txtTotalRounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void refreshView() {
        
        Player p1 = Session.INSTANCE.getGameSession().getClientPlayer();
        Player p2 = (Player)Session.INSTANCE.getGameSession().getOpponentPlayer().getPlayer();
        GameSession gameSession = Session.INSTANCE.getGameSession();
        
        lblNameP1.setText(p1.getName());
        lblNameP2.setText(p2.getName());
        
        List<String> strategiesP1 = new ArrayList<>(p1.getStrategies().keySet());
        
        pnlStrategiesP1.removeAll();
        for (String strategy : strategiesP1) {
            PanelLblTxtPair panel = new PanelLblTxtPair();
            panel.getLblValue().setText(strategy);
            panel.getTxtValue().setText(p1.getPlayedStrategies().get(strategy).toString());
            pnlStrategiesP1.add(panel);
        }
        
        List<String> strategiesP2 = new ArrayList<>(p2.getStrategies().keySet());
        
        pnlStrategiesP2.removeAll();
        for (String strategy : strategiesP2) {
            PanelLblTxtPair panel = new PanelLblTxtPair();
            panel.getLblValue().setText(strategy);
            panel.getTxtValue().setText(p2.getPlayedStrategies().get(strategy).toString());
            pnlStrategiesP2.add(panel);
        }
        
        txtPayoffP1.setText(p1.getTotalPayoff() + "");
        txtPayoffP2.setText(p2.getTotalPayoff() + "");
        txtTotalRounds.setText(gameSession.getTotalRounds() + "");
        
        txtGameFlow.append(gameSession.getCurrentMessage() + "\n");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNameP1;
    private javax.swing.JLabel lblNameP2;
    private javax.swing.JLabel lblPayoffP1;
    private javax.swing.JLabel lblPayoffP2;
    private javax.swing.JLabel lblTotalRounds;
    private javax.swing.JPanel pnlStrategiesP1;
    private javax.swing.JPanel pnlStrategiesP2;
    private javax.swing.JTextArea txtGameFlow;
    private javax.swing.JTextField txtPayoffP1;
    private javax.swing.JTextField txtPayoffP2;
    private javax.swing.JTextField txtTotalRounds;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(LightModeManager lightModeManager) {
            setBackground(lightModeManager.getColors().getBackgroundColor());
            pnlStrategiesP1.setBackground(lightModeManager.getColors().getBackgroundColor());
            pnlStrategiesP2.setBackground(lightModeManager.getColors().getBackgroundColor());
            
            lblNameP1.setForeground(lightModeManager.getColors().getTextColor());
            lblNameP2.setForeground(lightModeManager.getColors().getTextColor());
            
            lblPayoffP1.setForeground(lightModeManager.getColors().getTextColor());
            lblPayoffP2.setForeground(lightModeManager.getColors().getTextColor());
            
            lblTotalRounds.setForeground(lightModeManager.getColors().getTextColor());
    }

}
