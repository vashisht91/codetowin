package gs;

import java.util.ArrayList;
import java.util.List;

public class ArraySpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiralOrder(matrix));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		
		 if(matrix == null)
	            return null;
	        if(matrix.length==0)
	            return new ArrayList<Integer>();
	        int m = matrix.length;
	        int n = matrix[0].length;
	        List<Integer> result = new ArrayList<>();
	        int dir = 0;
	        int i=0, j=0;
	        int count =0;
	        int el = m*n;
	        while(count<el){
	            
	            if(dir%4==0){
	                while(j<(n-(dir/4))) {
	                    result.add(matrix[i][j++]);
	                    count++;
	                }
	                j--;
	                i++;
	                dir++;
	            }
	            if(dir%4==1 && count<el){
	                while(i<(m-(dir/4))) {
	                    result.add(matrix[i++][j]);
	                 count++;   
	                }
	                i--;
	                j--;
	                dir++;
	            }
	            if(dir%4==2 && count<el){
	                while(j>=(dir/4)) {
	                    result.add(matrix[i][j--]);
	                    count++;   
	                }
	                j++;
	                i--;
	                dir++;
	            }
	            if(dir%4==3 && count<el){
	                while(i>(dir/4)) {
	                    result.add(matrix[i--][j]);
	                    count++;   
	                }
	                i++;
	                j++;
	                dir++;
	            }
	            
	        }
	        return result;
    }

}
