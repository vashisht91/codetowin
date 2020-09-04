package ds;

public class SortingFirstBadVersion {
	static int badVersion = 4;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(firstBadVersion(5));
		System.out.println("Time : "+ (System.currentTimeMillis() - start));
	}
	
	public static int firstBadVersion(int n) {
        long start = 1, end = n;
       
        
        
        while(start <= end) {
            long mid = (start+end)/2;
            if(isBadVersion((int)mid)) 
                end = mid-1;
            else
                start = mid+1;
        }
        
        return (int)end+1;
    }
	
	
	/*public static int firstBadVersion(int n) {
		long start = 1, end = n;
		long mid = (start+end)/2;
        
        int result = 0;
        
        while(start <= end) {
            if(isBadVersion((int)mid)) {
                result = (int) mid;
                end = mid-1;
                mid = (start+end)/2;
            }
            else{
                start = mid+1;
                mid = (start+end)/2;
            }
        }
        
        return result;
    }*/
	
	public static boolean isBadVersion(int a) {
		if(a >= badVersion)
			return true;
		return false;
	}

}
