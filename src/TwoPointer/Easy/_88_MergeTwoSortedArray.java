package TwoPointer.Easy;

/**
 * Created by Shuhua Song
 */
public class _88_MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int p1 = m-1, p2 = n-1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[--len] = nums1[p1];
                p1--;
            }else{
                nums1[--len] = nums2[p2];
                p2--;
            }
        }
        while(p1 >= 0){
            nums1[--len] = nums1[p1--];
        }
        while(p2 >= 0){
            nums1[--len] = nums2[p2--];
        }
    }
}
