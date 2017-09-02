/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author david
 */
public class SpecificBadConsequence extends BadConsequence{
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> nvisible, ArrayList<TreasureKind> nhidden){
        super(text, levels);
        this.specificVisibleTreasures=nvisible;
        this.specificHiddenTreasures=nhidden;
    }
    
    SpecificBadConsequence(SpecificBadConsequence n){
        super(n.getText(), n.getLevels());
        this.specificVisibleTreasures= n.getSpecificVisibleTreasures();
        this.specificHiddenTreasures= n.getSpecificHiddenTreasures();
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    private void setSpecificHiddenTreasures(ArrayList<TreasureKind> h){
        specificHiddenTreasures=h;
    }   
    private void setSpecificVisibleTreasures(ArrayList<TreasureKind> v){
        specificVisibleTreasures=v;
    }
    @Override
    public String toString(){
        return (super.getText() +  "\nTesoros Visibles: "+specificVisibleTreasures.toString() + "\nTesoros Ocultos = " + specificHiddenTreasures.toString());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
        ArrayList<TreasureKind> visible = specificVisibleTreasures;
	ArrayList<TreasureKind> hidden = specificHiddenTreasures;
		
	SpecificBadConsequence devuelve = new SpecificBadConsequence(this.getText(), this.getLevels(), new ArrayList(), new ArrayList()  );
		
	for (int i = 0; i < v.size(); i++) {
            if ( visible.contains(v.get(i).getType() ) ) {
                devuelve.specificVisibleTreasures.add(v.get(i).getType());
                visible.remove(v.get(i).getType() );
            }
	}
        
	for (int i = 0; i < h.size(); i++) {
            if ( hidden.contains (h.get(i).getType() ) ) {
                devuelve.specificHiddenTreasures.add(h.get(i).getType());
                hidden.remove(h.get(i).getType() );
            }
	}
        
	return devuelve;

    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        boolean in;
        int index;
        index = -1;
        in = false;
        for (int i=0; i<specificVisibleTreasures.size(); ++i){
            if (specificVisibleTreasures.get(i) == t.getType()){
                in = true;
                index = i;
            }
        }

        if (in == true)
            specificVisibleTreasures.remove(index);   
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        boolean in;
        int index;
        index = -1;
        in = false;
        for (int i=0; i<specificHiddenTreasures.size(); ++i){
            if (specificHiddenTreasures.get(i) == t.getType()){
                in = true;
                index = i;
            }
        }

        if (in == true)
            specificHiddenTreasures.remove(index); 
    }
    
    @Override
    public boolean isEmpty(){   
        boolean resultado=false;
            if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
            resultado=true;
        return resultado;
    }       
    
    public void cuantoMalRollo(){
    System.out.println("Te queda " + specificVisibleTreasures + " tesoros visibles y " + specificHiddenTreasures + " tesoros ocultos.");
    }

    @Override
    public int getNVisibleTreasures() {
        return 0;
    }

    @Override
    public int getNHiddenTreasures() {
        return 0;
    }

    @Override
    public boolean isDeath() {
        return false;
    }
}
