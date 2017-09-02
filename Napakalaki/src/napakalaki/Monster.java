/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author user
 */

public class Monster {
    
    private String name;
    private int combatLevel;
    private int levelChangeAgainstCultistPlayer;
    private int icon;
    
    private Prize prize;
    private BadConsequence bc;
    
    @Override
    public String toString() {
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel + ", prize=" + prize + ", bc=" + bc + '}';
    }

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public int getLevelsGained() {
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }

    public BadConsequence getBadConsequence() {
        return bc;
    }
    
    public Monster(String name, int level, Prize prize, BadConsequence bc, int icon){
        this.name = name;
        combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer = 0;
        this.icon = icon;
    }
    
    public Monster(String name, int level, BadConsequence bc ,Prize prize, int IC, int icon){
        this.name = name;
        combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer = IC;
        this.icon = icon;
    }
    
    public int getIcon(){ return this.icon;}
    
    public int getCombatLevelAgainstCultistPlayer(){ return this.combatLevel+this.levelChangeAgainstCultistPlayer; }

    
    
}
