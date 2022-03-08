package TwoPointer.Hard;

/**
 * Created by Shuhua Song
 */
public class _2193_MinimumNumberOfMovesToMakePalindrome {


      public int minMovesToMakePalindrome(String s) {
        if(!isValid(s)) return -1;
        int n = s.length(), count = 0;
        char[] chs = s.toCharArray();
        for(int i=0; i<n/2; i++){
            int left = i;
            int right = n-i-1;
            //A loop which run from right pointer toward left pointer
            while(left < right){
                //if both char same, then break the loop
                //if not, then move right pointer to one position left
                if(chs[left]==chs[right]){
                    break;
                }else{
                    right--;
                }
            }
            //if both pointer are at the same position, it denotes that
            //we need to swap the char on the left position with next one, and move pointer
            //one position back
            if(left==right){
                char t = chs[left];
                chs[left] = chs[left+1];
                chs[left+1] = t;
                count++;
                i--;
            }else{
                //swap and increase the count
                for(int k=right; k<n-left-1; k++){
                    char t = chs[k];
                    chs[k] = chs[k+1];
                    chs[k+1] = t;
                    count++;
                }
            }
        }
        return count;
    }

    //check the is a stirng is palindrom by checking the occurence of character
    private boolean isValid(String s){
        int[] bank = new int[26];
        int odd = 0;
        for(char c : s.toCharArray()){
            bank[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(bank[i]!=0 && bank[i]%2 != 0){
                odd++;
            }
        }
        return odd <= 1;
    }

}


/*
Approach
The following are detailed steps to solve this problem.

Take two-pointer where the first pointer track from the left side of a string and second pointer keep track from the right side of a string.
Till the time we find the same character, keep moving the right pointer to one step left.
If the same character not found then return -1.
If the same character found then swap the right pointer’s character towards the right until it is not placed at its correct position in a string.
Increase left pointer and repeat step 2.

  left    right    count     new String
  0        9 --     0--     skwhhaaunskun
  1        9 --     3--     skwhhaaunkuns
  2        2 --     5--     skwhhaaununks
  2        4 --     6--     skhwhaaununks
  3        3 --     12--    skhwaaununhks
  3        5 --     13--    skhawaununhks
  4        4 --     17--    skhawununahks
  4        7 --     18--    skhauwnunahks
  5        5 --     19--    skhauwnnuahks
  5        7 --     20--    skhaunwnuahks


 */
