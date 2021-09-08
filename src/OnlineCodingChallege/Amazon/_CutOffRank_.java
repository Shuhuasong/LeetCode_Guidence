package OnlineCodingChallege.Amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
Parameters:
scores : List of int
cutOffRank : int
num: int (denoting amount of scores)

You are given a list of integers representing scores of players in a video game. Players can 'level-up' if by the end of the game they have a rank that is at least the cutOffRank. A player's rank is solely determined by their score relative to the other players' scores. For example:

Score : 10 | Rank 1
Score : 5 | Rank 2
Score : 3 | Rank 3
etc.

If multiple players happen to have the same score, then they will all receive the same rank. However, the next player with a score lower than theirs will receive a rank that is offset by this. For example:

Score: 10 | Rank 1
Score: 10 | Rank 1
Score: 10 | Rank 1
Score : 5 | Rank 4

Finally, any player with a score of 0 is automatically ineligible for leveling-up, regardless of their rank.

Return the number of players who are eligible for leveling-up
 */
public class _CutOffRank_ {

    private static int numPlayerLevelUp(int cutRank, List<Integer> scores){
        if(cutRank <= 0) return 0;
        Collections.sort(scores, Collections.reverseOrder());
        int  res = 0, rank = 0;
        for(int i=0; i<scores.size(); i++){
            if(i==0 && scores.get(i)!=0) rank = 1;
            else if(scores.get(i) != scores.get(i-1)){
                rank = i+1;
            }
            if(rank <= cutRank && scores.get(i) != 0) res++;
            else{
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Integer[] nums1 = {2, 2, 3, 4, 5, 1, 0};
        Integer[] nums2 = {100, 50, 50, 50, 0, 25};
        List<Integer> scores1 = Arrays.asList(nums1);
        List<Integer> scores2 = Arrays.asList(nums2);
        int k = 3;
        //int result = numPlayers(k, scores);
        System.out.println(numPlayerLevelUp(3, scores1));
        System.out.println(numPlayerLevelUp(4, scores2));
    }
}

/*
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
 */
