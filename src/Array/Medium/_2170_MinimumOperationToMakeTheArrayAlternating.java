package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _2170_MinimumOperationToMakeTheArrayAlternating {
    public int minimumOperations(int[] nums) {
        int[][] freq = new int[100001][2];
        for(int i=0; i<nums.length; i++){
            if(i%2==0) freq[nums[i]][0]++;
            else
                freq[nums[i]][1]++;
        }
        int n = nums.length;

        int evenMax_val = 0, evenMax_freq = 0;
        int even2Max_val = 0, even2Max_freq = 0;

        int oddMax_val = 0, oddMax_freq = 0;
        int odd2Max_val = 0, odd2Max_freq = 0;

        //Find the evenMax_val, evenMax_freq
        // and the oodMax_val, oddMax_freq
        for(int j=0; j<n; j++){
            //even positon
            int i = nums[j];
            if(j%2==0){
                if(freq[i][0] > evenMax_freq){
                    evenMax_freq = freq[i][0];
                    evenMax_val = i;
                }
            }else{
                if(freq[i][1] > oddMax_freq){
                    oddMax_freq = freq[i][1];
                    oddMax_val = i;
                }
            }
        }

        //Fine the even2Max_val, even2Max_freq
        // and the odd2Max_val, odd2Max_freq
        for(int j=0; j<n; j++){
            int i = nums[j];
            if(j%2==0){
                if(freq[i][0] > even2Max_freq && i != evenMax_val){
                    even2Max_freq = freq[i][0];
                    even2Max_val = i;
                }
            }else{
                if(freq[i][1] > odd2Max_freq && i != oddMax_val){
                    odd2Max_freq = freq[i][1];
                    odd2Max_val = i;
                }
            }
        }

        int res1 = n - evenMax_freq-oddMax_freq;
        int res2 = n - (evenMax_freq + odd2Max_freq);
        int res3 = n - (even2Max_freq + oddMax_freq);

        if(evenMax_val != oddMax_val) return res1;
        return  Math.min(res2, res3);
    }
}

/*
case-1:
        0  1  2  3  4  5  6  7  8
nums = {3, 1, 4, 2, 4, 1, 5, 7, 6}
        _     _     _     _     _

evenMap<num, freq> = { {3, 1},{4, 2},{5, 1},{7, 1}
oddMap<num, freq>  = { {1, 2},{2, 1},{7, 1}}
evenMaxFreq's_val = 4, oddMaxFreq's_val = 1
so change all even position with value 4
and change all odd position with value 1
both are different:  res1 = n - evenMapFreq - oddMaxFreq

case-2:
        0  1  2  3  4  5  6  7  8
nums = {3, 3, 4, 2, 3, 3, 5, 3, 6}
        _     _     _     _     _

evenMap<num, freq> = { {3, 2}, {4, 1}, {5, 1}, {6, 1}}
oddMap<num, freq> =  { {3, 3}, {2, 1}}
evenMaxFreq's_val = 3, oddMaxFreq's_val = 3
both are the same, which will make the array invalid
if we change all even and odd position with value 3,
so we need to pick a val with second max freq from either even position
or odd positon:
if we
1) choose a val with second max freq from odd position:
   the val = 2, and it's frequency is 1, so  oddSecondFreq = 1
   so change all even position with value 3
   and change all odd position with value 2
   res2 = totalChange = n - (evenMaxFreq + oddSecondFreq) = 9 - (2+1) = 6

2) choose a val with second max freq from even position:
   the val = 4, and it's frequency is 1, so  evenSecondFreq = 1
   so change all even position with value 4
   and change all odd position with value 3
   res3 = totalChange = n - (evenMaxFreq + oddSecondFreq) = 9 - (1+3) = 5

Finally, the result = Math.min(res1, res2, res3)

*/



