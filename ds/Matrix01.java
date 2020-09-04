package ds;
import java.util.*;

public class Matrix01 {

	public static void main(String[] args) {
		int[][] interval = {{1,1,0,1,1,1,1,1,1,1},{1,1,0,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,1,1,0},{1,1,1,1,1,1,0,0,1,0},{1,0,0,1,1,1,0,1,0,1},{0,0,1,0,0,1,1,0,0,1},{0,1,0,1,1,1,1,1,1,1},{1,0,0,1,1,0,0,0,0,0},{0,0,1,1,1,1,0,1,1,1},{1,1,0,0,1,0,1,0,1,1}};
		for(int i=0; i<interval.length; i++) {
			System.out.println(Arrays.toString(interval[i]));
		}
		System.out.println("----");
		interval = updateMatrix(interval);
		for(int i=0; i<interval.length; i++) {
			System.out.println(Arrays.toString(interval[i]));
		}
	}

	
	public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n ; j++) {
            	if(matrix[i][j]!=0) {
                    int first = Integer.MAX_VALUE;
                    int sec = Integer.MAX_VALUE;
                    if(i!=0)
                        first = matrix[i-1][j];
                    if(j!=0)
                        sec = matrix[i][j-1];
                    
                    matrix[i][j] = Math.min(first, sec);
                    if(matrix[i][j] != Integer.MAX_VALUE)
                    	matrix[i][j]++;
                }
            }
            for(int k=0; k<matrix.length; k++) {
    			System.out.println(Arrays.toString(matrix[k]));
    		}
            System.out.println("----");
        }
        
         for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0 ; j--) {
                if(matrix[i][j]!=0) {
                    int first = Integer.MAX_VALUE;
                    int sec = Integer.MAX_VALUE;
                    int third = Integer.MAX_VALUE;
                    int fourth = Integer.MAX_VALUE;
                    if(i!=0)
                        first = matrix[i-1][j];
                    if(j!=0)
                        sec = matrix[i][j-1];
                    if(i!=m-1)
                    	third = matrix[i+1][j];
                    if(j!=n-1)
                    	fourth = matrix[i][j+1];
                    
                    matrix[i][j] = Math.min(Math.min(first, sec), Math.min(third, fourth)) ;
                    if(matrix[i][j] != Integer.MAX_VALUE)
                    	matrix[i][j]++;
                }
            }
            for(int k=0; k<matrix.length; k++) {
    			System.out.println(Arrays.toString(matrix[k]));
    		}
            System.out.println("----");
        }
        
        return matrix;
    }
}
