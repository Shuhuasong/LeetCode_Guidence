package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    //Time = O(n * 2^n), generate all subsets and then copy them into output list
    //Space = O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }
    //There is no condition for the termination, because any time the list is one of results
    //And make a deep copy for the content of list
    //because solution must not contain duplicate subset, so we need start next i+1 for next backtrack()
    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            //start from i+1, to make sure no duplicate solution
            backtrack(nums, i+1, list, res);
            list.remove(list.size()-1);
        }
    }

    /*
    //Bitmask
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         if(nums==null || nums.length==0) return res;
         int totalNumber = 1 << nums.length;
         for(int mask=0; mask<totalNumber; mask++){
             List<Integer> currList = new ArrayList<>();
             //r = extract the bit the rightmost position when r = 0, then 2th, 4th, ....
             for(int r=0; r<nums.length; r++){
                 //if the rth bit is 1, then pick the number
                 if((mask & (1 << r)) != 0){
                     currList.add(nums[r]);
                 }
             }
             res.add(currList);
         }
       return res;
    }
     */


    /*
     //Time = O(n * 2^n)  Space = O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> results){

        if(start > nums.length) return;
        if(!results.contains(list)){
            results.add(new ArrayList<>(list));
        }
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i+1, list, results);
            list.remove(list.size()-1);
        }
    }
     */
}


/*
DFS:

       *
   /   |   \
  1    2    3
/  \   |
2   3  3
|
3

   mask  2^3=8
1  0 0 0 0 1 1 1 1
2  0 0 1 1 0 0 1 1
3  0 1 0 1 0 1 0 1
     3 2 2 1 1 1 1
         3   3 2 2
                 3

                */
