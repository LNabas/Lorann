/**
 * 
 */
package model;

import contract.Permeability;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class Item extends Entity{
	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}

}
