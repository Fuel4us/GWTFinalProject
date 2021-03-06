/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package pt.isep.nsheets.shared.core.formula;

import com.google.gwt.i18n.client.NumberFormat;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 * A binary operation in a formula.
 *
 * @author Einar Pehrson
 */
public class BinaryOperation extends Operation<BinaryOperator> {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 2326739272985753461L;

    /**
     * The left(first) operand
     */
    private Expression leftOperand;

    /**
     * The right(second) operand
     */
    private Expression rightOperand;

    /**
     * Creates a new binary operation.
     *
     * @param leftOperand the left(first) operand
     * @param operator the binary operator
     * @param rightOperand the right(second) operand
     */
    public BinaryOperation(Expression leftOperand, BinaryOperator operator, Expression rightOperand) {
        super(operator);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        Value newValue = operator.applyTo(leftOperand, rightOperand);
        String decimalFormat = NumberFormat.getFormat("0.00").format(newValue.toDouble());
        return Value.parseValue(decimalFormat);
    }

    /**
     * Returns the left(first) operand.
     *
     * @return an expression tree representing the operand
     */
    public Expression getLeftOperand() {
        return leftOperand;
    }

    /**
     * Returns the right(second) operand.
     *
     * @return an expression tree representing the operand
     */
    public Expression getRightOperand() {
        return rightOperand;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitBinaryOperation(this);
    }

    @Override
    public String toString() {
        return leftOperand + operator.toString() + rightOperand;
    }
}
