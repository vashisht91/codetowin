package main.java.model;

import java.util.Scanner;

import main.java.Game;

public class Play {
	static String[] battleAreaIP;
	static int battleShipCount;
	static String[] dimensions;
	static String missiles1;
	static String missiles2;
	static BattleArea battleArea1;
	static BattleArea battleArea2;
	static Player player1;
	static Player player2;
	
	
	public static void main(String[] args) {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		battleAreaIP = readBattleAreaIP(scanner.nextLine());
		battleShipCount = readBattleshipCount(scanner.nextLine());
		String[] dimensions = new String[battleShipCount];
		for(int i=0 ; i<dimensions.length ; i++) {
			dimensions[i] = scanner.nextLine();
		}
		String missiles1 = scanner.nextLine();
		String missiles2 = scanner.nextLine();
		scanner.close();
		
		BattleArea battleArea1 = new BattleArea(Integer.parseInt(battleAreaIP[0]), game.convertStringChartoInt(battleAreaIP[1]));
		BattleArea battleArea2 = new BattleArea(Integer.parseInt(battleAreaIP[0]), game.convertStringChartoInt(battleAreaIP[1]));
		
		player1 = new Player("Player-1", battleArea1);
		player2 = new Player("Player-2", battleArea2);
		
		for(int i=0 ; i<dimensions.length ; i++) {
			String[] shipDetails = dimensions[i].split(" ");
			Ship ship1 = readShipDetails(shipDetails[0].charAt(0), Integer.parseInt(shipDetails[1]), Integer.parseInt(shipDetails[2]), shipDetails[3]);
			Ship ship2 = readShipDetails(shipDetails[0].charAt(0), Integer.parseInt(shipDetails[1]), Integer.parseInt(shipDetails[2]), shipDetails[4]);
			
			player1.addShip(ship1);
			player2.addShip(ship2);
		}

		player1.setUnusedMissiles(missiles1);
		player2.setUnusedMissiles(missiles2);
		
		System.out.println(player1);
		System.out.println(player2);
		
		game.attack(player1, player2);
		if(!"Draw".equalsIgnoreCase(game.getWinner())) {
			System.out.println(game.getWinner() + " won the battle");
		}
		else {
			System.out.println("Match ended in a draw");
		}

	}

	
	public static String[] readBattleAreaIP(String battleArea) {
		String[] area = battleArea.split(" ");
		if( (Integer.parseInt(area[0]) >= 1 && Integer.parseInt(area[0])<=9)  && (area[1].charAt(0)>='A' && area[1].charAt(0)<='Z')) {
			return area;
		}
		else {
			System.out.println("1 <= Width of Battle area should be <= 9 and A <= Height of Battle area should be <= Z");
			System.exit(0);
		}
		return null;
	}
	
	public static int readBattleshipCount(String battleshipCount) {
		int count = Integer.parseInt(battleshipCount);
		if(count >= 1 && count <= (Integer.parseInt(battleAreaIP[0]) * (int) (battleAreaIP[1].charAt(0) -64) )) {
			return count;
		}
		else {
			System.out.println("1 <= Number of battleships should be <= Width * Height of battleArea");
			System.exit(0);
		}
		return 0;
	}
	
	public static Ship readShipDetails(char type, int shipWidth, int shipHeight, String position) {
		if(type!='Q' && type!='P') {
			System.out.println("Type of ship should be = {‘P’, ‘Q’}");
			System.exit(0);
		}
		if(shipWidth < 1 || shipWidth > Integer.parseInt(battleAreaIP[0])) {
			System.out.println("1 <= Width of battleship should be <= Width of Battle area");
			System.exit(0);
		}
		if(shipHeight < 1 || shipHeight > (int) (battleAreaIP[1].charAt(0) -64)) {
			System.out.println("1 <= Height of battleship should be <= Height of Battle area");
			System.exit(0);
		}
		
		return new Ship(type, shipWidth, shipHeight, position);		
	}
}
