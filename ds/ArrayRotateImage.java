package ds;

import java.util.Arrays;

public class ArrayRotateImage {

	public static void main(String[] args) {
//		int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] image = {{ 5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		
		for(int i=0; i<image.length ; i++)
			System.out.println(Arrays.toString(image[i]));	
		rotate(image);
		System.out.println("----");	
		for(int i=0; i<image.length ; i++)
			System.out.println(Arrays.toString(image[i]));		
	}

	 public static void rotate(int[][] matrix) {
	        int n = matrix[0].length;
	        int start = 0;
	       
	        myRotate(matrix, n, start);
	        
	    }
	    
	    public static void myRotate(int[][] matrix, int length, int start) {
	        int count = 0;
	        int i = start;
	        int j = start;
	        int next = 0;
	        int curr = 0;
	        while(count<(length-1)*4) {
	            int val =  (-1 * (i-start - (length-1)) ) + start;
	            if(count%4 == 0) {
	            	curr = matrix[i][j];
	            }
	            next = matrix[j][val];
	            	
	            matrix[j][val] = curr ;  
	            i = j;
	            j = val;
	            curr = next;
	            count++;
//	            if(count%4==0 && i==start && j==start) {
	            if(count%4==0) {
	                j++;
	            }
	            
	        }
	        
	        for(int k=0; k<matrix.length ; k++)
				System.out.println(Arrays.toString(matrix[k]));
	        
	        if(length-2 > 1) {
	            myRotate(matrix, length-2, start+1);
	        }
	    }
	
}
