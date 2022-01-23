package Math.Enumeration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1291_SequentialDigits {

    //Time = O(1), Space = O(1)
    //the s'length is 9, and low, high pointer are [2, 9]
    //So the nested loops are excuted no more than 8 * 8 = 64 times
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();
        String s = "123456789";
        int n1 = String.valueOf(low).length();
        int n2 = String.valueOf(high).length();
        for(int l=n1; l<=n2; l++){
            for(int i=0; i<=s.length()-l; i++){
                String st = s.substring(i, i+l);
                int val = Integer.parseInt(st);
                if(val >= low && val <= high){
                    results.add(val);
                }
            }
        }
        return results;
    }

    //Time = O(1), Space = O(1)
 /*   public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();
        int value = 0;
        for(int i=1; i<=9; i++){
            int data = i;
            value = data;
            while(value <= high && data < 9){
                value = value * 10 + (value%10+1);
                data = value % 10;
                if(value < low) continue;
                if(value >= low && value <= high){
                    results.add(value);
                }
            }
        }
        Collections.sort(results);
        return results;
    } */


    //Time = O(max(m,n)), m = lo.length, n = hi.length
 /*   public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();
        int value = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=9; i++){
            int data = i;
            sb.append(data);
            value = data;
            while(value <= high && data < 9){
                data += 1;
                sb.append(data);
                value = Integer.parseInt(sb.toString());
                if(value < low) continue;
                if(value >= low && value <= high){
                    results.add(value);
                }
            }
            sb = new StringBuilder();
        }
        Collections.sort(results);
        return results;
    } */
}
