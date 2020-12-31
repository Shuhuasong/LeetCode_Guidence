package String;

public class _14_LongestCommonPrefix {

    //Horizontal Checking: Time = O(S), S = the sum of all characters in all strings
    //Space = O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                //find the first occurence of res in strs[i]
                // edwar.indexOf("edward"), it means we didn't find the "edward" in "edwar", if it == 0, it means it find the string
                System.out.println( i + " " + strs[i].indexOf(prefix) + "  " + prefix);
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //Vertical Checking:
    //Time = O(S), S = the sum of all characters in all strings
  /*  public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i); //check the character by character for every word in array
            for(int j=1; j<strs.length; j++){
                //once find this word'length is equal i or the char of this word is not matching, we return the longest length from now on
                if(i==strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        System.out.println(strs[0]);
        return strs[0];
    }

   */



  /*
     //Binary Search: Time = O(Slogm), S = the sum of all characters in all strings
    // m = the average length of the string in array
    public String longestCommonPrefix(String[] strs) {
       if(strs==null || strs.length==0) return "";
        int minLen = Integer.MAX_VALUE;
        for(String str : strs){
            minLen = Math.min(str.length(), minLen);
        }
        int low = 1, high = minLen;
        while(low <= high){
            int midLen = low + (high-low)/2;
            if(isCommonPrefix(strs, midLen)){
                low = midLen + 1;
            }else{
                high = midLen -1;
            }
        }
        System.out.println(low + " " + high);
        return strs[0].substring(0, (low+high)/2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String subStr = strs[0].substring(0, len);
        for(int i=1; i<strs.length; i++){
            if(!strs[i].startsWith(subStr)){
                return false;
            }
        }
        return true;
    }
   */
}














