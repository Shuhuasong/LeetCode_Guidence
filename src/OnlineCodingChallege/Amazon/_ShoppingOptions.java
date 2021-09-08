package OnlineCodingChallege.Amazon;

import java.util.*;

/**
 * Created by Shuhua Song
 */

// 给定四个商品A,B,C,D。 然后有四个list，分别代表四个商品的不同价格。比如ListA, ListB, ListC, ListD。然后给你一个budget，问你不超过这个budget，每个商品买一个，一共有多少种买法。
// 比如 [1,2], [2,3],[4],[1,2,3], budget = 10
// 就有8种买法
public class _ShoppingOptions {

    private static int wayOfShopping(int[][] prods, int budget){
        for(int i=0; i<prods.length; i++){
            Arrays.sort(prods[i]);
        }
        TreeMap<Integer, Integer>  map1 = addTwo(prods[0], prods[1], budget);
        TreeMap<Integer, Integer>   map2 = addTwo(prods[2], prods[3], budget);
        int res = 0;
        for(int key1 : map1.keySet()){
            for(int key2 : map2.keySet()){
                if(key1+key2 <= budget){
                    res += map1.get(key1) * map2.get(key2);
                }else{
                    break;
                }
            }
        }
         return res;
    }
    private static TreeMap<Integer, Integer>  addTwo(int[] A, int[] B, int budget){
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        int sum = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                sum = A[i] + B[j];
                if(sum <= budget){
                    map1.put(sum, map1.getOrDefault(sum, 0)+1);
                }
            }
        }
        return map1;
    }


    public static void main(String[] args) {
        int[][] data = new int[][]{{1,2},{2,3},{4},{1,2,3}};//should return 12
        int budget = 10;
        System.out.println(wayOfShopping(data, budget));
    }
}
