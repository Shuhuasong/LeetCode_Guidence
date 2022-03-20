package Graph.Medium;

/**
 * Created by Shuhua Song
 */
public class _1007_MinimumDominoRotationForEqualRow {
    //Time = O(n), Space = O(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int A = tops[0], B = bottoms[0];
        int resA = Math.min(check(A, tops, bottoms), check(A, bottoms, tops));
        int resB = Math.min(check(B, tops, bottoms), check(B, bottoms, tops));
        int finalRes = Math.min(resA, resB);
        return finalRes==Integer.MAX_VALUE ? -1 : finalRes;
    }

    private int check(int target, int[] A, int[] B){
        int count = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]!=target){
                if(B[i]!=target) return Integer.MAX_VALUE;
                else{
                    count++;
                }
            }
        }
        return count;
    }
}

/*
Solution:
--Goal: every tile should be the same in at least one side/row.(Assume that every item=x after rotation)
--Since we can only rotate/swap tiles with same index.(A[0]<->B[0], A[1]<->B[1], .....)
--If there's a solution that every item=x: it means at least A[0] or B[0]==x,
  Otherwise, swap A[0]<-->B[0] will never be x. Contradict with our assumption.
--Therefore, we can simply use A[0] to check.
--If there's a solution for A[0], we already return the minimum counts

e.g

A = [2,2,3,3,2,3]
B = [3,3,2,2,3,2]

After some rotations, we get

A = [2,2,2,2,2,2] or [3,3,3,3,3,3]
B = [3,3,3,3,3,3] or [2,2,2,2,2,2]
*/
