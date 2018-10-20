package test.java;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import main.java.model.BattleArea;
import main.java.model.Ship;

public class BattleAreaTest {
	BattleArea battleArea;

	@Before
	public void setUp() throws Exception {
		battleArea = new BattleArea(5, 5);
	}

	@Test
	public void testSetOccupied() {
		Ship ship1 = new Ship('Q',1,1,"A1");
		Ship ship2 = new Ship('Q',1,1,"A1");
		
		battleArea.setOccupied(ship1);
		assertFalse(battleArea.setOccupied(ship2));
	}

}
