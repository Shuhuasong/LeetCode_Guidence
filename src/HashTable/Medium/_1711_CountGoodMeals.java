package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1711_CountGoodMeals {
    //Time = O(22*N), Space = O(1)
    public int countPairs(int[] deliciousness) {
        int MOD = (int)1e9+7;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : deliciousness){
            int pow = 1;
            for(int i=0; i<22; i++){ // condition: 0<= deliciousness[i] <= 2^20
                if(map.containsKey(pow-num)){
                    res += map.get(pow-num);
                    res %= MOD;
                }
                pow *= 2;
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return res;
    }

    /*
     //Time = O(22*n)
    public int countPairs(int[] deli) {
         int MOD = (int)1e9+7;
         Set<Integer> set = new HashSet<>();
         int pow = 1;
         for(int i=0; i<22; i++){
             set.add(pow);
             pow *= 2;
            // System.out.println(pow);
         }
         int res = 0, n = deli.length;
         Map<Integer, Integer> map = new HashMap<>();
         for(int i=0; i<n; i++){
            for(int sq : set){
                int comp = sq-deli[i];
                int count = map.getOrDefault(comp, 0);
                res = (res+count)%MOD;
            }
            map.put(deli[i], map.getOrDefault(deli[i], 0)+1);
         }
        return res;
    }
     */
}
