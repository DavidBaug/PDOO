/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import napakalaki.Treasure;

/**
 *
 * @author david
 */
public class TreasureView extends javax.swing.JPanel {

    private boolean selected = false;
    private Treasure treasureModel;
    
    public boolean isSelected() {return this.selected;}
    
    
    
    public void setTreasure(Treasure t){
        this.treasureModel = t;
        String n = t.getName();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Treasures/"+t.getIcon()+".JPG"))); // NOI18N

    }
    
    
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    
        if (this.isSelected()){
            this.selected = false;
        }else
            this.selected=true;
            
        this.setBackground(new java.awt.Color(255, 128, 0));
        this.setOpaque(selected);
        
        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_formMouseClicked

    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        // Se recorren los tesoros que contiene el panel,
        //almacenando en un vector aquellos que están seleccionados.
        //Finalmente se devuelve dicho vector.
        
        TreasureView tv;
        
        ArrayList<Treasure> output = new ArrayList();
        
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;

            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        
        return output;
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    Treasure getTreasure() {
        return this.treasureModel;
    }
}
