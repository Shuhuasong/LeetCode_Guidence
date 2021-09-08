package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */
/*
Let users to choose any songs they want to add to community list, but only
in pair of songs with durations that add up to a multiple of 60 seconds(60, 120, 180)
Example 1:
nums = {60, 60, 60}
there will be 3 pairs which are (0,1), (0, 2), and (1, 2) in indexes

Solutions:
 1) get the reminder of each elements
 2) count the number of each remainder
 3) analyze the counts to find the valid pair
 Time = O(n) Space = O(n)
 */
public class _MusicPairs {

    private static int findPair(int[] nums){
        int[] count = new int[60];
        int res = 0;
        for(int num : nums){
            count[num%60]++;
        }
        for(int i=1; i<30; i++){
            res += count[i] * count[60-i];
        }
        res += count[0] * (count[0]-1)/2 + count[30] * (count[30]-1)/2;
        return res;
    }

    public static void main(String[] args) {
       int[] nums = {60, 60, 60};
        System.out.println(findPair(nums));
    }
}
