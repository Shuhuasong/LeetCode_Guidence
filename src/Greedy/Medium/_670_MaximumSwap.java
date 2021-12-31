package Greedy.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _670_MaximumSwap {

    //Time = O(n)
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        //Covert the number into each digit
        int snapNum = num;
        while(num > 0){
            int v = num % 10;
            list.add(0, v);
            num /= 10;
        }
        //put the digits into a array
        int size = list.size();
        int[] nums = new int[size];
        int u = 0;
        for(int v : list) {
            //System.out.print(v + " ");
            nums[u++] = v;
        }
        //Store number and index into map
        Map<Integer, List<Integer>> map= new HashMap<>();
        for(int i=0; i<size; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        //record the max val from backward
        int[] sufixMax = new int[size];
        sufixMax[size-1] = nums[size-1];
        for(int i=size-2; i>=0; i--){
            sufixMax[i] = Math.max(nums[i], sufixMax[i+1]);
        }

        //check if a digit is smaller than digit in the backward
        boolean found = false;
        for(int i=0; i<size; i++){
            if(nums[i] < sufixMax[i]){
                List<Integer> curList = map.get(sufixMax[i]);
                int idx = curList.get(curList.size()-1);
                // System.out.println("idx = " + idx);
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                found = true;
                break;
            }
        }

        if(!found){
            // System.out.println("outFound = " + outFound);
            return snapNum;
        }else{
            int res = 0;
            for(int i=0; i<size; i++){
                res = res * 10 + nums[i];
            }
            return res;
        }
    }

    /*
    //Time = O(n^2)
     public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int snapNum = num;
        while(num > 0){
            int v = num % 10;
            list.add(0, v);
            num /= 10;
        }

        int size = list.size();
        int[] nums = new int[size];
        int u = 0;
        for(int v : list) {
           // System.out.print(v + " ");
            nums[u++] = v;
        }

        int[] sufixMax = new int[size];
        sufixMax[size-1] = nums[size-1];

    boolean outFound = false;
        for(int i=0; i<size; i++){
        boolean found = false;
        for(int j=i+1; j<size; j++){
            if(nums[i] < nums[j]){
                int maxVal = nums[j], maxIdx = j;
                for(int k=j; k<size; k++){
                    if(nums[k]>=maxVal){
                        maxVal = nums[k];
                        maxIdx = k;
                    }
                }
                if(maxIdx < size){
                    int temp = nums[i];
                    nums[i] = maxVal;
                    nums[maxIdx] = temp;
                    found = true;
                    break;
                }
            }
        }
        if(found){
            outFound = true;
            break;
        }
    }


            if(!outFound){
            // System.out.println("outFound = " + outFound);
            return snapNum;
        }else{
            int res = 0;
            for(int i=0; i<size; i++){
                res = res * 10 + nums[i];
            }
            return res;
        }
    }
     */


}

/*
/*
9 8 3 6 8


9 8 3 6 8



9 1 5 9
maxDigit = 9
  madIdx = 3

 0  1  2  3  4
 6  9  3  8  1   num
              |
 9  6  3  8  1

maxDigit = 9
maxIdx = 1

5 4 3 1
5
maxDigit = 5, maxIdx = 0


<= one time

3 5 7 2 8 =>  String => char array
3 5 7 2 8
        8
find the index of the biggest digit
swap with left-most digit==> check if this digit has the same number with biggest digit ==> no swap


8 5 7 2 3


num = length : n -- # digit
check ===> O(n)

    biggest number with largest index


9  1  5  9
         |
          maxDigit = 9, maxIdx = 3

9  9  9  8
         |

9  9  5  1

indice-max = 3
biggest = 9

*/
