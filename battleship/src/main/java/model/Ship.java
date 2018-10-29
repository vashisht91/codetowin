package main.java.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import main.java.Utils;

public class Ship {
	private char type;
	private int shipWidth;
	private int shipHeight;
	private String position;
	private String[] cells;
	private boolean isShipActive;
	private Map<String, Integer> cellsMap = new HashMap<>();

	public Ship(char type, int shipWidth, int shipHeight, String position) {
		super();
		validateShipDetails(type, shipWidth, shipHeight, position);
		this.type = type;
		this.shipWidth = shipWidth;
		this.shipHeight = shipHeight;
		this.position = position;
		setCells(shipHeight, shipWidth, position);
		this.isShipActive = true;
	}
	
	public Ship(char type, int shipWidth, int shipHeight, String position, String[] cells, boolean shipStatus) {
		super();
		this.type = type;
		this.shipWidth = shipWidth;
		this.shipHeight = shipHeight;
		this.position = position;
		this.cells = cells;
		this.isShipActive = shipStatus;
		this.isShipActive = true;
	}
	
	public Ship validateShipDetails(char type, int shipWidth, int shipHeight, String position) {
		if(type!='Q' && type!='P') {
			System.out.println("Type of ship should be = {‘P’, ‘Q’}");
			System.exit(0);
		}
		if(shipWidth < 1 || shipWidth > 9) {
			System.out.println("1 <= Width of battleship should be <= Width of Battle area");
			System.exit(0);
		}
		if(shipHeight < 1 || shipHeight > (int) (battleAreaIP[1].charAt(0) -64)) {
			System.out.println("1 <= Height of battleship should be <= Height of Battle area");
			System.exit(0);
		}
		
		return new Ship(type, shipWidth, shipHeight, position);		
	}
	
	public boolean destroyCell(String pos) {
		boolean cellHit = false;
		int hitCount = 0;
		if(cellsMap.get(pos)!=null) {
			hitCount= cellsMap.get(pos);
				if(!isCellDestroyed(hitCount)) {
					cellsMap.put(pos, ++hitCount);
					cellHit = true;
				}							
				
//				TODO Remove ifs from the method and change the way hits are being calculated 
//				TODO incorporate another ship type 'R' which takes 3 hits

//			}		
		}
		
//		TODO Improve the logic
		boolean destroyed = true;
				
		for(int count : cellsMap.values()) {
			if(!isCellDestroyed(count)) {
				destroyed = false;
				break;
			}
		}
		
//		TODO use boolean instead of string for shipstatus
		this.isShipActive = destroyed;
		return cellHit;
	}


	public boolean isCellDestroyed(int count) {
		if(count==1 && this.getType()=='P')
			return true;
		if(count==2 && this.getType()=='Q')
			return true;
		if(count==3 && this.getType()=='R')
			return true;
		return false;
	}
	
	public char getType() {
		return type;
	}

//	type can be 'Q' or 'P'
	public void setType(char type) {
		this.type = type;
	}

	public int getShipWidth() {
		return shipWidth;
	}

	public void setShipWidth(int shipWidth) {
		this.shipWidth = shipWidth;
	}

	public int getShipHeight() {
		return shipHeight;
	}

	public void setShipHeight(int shipHeight) {
		this.shipHeight = shipHeight;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

//	Cell values can be like A1 or A1H (Hit once) or A1D/A1HD (Cell Destroyed) 
	public void setCells(int height, int width, String pos) {		
		this.cells = Utils.setCells(height, width, pos);
		for(String cell : this.cells) {
			cellsMap.put(cell, 0);
		}
	}
	

	public String[] getCells() {
		return cells;
	}
	
/*	public String getShipStatus() {
		return isShipActive;
	}

//	Active or Destroyed
	public void setShipStatus(String shipStatus) {
		this.isShipActive = shipStatus;
	}
	*/
	public boolean isShipActive() {
		return isShipActive;
	}

	public void setShipActive(boolean isShipActive) {
		this.isShipActive = isShipActive;
	}

	@Override
	public String toString() {
		return "\nShip [\n type=" + type + ",\n shipWidth=" + shipWidth + ",\n shipHeight=" + shipHeight + ",\n position="
				+ position + ",\n cells=" + Arrays.toString(cells) + ",\n shipStatus=" + isShipActive 
				+ "]";
	}


	
}
