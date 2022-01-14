package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _360_SortTransformedArray {
    //Time = O(n), Space = O(n)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length, idx = 0;
        int[] res = new int[n];
        idx = (a < 0 ? 0 : n-1);
        int start = 0, end = n-1;
        while(start <= end){
            int sNum = getVal(nums[start], a, b, c);
            int eNum = getVal(nums[end], a, b, c);
            if(a >= 0){
                if(sNum > eNum){
                    res[idx--] = sNum;
                    start++;
                }else{
                    res[idx--] = eNum;
                    end--;
                }
            }else{
                if(sNum <= eNum){
                    res[idx++] = sNum;
                    start++;
                }else{
                    res[idx++] = eNum;
                    end--;
                }
            }
        }
        return res;
    }

    private int getVal(int x, int a, int b, int c){
        return a*x*x + b*x+c;
    }
}


/*
Note:
for a parabola,
if a>=0, the min is in the middle(vertex), and large data on two sides. so collection date from 0-->vertext<--- n
if a<0, the max is in the middle, and small data on two sides. so collections data from  0-->vertext<--- n


[-4,-2,2,4]
nums[0] : 1*16-4*3+5 = 16-12+5 = 9
nums[1] : 1*4-3*2+5 = 3
*/
