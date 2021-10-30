package Sorting;

/**
 * Created by Shuhua Song
 */
public class _MergeSort_ {

    public static void sortInteger(int[] A){
        if(A==null || A.length==0) return;
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length-1, temp);
        for(int a : A){
            System.out.print(a + " ");
        }
    }

    private  static void mergeSort(int[] A, int start, int end, int[] temp){
        if(start >= end) return;
        mergeSort(A, start, (start+end)/2, temp);
        mergeSort(A, (start+end)/2+1, end, temp);
        merge(A, start, end, temp);
    }

    private static void merge(int[] A, int start, int end, int[] temp){
        int mid = (start+end)/2;
        int left = start, right = mid+1;

        int j = start;
        while(left <= mid && right<=end){
            if(A[left] <= A[right]){
                temp[j++] = A[left++];
            }else{
                temp[j++] = A[right++];
            }
        }
        while(left <= mid){
            temp[j++] = A[left++];
        }
        while(right <= end){
            temp[j++] = A[right++];
        }
        for(int i=start;  i<=end; i++){
            A[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 2, 7, 8};
        sortInteger(nums);
    }
}
