package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _1423_MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] card, int k) {
        if(k<=0) return 0;
        int n = card.length;
        int total = 0;
        for(int c : card){ total += c;  }
        if(k==card.length) return total;
        int l = 0, sum = 0;
        int res = 0;
        for(int r=0; r<n; r++){
            sum += card[r];
            if(r-l+1==n-k){
                res = Math.max(res, total-sum);
                // System.out.println(sum + " " + (total-sum));
                sum -= card[l];
                l++;
            }
        }
        return res;
    }
}
