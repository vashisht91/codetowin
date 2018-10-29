package main.java.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Player {
	private String playerName;
	private BattleArea battleArea;
	private List<Ship> ships = new ArrayList<>();
	private boolean turn;
	private Queue<String> unusedMissiles = new LinkedList<>();
	private List<String> usedMissiles =  new ArrayList<>();
	
	
	public Player(String playerName, BattleArea battleArea) {
		super();
		this.playerName = playerName;
		this.battleArea = battleArea;
	}
	
	public Player(String playerName, BattleArea battleArea, List<Ship> ships) {
		super();
		this.playerName = playerName;
		this.battleArea = battleArea;
		this.ships = ships;
	}

	public Player(String playerName, BattleArea battleArea, List<Ship> ships, boolean turn) {
		super();
		this.playerName = playerName;
		this.battleArea = battleArea;
		this.ships = ships;
		this.turn = turn;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}

	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public Queue<String> getUnusedMissiles() {
		return unusedMissiles;
	}

	public void setUnusedMissiles(Queue<String> unusedMissiles) {
		this.unusedMissiles = unusedMissiles;
	}
	
	public void setUnusedMissiles(String missiles) {
		for(String missile : missiles.split(" ")){
			unusedMissiles.add(missile);
		}
	}

	public List<String> getUsedMissiles() {
		return usedMissiles;
	}

	public void setUsedMissiles(List<String> usedMissiles) {
		this.usedMissiles = usedMissiles;
	}
	
	public String useMissile() {
		String missile = unusedMissiles.remove();
		usedMissiles.add(missile);
		return missile;
	}
	
	public boolean addShip(Ship ship) {
		if(battleArea.setOccupied(ship)) {
			return ships.add(ship);
		}
		return false;
	}
	
	public boolean hitTarget(Player player) {
		boolean hit = false;
		String target = unusedMissiles.poll();
		if(target!= null) {
			for(Ship ship : player.getShips()) {
				boolean found = false;
				for(String cell : ship.getCells()) {
					if(cell.contains(target)) {
						hit = ship.destroyCell(target);
						found = true;
						break;
					}
				}
				if(found) {
					break;
				}
			}
		}
		if(hit) {
			System.out.println(this.getPlayerName()+ " fires a missile with target "+target+ " which got hit");
		}
		else {
			System.out.println(this.getPlayerName()+ " fires a missile with target "+target+ " which got miss");
		}
		return hit;
	}
	
	
//	TODO Simplify it
	public int getActiveShipsCount() {
		int count = 0;
		for(Ship ship : ships) {
			if(ship.isShipActive()) {
				count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		return "###################################################################################\n"
				+ "Player [\n playerName=" + playerName + ",\n battleArea=" + battleArea.toString() + ",\n ships=" + ships + ",\n turn=" + turn
				+ ",\n unusedMissiles=" + unusedMissiles + ",\n usedMissiles=" + usedMissiles + "]\n"
						+ "###################################################################################\n";
	}
	


}
