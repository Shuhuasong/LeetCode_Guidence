package Golden_Sach_21FallOA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class CompetitiveGaming {

    public static int numPlayers(int k, List<Integer> scores){
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
    }
    //One Case didn't pass
   /* public static int numPlayers(int k, List<Integer> scores) {
        if(scores == null || scores.size()==0 || k<=0) return 0;
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
    } */

    public static void main(String[] args) {
        Integer[] nums1 = {2, 2, 3, 4, 5, 1, 0};
        Integer[] nums2 = {100, 50, 50, 50, 0, 25};
        List<Integer> scores1 = Arrays.asList(nums1);
        List<Integer> scores2 = Arrays.asList(nums2);
        int k = 3;
        //int result = numPlayers(k, scores);
        System.out.println(numPlayers(3, scores1));
        System.out.println(numPlayers(4, scores2));
    }
}



/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int scoresCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(bufferedReader.readLine().trim());
            scores.add(scoresItem);
        }

        int result = Result.numPlayers(k, scores);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

 */
