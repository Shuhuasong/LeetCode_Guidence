package BinarySearch.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _658_FindKClosestElement {



    //Method #2: Binary Search to Find the left Bound
    //Time = O(log(n-k) + k)
    //Space = O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();
        if(arr==null || arr.length==0 || k > arr.length) return results;
        int left = 0, right = arr.length-k;
        while(left < right){
            int mid = left + (right-left)/2;
            System.out.println(left + " "+ mid + " " + right);
            if(x-arr[mid] <= arr[mid+k]-x){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        for(int i=left; i<left+k; i++){
            results.add(arr[i]);
        }
        return results;
    }

    /*
    //Method #3: Binary Search + Two Pointer
    public int[] kClosestNumbers(int[] A, int target, int k){
        if(A==null || A.length==0 || k > A.length) return A;
        int[] res = new int[k];
        //Find the first number greater than target
        int right = firstIndex(A, target);
        int left = right-1;
        System.out.println(left + " " + right);
        for(int i=0; i<k; i++){
            if(left < 0){
                res[i] = A[right++];
            }else if(right >= A.length){
                res[i] = A[left--];
            }else{
                if(target-A[left] <= A[right]-target){
                    res[i] = A[left];
                    left--;
                }else{
                    res[i] = A[right];
                    right++;
                }
            }
        }
        return res;
    }

    private int firstIndex(int[] A, int target){
        int left = 0, right = A.length-1;
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(A[mid] >= target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(A[left] >= target) return left;
        if(A[right] >= target) return right;
        return A.length;
    }

     */


    /*
     //Method #1: Sort with Coustom Comparator
    //Time = O(nlogn + klogk)
    //Space = O(n)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for(int a : arr) { list.add(a); }
        Collections.sort(list, (a, b)->Math.abs(x-a)-Math.abs(b-x));
        List<Integer> res = list.subList(0, k);
        Collections.sort(res);
        return res;
    }
     */

}
