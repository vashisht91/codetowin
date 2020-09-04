package ds;

import java.util.*;

public class UniquePathsII {

	public static void main(String[] args) {
//		int[][] interval = {{0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,0,0},{1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,1},{0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0},{0,0,0,0,0,1,0,0,0,0,1,1,0,1,0,0,0,0},{1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},{0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0},{0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0},{0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1},{0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},{1,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,0},{0,0,0,1,0,0,0,0,1,1,1,0,0,1,0,1,1,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1},{0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0},{1,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,0},{1,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,1},{1,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0}};
		int[][] interval = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
		for(int i=0; i<interval.length; i++) {
			System.out.println(Arrays.toString(interval[i]));
		}
		System.out.println(uniquePathsWithObstacles(interval));
		
	}
	
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;

	        if(obstacleGrid[0][0] == 1)
	            return 0;
	        
	        obstacleGrid[0][0] = 1;
	        
	        for(int i=1 ; i<n ; i++) {
	             obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
	        }
	        
	        for(int j=1 ; j<m ; j++) {
	             obstacleGrid[j][0] = (obstacleGrid[j][0] == 0 && obstacleGrid[j-1][0] == 1) ? 1 : 0;
	        }
	        
	        for(int k=1; k<m ; k++) {
	            for(int l=1; l<n ; l++) {
	                obstacleGrid[k][l] = (obstacleGrid[k][l] == 1) ? 0 : (obstacleGrid[k-1][l] + obstacleGrid[k][l-1] );
	            }
	        }
	        
	        return obstacleGrid[m-1][n-1];
	    }

	
	/* public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int result = 0; 
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;

	        int[] arr = {0,0} ;
	        
	        Queue<int[]> q = new LinkedList<>();
	        q.add(arr);
	        
	        while(!q.isEmpty()) {
	            int row = q.peek()[0];
	            int col = q.remove()[1];
	            if(obstacleGrid[row][col]==1)
	                continue;
	            if(row==m-1 && col == n-1 )
	                result++;
	            
	            else {
	                if(col+1 <= n-1 && obstacleGrid[row][col+1] !=2 && obstacleGrid[row][col+1] !=1) {
	                   obstacleGrid[row][col] = 2;
	                   arr = new int[2];
	                   arr[0] = row;
	                    arr[1] = col+1;
	                    
	                   q.add(arr); 
	                }
	                if(row+1 <= m-1 && obstacleGrid[row+1][col] !=2 && obstacleGrid[row+1][col] !=1) {
	                   obstacleGrid[row][col] = 2;
	                   arr = new int[2];
	                   arr[0] = row+1;
	                    arr[1] = col;
	                   q.add(arr); 
	                }
	            }
	            
	            for(int i=0; i<obstacleGrid.length; i++) {
	    			System.out.println(Arrays.toString(obstacleGrid[i]));
	    		}
	            
	            
	        }
	        return result;
	    }*/
}
