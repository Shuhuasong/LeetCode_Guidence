package DynamicProgramming.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e, (a, b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else{
                return a[0]-b[0];
            }
        });
        int n = e.length;
        int[] nums = new int[n];
        for(int i=0; i<e.length; i++){
            nums[i] = e[i][1];
            // System.out.println(e[0] + " " + e[1]);
        }
        int maxLen = 0, len = 0;
        int[] dp = new int[n];
        for(int num : nums){
            //find an index to insert the curr num into dp
            int index = Arrays.binarySearch(dp,0, len, num);
            if(index < 0){
                //the index is less than 0, convert it to positive
                index = -(index+1);
            }
            //if current index is good to insert a number
            dp[index] = num;
            if(index==len){
                len++;
            }
        }
        return len;
    }
}

/*

Why sort the second number in decreasing order:
e.g: if we sort first and second both in increasing order,
     we need to repeatly check the the if the first element is fit
    [[1, 3], [1, 4], [1, 5], [2, 3]]

if we sort the second elem in decreasing order,then got the second elem
order:
      [5, 4, 3, 3], which correctly reflects an LIS of one.

case-2:
       [3, 4], [12, 15], [12, 2], [30, 50]
dp[4]
0,0:  4    dp[0]=4,  len = 1
0,1: 15    dp[1]=15, len = 2
0,2:  2    dp[0]=2,  len = 2
0,2: 50    dp[2]=50, len = 3



[[10,8],[1,12],[6,15],[2,18]]
[[5,4],[6,4],[6,7],[2,3]]
[[1,1],[1,1],[1,1]]
[[7,8],[12,16],[12,5],[1,8],[4,19],[3,15],[4,10],[9,16]]
*/

