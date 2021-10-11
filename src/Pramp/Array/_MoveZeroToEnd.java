package Pramp.Array;

/**
 * Created by Shuhua Song
 */
public class _MoveZeroToEnd {

    public static int[] moveZerosToEnd(int[] nums){
        int n = nums.length;
        int l = 0, r = 0;
        while(r < n){
            if(nums[r] != 0){
                nums[l] = nums[r];
                l++;
                r++;
            }else{
                r++;
            }
        }
        while(l < n){
            nums[l++] = 0;
        }
        for(int a : nums){
            System.out.print(a + " ");
        }
        return nums;
    }

 /*  private static int[] moveZerosToEnd(int[] nums){
       int l = 0, n = nums.length;
       for(int r=0; r<n; r++){
           if(nums[r] != 0){
               nums[l] = nums[r];
               l++;
           }
       }
       for(int i=l; i<n; i++){
           nums[i] = 0;
       }
       for(int a : nums){
           System.out.print(a + " ");
       }
       return nums;
   } */

    public static void main(String[] args) {
        int[] nums = {1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0};
        int[] res = moveZerosToEnd(nums);

    }
}


