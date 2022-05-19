package Backtrack.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _679_24Game {

    //Time = O(4^(4!)), constant

    private final static double mod = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int card : cards) {
            list.add((double)card);
        }
        return backtrack(list);
    }

    private boolean backtrack(List<Double> cards){
        //base case
        if(cards.size()==1){
            return Math.abs(cards.get(0)-24) < mod;
        }

        int n = cards.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                double card1= cards.get(i);
                double card2 = cards.get(j);

                List<Double> newCards = new ArrayList<>();
                for(int k=0; k<n; k++){
                    if(k!=i && k!=j){
                        newCards.add(cards.get(k));
                    }
                }

                for(int op=0; op<4; op++){
                    if(op==0){
                        newCards.add(card1+card2);
                    }else if(op==1){
                        newCards.add(card1-card2);
                    }else if(op==2){
                        newCards.add(card1*card2);
                    }else{
                        newCards.add(card1/card2);
                    }

                    if(backtrack(newCards)) {
                        return true;
                    }
                    newCards.remove(newCards.size()-1);
                }
            }
        }
        return false;
    }
}

/*

                                    [4,1,8,7]
       /     /      /       /     /      |      \      \      \     \    \      \
    [4,1]  [1,4]  [4,8]  [8,4]  [4,7]  [7,4]  [1,8]  [8,1]  [1,7] [7,1] [8,7] [7,8]   C(4,1) * C(3,1)
     /
  + - * /
  / / \ \
 5 3  4
 |
{5,1,7}

card1: 4
card2: 1
Time: 4^(4!) //++
Space: 3 level

opres list2  (4 + 1) (4 - 1)
[5, 8, 7]

24
list1 [8 4 1 7] (8, 4) another {1, 7}
list2 [4 1 7]   {1, 7, x}
[4 6]

*/



