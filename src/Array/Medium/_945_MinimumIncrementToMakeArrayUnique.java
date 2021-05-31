package Array.Medium;

public class _945_MinimumIncrementToMakeArrayUnique {

    //Time = O(n)  Space = O(1)
    public int minIncrementForUnique(int[] A) {
        if(A==null || A.length==0) return 0;
        int moves = 0;
        int[] freq = new int[50000];
        for(int a : A){
            freq[a]++;
        }
        for(int i=0; i<freq.length-1; i++){
            if(freq[i] <=1) continue;
            //consider an example like where frequency of number 3 is 5
            //remaining that needs to be "reevaluated" is 3 (since one 3 is valid in this slot)
            //if we were to add 1 to the remain 4# of value 3, it is 4
            //since we have remain frequency of 4, its like now 4 has 4 frequency
            //we repeat this process
            int remain = freq[i]-1;
            moves += remain;
            freq[i+1] += remain;
        }
        System.out.println();
        return moves;
    }
}
