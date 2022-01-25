package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _340_LongestSubstringWithAtMostKdistinctCharacter {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;
        String res = "";
        for(int r=0; r<n; r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            //Once find the size of map is greater than k==> update the result
            //when map.size()==k, it may have another same char in the next char
            //So we need to update the result when map.size() > k
            while(map.size() > k){
                if(r-l > maxLen){
                    maxLen = r-l;
                }
                char leftC = s.charAt(l);
                l++;
                map.put(leftC, map.get(leftC)-1);
                if(map.get(leftC)==0) map.remove(leftC);
            }
        }
        maxLen = Math.max(maxLen, n-l);
        return maxLen;
    }


    /* Option
    //Rabin-Karp
    //Time = O(N-L), L = 10
    //Space=  O(N-L), hashset
    public List<String> findRepeatedDnaSequences(String s) {
       int L = 10, n = s.length();
    if (n <= L) return new ArrayList();

    // rolling hash parameters: base a
    int a = 4, aL = (int)Math.pow(a, L);

    // convert string to array of integers
    Map<Character, Integer> toInt = new
            HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
    int[] nums = new int[n];
    for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

    int h = 0;
    Set<Integer> seen = new HashSet();
    Set<String> output = new HashSet();
    // iterate over all sequences of length L
    for (int start = 0; start < n - L + 1; ++start) {
      // compute hash of the current sequence in O(1) time
      if (start != 0){
           h = h * a - nums[start - 1] * aL + nums[start + L - 1];
           System.out.println("h=" + h);
      }

      // compute hash of the first sequence in O(L) time
      else
        for(int i = 0; i < L; ++i){
            h = h * a + nums[i];
            System.out.println("h0=" + h);
        }
      // update output and hashset of seen sequences
      if (seen.contains(h)) output.add(s.substring(start, start + L));
      seen.add(h);
    }
    return new ArrayList<String>(output);
    }
     */
}

/*
/*
Solution-1: HashMap:
1) use a pointer start to iterate  String s, and take
   a substring from s; if the sub already contains in the
   set seen, then we can add it into answer. Otherwise,
   add it into seen for next time checking.
2) we can use map or set to keep if a substring show up
   more than one itme.

Solution-2: Rabin-Karp: Constant-time Slice using Rolling Hash
1) convert String to integer array:
   A=0, C=1, G=2, T=3
    AAAAACCCCCAAAAACCCCCC======>000001111100000111111
2) compute  hash for the first sequence of length L = 10, 0000011111
    hash0 = SUM_i(ci *4^(L-1-i)), i=[0, L-1]
    Here: C0-C4 = 0, C5-C9 = 1
3)  now consider second slice: AAAACCCCCA =====> 0000111110
    remove the leading 0 and add 0 at the end:
    hash = (hash0 * 4 - c0 * 4^L) + C_l+1



case-1:
        association
        with repeat character==> use map

        at most k diff char
        <= k diff char
        "e c e b a"
        l   r
 */
