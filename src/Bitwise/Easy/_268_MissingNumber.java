package Bitwise.Easy;

/**
 * Created by Shuhua Song
 */
public class _268_MissingNumber {

    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for(int i=0; i<nums.length; i++){
            miss ^= i ^ nums[i];
        }
        return miss;
    }


    /* HashSet
     public int missingNumber(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int a : nums) set.add(a);
       int m = 0;
       while(m < nums.length && set.contains(m)){
           m++;
       }
        return m;
    }
     */
}
