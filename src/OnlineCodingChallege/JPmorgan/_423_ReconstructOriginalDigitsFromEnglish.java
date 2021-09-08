package OnlineCodingChallege.JPmorgan;

/**
 * Created by Shuhua Song
 */
public class _423_ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        if(s==null || s.length()==0) return s;
        int bank[] = new int[26];
        for(char c : s.toCharArray()){
            bank[c-'a']++;
        }
        int[] nums = new int[10];

        nums[0] = bank['z'-'a'];//'z' only present in "zero"
        nums[2] = bank['w'-'a'];//'w' only present in "two"
        nums[4] = bank['u'-'a'];//'u' only present in "four"
        nums[6] = bank['x'-'a'];//'x' only present in "six"
        nums[8] = bank['g'-'a'];//'g' only present in 'eight'
        nums[3] = bank['h'-'a'] - nums[8]; //'h' = "three" + "eight"
        nums[5] = bank['f'-'a'] - nums[4]; //'f' = "five" + "four"
        nums[7] = bank['s'-'a'] - nums[6]; //'s' = "six" + "seven"
        nums[9] = bank['i'-'a'] - nums[5] - nums[6] - nums[8]; // 'i' = "five"+"six"+"eight"+"nine"
        nums[1] = bank['n'-'a'] - nums[7] - 2 * nums[9]; //'n' = "one"+"nine"+seven

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            for(int j=0; j<nums[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

}
