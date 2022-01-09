package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _12_IntegerToRoman {
    public String intToRoman(int num) {
        int[]  nums     =  {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols=  { "M", "CM", "D" ,"CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(num >= nums[i]){
                sb.append(symbols[i]);
                num -= nums[i];
            }

        }
        return sb.toString();
    }
}
