package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _FindAllCombinationOfNumbersThatSumToTarget {

    static List<List<Integer>> results;
    private static List<List<Integer>> combination(int target){
        results = new ArrayList<>();
        backtrack(target, 0, 1, new ArrayList<Integer>());
        return results;
    }

    private  static void backtrack(int target, int curSum, int start, ArrayList<Integer> curList){
        if(curSum==target){
            results.add(new ArrayList<>(curList));
            return;
        }
        for(int i=start; i<target; i++){
            if(curSum+i<=target){
                curList.add(i);
                backtrack(target, curSum+i, i, curList);
                curList.remove(curList.size()-1);
            }
        }
    }
    public static void main(String[] args) {
         int target = 5;
         List<List<Integer>> results = combination(target);
         for(int i=0; i<results.size(); i++){
             System.out.println(results.get(i));
         }
    }
}
