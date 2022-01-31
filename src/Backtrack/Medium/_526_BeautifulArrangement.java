package Backtrack.Medium;

/**
 * Created by Shuhua Song
 */
public class _526_BeautifulArrangement {


    /*
     //Better Brute force
    //Time = O(k), k = the number of valid permutations
    //Space = O(n)
    int count = 0;
    public int countArrangement(int n) {
        if(n==1) return 1;
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        permute(nums, 0);
        return count;
    }

    private void permute(int[] nums, int left){
        if(left==nums.length){
            count++;
        }
        for(int r=left; r<nums.length; r++){
            swap(nums, r, left);
            if(nums[left]%(left+1) == 0 || (left+1) % nums[left]==0){
                 permute(nums, left+1);
            }
            swap(nums, r, left);
        }
    }

    private void swap(int[]  nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
     */



    /*
       //Time = O(n!), Space = O(n)
    int count = 0;
    public int countArrangement(int n) {
        if(n==1) return 1;
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        permute(nums, 0);
        return count;
    }

    private void permute(int[] nums, int left){
        if(left==nums.length-1){
            int i;
            for(i=1; i<=nums.length; i++){
                if(nums[i-1]%i != 0 && i%nums[i-1] != 0) break;
            }
            if(i==nums.length+1){
                count++;
            }
        }
        for(int r=left; r<nums.length; r++){
            swap(nums, r, left);
            permute(nums, left+1);
            swap(nums, r, left);
        }
    }

    private void swap(int[]  nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
     */
}
