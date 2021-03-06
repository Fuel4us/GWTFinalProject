/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1160630.services;

/**
 *
 * @author pedromonteiro
 */
public enum CellStyleLine {
    DASHED("dashed"), DOTTED("dotted"), DOUBLE("double"), SOLID("solid");
    
    public String value;
    CellStyleLine(String value) {
        this.value = value;
    }
    
    static public CellStyleLine getCellStyleByValue(String value){
        for(CellStyleLine style: CellStyleLine.values()){
            if(style.value.equals(value)) return style;
        }
        
        return null;
    }
}
