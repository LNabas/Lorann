/**
 * 
 */
package model;

import static org.junit.Assert.*;

import org.junit.Test;

import contract.IMap;
import contract.TypeEntity;
import contract.VisualEntity;
import junit.framework.TestCase;

/**
 * @author Maxence
 *
 */
public class PaulTest extends Paul {

	/**
	 * Test method for {@link model.Demon#hit()}.
	 */
	@Test
	public void testHit()  {
		assertEquals(true,hit());
	}

	/**
	 * Test method for {@link model.Demon#isAlive()}.
	 */
	@Test
	public void testIsAlive() {
		assertEquals(true,hit());
	}

}
