package ds;

public class StringReorganizeString {

	public static void main(String[] args) {
		System.out.println(reorganizeString("baaba"));
	}

	
    public static String reorganizeString(String S) {
        if(S== null || S=="")
            return "";
        if(S.length()==1)
            return S;
        int toReplace = -1;
        int curr = 1;
        int prev = 0;
        int l = S.length()-1;
        StringBuilder b = new StringBuilder(S);
        
        while(curr <= l) {
            if(toReplace!=-1) {
                if(b.charAt(prev) != b.charAt(curr)) {
                    char temp = b.charAt(toReplace);
                    b.setCharAt(toReplace, b.charAt(curr)) ;
                    b.setCharAt(curr, temp);
                    prev = toReplace + 1;
                    curr = prev+1;
                    toReplace = -1;
                }
                else{
                    curr++;
                    prev++;
                }
            }
            else{
                if(b.charAt(prev) == b.charAt(curr)) {
                    toReplace = curr;
                }
                curr++;
                prev++;
            }
        }
        
        if(toReplace == -1)
            return b.toString();
        
        return "";
        
    }
}
