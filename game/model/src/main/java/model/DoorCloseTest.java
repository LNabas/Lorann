package model;

import static org.junit.Assert.*;

import org.junit.Test;

import contract.Permeability;
import contract.TypeEntity;
import contract.VisualEntity;

public class DoorCloseTest extends DoorClose{

	@Test
	public void testhit() {
		assertEquals(true,hit());
	}
	
	public void testgetPearmeability() {
		assertEquals(Permeability.IMPERMEABLE,getPermeability());
	}
	
	public void testgetVisualType() {
		assertEquals(VisualEntity.DOOR_CLOSED,getVisualType());
	}
	
	public void testgetType() {
		assertEquals(TypeEntity.DOORCLOSE,getType());
	}


}
