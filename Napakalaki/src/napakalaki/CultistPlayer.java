/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    CultistPlayer (Player p, Cultist c){
        super(p);
        this.myCultistCard = c;
        totalCultistPlayers++;
    }

    
    //Métodos
    @Override
    public int getCombatLevel() {
        return super.getCombatLevel() + this.myCultistCard.getSpecialValue();

    }

    @Override
    public Player getEnemy(){
        return super.enemy;
    }
    
    @Override
    public boolean shouldConvert() {
        //Siempre devuelve false
        return false;
    }

    @Override
    public int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();

    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    public Cultist getCultistCard() {
        return this.myCultistCard;
    }
    
    
    
}
