/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class Napakalaki {


    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer = CardDealer.getInstance();
    
    public int getPlayersSize(){  return this.players.size();}
    
    private Napakalaki() {
        players = new ArrayList<>();
        currentPlayer=null;
        currentMonster=null;
    }
    
    private void initPlayers(ArrayList<String> names){
        for(String n:names){
            players.add(new Player(n));
        }    
    }
    
    private Player nextPlayer(){

        if(currentPlayer == null){  
            int pos = (int) (players.size()*Math.random());
            currentPlayer = players.get(pos);
        }  
        else {
            if (players.indexOf(currentPlayer) == players.size() - 1) {
                currentPlayer = players.get(0);
            } else {               
                currentPlayer = players.get(players.indexOf(currentPlayer)+ 1);
            }
        }
        return currentPlayer;
    }
    
    public boolean nextTurnAllowed(){
        boolean ret;
        if (currentPlayer == null)
            ret = true;       
        else
            ret = currentPlayer.validState();
    
        return ret;
    }
    
    private void setEnemies(){
        int rand = 0;
        for(int i=0; i<players.size(); i++){
            while(rand == i) rand = (int) (players.size()*Math.random());
            players.get(i).setEnemy(players.get(rand));
        }
    }

    public static Napakalaki getInstance() {
        return instance;
    }
    
    public CombatResult developCombat(){
//        CombatResult combatResult;
//	combatResult = currentPlayer.combat(currentMonster);
//	dealer.giveMonsterBack(currentMonster);
//		
//	if(combatResult == CombatResult.LOSEANDCONVERT){
//            CardDealer dealer = CardDealer.getInstance();
//            Cultist sectario = dealer.nextCultist();
//			
//            CultistPlayer jugador_sect = new CultistPlayer(currentPlayer, sectario);
//			
//            int actual = players.indexOf(currentPlayer);
//			
//            currentPlayer = jugador_sect;
//            players.set(actual, jugador_sect);
//	}
//        
//        return combatResult;


        CombatResult combatResult = currentPlayer.combat(currentMonster);
        
        if (combatResult == CombatResult.LOSEANDCONVERT){
            Cultist cultist = dealer.nextCultist();
            Player newPlayer = new CultistPlayer(currentPlayer,cultist);
            int pos = players.indexOf(currentPlayer);
            players.set(pos,newPlayer);
            for(Player p:players) {
                if (p.enemy == currentPlayer)
                    p.enemy = newPlayer;
            }
            currentPlayer = newPlayer;
        }
        
        dealer.giveMonsterBack(currentMonster);
        return combatResult;

    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure t:treasures){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure t:treasures){
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(int i=0; i<treasures.size(); i++){
            Treasure t = treasures.get(i);
            currentPlayer.makeTreasureVisible(t);
        }
    }
        
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
     
    
    public boolean nextTurn(){
        boolean stateOK, dead;
        
        stateOK = true;
        if (currentPlayer != null)
            stateOK = nextTurnAllowed();
        
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            dead = currentPlayer.isDead();
            
            if (dead)
                currentPlayer.initTreasures();
        }
    
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }

}
    

