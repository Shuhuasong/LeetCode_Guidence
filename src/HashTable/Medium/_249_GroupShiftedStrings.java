package HashTable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _249_GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String w : strings){
            String hashKey = getHashKey(w);
            map.putIfAbsent(hashKey, new ArrayList<>());
            map.get(hashKey).add(w);
        }

        for(List<String> valList : map.values()){
            results.add(valList);
        }
        return results;
    }

    private String getHashKey(String w){
        char[] chs = w.toCharArray();
        StringBuilder hashKey = new StringBuilder();
        for(int i=1; i<chs.length; i++){
            hashKey.append((char)(chs[i]-chs[i-1]+26)%26+'a');
        }
        String res = hashKey.toString();
        //  System.out.println("res = " + res + " " + w);
        return res;
    }
}


/*
Note: if two character a and b: a<b, then (a-b)%26 will be negative,
so we need to manually add c to make it non-negative (a-b+26)%26.
Solution:
For strings : {"acf","gil","xzc"}
c - a = i - g = z - x = 2 and
f - c = l - i = c - z = 3
here, c-z = -23, so we need (c-z+26)%26


["abc","bcd","acef","xyz","az","ba","a","z","al"]
res = 11 abc
res = 11 bcd
res = 221 acef
res = 11 xyz
res = 25 az
res = 25 ba
res =  a
res =  z
res = 11 al
Output
[["abc","bcd","xyz","al"],["a","z"],["acef"],["az","ba"]]
Expected
[["acef"],["a","z"],["al"],["abc","bcd","xyz"],["az","ba"]]
*/