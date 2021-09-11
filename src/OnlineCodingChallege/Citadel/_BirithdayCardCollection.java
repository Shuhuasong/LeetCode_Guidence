package OnlineCodingChallege.Citadel;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _BirithdayCardCollection {


    private static List<Integer> hackerCards(int[] cards, int budget){
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=budget; i++) list.add(i);
        for(int c : cards) list.remove(Integer.valueOf(c));
        for(int i=0; i<list.size(); i++){
             if(budget <= 0) break;
             if(list.get(i) <= budget){
                 ans.add(list.get(i));
                 budget -= list.get(i);
             }
        }
       return ans;
    }

    public static void main(String[] args) {
        int[] cards = {2, 3, 4, 5};
        int budget = 7;
        List<Integer> results = hackerCards(cards, budget);
        System.out.println(results);
    }
}
