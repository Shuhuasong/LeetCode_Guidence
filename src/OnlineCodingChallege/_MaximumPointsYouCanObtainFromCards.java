package OnlineCodingChallege;

/**
 * Created by Shuhua Song
 */
public class _MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] card, int k) {
        if(card==null || card.length==0 || k<=0) return 0;
        int n = card.length, sum = 0, res = 0;
        int[] preSum = new int[k+1];
        int[] sufSum = new int[k+1];
        for(int i=0; i<k; i++){
            preSum[i+1] = preSum[i] + card[i];
            sufSum[i+1] = sufSum[i] + card[n-i-1];
        }

        for(int i=0; i<=k; i++){
            res = Math.max(res, preSum[i]+sufSum[k-i]);
        }

        return res;
    }
}
