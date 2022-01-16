package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _2139_MinimumMovesToResearchTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                count += target - 1;
                break;
            }
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
                count++;
            } else {
                target -= 1;
                count++;
            }
        }
        return count;
    }
}


/*
1) check if the maxDouble == 0 ==> res += target-1, break
2) check if the target%2==0 ==> target/=2, maxDouble--, res++
3) if target is odd==> target-=1, res++
*/