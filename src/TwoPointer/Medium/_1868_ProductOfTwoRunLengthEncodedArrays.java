package TwoPointer.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1868_ProductOfTwoRunLengthEncodedArrays {

    public List<List<Integer>> findRLEArray(int[][] e1, int[][] e2) {
        int n1 = e1.length, n2 = e2.length;
        List<List<Integer>> results = new ArrayList<>();
        if(n1==0 && n2==0) return results;
        int p1 = 0, p2 = 0;
        List<Integer> listPro  = new ArrayList<>();
        int val1 = e1[p1][0], freq1 = e1[p1][1];
        int val2 = e2[p2][0], freq2 = e2[p2][1];
        int prevVal = val1 * val2;
        int count = 0, currVal = 0;
        while(p1 < n1 && p2 < n2){
            while(freq1 > 0 && freq2 > 0){
                currVal = val1 * val2;
                int minFreq = Math.min(freq1, freq2);
                if(currVal==prevVal){
                    count += minFreq;
                }else{
                    List<Integer> currList = new ArrayList<>();
                    currList.add(prevVal);
                    currList.add(count);
                    //results.add(Arrays.asList(prevVal, count));
                    results.add(currList);
                    count = minFreq;
                    prevVal = currVal;
                }
                freq1 -= minFreq;
                freq2 -= minFreq;
            }

            if(freq1==0 && p1+1 < n1){
                p1++;
                val1 = e1[p1][0];
                freq1 = e1[p1][1];
            }
            if(freq2==0 && p2+1 < n2){
                p2++;
                val2 = e2[p2][0];
                freq2 = e2[p2][1];
            }
            if(freq1==0 && freq2==0) break;

        }

        List<Integer> list = new ArrayList<>();
        list.add(currVal); list.add(count);
        results.add(list);

        return results;
    }
}
