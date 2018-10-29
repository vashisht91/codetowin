package main.java;

public class Utils {

	public static String[][] setBattleArea(int height, int width) {
		String[][] area = new String[height][width];
		char yPos = 'A';
		int xPos = 0;
		for(int i=yPos;i<yPos+height;i++) {
			for(int j=xPos;j<xPos+width;j++) {
				area[i-65][j]= (char)i+""+j;
			}
		}
		return area;
	}
	
	public static String[] setCells(int height, int width, String pos) {
		String[] cells = new String[height*width];
		char yPos = pos.charAt(0);
		int xPos = Integer.parseInt(pos.substring(1, pos.length()));
		int count = 0;
		for(int i=yPos;i<yPos+height;i++) {
			for(int j=xPos;j<xPos+width;j++,count++) {
				cells[count]= (char)i+""+j;
			}
		}
		return cells;
	}
	
	public static int convertStringChartoInt(String val) {
		char ch = val.charAt(0);
		return (int) ch - 64;
	}
}
