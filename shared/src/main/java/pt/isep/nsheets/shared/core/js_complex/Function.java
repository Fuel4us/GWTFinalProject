/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.js_complex;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author pedromonteiro
 */
@Entity
public class Function implements Serializable{
    
    @Id
    private String functionId;
    private String functionBody;
    private boolean created;

    public Function(String functionId, String functionBody) {
        this.functionId = functionId;
        this.functionBody = functionBody;
        this.created = true;
    }

    public Function() {
        //For DTO efects
    }
    
    

    public String getFunctionId() {
        return functionId;
    }

    public String getFunctionBody() {
        return functionBody;
    }
    
    public String getFunction(){
        return "function "+functionId+"(){"+functionBody+"}";
    }

    public void setCreated() {
        this.created = false;
    }

    public boolean isCreated() {
        return created;
    }
    
    
    
    
}
