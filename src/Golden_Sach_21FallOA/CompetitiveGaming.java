package Golden_Sach_21FallOA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class CompetitiveGaming {

 /*   public static int numPlayers(int k, List<Integer> scores){
        if(k<=0) return 0;
        Collections.sort(scores, Collections.reverseOrder());
        int rank = 1, res = 0;
        for(int i=0; i<scores.size(); i++){
            if(i==0 && scores.get(i)!=0) rank = 1;
            else if(scores.get(i)!=scores.get(i-1)){
                rank = i+1;
            }
            if(rank <= k && scores.get(i) > 0) res++;
            else{
                break;
            }
        }
        return res;
    } */

    public static int numPlayers(int k, List<Integer> scores) {
       int res = 0;
       int n = scores.size();
       int[] ranks = new int[n];
       Collections.sort(scores, Collections.reverseOrder());
       for(int i=0; i<n; i++){
           if(i>0 && scores.get(i)==scores.get(i-1)){
               ranks[i] = ranks[i-1];
           }else if(scores.get(i)==0){
               ranks[i] = 0;
           }else{
               ranks[i] = i+1;
           }
       }
       for(int a : ranks){
           System.out.println(a + " ");
       }
        System.out.println();
       for(int i : ranks){
           if(i<=k){
               res++;
           }
       }
       return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 2, 3, 4, 5, 1, 0};
       // Integer[] nums = {100, 50, 50, 50, 0, 25};
        List<Integer> scores = Arrays.asList(nums);
        int k = 3;
        int result = numPlayers(k, scores);
        System.out.println(result);
    }
}
