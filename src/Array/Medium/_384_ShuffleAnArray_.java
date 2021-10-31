package Array.Medium;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Shuhua Song
 */
public class _384_ShuffleAnArray_ {

    //Time = O(n), Space = O(n)
    int[] nums, temp;
    Random random = new Random();
    public _384_ShuffleAnArray_(int[] nums) {
        this.nums = nums;
        this.temp = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        nums = temp.clone();
        return nums;
    }

    public void swapAt(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int randRange(int min, int max){
        return random.nextInt(max-min)+min;
    }


    public int[] shuffle() {
        for(int i=0; i<nums.length; i++){
            swapAt(i, randRange(i, nums.length));
        }
        return nums;
    }

    /*
      //Time = O(n^2), in the for loop, the list.remove spend O(n)
    //Space = O(n)
    int[] nums, temp;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        this.temp = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
       nums = temp.clone();
        return nums;
    }


    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for(int a : nums) list.add(a);
        for(int i=0; i<nums.length; i++){
            int removeIdx = random.nextInt(list.size());
            nums[i] = list.get(removeIdx);
            list.remove(removeIdx);
        }
        return nums;
    }
     */
}
