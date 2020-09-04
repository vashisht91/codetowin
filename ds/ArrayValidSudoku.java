package ds;

import java.util.*;

public class ArrayValidSudoku {

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(board));
	}

	
	 public static boolean isValidSudoku(char[][] board) {
	        boolean[][] rule1 = new boolean[9][10];
	        boolean[][] rule2 = new boolean[9][10];
	        boolean[][] rule3 = new boolean[9][10];
	        for(int i=0; i<9; ++i) {
	            for(int j=0; j<9; j++) {
	                char digit = board[i][j];

	                if (digit != '.') {
	                    int idx3 = 3 * (i / 3) + j / 3;
	                    // convert char to int '0' -> 0
	                    digit -= '0';
	                    System.out.println(digit);
	                    if (rule1[j][digit] || rule2[i][digit] || rule3[idx3][digit]) {
	                        return false;
	                    }
	                    rule1[j][digit] = true;
	                    rule2[i][digit] = true;
	                    rule3[idx3][digit] = true; 
	                }
	            }
	        }
	        
	        return true;
	    }
	
	/* public static boolean isValidSudoku(char[][] board) {
	        
	        Set<Character> digits = null;
	   
	        for(int i = 0; i<9 ; i++) {
	             digits = new HashSet<Character>();
	            for(int j = 0; j<9 ; j++) {
	                if(digits.contains(board[i][j]) && board[i][j] != '.') {
	                    return false;
	                }
	                digits.add(board[i][j]);
	            }
	        }
	        for(int i = 0; i<9 ; i++) {
	             digits = new HashSet<Character>();
	            for(int j = 0; j<9 ; j++) {
	               if(digits.contains(board[j][i]) && board[j][i] != '.') {
	                   return false;
	                }
	                digits.add(board[j][i]);
	            }
	        }
	        
	        for(int k=0 ; k<9 ; k++){
	             digits = new HashSet<Character>();
	            for(int i=(k/3)*3 ; i<(k/3)*3 + 3 ; i++) {
	                int start = (k%3)*3;
	                for(int j=start  ; j<start+3 ; j++) {
	                    if(digits.contains(board[i][j]) && board[i][j] != '.') {
	                      return false;
	                    }
	                    digits.add(board[i][j]);
	                }
	            }
	        }
	        
	                System.out.println("Third Done");
	        return true;
	    }*/
	 
	 
}
