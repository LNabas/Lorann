/**
 * 
 */
package model;

import contract.Permeability;

/**
 * @author Maxence
 *
 */
public class Item extends Entity{
	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}
}
