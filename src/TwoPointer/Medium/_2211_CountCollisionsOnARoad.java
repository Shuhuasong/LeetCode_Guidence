package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _2211_CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n-1;
        while(left < n && directions.charAt(left)=='L'){
            left++;
        }
        while(right >= 0 && directions.charAt(right)=='R'){
            right--;
        }
        int count = 0;
        for(int i=left; i<=right; i++){
            if(directions.charAt(i)=='S') continue;
            count++;
        }
        return count;
    }
}

/*
e.g
"RL" = 2
"RRLL" = 4
"RRRLLL" = 6
"RSRRLLL" = 6
"RRSRLLL" = 6
"RRRSLLL" = 6
"RRRLSLL" = 6
"RRRLLSL" = 6
Corner case: the leftmost of 'L' and rightmost of 'R' doesn't contrubut toward the anwer

The stationary('S') car doesn't contrubut toward the anwer
*/

