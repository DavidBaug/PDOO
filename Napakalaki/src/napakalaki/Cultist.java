/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author david
 */
public class Cultist {
    private String name;
    private int gainedLevels;   
    
    Cultist(String n, int l){
        this.name = n;
        this.gainedLevels = l;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getGainedLevels(){return this.gainedLevels;}
    
    public int getBasicValue() {
        return this.gainedLevels;
    }

    int getSpecialValue() {
        return this.getBasicValue() * CultistPlayer.getTotalCultistPlayers();
    }
    
}
