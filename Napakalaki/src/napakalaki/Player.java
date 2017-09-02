/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Player {

    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    public Player enemy;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList<>();
    private ArrayList<Treasure> visibleTreasures = new ArrayList<>();
    private BadConsequence pendingBadConsequence;
    private boolean soySectario;
    private boolean first = true;

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", level=" + level + ", dead=" + dead +'}';
    }

    public Player(String name) {
        this.name = name;
        level = 1;
        dead = true;
        canISteal = true;
    }
    
    public Player(Player p) {
        name = p.getName();
    }

    public String getName() {
        return name;
    }

    private void bringToLife() {
        dead = false;
    }

    public int getCombatLevel() {
        int combatLevel = level;
        for (int i = 0; i < visibleTreasures.size(); i++) {
            combatLevel += visibleTreasures.get(i).getBonus();
        }
        return combatLevel;
    }

    private void incrementLevels(int i) {
        level += i;
    }

    private void decrementLevels(int i) {
        if(level>i) level-=i;
        else level = 1;
    }

    public void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }

    private void applyPrize(Monster m) {
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if (nTreasures > 0) {
            CardDealer dealer = CardDealer.getInstance();
            for (int i = 0; i < nTreasures; i++) {
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }

    }

    private void applyBadConsequence(Monster m) {
        BadConsequence bc = m.getBadConsequence();
        int nLevels = bc.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = bc.adjustToFitTreasureList(visibleTreasures, hiddenTreasures); 
        setPendingBadConsequence(pendingBad);
    }

    private boolean canMakeTreasureVisible(Treasure t) {
        boolean valid_change = true;
        int n_onehand = 0;
        int n_bothhands = 0;

        for (Treasure tv : visibleTreasures) {
            if (tv.getType() == t.getType() && tv.getType()!=TreasureKind.ONEHAND) {
                valid_change = false;
            }
            if (tv.getType() == TreasureKind.BOTHHANDS) {
                n_bothhands++;
            }
            if (tv.getType() == TreasureKind.ONEHAND) {
                n_onehand++;
            }
        }
        if (t.getType() == TreasureKind.BOTHHANDS && n_onehand != 0) {
            valid_change = false;
        }
        if (t.getType() == TreasureKind.ONEHAND && n_onehand == 2) {
            valid_change = false;
        }
        if (t.getType() == TreasureKind.ONEHAND && n_bothhands == 1) {
            valid_change = false;
        }

        return valid_change;
    }

    private int howManyVisibleTreasures(TreasureKind tKind) {
        int cantidad = 0;
        for (Treasure t : visibleTreasures) {
            if (t.getType() == tKind) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private void dieIfNoTreasure() {
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()) {
            dead = true;
        }
    }

    public int getLevels() {
        return level;
    }

    public boolean isDead() {
        return dead;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public CombatResult combat(Monster m) {
        CombatResult combatResult;
	int myLevel = getCombatLevel();
	int monsterLevel = getOponentLevel(m);
	int enemyLevel;
	int number;

	if (!canISteal()) {
            Dice dice = Dice.getInstance();
            number = dice.nextNumber();

            if (number < 3 && getEnemy() != null) {
                enemyLevel = enemy.getCombatLevel();
            }
	}

	if (myLevel > monsterLevel) {
            applyPrize(m);

            if (level >= MAXLEVEL) {
                combatResult = CombatResult.WINGAME;
            } else {
                combatResult = CombatResult.WIN;
            }
	} else {
            applyBadConsequence(m);
            combatResult = CombatResult.LOSE;
	}

	if (combatResult == CombatResult.LOSE) {
            if (shouldConvert()) {
                combatResult = CombatResult.LOSEANDCONVERT;
            }
	}

	return combatResult;

    }
    
    protected boolean shouldConvert() {
	Dice dice = Dice.getInstance();
	int lanzar = dice.nextNumber();
	boolean deberia = false;

	if (lanzar == 6) {
            deberia = true;
	}

	return deberia;
    }

    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        if (canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        dieIfNoTreasure();
    }

    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        dieIfNoTreasure();
    }

    public boolean validState(){
        boolean ret = true;         
        if ( hiddenTreasures.size() > 4 )
            ret = false;
        if( pendingBadConsequence != null && !pendingBadConsequence.isEmpty() )
            ret = false;
        
        return ret;
    }

    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        if (number > 1) {
            Treasure treasure_2 = dealer.nextTreasure();
            hiddenTreasures.add(treasure_2);
        }
        if (number == 6) {
            Treasure treasure_3 = dealer.nextTreasure();
            hiddenTreasures.add(treasure_3);
        }
    }

    public Treasure stealTreasure() {
        boolean canI = canISteal();
        Treasure t = null;
        if (canI && enemy != null) {
            boolean canYou = enemy.canYouGiveATreasure();
            if (canYou) {
                t = enemy.giveMeATreasure();
                hiddenTreasures.add(t);
                enemy.hiddenTreasures.remove(t);
                haveStolen();
            }
        }
        return t;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    private Treasure giveMeATreasure() {
        return hiddenTreasures.get((int) (hiddenTreasures.size() * Math.random()));
    }

    public boolean canISteal() {
        return canISteal;
    }

    private boolean canYouGiveATreasure() {
        boolean puede_robar = false;
        if (hiddenTreasures.size() != 0) {
            puede_robar = true;
        }

        return puede_robar;
    }

    private void haveStolen() {
        canISteal = false;
    }
    
    public Player getEnemy(){
        return this.enemy;
    }

    public void discardAllTreasures() {
        ArrayList<Treasure> visible = new ArrayList<>(visibleTreasures);
        ArrayList<Treasure> hidden = new ArrayList<>(hiddenTreasures);
        
        for (Treasure t : visible) {
            discardVisibleTreasure(t);
        }
        for (Treasure t : hidden) {
            discardHiddenTreasure(t);
        }
    }
    
    public BadConsequence getPendingBad(){ return this.pendingBadConsequence;}

    protected int getOponentLevel(Monster m) {
        return m.getCombatLevel();
    }

}
