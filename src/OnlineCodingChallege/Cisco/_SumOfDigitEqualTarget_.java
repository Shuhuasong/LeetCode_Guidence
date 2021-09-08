package OnlineCodingChallege.Cisco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
input 是 X,Y ，然后 X 是最大可以取多少，Y 是要各个位数加在一起的和，比如 X  = 20  Y= 5 满足的就有 14,5
 */
public class _SumOfDigitEqualTarget_ {

    //upperBound is the maximum allowed
    //target is the required sum of all digits

    static List<Integer> results = new ArrayList<>();
    public static List<Integer> getNum(int uppderBound, int target){
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(nums, 0, 1, 0, uppderBound, target);
        return results;
    }

    private static void dfs(int[] nums, int curNum, int base, int digitSum, int upperBound, int target){
        if(curNum > upperBound) return;
        if(curNum <= upperBound && digitSum == target){
            results.add(curNum);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(curNum==0) continue;
                else{
                    dfs(nums, curNum*10, base*10, digitSum, upperBound, target);
                }
            }else{
                dfs(nums, curNum+base*nums[i], base*10, digitSum+nums[i], upperBound, target);
            }
        }
    }

    public static void main(String[] args) {

       int upperBound = 100, target = 6;
       List<Integer> results  = getNum(upperBound, target);
        System.out.println(results);
    }

}
