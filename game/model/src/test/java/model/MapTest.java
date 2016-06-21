package model;

import static org.junit.Assert.*;

import org.junit.Test;

import contract.VisualEntity;

public class MapTest extends Map{

	@Test
	public void testResize() {
		resize(10,15);
		assertEquals(10, getWidth());
		assertEquals(15, getHeight());
	}

	@Test
	public void testGetSet() {
		set(10,10, new Paul());
		assertEquals(get(10,10).getVisualType(), VisualEntity.PAUL);
	}

}
