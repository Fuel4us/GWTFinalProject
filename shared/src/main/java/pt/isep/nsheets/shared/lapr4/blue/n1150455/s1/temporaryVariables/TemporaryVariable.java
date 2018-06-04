/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;

/**
 *
 * @author João Pires 1150455@isep.ipp.pt>
 */
public class TemporaryVariable {

    private Spreadsheet sheet;

    private String variableName;

    private Value variableValue;

    /**
     * Constructor with parameters
     *
     * @param sheet sheet
     * @param varValue varValue
     * @param name name
     */
    public TemporaryVariable(Spreadsheet sheet, String name, Value varValue) {
        this.sheet = sheet;
        this.variableName = name;
        this.variableValue = varValue;
    }

    /**
     * Constructor with no parameters
     */
    public TemporaryVariable() {
    }

    /**
     * Returns the sheet where the temporary variable is being used
     *
     * @return sheet of the temporary variable
     */
    public Spreadsheet getSheet() {
        return sheet;
    }

    /**
     * Returns the name of the temporary variable
     *
     * @return name of temporary variable
     */
    public String getName() {
        return variableName;
    }

    /**
     * Returns the value of the temporary variable
     *
     * @return value of the temporary variable
     */
    public Value getValue() {
        return variableValue;
    }

    public void changeValue(Value value) {
        this.variableValue = value;
    }

    /**
     * @param value is the new value applied to the temporary variable
     */
    public void setValue(Value value) {
        this.variableValue = value;
    }

    /**
     * Method declaration to print
     *
     * @return name and value format
     */
    @Override
    public String toString() {
        return (this.getName());
    }

}
