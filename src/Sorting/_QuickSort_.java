package Sorting;

/**
 * Created by Shuhua Song
 */
public class _QuickSort_ {

    public static void sortInteger(int[] nums){
        if(nums==null || nums.length==0) return;
        quickSort(nums, 0, nums.length-1);
        for(int a : nums){
            System.out.print(a + " ");
        }
    }

    private static void quickSort(int[] A, int start, int end){
        if(start >= end) return;
        int left = start, right = end;
        int pivot = A[(start+end)/2];
        while(left <= right){
            while(left <= right && A[left] < pivot){
                left++;
            }
            while(left <= right && A[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 2, 7, 8};
        sortInteger(nums);
    }
}
