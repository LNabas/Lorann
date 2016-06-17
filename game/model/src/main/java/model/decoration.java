/**
 * 
 */
package model;

import contract.Permeability;

/**
 * @author Maxence
 *
 */
public abstract class decoration extends Entity{
	public Permeability getPearmeability(){
		return Permeability.IMPERMEABLE;
	}
	
}
