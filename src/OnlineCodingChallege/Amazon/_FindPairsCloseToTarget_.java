package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _FindPairsCloseToTarget_ {

    private static List<List<Integer>> findPair(int[][] a, int[][] b, int target){
        Arrays.sort(a, (a1, a2)->a1[1]-a2[1]);
        Arrays.sort(b, (b1, b2)->b1[1]-b2[1]);
        List<List<Integer>> results = new ArrayList<>();
        TreeMap<Integer, List<List<Integer>>> tree = new TreeMap<>();
        int minDiff = Integer.MAX_VALUE, currDiff = 0;
        int m = a.length, n = b.length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum = a[i][1]+b[j][1];
                if( sum <= target){
                    List<List<Integer>> list = tree.computeIfAbsent(sum, (k)->new ArrayList<>());
                    list.add(Arrays.asList(a[i][0], b[j][0]));
                }else{
                    break;
                }
            }
        }
        //return a key-value mapping associated with the greatest key less than or equal to the given key,
        //or null if there is no such key;
        return tree.floorEntry(target).getValue();
    }

    public static void main(String[] args) {
         int[][] a1 = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
         int[][] b1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
         List<List<Integer>> results1 = findPair(a1, b1, 10);
         for(int i=0; i<results1.size(); i++){
             System.out.println(results1.get(i));
         }

         int[][] a2 = {{1, 8}, {2, 15}, {3, 9}};
         int[][] b2 = {{1, 8}, {2, 11}, {3, 12}};
         List<List<Integer>> results2 = findPair(a2, b2, 20);
        for(int i=0; i<results2.size(); i++){
            //System.out.println(results2.get(i));
        }
    }
}
