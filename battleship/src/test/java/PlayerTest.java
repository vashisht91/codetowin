package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import main.java.model.BattleArea;
import main.java.model.Player;
import main.java.model.Ship;

public class PlayerTest {
	Player player1;
	Player player2;

	@Before
	public void setUp() throws Exception {
		BattleArea battleArea1 = new BattleArea(5, 5);
		BattleArea battleArea2 = new BattleArea(5, 5);
		player1 = new Player("Player-1",battleArea1);
		player2 = new Player("Player-2", battleArea2);
		player1.addShip(new Ship('Q',1,1,"A1"));
		player2.addShip(new Ship('P',2,1,"C3"));
		
	}

	@Test
	public void hitTargetSuccess() {
		player1.setUnusedMissiles("C3");
		assertTrue(player1.hitTarget(player2));
	}

	@Test
	public void hitTargetFailure() {
		player1.setUnusedMissiles("C5");
		assertFalse(player1.hitTarget(player2));
	}
}
