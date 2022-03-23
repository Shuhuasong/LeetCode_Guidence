package Sorting;

/**
 * Created by Shuhua Song
 */
public class _MergeSort_ {

    public static void sortInteger(int[] A){
        if(A==null || A.length==0) return;
        int[] temp = new int[A.length];
        mergeSort1(A, 0, A.length-1, temp);
        for(int a : A){
            System.out.print(a + " ");
        }
    }

    private  static void mergeSort1(int[] A, int start, int end, int[] temp){
        if(start >= end) return;
        mergeSort1(A, start, (start+end)/2, temp);
        mergeSort1(A, (start+end)/2+1, end, temp);
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


    public int[] mergeSort(int[] nums){
        return divide(nums, 0, nums.length-1);
    }

    public int[] divide(int[] nums, int left, int right){
        if(left>=right) return new int[]{nums[left]};
        int mid = left + (right-left)/2;
        int[] leftRes = divide(nums, left, mid);
        int[] rightRes = divide(nums, mid+1, right);
        return merge(leftRes, rightRes);
    }

    public int[] merge(int[] left, int[] right){
        int n1 = left.length, n2 = right.length;
        int[] res = new int[n1+n2];
        int i = 0, j = 0, k = 0;
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                res[k++] = left[i++];
            }else{
                res[k++] = right[j++];
            }
        }
        while(i<n1){
            res[k++] = left[i++];
        }
        while(j<n2){
            res[k++] = right[j++];
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 2, 7, 8};
        sortInteger(nums);
    }
}
