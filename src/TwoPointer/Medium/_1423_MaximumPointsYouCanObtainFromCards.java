package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _1423_MaximumPointsYouCanObtainFromCards {


    public int maxScore(int[] cardPoints, int k) {
        if(cardPoints.length < k) return 0;
        int n = cardPoints.length;
        int res = 0, sum = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        res = Math.max(res, sum);
        int left = k-1;
        for(int i=n-1; i>=n-k && left>=0; i--){
            sum = sum + cardPoints[i]-cardPoints[left];
            res = Math.max(res, sum);
            left--;
        }
        return res;
    }

    /*
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
    }  */

}

//https://docs.google.com/drawings/d/1JzEZLS1tD13ZD_GTDA8-F5nrRAZ6XNWAc9XuCnqls_M/edit