package Backtrack.Medium;

/**
 * Created by Shuhua Song
 */
public class _2212_MaximumPointsInArcheryCompetition {
    int[] a;
    int[] res;
    int n, maxPoint;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        n = aliceArrows.length; //n = 12
        maxPoint = 0;
        res = new int[n];
        this.a = aliceArrows;
        int[] temp = new int[n];
        //iterate to find each posiblity solution
        for(int i=n-1; i>=0; i--){
            dfs(numArrows, i, 0, temp);
        }
        return res;
    }

    private void dfs(int arrows, int start, int currPoint, int[] temp){
        //no more arrows, skip
        if(arrows < 0) return;
        //the Bob's points > Alice's Point, update the result
        if(currPoint > maxPoint){
            maxPoint = currPoint;
            for(int i=0; i<n; i++){
                res[i] = temp[i];
            }
            res[0] = arrows + temp[0];
        }
        //explore for index start
        for(int i=start;i>=0;i--){
            if(a[i] > 0){
                //enough arrows for a[i]+1 when a[i]>0
                if(arrows-a[i]-1 >= 0){
                    temp[i] = a[i]+1;
                    dfs(arrows-a[i]-1, i-1, currPoint+i, temp);
                    temp[i] = 0;
                }
            }else{
                //enough arrows for 1 when a[i]==0
                if(arrows-1 >= 0){
                    temp[i] = 1;
                    dfs(arrows-1, i-1, currPoint+i, temp);
                    temp[i] = 0;
                }
            }
        }
    }
}
