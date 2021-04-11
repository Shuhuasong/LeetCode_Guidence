package Array.Medium;

public class _769_MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {
        int maxVal = 0, result = 0;
        for(int i=0; i<arr.length; i++){
            maxVal = Math.max(maxVal, arr[i]);
            if(maxVal==i){
                result++;
            }
        }
        return result;
    }
}


/*
{1 , 0 , 2 , 3 , 4 }
 1 --> [-, 1, ?, ?, ?], max= 1;
 0 --> [0, 1, ?, ?, ?], max = 1;
 2 --> [0, 1, 2, ?, ?], max = 2;
 3 --> [0, 1, 2, 3, ?], max = 3;
 4 --> [0, 1, 2, 3, 4], max = 4;

 Solution: track max so far
 check is max == index : ans += 1

 Time = O(n)
 Space = O(1)

*/