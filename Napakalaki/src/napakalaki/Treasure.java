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
public class Treasure {

    @Override
    public String toString() {
        return "Treasure{" + "name=" + name + ", bonus=" + bonus + ", type=" + type + '}';
    }
    
    private String name;
    private int bonus;
    private TreasureKind type;
    private String icon;

    public String getIcon(){ return this.icon;}


    public Treasure(String name, int bonus, TreasureKind type, String icon) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
        this.icon = icon;
    }
    
    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public TreasureKind getType() {
        return type;
    }
   
  
    
}
