package main.java.model;

import java.util.Arrays;

public class Ship {
	private char type;
	private int shipWidth;
	private int shipHeight;
	private String position;
	private String[] cells;
	private String shipStatus;

	public Ship(char type, int shipWidth, int shipHeight, String position) {
		super();
		this.type = type;
		this.shipWidth = shipWidth;
		this.shipHeight = shipHeight;
		this.position = position;
		setCells(shipHeight, shipWidth, position);
		this.shipStatus = "Active";
	}
	
	public Ship(char type, int shipWidth, int shipHeight, String position, String[] cells, String shipStatus) {
		super();
		this.type = type;
		this.shipWidth = shipWidth;
		this.shipHeight = shipHeight;
		this.position = position;
		this.cells = cells;
		this.shipStatus = shipStatus;
		this.shipStatus = "Active";
	}

	public boolean destroyCell(String pos) {
		boolean cellHit = false;
		
		for(int i=0 ; i<cells.length; i++) {			
			if(cells[i].contains(pos)) {
				if(cells[i].length()>2 && cells[i].endsWith("D")) {
					break;
				}
				if(type=='Q') {
					if(cells[i].endsWith("H")) {
						cells[i]+="D";
						cellHit = true;
					}
					else {
						cells[i]+="H";
						cellHit = true;
					}
				
				}
				else {
					cells[i]+="D";
					cellHit = true;
				}
				break;
			}		
		}
		
		boolean destroyed = true;
		for(String cell : cells) {
			if(cell.length()>2 && cell.endsWith("D")) {
				continue;
			}
			else {
				destroyed = false;
				break;
			}
		}
		
		if(destroyed) {
			this.shipStatus = "Destroyed";
		}
		
		return cellHit;
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
		this.cells = new String[height*width];
		char yPos = pos.charAt(0);
		int xPos = Integer.parseInt(pos.substring(1, pos.length()));
		int count = 0;
		for(int i=yPos;i<yPos+height;i++) {
			for(int j=xPos;j<xPos+width;j++,count++) {
				cells[count]= (char)i+""+j;
			}
		}
	}
	

	public String[] getCells() {
		return cells;
	}
	
	public String getShipStatus() {
		return shipStatus;
	}

//	Active or Destroyed
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
	
	@Override
	public String toString() {
		return "\nShip [\n type=" + type + ",\n shipWidth=" + shipWidth + ",\n shipHeight=" + shipHeight + ",\n position="
				+ position + ",\n cells=" + Arrays.toString(cells) + ",\n shipStatus=" + shipStatus 
				+ "]";
	}


	
}
