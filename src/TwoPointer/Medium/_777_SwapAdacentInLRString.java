package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _777_SwapAdacentInLRString {

    //Solution-1: Time = O(n)
    public boolean canTransform(String s, String e) {
        if(s.length() != e.length()) return false;
        int n = s.length();
        int left = 0, right = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='L') left++;
            if(s.charAt(i)=='R') right++;
            if(e.charAt(i)=='L') left--;
            if(e.charAt(i)=='R') right--;
            //r!=0 is not enough to verify that "L" cannot cross "R" when an "R" is not required to move. Same for l!=0.
            if(left > 0 || right < 0 ||
                    (left<0 && (right!=0 || s.charAt(i)=='R' && e.charAt(i)=='R') ||
                            (right>0 && (left!=0 || s.charAt(i)=='L' && e.charAt(i)=='L'))) ) return false;
        }
        return left==0 && right==0;
    }


    /* Solution-1: Time = O(n)
     public boolean canTransform(String start, String end) {
       if(start.length() != end.length()) return false;
       int n = start.length();
       int[] bank1 = new int[26];
       int[] bank2 = new int[26];
       List<int[]> list1 = new ArrayList<>();
       List<int[]> list2 = new ArrayList<>();
       for(int i=0; i<n; i++){
           char sc = start.charAt(i);
           char ec = end.charAt(i);
           if(sc != 'X'){
               bank1[sc-'A']++;
               list1.add(new int[]{sc-'A', i});
           }
           if(ec != 'X'){
               bank2[ec-'A']++;
               list2.add(new int[]{ec-'A', i});
           }
       }
       for(int i=0; i<26; i++){
           if(bank1[i] != bank2[i]) return false;
       }

       for(int i=0; i<list1.size(); i++){
           int[] p1 = list1.get(i);
           int[] p2 = list2.get(i);
           if(p1[0] != p2[0]) return false;
           if(p1[0]==('L'-'A')){
               if(p1[1] < p2[1]) return false;
           }else{
               if(p1[1] > p2[1]) return false;
           }
       }
        return true;
    }
     */
}


/*
Solution-1: Time = O(n)
start : "RXXLRXRXL"

end:    "XRLXXRRLX"

intuitiive:
1) the relative order of 'R' and 'L' are the same in both String
2) for letter 'L', the index in start-string can  >= index in the end-string, because the
   letter 'L' can move to left until there is 'R'
3) for letter 'R', the index in start-string onln <= index in the end-string, because the
   letter 'R' can move the right until there is 'L'

   */

/*
Solution-2: Time = O(n)
start : "RXXLRXRXL"
end:    "XRLXXRRLX"

intuitiive:
'R' can move to the right until it is blocked by 'L', while 'L' can
move to the left until it blocked by 'R';
We count the number of 'L' and 'R' as follows:
1) the value left could only be zero and negative, but not positive. Because
'L' can move to the left, so 'L' may appear earlier in end-string than in start-string.
So once find left > 0, will return false;
2) the value of right could only be zero or positive, but not negative. Because 'R' can move to right,
so 'R' may appear later in end-string thank in start-string, so return false when right < 0
3)  when left < 0, right == 0. Because when left < 0, one 'L' appear earlier in the end-string, all 'R'
    before the current 'L' in the end-string should also be visited in start
4) when right > 0, left must be 0

*/



















