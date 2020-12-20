package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedInanArray {
    //Time = O(n)  Space = O(1)
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                results.add(i+1);
            }
        }
        return results;
    }
}
