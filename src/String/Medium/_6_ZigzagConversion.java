package String.Medium;

public class _6_ZigzagConversion {

    //Time = O(n)  Space = O(n)
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0) return "";
        if(numRows==1) return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cycLen = 2 * numRows-2;
        for(int i=0; i<numRows; i++){
            for(int j=0; j+i<n; j = j+cycLen){
                sb.append(s.charAt(i+j));
                if(i!=0 && i!=numRows-1 && j+cycLen-i<n){
                    sb.append(s.charAt(j+cycLen-i));
                }
            }
        }
        return sb.toString();
    }
}
