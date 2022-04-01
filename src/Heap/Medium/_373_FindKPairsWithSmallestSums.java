package Heap.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _373_FindKPairsWithSmallestSums {

    //Time = O(klogK) Space = O(1)
    /*
    idea: Use PriorityQueue to store the index of pairs, and add k pair with (i, 0), i=0->num1.length into
     pq first(because of array's accending order). Then add every pair's value into result,
     at the same time, continue to add more pair into pq, pq always keep the size with k
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        for(int i=0; i<nums1.length && i<k; i++){
            pq.add(new int[]{i,0});
        }
        List<List<Integer>> results = new ArrayList<>();
        while(results.size() < k && !pq.isEmpty()){
            int[] c = pq.poll();
            results.add(Arrays.asList(nums1[c[0]], nums2[c[1]]));
            if(c[1]+1 < nums2.length){
                pq.offer(new int[]{c[0], c[1]+1});
            }
        }
        return results;
    }
}


/*
本题本质上非常巧妙地转换成了二维矩阵问题，同378。

设想一个MxN的矩阵，其矩阵元素(m,n)就是num1[m]+nums2[n]，很显然这个矩阵的行、列都是递增的。于是立刻就转化成了找该矩阵第k个元素的问题。

解法1：BFS+PQ
用BFS的方法进行搜索。每次弹出一个PQ里最小的元素，然后新加入该元素相邻（右边和下边）的两个元素。最先弹出的k个元素就是答案。

*/

