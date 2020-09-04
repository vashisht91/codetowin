package ds;

import java.util.Arrays;

public class GameofBookCricket {

	public static void main(String[] args) {
		System.out.println(noOfWaysToDrawTheGame(6));
	}

	 static int noOfWaysToDrawTheGame(int totalScore) {
	        int scores[][] = new int[3][totalScore+1];
	        int test;


	        scores[0][0] = 1;
	        scores[1][0] = 1;
	        scores[2][0] = 1;

	        for(test=2;test<=totalScore; test++) {
	            scores[0][test] += scores[0][test-2];
	        }
	        
	        for(test=4;test<=totalScore; test++) {
	        	scores[1][test] += scores[0][test-4];
	        	scores[1][test] += scores[1][test-4];
	        }

	        for(test=6;test<=totalScore; test++) {
	        	scores[2][test] += scores[0][test-6];
	        	scores[2][test] += scores[1][test-6];
	        	scores[2][test] += scores[2][test-6];
	        }

	        return scores[2][totalScore];

	    }
}
