package HashTable.Medium;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _2007_FindOriginalArrayFronDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0) return new int[0];
        Arrays.sort(changed);
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int num : changed){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[n/2];
        int i = 0;
        for(int k : freq.keySet()){
            if(freq.get(k) > freq.getOrDefault(2*k, 0)) return new int[0];
            for(int j=0; j<freq.get(k) && i<n/2; j++){
                res[i++] = k;
                freq.put(2*k, freq.getOrDefault(2*k, 0)-1);
            }
        }
        return res;
    }
}
