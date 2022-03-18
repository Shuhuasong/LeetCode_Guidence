package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _923_3SumWithMultiplicity {

    //Time : O(101*101)
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        long count = 0;
        int MOD = (int)1e9+7;
        for(int k1 : map.keySet()){
            for(int k2 : map.keySet()){
                int k3 = target -(k1 + k2);
                if(map.containsKey(k3)){
                    long cnt1 = map.get(k1), cnt2 = map.get(k2), cnt3 = map.get(k3);
                    if(k1==k2 && k2==k3){
                        count += cnt1*(cnt1-1)*(cnt1-2)/6;
                    }else if(k1==k2){
                        count += cnt1*(cnt1-1)/2 * cnt3;
                    }else if(k1<k2 && k2<k3){
                        count += cnt1 * cnt2 * cnt3;
                    }
                    count %= MOD;
                }
            }
        }
        return (int)count;
    }

    /*
    //Time : O(n^2)
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int MOD = (int)1e9+7, res = 0;
        for(int i=0; i<A.length; i++){
            res = (res + map.getOrDefault(target-A[i], 0))%MOD;
            for(int j=0; j<i; j++){
                int sum = A[i]+A[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        return res;
    }
    
     */
}
