package main.java.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.java.Utils;

public class BattleArea {
	private int width;
	private int height;
	private String[][] area;
	private Set<String> occupied = new HashSet<>();
	
	public BattleArea(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		setArea();
	}

	public BattleArea(int width, int height, String[][] area) {
		super();
		this.width = width;
		this.height = height;
		this.area = area;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String[][] getArea() {
		return area;
	}

	public void setArea(String[][] area) {
		this.area = area;
	}
	
	public Set<String> getOccupied() {
		return occupied;
	}

	public void setOccupied(Set<String> occupied) {
		this.occupied = occupied;
	}
	
	public boolean setOccupied(Ship ship) {
		Set<String> tempSet = new HashSet<>();
		tempSet.addAll(occupied);
		for(String cell : ship.getCells()) {
			if(!tempSet.add(cell)) {
				System.out.println("Cell "+ cell+ " already occupied");
				return false;
			}
		}
		occupied = tempSet;
		return true;
	}

	
//	TODO Abstract the coordinate related methods into a different class
	public void setArea() {
		this.area = Utils.setBattleArea(this.height, this.width);
	}

	@Override
	public String toString() {
		return "\nBattleArea [\n width=" + width + ",\n height=" + height + ",\n area=" + Arrays.deepToString(area) + ",\n occupied="
				+ occupied + "]";
	}
	
	
}
