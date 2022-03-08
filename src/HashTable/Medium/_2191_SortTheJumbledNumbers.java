package HashTable.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _2191_SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        for(int num : nums){
            int newNum = getMappingNum(mapping, num);
            treemap.putIfAbsent(newNum, new ArrayList<>());
            treemap.get(newNum).add(num);
        }
        int i = 0;
        int[] res = new int[nums.length];
        for(int key : treemap.keySet()){
            List<Integer> list = treemap.get(key);
            for(int val : list){
                res[i++] = val;
            }
        }
        return res;
    }

    private int getMappingNum(int[] mapping, int num){
        int ans = 0, base = 1;
        if(num==0) return mapping[0];
        while(num > 0){
            int idx = num%10;
            int map = mapping[idx];
            ans = map * base + ans;
            base *= 10;
            num /= 10;
        }
        return ans;
    }
}
