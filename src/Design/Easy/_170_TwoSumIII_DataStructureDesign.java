package Design.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _170_TwoSumIII_DataStructureDesign {
    /*
    1) For the design question, we need to figure out the trade off
       add() call more or find() call more
    2) Usually the find() call more
    Solution-1 :
    */

    Map<Integer, Integer> map;
    public _170_TwoSumIII_DataStructureDesign() {
        map = new HashMap<>();
    }
    //add: O(1), find: O(n)
    public void add(int num) {
        map.put(num, map.getOrDefault(num, 0)+1);
    }

    public boolean find(int value) {
        if(map.size()==0) return false;
        for(int key : map.keySet()){
            int comp = value-key;
            if(comp!=key && map.containsKey(comp)) return true;
            if(comp==key && map.get(key)>1) return true;
        }
        return false;
    }

    /*
     Set<Integer> nums = new HashSet<>();
    Set<Integer> sums = new HashSet<>();
    public TwoSum() {

    }
    //add: O(1), find: O(n)
    public void add(int num) {
        for(int val : nums) sums.add(val+num);
        nums.add(num);
    }

    public boolean find(int value) {
       return sums.contains(value);
    }
     */
}
