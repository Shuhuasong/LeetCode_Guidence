package String.Easy;

public class _696_CountBinarySubstrings {


    //Time = O(n) Space = O(1)
    public static int countBinarySubstrings(String s) {
        int n = s.length();
        int prev = 0, cur = 1, result = 0;
        for(int i=1; i<n; i++){
            if(s.charAt(i) != s.charAt(i-1)){
                result += Math.min(prev, cur);
                System.out.println(prev + " " + cur);
                prev = cur;
                cur = 1;
            }else{
                cur++;
            }
        }
        //System.out.println(prev + "* " + cur);
        return result + Math.min(prev, cur);
    }

    public static void main(String[] args) {
        String s = "001100";
        System.out.println(countBinarySubstrings(s));
    }

    /*
     public int countBinarySubstrings(String s) {
      int n = s.length();
      int[] group = new int[n];
      int k = 0, result = 0;
      group[0] = 1;
      for(int i=1; i<n; i++){
          if(s.charAt(i) != s.charAt(i-1)){
              group[++k] = 1;
          }else{
              group[k]++;
          }
       }

       for(int i=1; i<=k; i++){
           result += Math.min(group[i], group[i-1]);
       }
       return result;
    }

     */
}

