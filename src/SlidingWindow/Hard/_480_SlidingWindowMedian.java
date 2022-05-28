package SlidingWindow.Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Shuhua Song
 */
public class _480_SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {

        /*//Must use Integer.compare(nums[a], nums[b]), otherewise, there is null value
         minHeap = new TreeSet<>((a, b)->nums[a]==nums[b] ? a-b : Integer.compare(nums[a], nums[b]));
          maxHeap = new TreeSet<>((a, b)->nums[a]==nums[b] ? a-b : Integer.compare(nums[b], nums[a]));
         */

        Comparator<Integer> comparator = (a, b)->nums[a]!=nums[b] ? Integer.compare(nums[a], nums[b]) : a-b;
        TreeSet<Integer> minHeap = new TreeSet<>(comparator);
        TreeSet<Integer> maxHeap = new TreeSet<>(comparator.reversed());

        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        for(int i = 0; i <= nums.length; i++) {
            if(i >= k) {
                res[idx++] = getMedian(nums, maxHeap, minHeap);
                maxHeap.remove(i-k);
                minHeap.remove(i-k);
            }

            if(i < nums.length) {
                //1. put in the minHeap
                minHeap.add(i);
                //2. put back to maxHeap
                maxHeap.add(minHeap.pollFirst());
                //3. Balance
                if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.pollFirst());
            }
        }
        return res;
    }

    double getMedian(int[] a, TreeSet<Integer> maxHeap, TreeSet<Integer> minHeap) {
        if(maxHeap.size() == minHeap.size()) {
            return ((double)a[maxHeap.first()] + (double)a[minHeap.first()])/2.0;
        } else {
            return (double)a[minHeap.first()];
        }
    }

    /*

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] results = new double[n-k+1];
        int[] window = new int[k];
        for(int i=0; i<k; i++){
            window[i] = nums[i];
        }
        Arrays.sort(window);
        for(int i=k; i<=n; i++){
            results[i-k] = ((double)window[k/2] + window[(k-1)/2]) / 2;
            if(i==n) break;
            remove(window, nums[i-k]);
            insert(window, nums[i]);
        }
        return results;
    }

    private void remove(int[] window, int target){
        int i=0, n = window.length;
        while(i<n-1 && target>window[i]){
            i++;
        }
        while(i<n-1){
            window[i] = window[i+1];
            i++;
        }
    }

    private void insert(int[] window, int target){
        int i=0, n = window.length;
        while(i<n && target>window[i]){
            i++;
        }
        int r = n-1;
        while(r > i){
            window[r] = window[r-1];
            r--;
        }
        window[r] = target;
    } */


    /*
    //TLE
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] results = new double[n-k+1];
        LinkedList<Integer> window = new LinkedList<>();
        for(int i=0; i<k; i++){
            window.add(nums[i]);
        }
        Collections.sort(window);

        for(int i=k; i<=n; i++){
            results[i-k] = ((double)window.get(k/2) + window.get((k-1)/2)) / 2;
            if(i==n) break;
            remove(window, nums[i-k]);
            insert(window, nums[i]);
        }
        return results;
    }

    private void remove(LinkedList<Integer> list, int target){
        int i = 0, size = list.size();
        while(i<size && target != list.get(i)){
            i++;
        }
        list.remove(i);
    }

    private void insert(LinkedList<Integer> list, int target){
        int i = 0, size = list.size();
        while(i<size && target > list.get(i)){
            i++;
        }
        list.add(i, target);
    }
     */
}


/*
Use two Heaps to store numbers. maxHeap for numbers smaller than current median,
minHeap for numbers bigger than and equal to current median. A small trick I used
is always make size of minHeap equal (when there are even numbers) or 1 element
more (when there are odd numbers) than the size of maxHeap. Then it will become
very easy to calculate current median.
Keep adding number from the right side of the sliding window and remove number
from left side of the sliding window. And keep adding current median to the result.

Solution: Brute Force
Time complexity: O( (n-k+1) *  k*logk )


Solution: Insertion
Time complexity: O((n-k+1)*k)

use array ==> moving window
 0
[1  3  -1] -3  5  3  6  7
            |
[-1   3]    i>=k ==i-k

     [-3  -1  3]

 1


Solution: Two heap
Time complexity: O(n*logk)
1) Firstly, add element to min heap.
2) Then, move top element from minHeap to maxHeap                 top
3) Balance step: check is minHeap.size < maxHeap, if it is, move back minHeap <==== maxHeap

minHeap  =  TreeSet(i)  set.remove(i)  ==> customize sort ==> logk
--------

1 (0)
3
===========

maxHeap
-----------
-1


min
 */
