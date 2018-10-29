package main.java;

import main.java.model.Player;

public class Game {
	public String winner = null;

	public Game() {}
	
	public void attack(Player player1, Player player2) {
		boolean result = false;
		Player currentPlayer = null;
		Player opponent = null;
		player1.setTurn(true);
		player2.setTurn(false);
		
//		TODO dont user currentplayer/opponent
		while(!result) {
			if(player1.isTurn()) {
				if(!player1.getUnusedMissiles().isEmpty()) {
					currentPlayer = player1;
					opponent = player2;
				}
				else {
					
					currentPlayer = player2;
					opponent = player1;
				}
			}
			else if(player2.isTurn()){
				if(!player2.getUnusedMissiles().isEmpty()) {
					currentPlayer = player2;
					opponent = player1;
				}
				else {
					currentPlayer = player1;
					opponent = player2;
				}
			}
			
			if(!currentPlayer.hitTarget(opponent)) {
				/*Player tempPlayer = currentPlayer;
				currentPlayer = opponent;
				opponent = tempPlayer;*/
				if(!opponent.getUnusedMissiles().isEmpty()) {
					currentPlayer.setTurn(false);
					opponent.setTurn(true);
				}
				else {
					System.out.println(opponent.getPlayerName()+ " has no more missiles left to launch");
				}
			}
			
			//TODO put in single if condition (using a private method check if game has ended) 
			if(currentPlayer.getActiveShipsCount()==0 || opponent.getActiveShipsCount()==0) {
				this.winner = getWinner(player1, player2);
				result = true;
			}
			
			if(currentPlayer.getUnusedMissiles().isEmpty() && opponent.getUnusedMissiles().isEmpty()) {
				this.winner = getWinner(player1, player2);
				result = true;
			}

		}
		
	}
	
	public String getWinner(Player p1, Player p2) {
		String winner = null;
		int p1ActiveShips = p1.getActiveShipsCount();
		int p2ActiveShips = p2.getActiveShipsCount();
//		TODO make it simpler
		if(p1ActiveShips==0 && p2ActiveShips>0) {
			winner = p2.getPlayerName();
		}
		else if(p1ActiveShips>0 && p2ActiveShips==0) {
			winner = p1.getPlayerName();
		}
		else {
			winner = "Draw";
		}
		
		return winner;
	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

/*	public int convertStringChartoInt(String val) {
		char ch = val.charAt(0);
		return (int) ch - 64;
	}*/
}
