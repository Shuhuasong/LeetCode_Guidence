package BinarySearch.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _685_FindKClosestElement {

    // Binary Search: O((log n) + k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();
        if(k<=0 || arr.length==0) return results;
        int n = arr.length;
        int left = 0, right = n-1;
        //find the target position
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(arr[mid]<x){
                left = mid;
            }else{
                right = mid;
            }
        }
        int count = 0;
        while(left>=0 && right<arr.length && count < k){
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                results.add(arr[left]);
                left--;
            }else{
                results.add(arr[right]);
                right++;
            }
            count++;
        }
        while(count < k && left >=0){
            results.add(arr[left--]);
            count++;
        }
        while(count < k && right < n){
            results.add(arr[right++]);
            count++;
        }
        Collections.sort(results);
        return results;
    }

    /*
     //Time =  O((nlog n))  Space = O(n)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       List<Integer> results = new ArrayList<>();
       if(k<=0 || arr.length==0) return results;
       int n = arr.length;
       PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
           @Override
           public int compare(Integer a, Integer b){
               if(Math.abs(a-x) < Math.abs(b-x)){
                   return -1;
               }else if(Math.abs(a-x)==Math.abs(b-x)){
                   return a-b;
               }else{
                   return 1;
               }
           }
       });
       for(int a : arr) pq.add(a);
       int count = 0;
       while(pq.size() > 0 && count < k){
           results.add(pq.poll());
           count++;
       }
        Collections.sort(results);
       return results;
    }
     */
}
