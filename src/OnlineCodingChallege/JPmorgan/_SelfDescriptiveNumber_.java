package OnlineCodingChallege.JPmorgan;

/**
 * Created by Shuhua Song
 */
/*
An integer is said to be self-descriptive if it has the property that, when digit positions are labeled 0 to N-1, the digit in each position is equal to the number of times that this digit appears in the number. Write a function that will check whether a given positive integer is self-descriptive.

Example 1:

Input: 2020
Output: true
Explanation:
Position 0 has value 2 and there are two 0s in the number
Position 1 has value 0 and there are no 1s in the number
Position 2 has value 2 and there are two 2s
Position 3 has value 0 and there are zero 3s
Example 2:

Input: 3211000
Output: true
Explanation:
Position 0 has value 3 and there are three 0s in the number
Position 1 has value 2 and there are two 1s in the number
Position 2 has value 1 and there is one 2 in the number
Position 3 has value 1 and there is one 3 in the number
Position 4 has value 0 and there are zero 4s
Position 5 has value 0 and there are zero 5s
Position 6 has value 0 and there are zero 6s
Follow-up:
Generate all self-descriptive numbers that will fit in a 32-bit integer. There are 6 such integers:

1210
2020
21200
3211000
42101000
521001000

one pass for hash map to get frequency
then another pass to verify element at index == dictionary mapping
otherwise if element is 0, make sure the element is also not in our dictionary
 */
public class _SelfDescriptiveNumber_ {

    private static boolean checkSelfDescript(int num){
        String s = Integer.toString(num);
        char[] chs = s.toCharArray();
        int[] count = new int[10];
        //sum of all digits of a self-descriptive number
        for(char c : chs){
            count[c-'0']++;
        }
        for(int i=0; i<chs.length; i++){
            if(count[i] != (chs[i]-'0')){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int num = 521001000;
        System.out.println(checkSelfDescript(num));
    }
}
/*
1210
2020
21200
3211000
42101000
521001000
 */
