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
package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;

/**
 * A concatenator of strings.
 * @author Einar Pehrson
 */
public class Concatenator implements BinaryOperator {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 4364553607579868067L;

	/**
	 * Creates a new concatenator.
	 */
	public Concatenator() {}

	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		return new Value(
			leftOperand.evaluate().toText()
			+
			rightOperand.evaluate().toText()
		);
	}

	public String getIdentifier() {
		return "&";
	}

	public Value.Type getOperandValueType() {
		return Value.Type.TEXT;
	}

	public String toString() {
		return getIdentifier();
	}
}