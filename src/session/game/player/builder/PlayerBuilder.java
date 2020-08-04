/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game.player.builder;

import domain.Game;
import session.game.player.Player;
import domain.PlayerConfiguration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author siux
 */
public class PlayerBuilder {
    public static Player createPlayer(Game game, int index, String playerName){
        PlayerConfiguration playerConfiguration = game.getPlayerConfigurations().get(index);
        
        String strategiesNames[][] = extractStrategies(game);
        int payoffs[][] = extractPayoffs(playerConfiguration, strategiesNames[index]);
        
        Map<String, Integer> strategies = makeStrategiesMap(strategiesNames, payoffs, index);
        Map<String, Integer> strategiesOpponent = makeStrategiesOpponentMap(strategiesNames, payoffs, index);
        Map<String, Integer> playedStrategies = makePlayedStrategies(strategiesNames, index);
        
        
        
        Player result = new Player(payoffs, strategies, strategiesOpponent, playerName, playedStrategies);
        result.setStrategyNames(strategiesNames[index]);
        
        return result;
    }

    private static int[][] extractPayoffs(PlayerConfiguration playerConfiguration, String[] strategies) {
        String payoffsRaw[] = playerConfiguration.getPayoffs().split(",");
        int payoffsRawCounter = 0;
        
        int payoffs[][] = new int[strategies.length][payoffsRaw.length/strategies.length];
        
        for (int i = 0; i < payoffs.length; i++) {
            for (int j = 0; j < payoffs[0].length; j++) {
                payoffs[i][j] = Integer.parseInt(payoffsRaw[payoffsRawCounter]);
                payoffsRawCounter++;
            }
        }
        
        return payoffs;
    }

    private static String[][] extractStrategies(Game game) {
        String result[][] = new String[game.getPlayerConfigurations().size()][];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = game.getPlayerConfigurations().get(i).getStrategies().split(",");
        }
        
        return result;
    }

    private static Map<String, Integer> makeStrategiesMap(String[][] strategiesNames, int[][] payoffs, int index) {
        Map<String, Integer> result = new HashMap<>();
        
        for (int i = 0; i < strategiesNames[index].length; i++) {
            result.put(strategiesNames[index][i], i);
        }
        return result;
    }
    
    private static Map<String, Integer> makePlayedStrategies(String[][] strategiesNames, int index) {
        Map<String, Integer> result = new HashMap<>();
        
        for (int i = 0; i < strategiesNames[index].length; i++) {
            result.put(strategiesNames[index][i], 0);
        }
        return result;
    }

    private static Map<String, Integer> makeStrategiesOpponentMap(String[][] strategiesNames, int[][] payoffs, int index) {
        int oppIndex = (index == 0 ? 1: 0);
        
        Map<String, Integer> result = new HashMap<>();
        
        for (int i = 0; i < strategiesNames[oppIndex].length; i++) {
            result.put(strategiesNames[oppIndex][i], i);
        }
        return result;
        
    }
}
