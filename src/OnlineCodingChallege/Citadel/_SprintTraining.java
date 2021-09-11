package OnlineCodingChallege.Citadel;

/**
 * Created by Shuhua Song
 */

//    Imagine there are n points along a straight trail, while a runner run sprints of intervals between those point.
//    The training plan is an array a[], which implies the runner should run from point a[i] to point a[i+1].
//
//    For example, given n = 10, a = [2, 4, 1, 2].
//    The runner should run from point 2 to point 4,
//    then turn back from point 4 to point 1,
//    and then from point 1 to point 2.
//    Find the point that visited the most by runner after he finished training, i.e. in above example, point 2 is the most visited.
//    If more than one point are visited the most, find the point with minimum index.

public class _SprintTraining {

    private static int getMostVisited(int[] sprints, int n){
        if(sprints==null || sprints.length < 2) return 0;
        int[] count = new int[n+1];
        int min = n, max = -1, maxCount = 0;
        for(int i=1; i<sprints.length; i++){
            min = Math.min(sprints[i], sprints[i-1]);
            max = Math.max(sprints[i], sprints[i-1]);
            System.out.println(min + " " + max);
            for(int j=min; j<=max; j++){
                count[j]++;
                maxCount = Math.max(maxCount, count[j]);
                System.out.println("maxCount = " + maxCount + " " + j);
            }
        }
        int res = n;
        for(int i=0; i<=n; i++){
            if(count[i]==maxCount){
                if(res >= i){
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
         int[] sprints1 = {2, 4, 1, 3};
         int n = 5;
        System.out.println(getMostVisited(sprints1, n));

        int[] sprints2 = {1, 5};
        System.out.println(getMostVisited(sprints2, 5));

        int[] sprints3 = {1, 5, 10, 3};
        System.out.println(getMostVisited(sprints3, 10));
    }
}
