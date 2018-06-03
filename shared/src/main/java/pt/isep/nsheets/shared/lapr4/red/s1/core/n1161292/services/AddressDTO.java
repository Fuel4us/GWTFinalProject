package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

import java.io.Serializable;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class AddressDTO implements Serializable {
    
    public int column;
    public int row;
    public String location;
    
    protected AddressDTO() {}
    
    public AddressDTO(int column, int row, String location){
        this.column = column;
        this.row = row;
        this.location = location;
    }
}