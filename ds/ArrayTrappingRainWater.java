package ds;

public class ArrayTrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trap(height));

	}
	
public static int trap(int[] height) {
        
        int[] maxHeightRight = new int[height.length];
        int maxHeightLeft = 0;
        int maxRightCurrent = 0;
        int maxLeftCurrent = 0;
        int trappedWater = 0;
        
        for(int i=maxHeightRight.length-1 ; i>=0; i--) {
            maxHeightRight[i] = maxRightCurrent;
            if(height[i] >= maxRightCurrent) {
                maxRightCurrent = height[i];
            }
        }
        
        for(int j=0 ; j<=height.length-1; j++) {
            trappedWater += Math.max(Math.min(maxLeftCurrent, maxHeightRight[j]) - height[j], 0);
            if(maxLeftCurrent<height[j])
                maxLeftCurrent = height[j];
        }
        
        return trappedWater;
            
    }

}
