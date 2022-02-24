package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _1915_NumberOfWonderfulSubstrings {

    //Time = O(10*n), Space = O(1)
    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024];
        int mask = 0;
        long result = 0;
        count[0] = 1;
        for(char c : word.toCharArray()){
            int shift = c-'a';
            mask ^= (1 << shift);
            //adding the number of letters are all even
            result += count[mask];
            for(int i=0; i<10; i++){
                //with only one odd number letter
                result += count[mask^(1<<i)];
            }
            count[mask]++;
        }
        return result;
    }

    /*
Explaination:
(A^B^C^A^B^C) = 0, with even number
(A^B^C^A^B^C) ^ A = 001, with one odd number letter

e.g word = "abbaccb"
index  0 1 2 3 4 5 6
       a b b a c c b
mask   1 3 1 0 4 0 2
             |   |
when mask are the same at two positions, the substring
in between must with even number letters

mask = 000
     ^ 001 a
    --------
       001    1
     ^ 010 b
    ---------
       011    3
     ^ 010 b
    ---------
       001    1
     ^ 001 a
    ---------
       000    0
     ^ 100 c
    ---------
       100    4
     ^ 100 c
    ---------
       000    0
     ^ 010 b
    ---------
       010    2

"aabb"
"he"
"jfdghjjejjbghchijfj"
*/





    /*
     //Time Limit EXceed
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        long res = 0;
        Set<String> notValid = new HashSet<>();
        Set<String> valid = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                String sub = word.substring(i, j);
               // System.out.println("sub = " + sub);
                if(notValid.contains(sub)) continue;
                else if(valid.contains(sub)){
                    res++;
                    continue;
                }
                if(sub.length()==1){
                    valid.add(sub);
                    res++;
                    continue;
                }
                if(isValid(sub)){
                    res++;
                    valid.add(sub);
                }else{
                    notValid.add(sub);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s){
        int[] bank = new int[10];
        for(char c : s.toCharArray()){
            bank[c-'a']++;
        }
        int count = 0;
        for(int i=0; i<bank.length; i++){
            if(bank[i] != 0 && bank[i]%2==1) count++;
            if(count > 1) return false;
        }
        return count <= 1;
    }
     */
}
