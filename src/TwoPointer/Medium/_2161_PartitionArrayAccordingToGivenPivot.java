package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _2161_PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int  less = 0, equal = 0, great = 0;
        for(int num : nums){
            if(num<pivot) less++;
            else if(num==pivot) equal++;
            else
                great++;
        }
        int l=0, e=less, g=less+equal;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int num = nums[i];
            if(num < pivot) res[l++] = num;
            else if(num == pivot) res[e++] = num;
            else
                res[g++] = num;
            //System.out.println(l + " " + e + " " + g);
        }
        return res;
    }
}
