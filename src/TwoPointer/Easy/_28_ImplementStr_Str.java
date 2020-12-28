package TwoPointer.Easy;

public class _28_ImplementStr_Str {


    //Substring : Time = O(N(N-L))   space = O(1)
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0) return 0;
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //Two pointer:  Time = O(N(N-L))   space = O(1)
  /*  public int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if(nLen==0) return 0;
        int hP = 0;
        while(hP < hLen-nLen+1){
            //find the position of the first needle character in the haystack string
            while(hP < hLen-nLen+1 && haystack.charAt(hP) != needle.charAt(0)){
                ++hP;
            }
            // compute the max matching string
            int  nP = 0, curLen = 0;
            while(hP<hLen && nP<nLen && haystack.charAt(hP)==needle.charAt(nP)){
                hP++;
                nP++;
                curLen++;
            }
            //if the whole needle string is found, return its start postition
            if(curLen==nLen) return hP - nLen;
            //otherwise, backtrack
            hP = hP-curLen + 1;
        }
        return -1;
    }

   */

}

