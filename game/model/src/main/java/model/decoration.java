/**
 * 
 */
package model;

import contract.Permeability;

/**
 * @author Maxence
 *
 */
public abstract class decoration {
	public Permeability getPearmeability(){
		return Permeability.IMPERMEABLE;
	}
	
}
