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
public class NumericBadConsequence extends BadConsequence{
    private int nVisiblesTreasures;
    private int nHiddenTreasures;   
    private boolean death = false;
    
    NumericBadConsequence(String t, int l, int nvisible, int nhidden){
        super(t,l);
        this.nVisiblesTreasures=nvisible;
        this.nHiddenTreasures=nhidden;
    }
    
    NumericBadConsequence(String t){
        super(t);
    }
    
    NumericBadConsequence(NumericBadConsequence n){
        super(n.getText(), n.getLevels());
        this.nVisiblesTreasures= n.getNVisibleTreasures();
        this.nHiddenTreasures= n.getNHiddenTreasures();
    }
    
    @Override
    public int getNVisibleTreasures(){
        return this.nVisiblesTreasures;
    }
    
    @Override
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public void setNVisiblesTreasures(int n){
        this.nVisiblesTreasures=n;
    }
    
    public void setNHiddenTreasures(int n){
        this.nHiddenTreasures=n;
    }
    
    @Override
    public String toString(){
        return (super.getText()  + "\nTesoros ocultos que te quitan = " + Integer.toString(nHiddenTreasures) + "\nTesoros equipados que te quitan = " + Integer.toString(nVisiblesTreasures)) ;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        NumericBadConsequence bc = new NumericBadConsequence(this);
        
        if(v.size()< this.getNVisibleTreasures())
            bc.setNVisiblesTreasures(v.size());
        if(h.size()< this.getNHiddenTreasures())
            bc.setNHiddenTreasures(h.size());
        
        return bc;
        
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(this.nVisiblesTreasures!=0)
            nVisiblesTreasures--; 
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures!=0)
            nHiddenTreasures--;  
    }
    
    
    @Override
    public boolean isEmpty(){   
        boolean resultado=false;
        if( nHiddenTreasures==0 && nVisiblesTreasures==0) 
            resultado=true;
        return resultado;
    }
    
    public void cuantoMalRollo(){
        System.out.println("Te queda " + nVisiblesTreasures + " tesoros visibles y " + nHiddenTreasures + " tesoros ocultos.");
    }

    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        NumericBadConsequence bc = new NumericBadConsequence(this);
        
        if(v.size()< this.getNVisibleTreasures())
            bc.setNVisiblesTreasures(v.size());
        if(h.size()< this.getNHiddenTreasures())
            bc.setNHiddenTreasures(h.size());
        
        return bc;
    }

    @Override
    public boolean isDeath() {
        return this.death;
    }

    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return null;
    }

    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return null;
    }

}
