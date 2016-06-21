package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class FireballTest extends Fireball{

	public FireballTest() {
		super(0,0);
	}

	@Test
	public void testhit() {
		assertEquals(false,hit());
	}
	
	public void testmove(){
		switch (me){
		case FIREBALL:
			return;
		case FIREBALL1:
			return;
		case FIREBALL2:
			return;
		case FIREBALL3:
			return;
		case FIREBALL4:
			return;
		default:
			fail("It doesn't works");
			break;
		}
	}
}


