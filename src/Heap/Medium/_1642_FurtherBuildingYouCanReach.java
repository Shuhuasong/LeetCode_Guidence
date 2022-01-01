package Heap.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1642_FurtherBuildingYouCanReach {
    //Time = O(n*logn) or O(n*logL), n = heights.length, L = #ladders
    //Space = O(n)
    public int furthestBuilding(int[] ht, int bricks, int ladders) {
        int n = ht.length;
        //a min-heap for store the the number of climbs the ladders can allocate
        Queue<Integer> ladderAllocate = new PriorityQueue<>((a, b)->a-b);
        for(int i=0; i<n-1; i++){
            int climb = ht[i+1] - ht[i];
            if(climb < 0) continue;
            ladderAllocate.add(climb);
            //If we have used all the ladders, then take a top(mini) climb from heap to substract the bricks
            if(ladderAllocate.size()>ladders){
                bricks -= ladderAllocate.poll();
                //If this brickes have used up, became negative, we can't go to next i+1
                if(bricks < 0) return i;
            }
        }
        //If we got to here, this means we had enough materials to cover all climbs
        return n-1;
    }


    /*
    //Time = O(n*logn), n = heights.length
    //Space = O(n)
    public int furthestBuilding(int[] ht, int bricks, int ladders) {
        int n = ht.length;
        //a max-heap for store the the number of climbs the bricks can allocate
        int brickCnt = 0;
        Queue<Integer>  bricksAllocate = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<n-1; i++){
            int climb = ht[i+1] - ht[i];
            if(climb < 0) continue;
            //allocate bricks for this climb
            bricksAllocate.add(climb);
            bricks -= climb;
            //we still have bricks
            if(bricks >= 0) continue;
            //otherwise, we run out of bricks, we should replace the largest climbs with a ladder
            if(ladders > 0){
                ladders -= 1;
                bricks += bricksAllocate.poll();
            }else{
                //no bricks and no ladders
                return i;
            }
        }
        //If we got to here, this means we had enough materials to cover all climbs
        return n-1;
    }
     */

    /*
    //Binary Search for Final Reachable building
    //Time = O(n*(logn)^2), n = heights.length
    //Space = O(n)
    public int furthestBuilding(int[] ht, int bricks, int ladders) {
        int n = ht.length;
        int left = 0, right = n-1;
        while(left <= right){
            //O(logn)
            int mid = left + (right-left)/2;
            if(isReachable(ht, bricks, ladders, mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isReachable(int[] ht, int bricks, int ladders, int end){
        List<Integer> climbs = new ArrayList<>();
        for(int i=0; i<end; i++){
            if(ht[i+1]-ht[i] <= 0) continue;
            climbs.add(ht[i+1]-ht[i]);
        }
        //O(n*logn)
        Collections.sort(climbs);
        for(int c : climbs){
            if(c <= bricks){
                bricks -= c;
            }else if(ladders > 0){
                ladders -= 1;
            }else{
                return false;
            }
        }
        return true;
    }

     */
}
