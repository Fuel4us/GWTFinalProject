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
package pt.isep.nsheets.shared.ext;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;

/**
 * An interface for extensions to the CleanSheets application.
 * @author Einar Pehrson
 */
public abstract class Extension implements Comparable<Extension> {

	/** The name of the extensions */
	private final String name;

	/** The base key to use for properties of the extensions */
	private final String basePropKey;


	/**
	 * Creates a new extensions.
	 * @param name the name of the extensions
	 */
	public Extension(String name) {
		this.name = name;

		// Builds UI extensions base property key
		String basePropKey = "";
		for (String token : name.toLowerCase().split(" "))
			basePropKey += token;
		this.basePropKey = basePropKey + ".ui.";
	}

	/**
	 * Returns the name of the extensions.
	 * @return the name of the extensions
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Returns the base key to use for properties of the UI extensions.
	 * @return the base key to use for properties of the UI extensions
	 */
	public final String getPropertyKey() {
		return basePropKey;
	}

	/**
	 * Compares this extensions with the given extensions for order.
	 * Ordering is done by the extensions' names.
	 * @param extension the extensions to compared to
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	public final int compareTo(Extension extension) {
		return name.compareTo(extension.name);
	}

	/**
	 * Returns an extensions of the given spreadsheet.
	 * @param spreadsheet the spreadsheet to extend
	 * @return a spreadsheet extensions, or null if none is provided
	 */
	public SpreadsheetExtension extend(Spreadsheet spreadsheet) {
		return null;
	}

	/**
	 * Returns an extensions of the given cell.
	 * @param cell the cell to extend
	 * @return a cell extensions, or null if none is provided
	 */
	public CellExtension extend(Cell cell) {
		return null;
	}

	/**
	 * Returns the user interface extensions of this extensions.
	 * @param uiController the user interface controller
	 * @return a user interface extensions, or null if none is provided
	 */
//	public UIExtension getUIExtension(UIController uiController) {
//		return null;
//	}
}