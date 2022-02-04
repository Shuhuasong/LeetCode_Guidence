package HashTable.Medium;

/**
 * Created by Shuhua Song
 */
public class _1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    //Note: 1) the time = 0 and 30 need to deal with seperately with other time.
    //         They need to add into result by  count*(count-1)/2
    // 2) other time from 1-29, to find a comprement and adding directly
    //Bucket Sort
    //Bucket Sort
    public int numPairsDivisibleBy60(int[] time) {
        long[] bucket = new long[60];
        for(int t : time){
            int ti = t % 60;
            bucket[ti]++;
        }

        long res = 0;
        for(int i=0; i<=60/2; i++){
            if(i==0 || i==30 && bucket[i]!=0){
                res += bucket[i]*(bucket[i]-1)/2;// 3*(3-1)/2
            }else{
                long sum = bucket[i]+bucket[60-i];
                if(sum ==0) continue;
                res += (bucket[i]*bucket[60-i]);
            }
        }
        return (int)res;
    }
}
