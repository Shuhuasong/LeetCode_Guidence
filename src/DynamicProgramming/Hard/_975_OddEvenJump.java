package DynamicProgramming.Hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _975_OddEvenJump {

    public int oddEvenJumps(int[] A) {
        int n = A.length;
        if(n<1) return 0;
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = true; even[n-1] = true;
        for(int i=n-2; i>=0; i--){
            Map.Entry oddEntry = map.ceilingEntry(A[i]),
                    evenEntry= map.floorEntry(A[i]);
            if(oddEntry!=null){
                odd[i] = even[(int)oddEntry.getValue()];
            }
            if(evenEntry!=null){
                even[i] = odd[(int)evenEntry.getValue()];
            }
            map.put(A[i], i);
        }
        for(boolean k : odd){
            if(k) res++;
        }
        return res;
    }

    /*
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        if(n<1) return 0;
        int res = 0;
        for(int i=0; i<n; i++){
            if(i==n-1){
                res++;
                break;
            }
            int currVal = A[i];
            int idx = i;
            while(idx < n){
                currVal = A[idx];
                idx = findGreater(A, currVal, idx+1, n);
                if(idx==n-1){
                    res++;
                    break;
                }else if (idx==-1){
                    break;
                }

                currVal = A[idx];
                idx = findSmaller(A, currVal, idx+1, n);
                if(idx==n-1){
                    res++;
                    break;
                }else if(idx==-1){
                    break;
                }
            }
        }
        return res;
    }

    private int findGreater(int[] A, int value, int from, int to){
        int minAns = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=from; i<to; i++){
            if(A[i]==value){
               return i;
            }else if(A[i]>value && minAns>A[i]){
                minAns = A[i];
                idx = i;
            }
        }
        return idx;
    }

    private int findSmaller(int[] A, int value, int from, int to){
        int maxAns = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=from; i<to;i++){
            if(A[i]==value){
                return i;
            }else if(A[i]<value && maxAns<A[i]){
                maxAns = A[i];
                idx = i;
            }
        }
        return idx;
    }
     */
}

/*
Odd jumps:
jumps from i to j, a[i] <= a[j] and a[j] is the smallest value
Even jumps:
jumps from i to j, a[i] >= a[j] and a[j] is the largest value

Find Good starting index:
From that starting index, we can reach the end of arry
e.g  [10, 13, 12, 14, 15]
10 :  1st jump==> 12, then there is no value <= 12  X
13 :  1st jump==> 14, then there is no value <= 14 X
12 :  1st jump==> 14, then there is no value < 12
14 :  1st jump==> 15 , then end
15 : then end

Brute force: O(n^2)
start from index 0 to n-1
then alternative do odd jump and even jump by
finding the next larger value(but smallest), or
find the next smaller value(but largest)

DP solution---Time = O(nlogn):
Start from index n-1 to 0:
    use calculated information ==> we need to find value on its right
    ====> save element from right to left
 Use treemap: to look up wether the value exist we want to find
 Odd Jump: map.ceilingEntry(A[i])  greatr then equal(logn)
 Even Jump: map.floorEntry(A[i]) smaller than equal(logn)

 whether we can reach i is transively by odd jump and even jump
 odd[i] = even[oddJump.getValue()]
 even[i] = odd[evenJump.getValue()]

 map.put(A[i], i)
 Note: we must do odd jump at first
 in the end, we check how many value in Odd are true

*/

