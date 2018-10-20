package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Game;
import main.java.model.BattleArea;
import main.java.model.Player;
import main.java.model.Ship;

public class GameTest {
	Player player1;
	Player player2;
	Game game;
	
	
	@Before
	public void setUp() throws Exception {
		BattleArea battleArea1 = new BattleArea(5, 5);
		BattleArea battleArea2 = new BattleArea(5, 5);
		player1 = new Player("Player-1",battleArea1);
		player2 = new Player("Player-2", battleArea2);
		player1.addShip(new Ship('Q',1,1,"A1"));
		player1.addShip(new Ship('P',2,1,"D4"));
		player2.addShip(new Ship('P',2,1,"C3"));
		
		player1.setUnusedMissiles("A1 B2 B2 B3");
		player2.setUnusedMissiles("A1 B2 B3 A1 D1 E1 D4 D4 D5 D5");
		game = new Game();
	}

	@Test
	public void resultTest() {
		game.attack(player1, player2);
		assertEquals(game.getWinner(), "Player-2");
	}

}
