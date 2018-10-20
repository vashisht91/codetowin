package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import main.java.model.Ship;

public class ShipTest {
	Ship ship;
	
	@Before
	public void setUp() throws Exception {
		ship = new Ship('Q',1,1,"A1");
	}

	@Test
	public void testSetCells() {
		ship.setCells(2, 2, "A1");
		String[] cells = ship.getCells();
		assertArrayEquals(cells, new String[]{"A1","A2","B1","B2"});
	}

	@Test
	public void testDestroyCell() {
		ship.destroyCell("A1");
		String[] cells = ship.getCells();
		assertEquals(cells[0], "A1H");
	}
	
	@Test
	public void testDestroyCellTwice() {
		ship.destroyCell("A1");
		ship.destroyCell("A1");
		String[] cells = ship.getCells();
		assertEquals(cells[0], "A1HD");
	}
}
